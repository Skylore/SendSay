package controllers;

import java.util.*;

import exceptions.*;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import models.ContactList;
import models.SupportRequest;
import models.User;
import models.WorkRequest;

public interface UserController {

   void signUp(String login, String pass, String email) throws BookedLoginException;

   void signIn(String login, String pass) throws NoSuchContactException;

   void makeDistribution(List<String> receivers,String tittle, String text) throws InvalidEmailException, BannedUserException;

   void makeDistribution(String contactList, String tittle, String text) throws NoSuchContactListException, InvalidEmailException, BannedUserException;

   void createContactList(Map<String, String> contacts, String name, User owner) throws BookedListNameException, NoSuchContactException;

   void removeContactList(String name) throws NoSuchContactListException;

   void addContactToList(String scope, String name, String email) throws NoSuchContactListException;

   void removeContactFromList(String list, String contactName) throws NoSuchContactListException, NoSuchContactException;

   void updateInfo(String name, User user) throws NoSuchContactException;

   void sendWorkRequest(WorkRequest workRequest);

   void ask(SupportRequest supportRequest);

   ObservableList<ContactList> showMyContactLists();

   ObservableMap<String, String> showAllContactsInList(String name) throws NoSuchContactListException;

   User getInSystem();
}
