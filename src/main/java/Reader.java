import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Reader {

///
    public List<Book> readBook() throws IOException {

        List<Book> listOfBook = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader("books.csv"))) {
            String line = file.readLine();
            String[] table;

            while (line != null) {
                table = line.split(";");
                String s = table[5];
                String[] split = s.split(",");
                List<Author> listAuthor = new ArrayList<>();
                for (String number : split) {
                    listAuthor.add(readAuthor().get(Integer.parseInt(number) - 1));
                }
                listOfBook.add(new Book(Integer.parseInt(table[0]), table[1], table[2], table[3], table[4], listAuthor, readCategories().get(Integer.parseInt(table[6]) - 1)));
                line = file.readLine();
            }
        }
        return listOfBook;
    }

    public List<Author> readAuthor() throws IOException {

        List<Author> listOfAuthor = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader("authors.csv"))) {
            String line = file.readLine();
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfAuthor.add(new Author(Integer.parseInt(table[0]), table[1], table[2]));
                line = file.readLine();
            }
        }
        return listOfAuthor;
    }

    public List<Categories> readCategories() throws IOException {

        List<Categories> listOfCategories = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader("categories.csv"))) {
            String line = file.readLine();
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfCategories.add(new Categories(Integer.parseInt(table[0]), table[1], Integer.parseInt(table[2])));
                line = file.readLine();
            }
        }
        return listOfCategories;
    }
}