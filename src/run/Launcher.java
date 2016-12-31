package run;

import javafx.application.Application;
import javafx.stage.Stage;
import view.PrimaryLayout;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new PrimaryLayout().start(primaryStage);
    }
}
