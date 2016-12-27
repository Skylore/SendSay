package controllers;

import api.SendMailSSL;
import dataBase.DataBase;
import exceptions.*;
import models.ContactList;
import models.User;
import models.WorkRequest;
import sun.plugin.dom.exception.InvalidAccessException;

import java.util.List;
import java.util.Map;

public class UserControllerImpl implements UserController {

    private DataBase dataBase = DataBase.getInstance();
    private User inSystem;

    @Override
    public void signUp(String login, String pass, String email) throws BookedLoginException {
        if (dataBase.users.containsKey(login)) {
            throw new BookedLoginException();
        }

        dataBase.users.put(login, new User(login, pass, email));
    }

    @Override
    public void signIn(String login, String pass) throws NoSuchContactException {
        if (!dataBase.users.containsKey(login)) {
            throw new NoSuchContactException();
        } else if (dataBase.users.get(login).getPassword().equals(pass)) {
            this.inSystem = dataBase.users.get(login);
            return;
        }

        throw new InvalidAccessException("Incorrect password");
    }

    @Override
    public void makeDistribution(List<String> receivers, String tittle, String text) throws InvalidEmailException, BannedUserException {
        if (dataBase.banned.containsKey(inSystem.getLogin())) {
            throw new BannedUserException("You have been banned");
        }
        for (String receiver : receivers) {
            try {
                SendMailSSL.sendLetter(receiver, tittle, text);
            } catch (RuntimeException e) {
                throw new InvalidEmailException();
            }
        }
    }

    @Override
    public void makeDistribution(String contactList, String tittle, String text) throws NoSuchContactListException, InvalidEmailException, BannedUserException {
        if (dataBase.banned.containsKey(inSystem.getLogin())) {
            throw new BannedUserException();
        }
        try {
            for (String email : dataBase.contactLists.get(contactList).getContacts().values()) {
                try {
                    SendMailSSL.sendLetter(email, tittle, text);
                } catch (RuntimeException ex) {
                    throw new InvalidEmailException();
                }
            }
        } catch (Exception e) {
            throw new NoSuchContactListException();
        }
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
}
