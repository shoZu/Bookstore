import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {


    public List<Book> readBook() throws IOException {
        BufferedReader file = null;
        List<Book> listOfBook = new ArrayList<>();

        try {
            file = new BufferedReader(new FileReader("books.csv"));
            String line = file.readLine();
            String[] table;

            while (line != null) {
                table = line.split(";");
                String s = table[5];
                String[] split = s.split(",");
                List<Author> listAuthor = new ArrayList<>();
                for(String number:split){
                    listAuthor.add(readAuthor().get(Integer.parseInt(number)-1));
                }
                listOfBook.add(new Book(Integer.parseInt(table[0]), table[1], table[2], table[3], table[4], listAuthor, readCategories().get(Integer.parseInt(table[6])-1)));
                line = file.readLine();
            }
        } finally {
            if (file != null) {
                file.close();
            }
        }
        return listOfBook;
    }

    public List<Author> readAuthor() throws IOException {
        BufferedReader file = null;
        List<Author> listOfAuthor = new ArrayList<>();

        try {
            file = new BufferedReader(new FileReader("authors.csv"));
            String line = file.readLine();
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfAuthor.add(new Author(Integer.parseInt(table[0]), table[1], table[2]));
                line = file.readLine();
            }
        } finally {
            if (file != null) {
                file.close();
            }
        }
        return listOfAuthor;
    }

    public List<Categories> readCategories() throws IOException {
        BufferedReader file = null;
        List<Categories> listOfCategories = new ArrayList<>();

        try {
            file = new BufferedReader(new FileReader("categories.csv"));
            String line = file.readLine();
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfCategories.add(new Categories(Integer.parseInt(table[0]), table[1], Integer.parseInt(table[2])));
                line = file.readLine();
            }
        } finally {
            if (file != null) {
                file.close();
            }
        }
        return listOfCategories;
    }
}