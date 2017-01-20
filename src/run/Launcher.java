package run;

import dataBase.Converter;
import dataBase.DataBase;
import dataBase.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainPage;

public class Launcher extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setOnCloseRequest((e) -> new Logger().write(Converter.toJson(DataBase.getInstance())));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Send Say");

        MainPage.getPage(primaryStage);
        primaryStage.show();
    }
}
