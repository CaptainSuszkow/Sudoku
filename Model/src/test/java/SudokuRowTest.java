import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuRowTest {
    SudokuSolver solver = new BacktrackingSudokuSolver();
    SudokuBoard a = new SudokuBoard();

    @Test
    void verify() {
        solver.solve(a);
        SudokuRow sr1 = new SudokuRow(a.board, 0);

        assertTrue(sr1.verify());

        sr1.setElementOfArray(sr1.getElementOfArray(1), 2);

        assertFalse(sr1.verify());
    }

    @Test
    void equals() {
        solver.solve(a);
        SudokuRow sr1 = new SudokuRow(a.board, 0);
        SudokuRow sr2 = new SudokuRow(a.board, 0);

        assertTrue(sr1.equals(sr2));

        sr2.setElementOfArray(sr2.getElementOfArray(1), 2);

        assertFalse(sr1.equals(sr2));
    }
    @Test
    void hashCodeTest() {
        solver.solve(a);
        SudokuRow sr1 = new SudokuRow(a.board, 0);
        SudokuRow sr2 = new SudokuRow(a.board, 1);
        assertTrue(sr1.hashCode() == sr1.hashCode());
        assertFalse(sr1.hashCode() == sr2.hashCode());
    }
}
