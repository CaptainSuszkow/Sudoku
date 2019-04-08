public class SudokuElement {
    private SudokuField[] array;

    SudokuElement() {
        array = new SudokuField[9];
        for (int i = 0; i < 9; ++i) {
            array[i] = new SudokuField();
        }
    }

    public boolean verify() {
        for (int i = 0; i < 8; ++i) {
            for (int j = i + 1; j < 9; ++j) {
                if (array[i].getFieldValue() == array[j].getFieldValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setElementOfArray(SudokuField sf, int i) {
        array[i] = sf;
    }

    public SudokuField getElementOfArray(int i) {
        return array[i];
    }
}
