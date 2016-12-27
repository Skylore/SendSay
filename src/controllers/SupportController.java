package controllers;

import javafx.collections.ObservableList;
import models.SupportRequest;

public interface SupportController {

    ObservableList<SupportRequest> showAllRequests();
    boolean reply(SupportRequest request, String answer);
}
