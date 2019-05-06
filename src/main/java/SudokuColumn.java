import java.util.List;

public class SudokuColumn extends SudokuElement
{
    SudokuColumn (List<List<SudokuField>> board, int line)
    {
        for (int i = 0; i < 9; ++i) {
            array.set(i, new SudokuField());
        }

        //wypełnianie column
        for (int i = 0; i < 9; ++i) {
            array.set(i, board.get(i).get(line));
        }
    }
}
