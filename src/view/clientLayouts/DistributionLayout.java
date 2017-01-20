package view.clientLayouts;

import controllers.UserController;
import controllers.UserControllerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DistributionLayout {

    DistributionLayout() {
        init();
    }

    private BorderPane pane = new BorderPane();

    private VBox leftPanel = initLeftPanel();
    private VBox emailPanel = initCenterPanel();
    private Label bottomPanel;

    private ObservableList<String> emails = FXCollections.observableArrayList();
    private TextField currentTittle;
    private TextField currentText;

    private VBox initLeftPanel() {
        VBox target = new VBox(10);
        target.setPrefSize(150, 200);

        final ListView<String> listView = new ListView<>(emails);
        listView.setStyle("-fx-background-color: #F0FFF0");
        listView.setOpacity(0.8);

        TextField emailInput = new TextField();
        emailInput.setStyle("-fx-background-color: #F0FFF0");
        emailInput.setOpacity(0.8);
        emailInput.setPrefSize(80, 20);
        emailInput.setPromptText("Inout email and press");
        emailInput.setOnMouseClicked((e) -> {
            if (!emailInput.getText().isEmpty() || emailInput.getText().contains("@")) {
                emails.addAll(emailInput.getText());
                listView.refresh();
                System.out.println(emailInput.getText() + " has been added");
                emailInput.setText("");
            }
        });
        emailInput.setOnMouseEntered((e) -> {
            emailInput.setScaleX(1.05);
            emailInput.setScaleY(1.05);
        });
        emailInput.setOnMouseExited((e) -> {
            emailInput.setScaleX(1);
            emailInput.setScaleY(1);
        });

        target.getChildren().addAll(emailInput, listView);

        return target;
    }

    private VBox initCenterPanel() {
        VBox target = new VBox(10);
        target.setPrefSize(400, 200);

        currentTittle.setPromptText("Tittle");
        currentTittle.setPrefSize(400, 30);
        currentTittle.setStyle("-fx-background-color: #F0FFF0");
        currentTittle.setOpacity(0.9);

        currentText.setPrefSize(400, 270);
        currentText.setStyle("-fx-background-color: #F0FFF0");
        currentText.setOpacity(0.9);

        target.getChildren().addAll(currentTittle, currentText);
        target.setTranslateX(10);

        return target;
    }

    private void init() {
        pane.setLeft(leftPanel);
        pane.setCenter(emailPanel);
    }

    public static BorderPane getPane(Stage primaryStage) {
        DistributionLayout distributionLayout = new DistributionLayout();

        BorderPane borderPane = distributionLayout.pane;
        borderPane.setScaleX(0.9);
        borderPane.setScaleY(0.9);
        return distributionLayout.pane;
    }

    public BorderPane getPane() {
        return pane;
    }

    public VBox getLeftPanel() {
        return leftPanel;
    }

    public VBox getEmailPanel() {
        return emailPanel;
    }

    public Label getBottomPanel() {
        return bottomPanel;
    }
}
