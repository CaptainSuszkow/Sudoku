import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {
    SudokuSolver solver = new BacktrackingSudokuSolver();
    SudokuBoard b = new SudokuBoard();
    SudokuBoard a = new SudokuBoard();

    @Test
    void solver() {
        solver.solve(a);
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                assertTrue(a.checkBoard(i,j,a.get(i,j)));
            }
        }
    }

    @Test
    void equals() {
        solver.solve(b);
        SudokuBoard d = new SudokuBoard();
        SudokuBoard c = new SudokuBoard();
        assertFalse(a.equals(b));
        assertTrue(c.equals(d));
        assertTrue(a.equals(a));
    }

    @Test
    void hashCodeTest() {
        solver.solve(a);
        solver.solve(b);
        assertTrue(a.hashCode() == a.hashCode());
        assertFalse(a.hashCode() == b.hashCode());
    }

    @Test
    void get() {
        a.set(1,1,1);
        assertEquals(a.get(1,1),1);
    }

    @Test
    void set() {
        a.set(1,2,3);
        assertEquals(a.get(1,2),3);
    }
    @Test
    void checkBoard() {
        a.set(1,1,0);
        assertFalse(a.checkBoard(1,1,0));
    }

    @Test
    void getColumn() {
        SudokuBoard c = new SudokuBoard();
        solver.solve(c);

        SudokuElement sc = new SudokuElement();

        for (int i = 0; i < 9; ++i) {
            sc = c.getColumn(i);
            assertTrue(sc.verify());

            for (int j = 0; j < 9; ++j) {
                assertTrue(sc.getElementOfArray(j).getFieldValue() == c.get(j, i));
            }
        }

        SudokuField sf = new SudokuField();
        sf.setFieldValue(2);

        sc.setElementOfArray(sf, 0);
        sc.setElementOfArray(sf, 1);

        assertFalse(sc.verify());
    }

    @Test
    void getRow() {
        SudokuBoard c = new SudokuBoard();
        solver.solve(c);

        //SudokuRow sr = new SudokuRow();
        SudokuElement sr = new SudokuElement();
        for (int i = 0; i < 9; ++i) {
            sr = c.getRow(i);
            assertTrue(sr.verify());

            for (int j = 0; j < 9; ++j) {
                assertTrue(sr.getElementOfArray(j).getFieldValue() == c.get(i, j));
            }
        }

        SudokuField sf = new SudokuField();
        sf.setFieldValue(2);

        sr.setElementOfArray(sf, 0);
        sr.setElementOfArray(sf, 1);

        assertFalse(sr.verify());
    }

    @Test
    void getBox() {
        SudokuBoard c = new SudokuBoard();
        solver.solve(c);

        SudokuBox sb = new SudokuBox(c.board, 0, 0);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb = c.getBox(i*3, j*3);
                assertTrue(sb.verify());

                for (int x = 0; x < 3; ++x) {
                    for (int y = 0; y < 3; ++y) {
                        assertTrue(sb.getElementOfBox(x, y).getFieldValue() == c.get(j * 3 + x, i * 3 + y));
                    }
                }
            }
        }

        SudokuField sf = new SudokuField();
        sf.setFieldValue(2);

        sb.setElementOfBox(sf, 0, 0);
        sb.setElementOfBox(sf, 1, 1);

        assertFalse(sb.verify());
    }


}
