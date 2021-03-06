package view.clientLayouts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import view.MainPage;
import view.Transition;

public class Entrance {

    private Stage primaryStage;

    public Entrance(Stage primaryStage) {
        this.primaryStage = primaryStage;
        init();
    }

    private BorderPane borderPane = new BorderPane();

    private GridPane logInPane;
    private GridPane signUpPane;
    private GridPane corporate;

    private Label signIn = new Label("Sign in");
    private Label signUp = new Label("Sign up");
    private Label corporateLabel = new Label("Corporate");
    private HBox topPanel = new HBox(15);

    private HBox pagination = new HBox(10);

    private void init() {

        logInPane = new SignInLayout(primaryStage).getLogInPane();
        signUpPane = SignUpLayout.getLayout(primaryStage);
        corporate = CorporateSignInLayout.getLayout(primaryStage);

        borderPane.getChildren().add(new KeyEvent());

        Transition transition = new Transition();

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

        Circle circle = new Circle(5, Color.WHEAT);
        circle.setOpacity(0.8);
        circle.setOnMouseClicked((e) -> slide());
        circle.setOnMouseEntered((e) -> {
            circle.setScaleX(1.1);
            circle.setScaleY(1.1);
        });
        circle.setOnMouseExited((e) -> {
            circle.setScaleX(1);
            circle.setScaleY(1);
        });

        Circle circle1 = new Circle(5, Color.WHEAT.darker());
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
        topPanel.setAlignment(Pos.TOP_CENTER);
        topPanel.getChildren().addAll(signIn, signUp, corporateLabel);

        borderPane.setTop(topPanel);
        borderPane.getStylesheets().add("view/style");
    }

    private void slide() {
        Transition transition = new Transition();
        transition.translateTransition(0.8, topPanel.getTranslateX(), topPanel.getTranslateX() + 800,
                topPanel.getTranslateY(), topPanel.getTranslateY(), topPanel).
                setOnFinished((e) -> MainPage.getPage(primaryStage));
        Label target = new MainPage(primaryStage).getFrontPane();
        target.setTranslateX(-800);
        target.setTranslateY(190);
        borderPane.getChildren().add(target);
        transition.translateTransition(0.8, target.getTranslateX(), target.getTranslateX() + 800,
                target.getTranslateY(), target.getTranslateY(), target);
    }

    private class KeyEvent extends Region {
        KeyEvent() {
            setId("EnterKeyEvent");
            setPrefSize(800, 500);
            setFocusTraversable(true);
            setOnKeyPressed((e) -> {
                if (e.getCode().getName().equals("Left") && borderPane.getCenter() == null)
                    slide();
            });
        }
    }

    public static void getLayout(Stage primaryStage) {

        Entrance entrance = new Entrance(primaryStage);
        primaryStage.setScene(new Scene(entrance.borderPane, 800, 500));
    }

    public HBox getTopPanel() {
        return topPanel;
    }
}