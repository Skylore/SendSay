package view.clientLayouts;

import controllers.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.AlertBox;

class CorporateSignInLayout {
    static GridPane getLayout(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label admin = new Label("Admin");
        admin.setAlignment(Pos.CENTER);
        admin.setPrefSize(120, 20);
        admin.getStyleClass().add("corp_choose_label");
        GridPane.setConstraints(admin, 0, 0);
        admin.setOnMouseEntered((e) -> {
            admin.setScaleX(1.05);
            admin.setScaleY(1.05);
        });
        admin.setOnMouseExited((e) -> {
            admin.setScaleX(1);
            admin.setScaleY(1);
        });

        Label manager = new Label("Manager");
        manager.setAlignment(Pos.CENTER);
        manager.setPrefSize(120, 20);
        manager.getStyleClass().add("corp_choose_label");
        GridPane.setConstraints(manager, 1, 0);
        manager.setOnMouseEntered((e) -> {
            manager.setScaleX(1.05);
            manager.setScaleY(1.05);
        });
        manager.setOnMouseExited((e) -> {
            manager.setScaleX(1);
            manager.setScaleY(1);
        });

        Label support = new Label("Support");
        support.setAlignment(Pos.CENTER);
        support.setPrefSize(120, 20);
        support.getStyleClass().add("corp_choose_label");
        GridPane.setConstraints(support, 3, 0);
        support.setOnMouseEntered((e) -> {
            support.setScaleX(1.05);
            support.setScaleY(1.05);
        });
        support.setOnMouseExited((e) -> {
            support.setScaleX(1);
            support.setScaleY(1);
        });

        admin.setOnMouseClicked((e) -> {
            admin.setOpacity(0.9);
            manager.setOpacity(0.5);
            support.setOpacity(0.5);
        });
        manager.setOnMouseClicked((e) -> {
            manager.setOpacity(0.9);
            admin.setOpacity(0.5);
            support.setOpacity(0.5);
        });
        support.setOnMouseClicked((e) -> {
            support.setOpacity(0.9);
            admin.setOpacity(0.5);
            manager.setOpacity(0.5);
        });

        Label back = new Label("Back");
        back.setAlignment(Pos.CENTER);
        back.setPrefSize(120, 20);
        back.getStyleClass().add("sign");
        GridPane.setConstraints(back, 0, 1);
        back.setOnMouseEntered((e) -> {
            back.setScaleX(1.05);
            back.setScaleY(1.05);
        });
        back.setOnMouseExited((e) -> {
            back.setScaleX(1);
            back.setScaleY(1);
        });

        TextField pass = new TextField();
        pass.setPromptText("Password");
        pass.setPrefSize(120, 20);
        pass.getStyleClass().add("sign");
        GridPane.setConstraints(pass, 1, 1);

        Label submit = new Label("Submit");
        submit.setAlignment(Pos.CENTER);
        submit.setPrefSize(120, 20);
        submit.getStyleClass().add("sign");
        GridPane.setConstraints(submit, 3, 1);
        submit.setOnMouseEntered((e) -> {
            submit.setScaleX(1.05);
            submit.setScaleY(1.05);
        });
        submit.setOnMouseExited((e) -> {
            submit.setScaleX(1);
            submit.setScaleY(1);
        });
        submit.setOnMouseClicked((e) -> {
            if (admin.getOpacity() == 0.9 && pass.getText().equals(AdminControllerImpl.pass)) {
                ClientLayout.getLayout(primaryStage);
            } else if (manager.getOpacity() == 0.9 && pass.getText().equals(ManagerControllerImpl.pass)) {
                ClientLayout.getLayout(primaryStage);
            } else if (support.getOpacity() == 0.9 && pass.getText().equals(SupportControllerImpl.pass)) {
                ClientLayout.getLayout(primaryStage);
            } else if (admin.getOpacity() != 0.9 && manager.getOpacity() != 0.9 && support.getOpacity() != 0.9) {
                AlertBox.display("Please choose statement");
            } else {
                AlertBox.display("Incorrect password");
            }
        });

        pane.getChildren().addAll(admin, manager, support, back, pass, submit);
        pane.getStylesheets().add("view/style");
        pane.setAlignment(Pos.CENTER);

        return pane;
    }
}
