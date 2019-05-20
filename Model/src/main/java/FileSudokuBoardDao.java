import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private String filename;

    FileSudokuBoardDao(String file) {
        this.filename = file;
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard board = null;

        try (FileInputStream inputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
             board = (SudokuBoard) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return board;
    }

    @Override
    public void write(SudokuBoard a) {
        try (FileOutputStream outputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
