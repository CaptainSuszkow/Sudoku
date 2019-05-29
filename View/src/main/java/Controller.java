//package sample;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {
    public Button buttonEasy;
    public Button buttonMedium;
    public Button buttonHard;

    private TextField[][] input = new TextField[9][9];

    private SudokuSolver solver = new BacktrackingSudokuSolver();
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private List<List<SudokuField>> board = new ArrayList<List<SudokuField>>();

    public void handleButtonClick(ActionEvent event) {

        solver.solve(sudokuBoard);

        if (buttonEasy.isHover()) {
            board = sudokuBoard.getBoardLevel(SudokuBoard.DifficultyLevel.EASY);
        } else if (buttonMedium.isHover()) {
            board = sudokuBoard.getBoardLevel(SudokuBoard.DifficultyLevel.MEDIUM);
        } else if (buttonHard.isHover()) {
            board = sudokuBoard.getBoardLevel(SudokuBoard.DifficultyLevel.HARD);
        }

        GridPane gpLayout = new GridPane();
        gpLayout.setPadding(new Insets(25, 25, 25, 25));
        gpLayout.setHgap(10);
        gpLayout.setVgap(10);

        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[0].length; ++j) {
                if (board.get(i).get(j).getFieldValue() != 0) {
                    input[i][j] = new TextField(Integer.toString(board.get(i).get(j).getFieldValue()));
                } else {
                    input[i][j] = new TextField();
                }
                gpLayout.getChildren().add(input[i][j]);
                GridPane.setConstraints(input[i][j], i, j);
            }
        }

        Scene scene2 = new Scene(gpLayout, 400, 400);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }

}