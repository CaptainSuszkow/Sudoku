import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSudokuBoardDaoTest {
    SudokuBoard board = new SudokuBoard();
    SudokuSolver solver = new BacktrackingSudokuSolver();

    @Test
    void read() {
        FileSudokuBoardDao reader = new FileSudokuBoardDao("file.txt");

        board = reader.read();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               System.out.print(board.get(i,j)+" ");
            }
            System.out.println();
        }

    }

    @Test
    void write() {
        FileSudokuBoardDao writer = new FileSudokuBoardDao("file.txt");

        solver.solve(board);

        writer.write(board);
    }
}