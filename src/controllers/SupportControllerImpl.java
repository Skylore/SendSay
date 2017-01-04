package controllers;

import api.SendMailSSL;
import dataBase.DataBase;
import exceptions.NoSuchRequestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.SupportRequest;

public class SupportControllerImpl implements SupportController {

    public static final String pass = "supportPass";

    @Override
    public ObservableList<SupportRequest> showAllRequests() {
        ObservableList<SupportRequest> result = FXCollections.observableArrayList();
        DataBase.getInstance().supportRequests.forEach(result::add);

        return result;
    }

    @Override
    public void reply(SupportRequest request, String answer) throws NoSuchRequestException {

        if (DataBase.getInstance().supportRequests.contains(request)) {
            DataBase.getInstance().supportRequests.remove(request);
            SendMailSSL.sendLetter(request.getEmail(), "SendSay", answer);
        } else {
            throw new NoSuchRequestException();
        }
    }

}
