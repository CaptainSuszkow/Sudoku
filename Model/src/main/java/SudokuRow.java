import java.util.List;

public class SudokuRow extends SudokuElement {
    SudokuRow(List<List<SudokuField>> board, int line) {
        for (int i = 0; i < 9; ++i) {
            array.set(i, new SudokuField());
        }

        //wypełnianie row
        for (int i = 0; i < 9; ++i) {
            array.set(i, board.get(line).get(i));
        }
    }
}
