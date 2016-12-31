package view.clientLayouts;

import controllers.UserController;
import controllers.UserControllerImpl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.AlertBox;

public class SignInLayout {

    public static GridPane getLayout(Stage primary) {
        ClientLayout clientLayout = new ClientLayout();
        UserController userController = new UserControllerImpl();

        GridPane logInPane = new GridPane();
        logInPane.setPadding(new Insets(10, 10, 10, 10));
        logInPane.setHgap(10);
        logInPane.setVgap(10);

        TextField login = new TextField();
        login.setPromptText("Login");
        login.getStyleClass().add("sign");
        GridPane.setConstraints(login, 0, 0);
        login.setPrefSize(200, 20);

        TextField pass = new TextField();
        pass.setPromptText("Password");
        pass.getStyleClass().add("sign");
        GridPane.setConstraints(pass, 0, 1);
        pass.setPrefSize(200, 20);

        Label submit = new Label("log in");
        submit.setAlignment(Pos.CENTER);
        GridPane.setConstraints(submit, 0, 2);
        submit.setPrefSize(200, 20);
        submit.getStyleClass().add("sign");
        submit.setOnMouseEntered((e) -> {
            submit.setScaleX(1.05);
            submit.setScaleY(1.05);
        });
        submit.setOnMouseExited((e) -> {
            submit.setScaleX(1);
            submit.setScaleY(1);
        });
        submit.setOnMouseClicked((e) -> {
            if (!login.getText().equals("") && !pass.getText().equals("")) {
                try {
                    userController.signIn(login.getText(), pass.getText());
                    clientLayout.getLayout(primary);
                } catch (Exception e1) {
                    AlertBox.display("Incorrect input");
                }
            } else {
                AlertBox.display("Please, fill up all fields");
            }
        });

        Label back = new Label("Back");
        back.getStyleClass().add("sign");
        back.setAlignment(Pos.CENTER);
        GridPane.setConstraints(back, 0, 3);
        back.setPrefSize(200, 20);
        back.getStyleClass().add("sign");
        back.setOnMouseEntered((e) -> {
            back.setScaleX(1.05);
            back.setScaleY(1.05);
        });
        back.setOnMouseExited((e) -> {
            back.setScaleX(1);
            back.setScaleY(1);
        });

        logInPane.getChildren().addAll(login, pass, submit, back);

        logInPane.setAlignment(Pos.CENTER);
        logInPane.getStylesheets().add("view/style");

        return logInPane;
    }
}
