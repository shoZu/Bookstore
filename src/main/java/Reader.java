import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Reader {

    public List<Book> readBook()  {

        List<Book> listOfBook = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader("books.csv"))) {
            String line = null;
            try {
                line = file.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] table;

            while (line != null) {
                table = line.split(";");
                String[] split = table[5].split(",");
                List<Author> listAuthor = new ArrayList<>();
                for (String number : split) {
                    for(Author author:readAuthor()){
                        if(author.getId()==Integer.parseInt(number)){
                            listAuthor.add(author);
                        }
                    }

                }
                Book book = new Book(Integer.parseInt(table[0]), table[1], table[2], table[3], table[4],
                        listAuthor, readCategories().get(Integer.parseInt(table[6]) - 1));
                listOfBook.add(book);
                line = file.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfBook;
    }

    public List<Author> readAuthor() {

        List<Author> listOfAuthor = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader("authors.csv"))) {
            String line = null;
            try {
                line = file.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfAuthor.add(new Author(Integer.parseInt(table[0]), table[1], table[2]));
                line = file.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfAuthor;
    }

    public List<Categories> readCategories() {

        List<Categories> listOfCategories = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader("categories.csv"))) {
            String line = null;
            try {
                line = file.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfCategories.add(new Categories(Integer.parseInt(table[0]), table[1], Integer.parseInt(table[2])));
                line = file.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfCategories;
    }
}