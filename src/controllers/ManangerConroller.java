package controllers;

import exceptions.NoSuchContactException;
import exceptions.NoSuchUserException;
import javafx.collections.ObservableList;
import models.User;

public interface ManangerConroller {

    ObservableList<User> showMyUsers(User mentor);
    String showUserInfo(String login) throws NoSuchContactException;
    void updateInfo(String login, User user) throws NoSuchContactException;
    void banUser(String login, String couse) throws NoSuchContactException;
}
