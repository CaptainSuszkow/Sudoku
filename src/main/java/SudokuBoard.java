import java.util.Random;

public class SudokuBoard {

    public SudokuField[][] board;

    public SudokuBoard() {
        board = new SudokuField[9][];
        for (int i = 0; i < 9; ++i) {
            board[i] = new SudokuField[9];
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                board[i][j] = new SudokuField();
            }
        }
    }



    public int get(int x, int y) {
        return board[x][y].getFieldValue();
    }

    public void set(int x, int y, int n) {
        board[x][y].setFieldValue(n);
    }

    public boolean checkBoard(int row, int col, int n) {

        for (int i = 0; i < board.length; ++i) {
            if ((i != col && board[row][i].getFieldValue() == n
                    || i != row && board[i][col].getFieldValue() == n)) {
                return false;
            }
        }

        int subX = col - col % 3;
        int subY = row - row % 3;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (subY + i != row && subX + j != col
                        && board[subY + i][subX + j].getFieldValue() == n) {
                    return false;
                }
            }
        }


        return true;
    }

    public boolean equals(final SudokuBoard  b) {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] != b.board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public SudokuRow getRow(int y) {
        SudokuRow sr = new SudokuRow();

        for (int i = 0; i < 9; ++i) {
            sr.setElementOfArray(board[y][i], i);
        }
        return sr;
    }

    public SudokuColumn getColumn(int x) {
        SudokuColumn sc = new SudokuColumn();

        for (int i = 0; i < 9; ++i) {
            sc.setElementOfArray(board[i][x], i);
        }
        return sc;
    }

    public SudokuBox getBox(int x, int y) {
        int subX = x - x % 3;
        int subY = y - y % 3;

        SudokuBox sb = new SudokuBox();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.setElementOfBox(board[subY + i][subX + j], i, j);
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

