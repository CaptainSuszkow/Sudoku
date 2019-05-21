import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuBoard implements Serializable, Cloneable {


    private List<List<SudokuField>> board;


    public SudokuBoard() {
        List<List<SudokuField>> temp = new ArrayList<List<SudokuField>>();

        for (int i = 0; i < 9; i++) {
            SudokuField[] row = new SudokuField[9];
            temp.add(Arrays.asList(row));
        }
        this.board  = Collections.unmodifiableList(temp);

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                board.get(i).set(j, new SudokuField());
            }
        }
    }

    public int get(int x, int y) {
        return board.get(x).get(y).getFieldValue();
    }

    public void set(int x, int y, int n) {
        board.get(x).get(y).setFieldValue(n);
    }

    public List<List<SudokuField>> getBoard() {
        return board;
    }

    public boolean checkBoard(int row, int col, int n) {

        for (int i = 0; i < 9; ++i) {
            if ((i != col && this.get(row,i) == n
                    || i != row && this.get(i,col) == n)) {
                return false;
            }
        }

        int subX = col - col % 3;
        int subY = row - row % 3;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (subY + i != row && subX + j != col
                        && this.get(subY + i, subX + j) == n) {
                    return false;
                }
            }
        }

        return true;
    }

    public SudokuRow getRow(int y) {
        SudokuRow sr = new SudokuRow(board, y);

        return sr;
    }

    public SudokuColumn getColumn(int x) {
        SudokuColumn sc = new SudokuColumn(board, x);

        return sc;
    }

    public SudokuBox getBox(int x, int y) {
        int subX = x - x % 3;
        int subY = y - y % 3;

        SudokuBox sb = new SudokuBox(board, subX, subY);

        return sb;


    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("board", board)
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

        SudokuBoard that = (SudokuBoard) o;

        return new EqualsBuilder()
                .append(board, that.board)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(board)
                .toHashCode();
    }

    public enum difficultyLevel {
        EASY, MEDIUM, HARD
    }

    public List<List<SudokuField>> getBoardLevel(difficultyLevel dLevel) {
        int numberOfEmptyFields;
        Random rnd = new Random();

        switch (dLevel) {
            case EASY:
                numberOfEmptyFields = 2;
                break;
            case MEDIUM:
                numberOfEmptyFields = 3;
                break;
            case HARD:
                numberOfEmptyFields = 4;
                break;
            default:
                numberOfEmptyFields = 2;
                break;
        }

        int r;

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < numberOfEmptyFields; ++j) {
                do {
                    r = rnd.nextInt(9);
                } while(board.get(i).get(r).getFieldValue() == 0);
                board.get(i).get(r).setFieldValue(0);
            }
        }



        return board;
    }


}

