import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class SudokuBoard {


    public List<List<SudokuField>> board;


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

    public boolean equals(final SudokuBoard  b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.get(i,j) != b.get(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public SudokuRow getRow(int y) {
        SudokuRow sr = new SudokuRow();

        for (int i = 0; i < 9; ++i) {
            sr.setElementOfArray(board.get(y).get(i), i);
        }
        return sr;
    }

    public SudokuColumn getColumn(int x) {
        SudokuColumn sc = new SudokuColumn();

        for (int i = 0; i < 9; ++i) {
            sc.setElementOfArray(board.get(i).get(x), i);
        }
        return sc;
    }

    public SudokuBox getBox(int x, int y) {
        int subX = x - x % 3;
        int subY = y - y % 3;

        SudokuBox sb = new SudokuBox();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.setElementOfBox(board.get(subY + i).get(subX + j), i, j);
            }
        }
        return sb;
    }
    /*
    public static void main(final String[] args) {
        SudokuBoard sb = new SudokuBoard();

        SudokuSolver solver = new BacktrackingSudokuSolver();

        if (solver.solve(sb)) {
            for (int i = 0; i < 9; ++i) {
                System.out.print('\n');
                if (i % 3 == 0 && i > 0) {
                    System.out.print('\n');
                }
                for (int j = 0; j < 9; ++j) {
                    System.out.print(sb.board[i][j].getFieldValue() + " ");
                    if (j % 3 == 2) {
                        System.out.print(" ");
                    }
                }
            }
        }

        SudokuBox box = new SudokuBox();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                box = sb.getBox(i * 3, j * 3);

                System.out.println("\nBox: ");

                for (int b = 0; b < 3; ++b) {
                    System.out.print('\n');
                    for (int p = 0; p < 3; ++p) {
                        System.out.print(box.getElementOfBox(b, p).getFieldValue() + " ");
                        System.out.print(sb.get(j * 3 + b, i * 3 + p) + " ");
                    }
                }
            }
        }
    }
    */
}

