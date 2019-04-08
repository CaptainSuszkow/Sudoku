public class SudokuBox {
    private SudokuField[][] box;

    public SudokuBox() {
        box = new SudokuField[3][];
        for (int i = 0; i < 3; ++i) {
            box[i] = new SudokuField[3];
        }
    }

    public boolean verify() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int x = 0; x < 3; ++x) {
                    for (int y = 0; y < 3; ++y) {
                        if (i != x && j != y && (box[i][j].getFieldValue() == box[x][y].getFieldValue())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void setElementOfBox(SudokuField sf, int i, int j) {
        box[i][j] = sf;
    }

    public SudokuField getElementOfBox(int i, int j) {
        return box[i][j];
    }
}
