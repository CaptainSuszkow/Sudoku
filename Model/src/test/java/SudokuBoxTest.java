import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoxTest {
    SudokuSolver solver = new BacktrackingSudokuSolver();
    SudokuBoard a = new SudokuBoard();

    @Test
    void verify() {
        solver.solve(a);
        SudokuBox sb1 = new SudokuBox(a.board, 0,0);
        SudokuBox sb2 = new SudokuBox(a.board, 0,0);

        sb2.setElementOfBox(sb2.getElementOfBox(1,1), 1, 2);

        assertTrue(sb1.verify());
        assertFalse(sb2.verify());
    }

    @Test
    void equals() {
        solver.solve(a);
        SudokuBox sb1 = new SudokuBox(a.board, 0,0);
        SudokuBox sb2 = new SudokuBox(a.board, 0,0);

        assertTrue(sb1.equals(sb2));

        sb2.setElementOfBox(sb2.getElementOfBox(1,1), 1, 2);

        assertFalse(sb1.equals(sb2));
    }

    @Test
    void hashCodeTest() {
        solver.solve(a);
        SudokuBox sb1 = new SudokuBox(a.board, 0, 0);
        SudokuBox sb2 = new SudokuBox(a.board, 6, 6);
        assertTrue(sb1.hashCode() == sb1.hashCode());
        assertFalse(sb1.hashCode() == sb2.hashCode());
    }
}
