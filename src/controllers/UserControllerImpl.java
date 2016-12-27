package controllers;

import api.SendMailSSL;
import dataBase.DataBase;
import exceptions.*;
import models.User;

import java.util.List;

public class UserControllerImpl implements UserController {

    private DataBase dataBase = DataBase.getInstance();

    @Override
    public void signUp(String login, String pass, String email) throws BookedLoginException {
        if (dataBase.users.containsKey(login)) {
            throw new BookedLoginException();
        }

        dataBase.users.put(login, new User(login, pass, email));
    }

    @Override
    public void makeDistribution(List<String> receivers, String tittle, String text) throws InvalidEmailException {
        for (String receiver : receivers) {
            try {
                SendMailSSL.sendLetter(receiver, tittle, text);
            } catch (RuntimeException e) {
                throw new InvalidEmailException();
            }
        }
    }

    @Override
    public void makeDistribution(String contactList, String tittle, String text) throws NoSuchContactListException, InvalidEmailException {
        try {
            for (User o : dataBase.contactLists.get(contactList).getContacts()) {
                try {
                    SendMailSSL.sendLetter(o.getEmail(), tittle, text);
                } catch (RuntimeException ex) {
                    throw new InvalidEmailException();
                }
            }
        } catch (Exception e) {
            throw new NoSuchContactListException();
        }
    }

    @Override
    public void createContactList(List<User> contacts) throws BookedListNameException {

    }

    @Override
    public void removeContactList(String name) throws NoSuchContactListException {

    }

    @Override
    public void addContactToList(String scope, User contact) throws NoSuchContactListException {

    }

    @Override
    public void removeContactFromList(String list, String contactName) throws NoSuchContactListException, NoSuchContactException {

    }

    @Override
    public void showAllContactLists() {

    }

    @Override
    public void showAllContactsInList(String name) throws NoSuchContactListException {

    }

    @Override
    public void updateInfo(String name, User user) {

    }
}
