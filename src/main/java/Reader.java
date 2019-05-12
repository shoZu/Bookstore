import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<Book> read() throws IOException {
        BufferedReader file = null;
        List<Book> listOfBook = new ArrayList<>();

        try {
            file = new BufferedReader(new FileReader("books.csv"));
            String line = file.readLine();
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfBook.add(new Book(table[0], table[1], table[2]));
                line = file.readLine();
            }
        } finally {
            if (file != null) {
                file.close();
            }
        }
        return listOfBook;
    }
}