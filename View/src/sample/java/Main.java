//package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/

        window = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setScene(new Scene(root, 300, 300));
        window.setTitle("Sudoku");
        window.show();
    }


}