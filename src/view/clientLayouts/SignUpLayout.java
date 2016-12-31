package view.clientLayouts;

import api.SendMailSSL;
import controllers.UserController;
import controllers.UserControllerImpl;
import dataBase.DataBase;
import exceptions.BookedLoginException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.AlertBox;

import java.util.UUID;

public class SignUpLayout {
    public static GridPane getLayout(Stage primaryStage) {
        UserController userController = new UserControllerImpl();

        GridPane signUpPane = new GridPane();
        signUpPane.setPadding(new Insets(20, 20, 20, 20));
        signUpPane.setVgap(8);
        signUpPane.setHgap(10);
        signUpPane.setAlignment(Pos.CENTER);

        TextField loginSignUp = new TextField();
        loginSignUp.setPromptText("Input your login");
        GridPane.setConstraints(loginSignUp, 0, 0);
        loginSignUp.getStyleClass().add("sign");
        loginSignUp.setPrefSize(200, 20);

        TextField emailSignUp = new TextField();
        emailSignUp.setPromptText("Input your email");
        GridPane.setConstraints(emailSignUp, 0, 1);
        emailSignUp.getStyleClass().add("sign");
        emailSignUp.setPrefSize(200, 20);

        TextField passSignUp = new TextField();
        passSignUp.setPromptText("Input your password");
        GridPane.setConstraints(passSignUp, 0, 2);
        passSignUp.getStyleClass().add("sign");
        passSignUp.setPrefSize(200, 20);

        TextField repPass = new TextField();
        repPass.setPromptText("Repeat your password");
        GridPane.setConstraints(repPass, 0, 3);
        repPass.getStyleClass().add("sign");
        repPass.setPrefSize(200, 20);

        Label submitSignUp = new Label("Submit");
        submitSignUp.setPrefSize(200, 20);
        submitSignUp.getStyleClass().add("sign");
        submitSignUp.setAlignment(Pos.CENTER);
        submitSignUp.setOnMouseEntered((e) -> {
            submitSignUp.setScaleX(1.05);
            submitSignUp.setScaleY(1.05);
        });
        submitSignUp.setOnMouseExited((e) -> {
            submitSignUp.setScaleY(1);
            submitSignUp.setScaleX(1);
        });
        GridPane.setConstraints(submitSignUp, 0, 4);

        Label backSignUp = new Label("Back");
        backSignUp.setAlignment(Pos.CENTER);
        backSignUp.setPrefSize(200, 20);
        backSignUp.getStyleClass().add("sign");
        GridPane.setConstraints(backSignUp, 0, 5);
        backSignUp.setOnMouseEntered((e) -> {
            backSignUp.setScaleX(1.05);
            backSignUp.setScaleY(1.05);
        });
        backSignUp.setOnMouseExited((e) -> {
            backSignUp.setScaleX(1);
            backSignUp.setScaleY(1);
        });

        submitSignUp.setOnMouseClicked((e) -> {
            if (loginSignUp.getText().isEmpty() || emailSignUp.getText().isEmpty() || passSignUp.getText().isEmpty()
                    || repPass.getText().isEmpty()) {
                AlertBox.display("Please fill up all fields");
            } else if (passSignUp.getText().equals(repPass.getText())) {
                try {
                    Integer.parseInt(loginSignUp.getText());
                    Integer.parseInt(emailSignUp.getText());
                    AlertBox.display("Wrong input");
                } catch (Exception e1) {
                    if (!DataBase.getInstance().users.containsKey(loginSignUp.getText())) {

                        try {
                            String VERIFY_CODE = UUID.randomUUID().toString().substring(0, 8);
                            SendMailSSL.sendLetter(emailSignUp.getText(), "Send Say", "Your verify code is: \n" + VERIFY_CODE);

                            String log = loginSignUp.getText();
                            String password = passSignUp.getText();
                            String mail = emailSignUp.getText();

                            loginSignUp.setPromptText("Input verify code");
                            loginSignUp.setText("");
                            loginSignUp.getStyleClass().add("sign");
                            signUpPane.getChildren().removeAll(emailSignUp, passSignUp, repPass, submitSignUp);

                            Button submit1 = new Button("check");
                            GridPane.setConstraints(submit1, 0, 1);
                            submit1.getStyleClass().add("sign");
                            signUpPane.getChildren().addAll(submit1);
                            submit1.setOnAction((e2) -> {
                                if (VERIFY_CODE.equals(loginSignUp.getText())) {
                                    try {
                                        userController.signUp(log, password, mail);
                                        new ClientLayout().getLayout(primaryStage);
                                    } catch (BookedLoginException e3) {
                                        e3.printStackTrace();
                                    }
                                } else {
                                    AlertBox.display("Incorrect input");
                                }
                            });

                        } catch (Exception e2) {
                            AlertBox.display("Incorrect email");
                        }
                    } else {
                        AlertBox.display("Such login is already existing");
                    }
                }
            } else {
                AlertBox.display("Passwords must be equals");
            }
        });
        GridPane.setConstraints(submitSignUp, 0, 4);
        submitSignUp.getStyleClass().add("sign");

        signUpPane.getChildren().addAll(loginSignUp, emailSignUp, passSignUp, repPass, submitSignUp, backSignUp);
        signUpPane.getStylesheets().add("view/style");

        return signUpPane;
    }
}
