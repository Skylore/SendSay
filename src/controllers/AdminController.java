package controllers;

import exceptions.NoSuchContactException;
import javafx.collections.ObservableList;
import models.User;
import models.WorkRequest;

public interface AdminController {

    ObservableList<User> showAllUsers();

    ObservableList<WorkRequest> showWorkRequests();

    void setManager(String user, String manager) throws NoSuchContactException;

    void banUser(String user, String cause) throws NoSuchContactException;

    void confirmWorkRequest();
}
