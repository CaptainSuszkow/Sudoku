import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileSudokuBoardDaoTest {


    @Test
    void readAndWrtie() {
        SudokuBoard board = new SudokuBoard();
        SudokuBoard board1 = null;
        SudokuSolver solver = new BacktrackingSudokuSolver();

        solver.solve(board);

        try(FileSudokuBoardDao steam = new FileSudokuBoardDao("file.txt") ){
            steam.write(board);
            board1 = steam.read();
        } catch (IOException e){

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(board.hashCode(),board1.hashCode());

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               System.out.print(board.get(i,j)+" ");
            }
            System.out.println();
        }
    }
}