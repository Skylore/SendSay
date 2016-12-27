package controllers;

import exceptions.NoSuchContactException;

public interface AdminController {

    void setManager(String user, String manager) throws NoSuchContactException;

    void banUser(String user, String cause) throws NoSuchContactException;

    void confirmWorkRequest();
}
