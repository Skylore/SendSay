package view.clientLayouts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class ClientLayout {

    private Stage primaryStage;

    private ClientLayout(Stage primaryStage) {
        this.primaryStage = primaryStage;
        init();
    }

    private BorderPane layout = new BorderPane();
    private HBox topPanel = new HBox(-20);

    private Label sendSayLogo = initSendSayLogo();
    private Label distribution = new Label("", new ImageView("view/res/distributionIcon.png"));

    private Label contactList = new Label("", new ImageView("view/res/contactListIcon.png"));
    private Label workRequest = new Label("", new ImageView("view/res/workRequestIcon.png"));
    private Label help = new Label("", new ImageView("view/res/supportIcon.png"));
    private Label settings = new Label("", new ImageView("view/res/settingsIcon.png"));
    private Label exit = new Label("", new ImageView("view/res/logOutIcon.png"));

    private void init() {

        // top panel preferences
        sendSayLogo.getStyleClass().clear();
        topPanel.setTranslateX(30);
        topPanel.setOpacity(0.8);
        topPanel.getChildren().addAll(distributionBox(), contactListBox(), workRequestBox(), helpBox(), settingsBox(), exitBox());
        topPanel.setAlignment(Pos.TOP_CENTER);
        layout.setTop(topPanel);

        sendSayLogo.setTranslateY(-60);
        sendSayLogo.setTranslateX(10);
        layout.setLeft(sendSayLogo);

        layout.getStylesheets().add("view/style");
    }

    private Label initSendSayLogo() {

        ImageView imageView = new ImageView("view/SendSayLogo.png");
        imageView.setFitWidth(141);
        imageView.setFitHeight(38);

        return new Label("", imageView);
    }

    private VBox distributionBox() {
        distribution = new Label("", new ImageView("view/res/distributionIcon.png"));

        VBox distributionBox = new VBox();
        distributionBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        distributionBox.setAlignment(Pos.CENTER);
        distributionBox.setPrefWidth(110);
        distributionBox.setScaleX(0.8);
        distributionBox.setScaleY(0.8);
        distribution.getStyleClass().clear();
        distribution.setScaleX(1);
        distribution.setScaleY(1);
        distribution.setAlignment(Pos.TOP_CENTER);
        distribution.setOnMouseEntered((e) -> {
            distribution.setScaleX(1.1);
            distribution.setScaleY(1.1);
        });
        distribution.setOnMouseExited((e) -> {
            distribution.setScaleX(1);
            distribution.setScaleY(1);
        });
        Label distributionLabel = new Label("Distribution");
        distributionLabel.setAlignment(Pos.CENTER);
        distributionLabel.setStyle(" -fx-font-weight: bold");
        distributionLabel.setPrefWidth(distribution.getPrefWidth());
        distributionBox.getChildren().addAll(distribution, distributionLabel);

        return distributionBox;
    }

    private VBox contactListBox() {
        VBox contactListBox = new VBox();
        contactListBox.setAlignment(Pos.CENTER);
        contactListBox.setPrefWidth(110);
        contactListBox.setScaleX(0.8);
        contactListBox.setScaleY(0.8);
        contactList.getStyleClass().clear();
        contactList.setScaleX(1);
        contactList.setScaleY(1);
        contactListBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        contactList.setAlignment(Pos.CENTER);
        contactList.setOnMouseEntered((e) -> {
            contactList.setScaleX(1.1);
            contactList.setScaleY(1.1);
        });
        contactList.setOnMouseExited((e) -> {
            contactList.setScaleX(1);
            contactList.setScaleY(1);
        });
        Label contactListLabel = new Label("Contact lists");
        contactListLabel.setAlignment(Pos.CENTER);
        contactListLabel.setAlignment(Pos.CENTER);
        contactListLabel.setStyle(" -fx-font-weight: bold");
        contactListLabel.setPrefWidth(contactList.getPrefWidth());
        contactListBox.getChildren().addAll(contactList, contactListLabel);

        return contactListBox;
    }

    private VBox workRequestBox() {
        VBox workRequestBox = new VBox();
        workRequestBox.setAlignment(Pos.CENTER);
        workRequestBox.setPrefWidth(110);
        workRequestBox.setScaleX(0.8);
        workRequestBox.setScaleY(0.8);
        workRequest.getStyleClass().clear();
        workRequest.setScaleX(1);
        workRequest.setScaleY(1);
        workRequestBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        workRequest.setAlignment(Pos.CENTER);
        workRequest.setOnMouseEntered((e) -> {
            workRequest.setScaleX(1.1);
            workRequest.setScaleY(1.1);
        });
        workRequest.setOnMouseExited((e) -> {
            workRequest.setScaleX(1);
            workRequest.setScaleY(1);
        });
        Label workRequestLabel = new Label("Work");
        workRequestLabel.setAlignment(Pos.CENTER);
        workRequestLabel.setAlignment(Pos.CENTER);
        workRequestLabel.setStyle(" -fx-font-weight: bold");
        workRequestLabel.setPrefWidth(workRequest.getPrefWidth());
        workRequestBox.getChildren().addAll(workRequest, workRequestLabel);

        return workRequestBox;
    }

    private VBox helpBox() {
        VBox helpBox = new VBox();
        helpBox.setAlignment(Pos.CENTER);
        helpBox.setPrefWidth(110);
        helpBox.setScaleX(0.8);
        helpBox.setScaleY(0.8);
        help.getStyleClass().clear();
        help.setScaleX(1);
        help.setScaleY(1);
        helpBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        help.setAlignment(Pos.CENTER);
        help.setOnMouseEntered((e) -> {
            help.setScaleX(1.1);
            help.setScaleY(1.1);
        });
        help.setOnMouseExited((e) -> {
            help.setScaleX(1);
            help.setScaleY(1);
        });
        Label helpLabel = new Label("Help");
        helpLabel.setAlignment(Pos.CENTER);
        helpLabel.setStyle(" -fx-font-weight: bold");
        helpLabel.setPrefWidth(help.getPrefWidth());
        helpBox.getChildren().addAll(help, helpLabel);

        return helpBox;
    }

    private VBox settingsBox() {
        VBox settingsBox = new VBox();
        settingsBox.setAlignment(Pos.CENTER);
        settingsBox.setPrefWidth(110);
        settingsBox.setScaleX(0.8);
        settingsBox.setScaleY(0.8);
        settings.getStyleClass().clear();
        settings.setScaleX(1);
        settings.setScaleY(1);
        settingsBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        settings.setAlignment(Pos.CENTER);
        settings.setOnMouseEntered((e) -> {
            settings.setScaleX(1.1);
            settings.setScaleY(1.1);
        });
        settings.setOnMouseExited((e) -> {
            settings.setScaleX(1);
            settings.setScaleY(1);
        });
        Label settingsLabel = new Label("Preferences");
        settingsLabel.setAlignment(Pos.CENTER);
        settingsLabel.setAlignment(Pos.CENTER);
        settingsLabel.setStyle(" -fx-font-weight: bold");
        settingsLabel.setPrefWidth(settings.getPrefWidth());
        settingsBox.getChildren().addAll(settings, settingsLabel);

        return settingsBox;
    }

    private VBox exitBox() {
        VBox exitBox = new VBox();
        exitBox.setAlignment(Pos.CENTER);
        exitBox.setPrefWidth(110);
        exitBox.setScaleX(0.8);
        exitBox.setScaleY(0.8);
        exit.getStyleClass().clear();
        exit.setScaleX(1);
        exit.setScaleY(1);
        exitBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
        exit.setAlignment(Pos.CENTER);
        exit.setOnMouseEntered((e) -> {
            exit.setScaleX(1.1);
            exit.setScaleY(1.1);
        });
        exit.setOnMouseExited((e) -> {
            exit.setScaleX(1);
            exit.setScaleY(1);
        });
        Label exitLabel = new Label("Log out");
        exitLabel.setAlignment(Pos.CENTER);
        exitLabel.setAlignment(Pos.CENTER);
        exitLabel.setStyle(" -fx-font-weight: bold");
        exitLabel.setPrefWidth(exit.getPrefWidth());
        exitBox.getChildren().addAll(exit, exitLabel);

        exitBox.setOnMouseClicked((e) -> Entrance.getLayout(primaryStage));

        return exitBox;
    }

    static void getLayout(Stage primaryStage) {
        ClientLayout clientLayout = new ClientLayout(primaryStage);
        primaryStage.setScene(new Scene(clientLayout.layout, 800, 500));
    }
}
