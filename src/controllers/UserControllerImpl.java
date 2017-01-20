package controllers;

import annotations.Valid;
import api.SendMailSSL;
import dataBase.DataBase;
import exceptions.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import models.ContactList;
import models.SupportRequest;
import models.User;
import models.WorkRequest;
import sun.plugin.dom.exception.InvalidAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javafx.collections.FXCollections.observableHashMap;

public class UserControllerImpl implements UserController {

    private DataBase dataBase = DataBase.getInstance();
    private static User inSystem;

    @Override
    public void signUp(String login, String pass, @Valid String email) throws BookedLoginException {
        if (dataBase.users.containsKey(login)) {
            throw new BookedLoginException();
        }

        dataBase.users.put(login, new User(login, pass, email));
        inSystem = dataBase.users.get(login);
    }

    @Override
    public void signIn(String login, String pass) throws NoSuchContactException {
        if (!dataBase.users.containsKey(login)) {
            throw new NoSuchContactException();
        } else if (dataBase.users.get(login).getPassword().equals(pass)) {
            inSystem = dataBase.users.get(login);
            return;
        }

        throw new InvalidAccessException("Incorrect password");
    }

    @Override
    public List<String> makeDistribution(List<String> receivers, String tittle, String text) throws InvalidEmailException, BannedUserException {
        if (dataBase.banned.containsKey(inSystem.getLogin())) {
            throw new BannedUserException("You have been banned");
        }

        List<String> res = new ArrayList<>();
        for (String receiver : receivers) {
            try {
                SendMailSSL.sendLetter(receiver, tittle, text);
                res.add(receiver);
            } catch (Exception e) {
                System.err.println(receiver + " has been failed");
            }
        }

        if (res.isEmpty()) {
            throw new InvalidEmailException("All operations have been failed");
        }

        return res;
    }

    @Override
    public List<String> makeDistribution(String contactList, String tittle, String text) throws NoSuchContactListException, InvalidEmailException, BannedUserException {
        if (dataBase.banned.containsKey(inSystem.getLogin())) {
            throw new BannedUserException();
        } else if (!dataBase.contactLists.containsKey(contactList)) {
            throw new NoSuchContactListException();
        }

        List<String> res = new ArrayList<>();
        for (String email : dataBase.contactLists.get(contactList).getContacts().values()) {
            try {
                SendMailSSL.sendLetter(email, tittle, text);
                res.add(email);
            } catch (RuntimeException ex) {
                System.err.println(email + "has been failed");
            }
        }

        if (res.isEmpty())
            throw new InvalidEmailException("All operation have been failed");

        return res;
    }

    @Override
    public void createContactList(Map<String, String> contacts, String name, User owner) throws BookedListNameException, NoSuchContactException {
        if (dataBase.contactLists.containsKey(name)) {
            throw new BookedListNameException();
        } else if (!dataBase.users.containsKey(owner.getLogin())) {
            throw new NoSuchContactException();
        }

        dataBase.contactLists.put(name, new ContactList(owner, contacts));
    }

    @Override
    public void removeContactList(String name) throws NoSuchContactListException {
        if (!dataBase.contactLists.containsKey(name)) {
            throw new NoSuchContactListException();
        }

        dataBase.contactLists.remove(name);
    }

    @Override
    public void addContactToList(String scope, String name, String email) throws NoSuchContactListException {
        if (!dataBase.contactLists.containsKey(scope)) {
            throw new NoSuchContactListException();
        }

        ContactList list = dataBase.contactLists.get(scope);
        list.contacts.put(name, email);
        dataBase.contactLists.put(scope, list);
    }

    @Override
    public void removeContactFromList(String list, String contactName) throws NoSuchContactListException, NoSuchContactException {
        if (!dataBase.contactLists.containsKey(list)) {
            throw new NoSuchContactListException();
        } else if (!dataBase.contactLists.get(list).contacts.containsKey(contactName)) {
            throw new NoSuchContactException();
        }

        ContactList contactList = dataBase.contactLists.get(list);
        contactList.contacts.remove(contactName);
        dataBase.contactLists.put(list, contactList);
    }

    @Override
    public void updateInfo(String name, User user) throws NoSuchContactException {
        if (!dataBase.users.containsKey(name)) {
            throw new NoSuchContactException();
        }

        dataBase.users.put(name, user);
    }

    @Override
    public void sendWorkRequest(WorkRequest workRequest) {
        dataBase.workRequests.add(workRequest);
    }

    @Override
    public void ask(SupportRequest supportRequest) {
        if (inSystem.getMentor() == null) {
            dataBase.supportRequests.add(supportRequest);
        } else {
            dataBase.managerSupportRequest.put(inSystem.getLogin(), supportRequest);
        }
    }

    @Override
    public ObservableList<ContactList> showMyContactLists() {
        ObservableList<ContactList> res = FXCollections.observableArrayList();
        dataBase.contactLists.values().stream().filter((e) -> e.getOwner().equals(inSystem)).forEach(res::add);
        return res;
    }

    @Override
    public ObservableMap<String, String> showAllContactsInList(String name) throws NoSuchContactListException {
        if (!dataBase.contactLists.containsKey(name)) {
            throw new NoSuchContactListException();
        }

        ObservableMap<String, String> res = observableHashMap();
        res.putAll(dataBase.contactLists.get(name).getContacts());
        return res;
    }

    public User getInSystem() {
        return inSystem;
    }
}
