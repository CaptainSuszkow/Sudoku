import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("array", array)
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

        SudokuElement that = (SudokuElement) o;

        return new EqualsBuilder()
                .append(array, that.array)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(array)
                .toHashCode();
    }
}
