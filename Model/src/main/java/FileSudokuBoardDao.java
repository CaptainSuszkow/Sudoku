import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private String filename;

    FileSudokuBoardDao(String file) {
        this.filename = file;
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard board = new SudokuBoard();
        String input = null;
        String[] numbers = null;

        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            input = fileReader.readLine();
            numbers = input.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board.set(i,j,Integer.parseInt(numbers[i * 9 + j]));
            }
        }
        return board;
    }

    @Override
    public void write(SudokuBoard a) {
        BufferedWriter fileWriter = null;
        String output  = new String();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                output += Integer.toString(a.get(i,j));
                output += " ";
            }
        }

        try {
            fileWriter = new BufferedWriter(new FileWriter(filename));
            fileWriter.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
