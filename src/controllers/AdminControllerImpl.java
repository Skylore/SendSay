package controllers;

import api.SendMailSSL;
import dataBase.DataBase;
import exceptions.NoSuchContactException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.User;
import models.WorkRequest;

import java.util.NoSuchElementException;

public class AdminControllerImpl implements AdminController {

    public static final String pass = "adminPass";

    private DataBase dataBase = DataBase.getInstance();

    @Override
    public ObservableList<User> showAllUsers() {
        ObservableList<User> scope = FXCollections.observableArrayList();
        scope.addAll(dataBase.users.values());
        return scope;
    }

    @Override
    public ObservableList<WorkRequest> showWorkRequests() {
        ObservableList<WorkRequest> scope = FXCollections.observableArrayList();
        scope.addAll(dataBase.workRequests);
        return scope;
    }

    @Override
    public void setManager(String user, String manager) throws NoSuchContactException {
        if (!dataBase.users.containsKey(user)) {
            throw new NoSuchContactException();
        } else if (!dataBase.managers.containsKey(manager)) {
            throw new NoSuchContactException("No such manager in data base");
        }

        User scope = dataBase.users.get(user);
        scope.setMentor(dataBase.managers.get(manager));
        dataBase.users.put(user, scope);
    }

    @Override
    public void banUser(String user, String cause) throws NoSuchContactException {
        if (!dataBase.users.containsKey(user)) {
            throw new NoSuchContactException();
        }

        User scope = dataBase.users.get(user);
        dataBase.banned.put(user, scope);

        SendMailSSL.sendLetter(dataBase.users.get(user).getEmail(), "SandSay", scope.getLogin() +
                "You've been banned by cause: \n" + cause);
    }

    @Override
    public void confirmWorkRequest() {
        WorkRequest request = dataBase.workRequests.poll();
        String goal = request.getState();

        String pass;
        if (goal.equalsIgnoreCase("admin")) {
            pass = "adminPass";
        } else if (goal.equalsIgnoreCase("manager")) {
            pass = "managerPass";
        } else if (goal.equalsIgnoreCase("support")) {
            pass = "supportPass";
        } else {
            throw new NoSuchElementException();
        }

        SendMailSSL.sendLetter(request.getEmail(), "SendSay", request.getName() + ", You've been recruited by " +
                "state: " + goal + ".\nYour salary is " + request.getSalary() +
                ".\nYour password is " + pass);
    }
}
