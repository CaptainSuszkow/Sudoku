import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class SudokuFieldTest {
    @Test
    void equals() {
        SudokuField sf1 = new SudokuField();
        SudokuField sf2 = new SudokuField();

        assertTrue(sf1.equals(sf2));
        sf2.setFieldValue(1);
        assertFalse(sf1.equals(sf2));
    }

    @Test
    void hashCodeTest() {
        SudokuField sf1 = new SudokuField();
        SudokuField sf2 = new SudokuField();
        sf2.setFieldValue(1);
        assertTrue(sf1.hashCode() == sf1.hashCode());
        assertFalse(sf1.hashCode() == sf2.hashCode());
    }
}
