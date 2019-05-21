//package sample;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class Controller /*implements Initializable */{

    public Button buttonEasy;
    public Button buttonMedium;
    public Button buttonHard;

    private TextField[][] input = new TextField[9][9];

    private SudokuSolver solver = new BacktrackingSudokuSolver();
    private SudokuBoard a = new SudokuBoard();
    private List<List<SudokuField>> board = new ArrayList<List<SudokuField>>();

    public void handleButtonClick (ActionEvent event) {
        /*if (buttonEasy.isHover()) {
            System.out.println("Easy button clicked");

        }
        else
            System.out.println("other button");*/

        solver.solve(a);

        if (buttonEasy.isHover())
        {
            board = a.getBoardLevel(SudokuBoard.difficultyLevel.EASY);
        } else if (buttonMedium.isHover())
        {
            board = a.getBoardLevel(SudokuBoard.difficultyLevel.MEDIUM);
        } else if (buttonHard.isHover()) {
            board = a.getBoardLevel(SudokuBoard.difficultyLevel.HARD);
        }

        GridPane gpLayout = new GridPane();
        gpLayout.setPadding(new Insets(25, 25, 25, 25));
        gpLayout.setHgap(10);
        gpLayout.setVgap(10);

        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[0].length; ++j) {
                if (board.get(i).get(j).getFieldValue() != 0) {
                    input[i][j] = new TextField(Integer.toString(board.get(i).get(j).getFieldValue()));
                } else
                    input[i][j] = new TextField();
                /*if (a.getBoard().get(i).get(j).getFieldValue() != 0) {
                    input[i][j] = new TextField(Integer.toString(a.getBoard().get(i).get(j).getFieldValue()));
                } else
                    input[i][j] = new TextField();*/

                /*input[i][j].prefWidth(30);
                input[i][j].prefHeight(15);*/
                gpLayout.getChildren().add(input[i][j]);
                GridPane.setConstraints(input[i][j], i, j);
            }
        }



        /*StackPane layout2 = new StackPane();
        Label lab2 = new Label("Secon scene, yay!");
        layout2.getChildren().add(lab2);*/
        Scene scene2 = new Scene(gpLayout, 400, 400);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }

}