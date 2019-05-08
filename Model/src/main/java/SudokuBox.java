import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuBox {

    public List<List<SudokuField>> box;

    public SudokuBox(List<List<SudokuField>> board, int subX, int subY) {
        List<List<SudokuField>> temp = new ArrayList<List<SudokuField>>();

        for (int i = 0; i < 3; i++) {
            SudokuField[] row = new SudokuField[3];
            temp.add(Arrays.asList(row));
        }
        this.box  = Collections.unmodifiableList(temp);

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                box.get(i).set(j, new SudokuField());
            }
        }
        //wypełnianie boxa
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                box.get(i).set(j, board.get(subY + i).get(subX + j));
                //sb.setElementOfBox(board.get(subY + i).get(subX + j), i, j);
            }
        }
    }

    public boolean verify() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int x = 0; x < 3; ++x) {
                    for (int y = 0; y < 3; ++y) {
                        if ((i != x || j != y) && (box.get(i).get(j).getFieldValue() == box.get(x).get(y).getFieldValue())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void setElementOfBox(SudokuField sf, int i, int j) {
        //box[i][j] = sf;
        box.get(i).set(j,sf);
    }

    public SudokuField getElementOfBox(int i, int j) {
        return box.get(i).get(j);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("box", box)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SudokuBox sudokuBox = (SudokuBox) o;

        return new EqualsBuilder()
                .append(box, sudokuBox.box)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(box)
                .toHashCode();
    }
}
