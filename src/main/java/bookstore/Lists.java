package bookstore;

import bookstore.file.Reader;
import bookstore.structure.Author;
import bookstore.structure.Book;
import bookstore.structure.Categories;
import java.util.List;
import static bookstore.file.Path.*;

public class Lists {
    private static final Lists lists = new Lists();
    private final Reader reader = new Reader();
    private List<Author> listOfAuthor = reader.readAuthor(AUTHORS.getPath());
    private List<Book> listOfBooks = reader.readBook(BOOKS.getPath(), AUTHORS.getPath(), CATEGORIES.getPath());
    private List<Categories> listOfCategories = reader.readCategories(CATEGORIES.getPath());

    private Lists() {
    }

    public static Lists getInstance() {
        return lists;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public List<Author> getListOfAuthor() {
        return listOfAuthor;
    }

    public void setListOfAuthor(List<Author> listOfAuthor) {
        this.listOfAuthor = listOfAuthor;
    }

    public List<Categories> getListOfCategories() {
        return listOfCategories;
    }

    public void setListOfCategories(List<Categories> listOfCategories) {
        this.listOfCategories = listOfCategories;
    }
}
