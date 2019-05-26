package bookstore.file;

import bookstore.structure.Author;
import bookstore.structure.Book;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class SaveBooks {
    public void save(List<Book> listOfBooks, String fileWithBooks) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileWithBooks);
        } catch (FileNotFoundException e) {
            System.out.println("Nie mozna zapisac do pliku books.csv");
        }
        for (Book book : listOfBooks) {
            StringBuilder stringBuilder = new StringBuilder();
            List<Author> authors = book.getAuthors();
            for (int i = 0; i < authors.size(); i++) {
                Author author = authors.get(i);
                stringBuilder.append(author.getId());
                if (i < authors.size() - 1) {
                    stringBuilder.append(",");
                }
            }

            out.println(book.getId() + ";" + book.getTitle() + ";" + book.getIsbn() + ";"
                    + book.getYear() + ";" + book.getType() + ";" + stringBuilder + ";"
                    + book.getCategory().getId());
        }
        out.close();
    }
}
