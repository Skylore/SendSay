package view.clientLayouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClientLayout {

    public void getLayout(Stage primaryStage) {
        BorderPane layout = new BorderPane();

        // Top Menu
        HBox topMenu = new HBox(70);

        Label main = new Label("SendSay");
        main.setAlignment(Pos.CENTER);
        main.setPrefSize(150, 30);
        main.setOnMouseEntered((e) -> {
            main.setScaleY(0.95);
            main.setScaleX(0.95);
                });
        main.setOnMouseExited((e) -> {
            main.setScaleY(1);
            main.setScaleX(1);
        });
        main.setOnMouseClicked((e) -> System.out.println("Main"));
        main.getStylesheets().addAll("view/style");

        Label distribution = new Label("Distribution");
        distribution.setAlignment(Pos.CENTER);

        distribution.setOnMouseEntered((e) -> {
            distribution.setScaleY(0.95);
            distribution.setScaleX(0.95);
        });
        distribution.setOnMouseExited((e) -> {
            distribution.setScaleY(1);
            distribution.setScaleX(1);
        });
        distribution.setOnMouseClicked((e) -> System.out.println("Distribution"));
        distribution.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE.darker(), CornerRadii.EMPTY, Insets.EMPTY)));
        distribution.setPrefSize(150, 30);

        Label contacts = new Label("Contact lists");
        contacts.setAlignment(Pos.CENTER);
        contacts.setOnMouseEntered((e) -> {
            contacts.setScaleY(0.95);
            contacts.setScaleX(0.95);
        });
        contacts.setOnMouseExited((e) -> {
            contacts.setScaleY(1);
            contacts.setScaleX(1);
        });
        contacts.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE.darker(), CornerRadii.EMPTY, Insets.EMPTY)));
        contacts.setPrefSize(150, 30);
        contacts.setOnMouseClicked((e) -> System.out.println("ContactLists"));

        Label work = new Label("Work");
        work.setAlignment(Pos.CENTER);
        work.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE.darker(), CornerRadii.EMPTY, Insets.EMPTY)));
        work.setPrefSize(150, 30);
        work.setOnMouseEntered((e) -> {
            work.setScaleY(0.95);
            work.setScaleX(0.95);
        });
        work.setOnMouseExited((e) -> {
            work.setScaleY(1);
            work.setScaleX(1);
        });
        work.setOnMouseClicked((e) -> System.out.println("Work"));

        //signUp.setOnMouseClicked((e) -> layout.setCenter(SignUpLayout.getLayout(primaryStage)));

        topMenu.getChildren().addAll(main, distribution, contacts, work);

        StackPane leftMenu = new StackPane();
        Label adminLabel = new Label("admin menu");
        adminLabel.setRotate(90);
        adminLabel.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE.darker(), CornerRadii.EMPTY, Insets.EMPTY)));
        adminLabel.setOnMouseClicked((e) -> System.out.println("Admin menu"));
        leftMenu.getChildren().addAll(adminLabel);
        leftMenu.setTranslateX(-35);
        leftMenu.setTranslateY(50);

        layout.setTop(topMenu);
        layout.setLeft(leftMenu);

        Scene scene = new Scene(layout, 800, 500);
        scene.getStylesheets().add("view/style");
        primaryStage.setScene(scene);
    }
}
