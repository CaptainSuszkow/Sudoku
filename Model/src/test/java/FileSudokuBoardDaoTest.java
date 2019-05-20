import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSudokuBoardDaoTest {


    @Test
    void readAndWrtie() {
        SudokuBoard board = new SudokuBoard();
        SudokuSolver solver = new BacktrackingSudokuSolver();
        FileSudokuBoardDao steam = new FileSudokuBoardDao("file.txt");

        solver.solve(board);

        steam.write(board);

        SudokuBoard board1 = steam.read();

        assertEquals(board.hashCode(),board1.hashCode());

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               System.out.print(board.get(i,j)+" ");
            }
            System.out.println();
        }

    }


}