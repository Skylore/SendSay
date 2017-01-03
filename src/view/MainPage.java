package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import view.clientLayouts.Entrance;

public class MainPage {

    private Stage primaryStage;

    public MainPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        init();
    }

    private BorderPane layout = new BorderPane();
    private VBox top = new VBox();

    private Label logo = new Label("", new ImageView("view/SendSayLogo.png"));
    private Label info = new Label("Bulk email distributions");
    private Label button = new Label("Try it free");

    private HBox pagination = new HBox(10);

    private void init() {

        Transition transition = new Transition();

        // top panel
        logo.getStyleClass().clear();
        logo.setScaleX(0.7);
        logo.setScaleY(0.7);

        info.getStyleClass().clear();
        info.setAlignment(Pos.CENTER);
        info.setScaleX(1.5);
        info.setScaleY(1.5);
        info.setTextFill(Color.WHEAT);
        info.setTranslateX(60);

        top.getChildren().addAll(logo, info);

        layout.setTop(top);

        // pagination
        Circle circle = new Circle(5, Color.WHEAT);
        circle.setOpacity(0.8);
        circle.setOnMouseEntered((e) -> {
            circle.setScaleX(1.1);
            circle.setScaleY(1.1);
        });
        circle.setOnMouseExited((e) -> {
            circle.setScaleX(1);
            circle.setScaleY(1);
        });

        // center button
        button.setOpacity(0.9);
        button.setScaleX(2.3);
        button.setScaleY(2.3);
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-font-style: italic");
        button.setAlignment(Pos.CENTER);
        button.getStyleClass().clear();
        button.setBackground(new Background(new BackgroundFill(Color.INDIANRED.darker(), null, null)));
        button.setOnMouseEntered((e) -> {
            button.setScaleX(2.4);
            button.setScaleY(2.4);
        });
        button.setOnMouseExited((e) -> {
            button.setScaleX(2.3);
            button.setScaleY(2.3);
        });
        button.setTranslateY(-50);
        button.setOnMouseClicked((e) -> {
            HBox target = new Entrance(primaryStage).getTopPanel();
            button.setTranslateX(240);
            target.setTranslateY(-107);
            layout.setRight(target);
            transition.translateTransition(0.8, logo.getTranslateX(), logo.getTranslateX() - 500,
                    logo.getTranslateY(), logo.getTranslateY(), logo);
            transition.translateTransition(0.8, info.getTranslateX(), info.getTranslateX() - 500,
                    info.getTranslateY(), info.getTranslateY(), info);
            transition.translateTransition(0.8, button.getTranslateX(), button.getTranslateX() - 500,
                    button.getTranslateY(), button.getTranslateY(), button).setOnFinished((e2) -> {
                Entrance.getLayout(primaryStage);
                layout.getChildren().remove(pagination);
            });
            transition.translateTransition(0.8, target.getTranslateX() + 500, target.getTranslateX() - 160,
                    target.getTranslateY(), target.getTranslateY(), target);
        });

        layout.setCenter(button);

        Circle circle1 = new Circle(5, Color.WHITESMOKE);
        circle1.setOpacity(0.8);
        circle1.setOnMouseClicked((e) -> {
            HBox target = new Entrance(primaryStage).getTopPanel();
            button.setTranslateX(240);
            target.setTranslateY(-107);
            layout.setRight(target);
            transition.translateTransition(0.8, logo.getTranslateX(), logo.getTranslateX() - 500,
                    logo.getTranslateY(), logo.getTranslateY(), logo);
            transition.translateTransition(0.8, info.getTranslateX(), info.getTranslateX() - 500,
                    info.getTranslateY(), info.getTranslateY(), info);
            transition.translateTransition(0.8, button.getTranslateX(), button.getTranslateX() - 500,
                    button.getTranslateY(), button.getTranslateY(), button).setOnFinished((e2) -> {
                Entrance.getLayout(primaryStage);
                layout.getChildren().remove(pagination);
            });
            transition.translateTransition(0.8, target.getTranslateX() + 500, target.getTranslateX() - 160,
                    target.getTranslateY(), target.getTranslateY(), target);
        });
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

        layout.setBottom(pagination);

        layout.getStylesheets().add("view/style");

    }

    public static void getPage(Stage primaryStage) {
        MainPage mainPage = new MainPage(primaryStage);
        Scene scene = new Scene(mainPage.layout, 800, 500);

        primaryStage.setScene(scene);
    }

    public Label getLogo() {
        return logo;
    }

    public Label getInfo() {
        return info;
    }

    public Label getButton() {
        return button;
    }
}
