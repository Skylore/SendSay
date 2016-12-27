package controllers;

import exceptions.NoSuchRequestException;
import javafx.collections.ObservableList;
import models.SupportRequest;

public interface SupportController {

    ObservableList<SupportRequest> showAllRequests();
    void reply(SupportRequest request, String answer) throws NoSuchRequestException;
}
