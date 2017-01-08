package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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

    private Label frontPane = new Label("", new ImageView("view/res/SendsayPrimaryPage.png"));

    private HBox pagination = new HBox(10);

    private void init() {

        frontPane.getStyleClass().clear();
        frontPane.setOpacity(0.7);
        frontPane.setTranslateY(-55);
        frontPane.setOnMouseClicked((e) -> slide());
        layout.setCenter(frontPane);

        // pagination
        Circle circle = new Circle(5, Color.WHEAT.darker());
        circle.setOpacity(0.8);
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
        circle1.setOnMouseClicked((e) -> slide());
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
        layout.getChildren().add(new KeyEvent());

    }

    private class KeyEvent extends Region {
        private KeyEvent() {
            setId("KeyEvent");
            setPrefSize(800, 500);
            setFocusTraversable(true);
            setOnKeyPressed((e) -> {
                switch (e.getCode().getName()) {
                    case "Right":
                        slide();
                    case "Enter":
                        slide();

                }
            });
        }
    }

    private void slide() {
        Transition transition = new Transition();
        transition.translateTransition(0.8, frontPane.getTranslateX(), frontPane.getTranslateX() - 800,
                frontPane.getTranslateY() - 15, frontPane.getTranslateY() - 15, frontPane);

        HBox target = new Entrance(primaryStage).getTopPanel();
        layout.setTop(target);
        target.setTranslateX(800);
        transition.translateTransition(0.8, target.getTranslateX(), target.getTranslateX() - 800,
                target.getTranslateY(), target.getTranslateY(), target).
                setOnFinished((e) -> Entrance.getLayout(primaryStage));
    }

    public static void getPage(Stage primaryStage) {
        MainPage mainPage = new MainPage(primaryStage);
        Scene scene = new Scene(mainPage.layout, 800, 500);

        primaryStage.setScene(scene);
    }

    public Label getFrontPane() {
        return frontPane;
    }
}
