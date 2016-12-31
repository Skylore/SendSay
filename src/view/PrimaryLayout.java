package view;

import dataBase.Converter;
import dataBase.DataBase;
import dataBase.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.clientLayouts.CorporateSignInLayout;
import view.clientLayouts.SignInLayout;
import view.clientLayouts.SignUpLayout;

public class PrimaryLayout extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();

        GridPane logInPane = SignInLayout.getLayout(primaryStage);
        GridPane signUpPane = SignUpLayout.getLayout(primaryStage);
        GridPane corporate = CorporateSignInLayout.getLayout(primaryStage);

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

        signIn.setOnMouseClicked((e) -> {

            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.3), signIn);
            translateTransition.setFromY(235);
            translateTransition.setToY(100);
            translateTransition.setFromX(signIn.getTranslateX());
            translateTransition.setToX(160 - signIn.getTranslateX());
            translateTransition.play();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.3), signUp);
            fadeTransition.setFromValue(0.5);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1.3), corporateLabel);
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            logInPane.setOpacity(0);
            borderPane.setCenter(logInPane);

            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1.3), logInPane);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(0.8);
            fadeTransition2.play();

            logInPane.getChildren().get(3).setOnMouseClicked((e1) -> {
                TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(1.3), signIn);
                translateTransition3.setFromY(100);
                translateTransition3.setToY(235);
                translateTransition3.setFromX(signIn.getTranslateX());
                translateTransition3.setToX(signIn.getTranslateX() - 160);
                translateTransition3.play();

                FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(1.3), signUp);
                fadeTransition4.setFromValue(0);
                fadeTransition4.setToValue(0.5);
                fadeTransition4.play();

                FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(1.3), corporateLabel);
                fadeTransition5.setFromValue(0);
                fadeTransition5.setToValue(0.5);
                fadeTransition5.play();

                FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(1.3), logInPane);
                fadeTransition6.setFromValue(0.8);
                fadeTransition6.setToValue(0);
                fadeTransition6.play();
                fadeTransition6.setOnFinished((e2) -> borderPane.getChildren().remove(logInPane));
            });
        });
        signUp.setOnMouseClicked((e) -> {
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.3), signUp);
            translateTransition.setFromY(235);
            translateTransition.setToY(100);
            translateTransition.play();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.3), signIn);
            fadeTransition.setFromValue(0.5);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1.3), corporateLabel);
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            signUpPane.setOpacity(0);
            borderPane.setCenter(signUpPane);

            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1.3),signUpPane);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(0.8);
            fadeTransition2.play();

            signUpPane.getChildren().get(5).setOnMouseClicked((e1) -> {
                TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(1.3), signUp);
                translateTransition3.setFromY(100);
                translateTransition3.setToY(235);
                translateTransition3.play();

                FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(1.3), signIn);
                fadeTransition4.setFromValue(0);
                fadeTransition4.setToValue(0.5);
                fadeTransition4.play();

                FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(1.3), corporateLabel);
                fadeTransition5.setFromValue(0);
                fadeTransition5.setToValue(0.5);
                fadeTransition5.play();

                FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(1.3), signUpPane);
                fadeTransition6.setFromValue(0.8);
                fadeTransition6.setToValue(0);
                fadeTransition6.play();
                fadeTransition6.setOnFinished((e2) -> borderPane.getChildren().remove(signUpPane));
            });
        });
        corporateLabel.setOnMouseClicked((e) -> {
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.3), corporateLabel);
            translateTransition.setFromY(235);
            translateTransition.setToY(100);
            translateTransition.setFromX(corporateLabel.getTranslateX());
            translateTransition.setToX(corporateLabel.getTranslateX() - 170);
            translateTransition.play();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.3), signIn);
            fadeTransition.setFromValue(0.5);
            fadeTransition.setToValue(0);
            fadeTransition.play();

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(1.3), signUp);
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            corporate.setOpacity(0);
            borderPane.setCenter(corporate);

            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1.3), corporate);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(0.8);
            fadeTransition2.play();

            corporate.getChildren().get(3).setOnMouseClicked((e1) -> {
                TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(1.3), corporateLabel);
                translateTransition3.setFromY(100);
                translateTransition3.setToY(235);
                translateTransition3.setFromX(corporateLabel.getTranslateX());
                translateTransition3.setToX(corporateLabel.getTranslateX() + 170);
                translateTransition3.play();

                FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(1.3), signIn);
                fadeTransition4.setFromValue(0);
                fadeTransition4.setToValue(0.5);
                fadeTransition4.play();

                FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(1.3), signUp);
                fadeTransition5.setFromValue(0);
                fadeTransition5.setToValue(0.5);
                fadeTransition5.play();

                FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(1.3), corporate);
                fadeTransition6.setFromValue(0.8);
                fadeTransition6.setToValue(0);
                fadeTransition6.play();
                fadeTransition6.setOnFinished((e2) -> borderPane.getChildren().remove(corporate));
            });
        });

        topPanel.setAlignment(Pos.TOP_CENTER);
        topPanel.getChildren().addAll(signIn, signUp, corporateLabel);

        borderPane.setTop(topPanel);

        Scene scene = new Scene(borderPane, 800, 500);
        scene.getStylesheets().add("view/style");

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest((e) -> new Logger().write(Converter.toJson(DataBase.getInstance())));
        primaryStage.show();
    }
}
