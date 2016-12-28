package controllers;

import exceptions.NoSuchContactException;
import exceptions.NoSuchUserException;
import javafx.collections.ObservableList;
import models.SupportRequest;
import models.User;

public interface ManagerController {

    ObservableList<User> showMyUsers(User mentor);

    String showUserInfo(String login) throws NoSuchContactException;

    void updateInfo(String login, User user) throws NoSuchContactException;

    void banUser(String login, String cause) throws NoSuchContactException;

    void reply(SupportRequest supportRequest, String reply);
}
