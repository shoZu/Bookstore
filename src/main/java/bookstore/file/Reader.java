package bookstore.file;

import bookstore.structure.Author;
import bookstore.structure.Book;
import bookstore.structure.Categories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<Book> readBook(String fileWithBook, String fileWithAuthors, String fileWithCategories) {

        List<Book> listOfBook = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(fileWithBook))) {
            String line = null;
            try {
                line = file.readLine();
            } catch (IOException e) {
                System.err.println("Blad przy wczytywaniu pliku " + fileWithBook);
                return listOfBook;
            }
            String[] table;

            while (line != null) {
                table = line.split(";");
                List<Author> listAuthor = new ArrayList<>();
                if(!table[5].equals("")) {
                    String[] split = table[5].split(",");
                    for (String number : split) {
                        for (Author author : readAuthor(fileWithAuthors)) {
                            if (author.getId() == Integer.parseInt(number)) {
                                listAuthor.add(author);
                            }
                        }
                    }
                }
                String[] finalTable = table;
                Categories category=null;
                if(readCategories(fileWithCategories).stream()
                        .filter(categories -> categories.getId()==Integer.parseInt(finalTable[6])).count()>0){

                     category = readCategories(fileWithCategories).stream()
                            .filter(categories -> categories.getId() == Integer.parseInt(finalTable[6]))
                            .findFirst()
                            .get();
                }


                Book book = new Book(Integer.parseInt(table[0]), table[1], table[2], Integer.parseInt(table[3]), table[4],
                        listAuthor, category);
                listOfBook.add(book);
                line = file.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie ma pliku " + fileWithBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfBook;
    }

    public List<Author> readAuthor(String fileWithAuthors) {

        List<Author> listOfAuthor = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(fileWithAuthors))) {
            String line = null;
            try {
                line = file.readLine();
            } catch (IOException e) {
                System.err.println("Blad przy wczytywaniu pliku " + fileWithAuthors);
                return listOfAuthor;
            }
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfAuthor.add(new Author(Integer.parseInt(table[0]), table[1], table[2]));
                line = file.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie ma pliku " + fileWithAuthors);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfAuthor;
    }

    public List<Categories> readCategories(String fileWithCategories) {

        List<Categories> listOfCategories = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(fileWithCategories))) {
            String line = null;
            try {
                line = file.readLine();
            } catch (IOException e) {
                System.err.println("Blad przy wczytywaniu pliku " + fileWithCategories);
                return listOfCategories;
            }
            String[] table;

            while (line != null) {
                table = line.split(";");
                listOfCategories.add(new Categories(Integer.parseInt(table[0]), table[1], Integer.parseInt(table[2])));
                line = file.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie ma pliku " + fileWithCategories);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfCategories;
    }
}