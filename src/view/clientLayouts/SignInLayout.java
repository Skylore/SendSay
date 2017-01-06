package view.clientLayouts;

import controllers.UserController;
import controllers.UserControllerImpl;
import exceptions.NoSuchContactException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.AlertBox;

class SignInLayout {

    private Stage primary;

    SignInLayout(Stage primary) {
        this.primary = primary;
        init();
    }

    private UserController userController = new UserControllerImpl();
    private GridPane logInPane = new GridPane();

    private TextField login = new TextField();
    private TextField pass = new TextField();
    private Label submit = new Label("log in");
    private Label back = new Label("Back");

    private void init() {

        logInPane.setPadding(new Insets(10, 10, 10, 10));
        logInPane.setHgap(10);
        logInPane.setVgap(10);

        login.setPromptText("Login");
        login.getStyleClass().add("sign");
        GridPane.setConstraints(login, 0, 0);
        login.setPrefSize(200, 20);

        pass.setPromptText("Password");
        pass.getStyleClass().add("sign");
        GridPane.setConstraints(pass, 0, 1);
        pass.setPrefSize(200, 20);

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

        submit.setOnMouseClicked((e) -> signInAction());

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
    }

    GridPane getLogInPane() {
        return logInPane;
    }

    void signInAction() {
        if (!login.getText().equals("") && !pass.getText().equals("")) {
            try {
                userController.signIn(login.getText(), pass.getText());
                ClientLayout.getLayout(primary);
            } catch (NoSuchContactException e1) {
                AlertBox.display("Incorrect input");
            }
        } else {
            AlertBox.display("Please, fill up all fields");
        }
    }

    static void getLayout(Stage primary) {
        SignInLayout signInLayout = new SignInLayout(primary);
        primary.setScene(new Scene(signInLayout.logInPane, 800, 500));
    }
}
