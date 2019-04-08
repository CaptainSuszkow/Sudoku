import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver {

    public boolean solve(SudokuBoard a) {
        int x = 0;
        int y = 0;
        boolean foundPlace = false;

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (a.get(i, j) == 0) {
                    y = i;
                    x = j;
                    foundPlace = true;
                    break;
                }
            }
        }
        if (!foundPlace) {
            return true;
        }

        Random rand = new Random();
        int randomNumber = rand.nextInt(9) + 1;
        int number = 0;
        for (int i = 1; i < 10; ++i) {
            number = ((randomNumber + i) % 9) + 1;
            if (a.checkBoard(y, x, number)) {
                a.set(y, x, number);
                if (solve(a)) {
                    return true;
                }

                a.set(y, x, 0);

            }
        }
        return false;
    }
}
