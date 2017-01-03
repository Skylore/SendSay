package view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import view.clientLayouts.Entrance;

public class MainPage {

    public void getPage(Stage primaryStage) {

        Transition transition = new Transition();
        BorderPane layout = new BorderPane();

        // top panel
        VBox top = new VBox();

        Label logo = new Label("", new ImageView("view/SendSayLogo.png"));
        logo.getStyleClass().clear();
        logo.setScaleX(0.7);
        logo.setScaleY(0.7);

        Label info = new Label("Bulk email distributions");
        info.getStyleClass().clear();
        info.setAlignment(Pos.CENTER);
        info.setScaleX(1.5);
        info.setScaleY(1.5);
        info.setTextFill(Color.WHEAT);
        info.setTranslateX(60);

        top.getChildren().addAll(logo, info);

        layout.setTop(top);

        // pagination
        HBox pagination = new HBox(10);
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
        Label button = new Label("Try it free");
        button.setOpacity(0.7);
        button.setScaleX(2.3);
        button.setScaleY(2.3);
        button.setTextFill(Color.INDIANRED.darker());
        button.setStyle("-fx-font-weight: bold");
        button.setAlignment(Pos.CENTER);
        button.getStyleClass().clear();
        button.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        button.setBorder(new Border(new BorderStroke(Color.INDIANRED.darker(), BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(0.5))));
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
            layout.getChildren().remove(pagination);
            transition.translateTransition(0.8, logo.getTranslateX(), logo.getTranslateX() - 500,
                    logo.getTranslateY(), logo.getTranslateY(), logo);
            transition.translateTransition(0.8, info.getTranslateX(), info.getTranslateX() - 500,
                    info.getTranslateY(), info.getTranslateY(), info);
            transition.translateTransition(0.8, button.getTranslateX(), button.getTranslateX() - 500,
                    button.getTranslateY(), button.getTranslateY(), button).setOnFinished((e2) -> new Entrance().getLayout(primaryStage));
        });

        layout.setCenter(button);


        Circle circle1 = new Circle(5, Color.WHITESMOKE);
        circle1.setOpacity(0.8);
        circle1.setOnMouseClicked((e) -> {
            layout.getChildren().remove(pagination);
            transition.translateTransition(0.8, logo.getTranslateX(), logo.getTranslateX() - 500,
                    logo.getTranslateY(), logo.getTranslateY(), logo);
            transition.translateTransition(0.8, info.getTranslateX(), info.getTranslateX() - 500,
                    info.getTranslateY(), info.getTranslateY(), info);
            transition.translateTransition(0.8, button.getTranslateX(), button.getTranslateX() - 500,
                    button.getTranslateY(), button.getTranslateY(), button).setOnFinished((e2) -> new Entrance().getLayout(primaryStage));
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
        Scene scene = new Scene(layout, 800, 500);
        primaryStage.setScene(scene);
    }
}
