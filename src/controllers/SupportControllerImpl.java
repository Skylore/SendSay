package controllers;

import dataBase.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.SupportRequest;

public class SupportControllerImpl implements SupportController{

    public SupportControllerImpl() {
    }

    @Override
    public ObservableList<SupportRequest> showAllRequests() {
        ObservableList<SupportRequest> result = FXCollections.observableArrayList();
        DataBase.getInstance().supportRequests.forEach(result::add);

        return result;
    }

    @Override
    public boolean reply(SupportRequest request, String answer) {
        return false;
    }

}
