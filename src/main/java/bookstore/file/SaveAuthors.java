package bookstore.file;

import bookstore.structure.Author;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SaveAuthors {
    public void save(List<Author> authorList, String fileWithAuthors) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileWithAuthors);
        } catch (FileNotFoundException e) {
            System.out.println("Nie mozna zapisac do pliku categories.csv");
        }
        for (Author author : authorList) {
            out.println(author.getId() + ";" + author.getName() + ";" + author.getAge());
        }
        out.close();
    }
}

