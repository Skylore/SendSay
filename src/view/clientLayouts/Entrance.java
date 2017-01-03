package view.clientLayouts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import view.MainPage;
import view.Transition;

public class Entrance {

    public BorderPane getLayout(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();
        Transition transition = new Transition();

        GridPane logInPane = SignInLayout.getLayout(primaryStage);
        GridPane signUpPane = SignUpLayout.getLayout(primaryStage);
        GridPane corporate = CorporateSignInLayout.getLayout(primaryStage);

        // action choose panel
        HBox topPanel = new HBox(15);

        Label signIn = new Label("Sign in");
        signIn.setPrefSize(150, 30);
        signIn.setAlignment(Pos.CENTER);
        signIn.getStyleClass().add("label_main");
        signIn.setTranslateY(235);
        signIn.setOnMouseEntered((e) -> {
            signIn.setScaleX(1.05);
            signIn.setScaleY(1.05);
        });
        signIn.setOnMouseExited((e) -> {
            signIn.setScaleX(1);
            signIn.setScaleY(1);
        });

        Label signUp = new Label("Sign up");
        signUp.setPrefSize(150, 30);
        signUp.setAlignment(Pos.CENTER);
        signUp.getStyleClass().add("label_main");
        signUp.setTranslateY(235);
        signUp.setOnMouseEntered((e) -> {
            signUp.setScaleX(1.05);
            signUp.setScaleY(1.05);
        });
        signUp.setOnMouseExited((e) -> {
            signUp.setScaleX(1);
            signUp.setScaleY(1);
        });

        Label corporateLabel = new Label("Corporate");
        corporateLabel.setPrefSize(150, 30);
        corporateLabel.setAlignment(Pos.CENTER);
        corporateLabel.getStyleClass().add("label_main");
        corporateLabel.setTranslateY(235);
        corporateLabel.setOnMouseEntered((e) -> {
            corporateLabel.setScaleX(1.05);
            corporateLabel.setScaleY(1.05);
        });
        corporateLabel.setOnMouseExited((e) -> {
            corporateLabel.setScaleX(1);
            corporateLabel.setScaleY(1);
        });

        // transitions
        signIn.setOnMouseClicked((e) -> {

            transition.translateTransition(0.8, signIn.getTranslateX(), 160 - signIn.getTranslateX(), 235, 100, signIn);
            transition.fadeTransition(0.8, signUp, 0.5, 0);
            transition.fadeTransition(0.8, corporateLabel, 0.5, 0);

            logInPane.setOpacity(0);
            borderPane.setCenter(logInPane);

            transition.fadeTransition(0.8, logInPane, 0, 0.8);

            logInPane.getChildren().get(3).setOnMouseClicked((e1) -> {

                transition.translateTransition(0.8, signIn.getTranslateX(), signIn.getTranslateX() - 160, 100, 235, signIn);
                transition.fadeTransition(0.8, signUp, 0, 0.5);
                transition.fadeTransition(0.8, corporateLabel, 0, 0.5);
                transition.fadeTransition(0.8, logInPane, 0.8, 0).setOnFinished((e2) -> borderPane.getChildren().remove(logInPane));
            });
        });
        signUp.setOnMouseClicked((e) -> {

            transition.translateTransition(0.8, signUp.getTranslateX(), signUp.getTranslateX(), 235, 100, signUp);
            transition.fadeTransition(0.8, signIn, 0.5, 0);
            transition.fadeTransition(0.8, corporateLabel, 0.5, 0);

            signUpPane.setOpacity(0);
            borderPane.setCenter(signUpPane);

            transition.fadeTransition(0.8, signUpPane, 0, 0.8);

            signUpPane.getChildren().get(5).setOnMouseClicked((e1) -> {

                transition.translateTransition(0.8, signUp.getTranslateX(), signUp.getTranslateX(), 100, 235, signUp);
                transition.fadeTransition(0.8, signIn, 0, 0.5);
                transition.fadeTransition(0.8, corporateLabel, 0, 0.5);
                transition.fadeTransition(0.8, signUpPane, 0.8, 0).setOnFinished((e2) -> borderPane.getChildren().remove(signUpPane));
            });
        });
        corporateLabel.setOnMouseClicked((e) -> {

            transition.translateTransition(0.8, corporateLabel.getTranslateX(), corporate.getTranslateX() - 170, 235, 100, corporateLabel);
            transition.fadeTransition(0.8, signIn, 0.5, 0);
            transition.fadeTransition(0.8, signUp, 0.5, 0);

            corporate.setOpacity(0);
            borderPane.setCenter(corporate);

            transition.fadeTransition(0.8, corporate, 0, 0.8);

            corporate.getChildren().get(3).setOnMouseClicked((e1) -> {

                transition.translateTransition(0.8, corporateLabel.getTranslateX(), corporateLabel.getTranslateX() + 170, 100, 235, corporateLabel);
                transition.fadeTransition(0.8, signIn, 0, 0.5);
                transition.fadeTransition(0.8, signUp, 0, 0.5);
                transition.fadeTransition(0.8, corporate, 0.8, 0).setOnFinished((e2) -> borderPane.getChildren().remove(corporate));
            });
        });

        // pagination

        HBox pagination = new HBox(10);
        Circle circle = new Circle(5, Color.WHEAT);
        circle.setOpacity(0.8);
        circle.setOnMouseClicked(e ->
                transition.translateTransition(0.8, topPanel.getTranslateX(), 640,
                        topPanel.getTranslateY(), topPanel.getTranslateY(), topPanel).setOnFinished((e1) -> {
                    borderPane.getChildren().remove(pagination);
                    new MainPage().getPage(primaryStage);
            }));
        circle.setOnMouseEntered((e) -> {
            circle.setScaleX(1.1);
            circle.setScaleY(1.1);
        });
        circle.setOnMouseExited((e) -> {
            circle.setScaleX(1);
            circle.setScaleY(1);
        });

        Circle circle1 = new Circle(5, Color.WHEAT);
        circle1.setOpacity(0.8);
        circle1.setOnMouseEntered((e) -> {
            circle1.setScaleX(1.1);
            circle1.setScaleY(1.1);
        });
        circle1.setOnMouseExited((e) -> {
            circle1.setScaleX(1);
            circle1.setScaleY(1);
        });

        pagination.setAlignment(Pos.BOTTOM_CENTER);
        pagination.setTranslateY(-20);
        pagination.getChildren().addAll(circle, circle1);

        borderPane.setBottom(pagination);

        // preferences
        topPanel.setAlignment(Pos.TOP_CENTER);
        topPanel.getChildren().addAll(signIn, signUp, corporateLabel);

        borderPane.setTop(topPanel);
        borderPane.getStylesheets().add("view/style");
        primaryStage.setScene(new Scene(borderPane, 800, 500));

        return borderPane;
    }
}
