package controllers;

import api.SendMailSSL;
import dataBase.DataBase;
import exceptions.NoSuchContactException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.SupportRequest;
import models.User;

import java.util.*;

public class ManagerControllerImpl implements ManagerController {

    private DataBase db = DataBase.getInstance();

    @Override
    public ObservableList<User> showMyUsers(User mentor) {
        ObservableList<User> result = FXCollections.observableArrayList();
        db.users.keySet().stream().filter(key -> mentor.equals(db.users.get(key).getMentor())).
                forEach(key -> result.add(db.users.get(key)));

        return result;
    }

    @Override
    public String showUserInfo(String login) throws NoSuchContactException {

        Optional<String> key = findKey(login);
        if (!key.isPresent())
            throw new NoSuchContactException();

        return db.users.get(key.get()).toString();
    }

    @Override
    public void updateInfo(String login, User user) throws NoSuchContactException {
        Optional<String> key = findKey(login);
        if (!key.isPresent())
            throw new NoSuchContactException();

        db.users.replace(key.get(), user);
    }

    @Override
    public void banUser(String name, String cause) throws NoSuchContactException {

        if (!db.users.containsKey(name)) {
            throw new NoSuchContactException();
        }

        User scope = db.users.get(name);
        db.banned.put(name, scope);

        SendMailSSL.sendLetter(db.users.get(name).getEmail(), "SandSay", scope.getLogin() +
                "You've been banned by cause: \n" + cause);

    }

    @Override
    public void reply(SupportRequest supportRequest, String reply) {
        List<SupportRequest> supportRequests = (ArrayList<SupportRequest>)db.managerSupportRequest.values();

        supportRequests.forEach((e) -> {
            if (e.equals(supportRequest)) {
                SendMailSSL.sendLetter(e.getEmail(), "SendSay", reply);
            }
        });
    }

    private Optional<String> findKey(String login) {
        return db.users.keySet().stream().filter(k -> db.users.get(k).getLogin().
                equals(login)).findAny();
    }
}
