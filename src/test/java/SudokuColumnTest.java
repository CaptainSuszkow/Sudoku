import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuColumnTest {
    SudokuSolver solver = new BacktrackingSudokuSolver();
    SudokuBoard a = new SudokuBoard();

    @Test
    void verify() {
        solver.solve(a);
        SudokuColumn sc1 = new SudokuColumn(a.board, 0);

        assertTrue(sc1.verify());

        sc1.setElementOfArray(sc1.getElementOfArray(1), 2);

        assertFalse(sc1.verify());
    }

    @Test
    void equals() {
        solver.solve(a);
        SudokuColumn sc1 = new SudokuColumn(a.board, 0);
        SudokuColumn sc2 = new SudokuColumn(a.board, 0);

        assertTrue(sc1.equals(sc2));

        sc2.setElementOfArray(sc2.getElementOfArray(1), 2);

        assertFalse(sc1.equals(sc2));

    }

}
