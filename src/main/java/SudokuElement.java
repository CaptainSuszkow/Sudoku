import java.util.Arrays;
import java.util.List;

public class SudokuElement {
    //private SudokuField[] array;
    protected List<SudokuField> array  = Arrays.asList(new SudokuField[9]);

    SudokuElement() {
        //array = new SudokuField[9];
        for (int i = 0; i < 9; ++i) {
            array.set(i,new SudokuField());
        }
    }

    public boolean verify() {
        for (int i = 0; i < 8; ++i) {
            for (int j = i + 1; j < 9; ++j) {
                if (array.get(i).getFieldValue() == array.get(j).getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setElementOfArray(SudokuField sf, int i) {
        array.set(i,sf);
    }

    public SudokuField getElementOfArray(int i) {
        return array.get(i);
    }
}
