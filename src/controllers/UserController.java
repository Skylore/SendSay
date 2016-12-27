package controllers;

import java.util.*;

import exceptions.*;
import models.User;

public interface UserController {

   void signUp(String login, String pass, String email) throws BookedLoginException;

   void makeDistribution(List<String> receivers,String tittle, String text) throws InvalidEmailException;

   void makeDistribution(String contactList, String tittle, String text) throws NoSuchContactListException, InvalidEmailException;

   void createContactList(List<User> contacts) throws BookedListNameException;

   void removeContactList(String name) throws NoSuchContactListException;

   void addContactToList(String scope, User contact) throws NoSuchContactListException;

   void removeContactFromList(String list, String contactName) throws NoSuchContactListException, NoSuchContactException;

   void showAllContactLists();

   void showAllContactsInList(String name) throws NoSuchContactListException;

   void updateInfo(String name, User user);
}
