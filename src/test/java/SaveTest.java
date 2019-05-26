import bookstore.file.Reader;
import bookstore.file.SaveAuthors;
import bookstore.file.SaveBooks;
import bookstore.file.SaveCategories;
import bookstore.structure.Author;
import bookstore.structure.Book;
import bookstore.structure.Categories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class SaveTest {
    Reader reader = new Reader();

    @Test
    void saveBooksTest() {
        List<Author> authors = new ArrayList<>();
        Categories categories = new Categories(1, "", 2);
        List<Book> list = new ArrayList<>();
        SaveBooks saveBooks = new SaveBooks();
        list.add(new Book(1, "asd", "123", 2008, "M", authors, categories));
        list.add(new Book(2, "asdd", "1234", 2009, "M", authors, categories));
        saveBooks.save(list, "test2.csv");
        List<Book> newList = reader.readBook("test2.csv", "authors.csv", "categories.csv");
        Assertions.assertEquals("asd", newList.get(0).getTitle());
        Assertions.assertEquals("asdd", newList.get(1).getTitle());
        Assertions.assertEquals(2008, newList.get(0).getYear());
        Assertions.assertEquals(2009, newList.get(1).getYear());
        Assertions.assertEquals("123", newList.get(0).getIsbn());
        Assertions.assertEquals("1234", newList.get(1).getIsbn());
    }

    @Test
    void saveAuthorsTest(){
        SaveAuthors saveAuthors = new SaveAuthors();
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(1,"Adam", "25"));
        authors.add(new Author(2,"Czeslaw", "29"));
        saveAuthors.save(authors,"testAuthor2.csv");
        List<Author> authorList = reader.readAuthor("testAuthor2.csv");
        Assertions.assertEquals("Adam", authorList.get(0).getName());
        Assertions.assertEquals("Czeslaw", authorList.get(1).getName());
        Assertions.assertEquals(1, authorList.get(0).getId());
        Assertions.assertEquals(2, authorList.get(1).getId());
        Assertions.assertEquals("25", authorList.get(0).getAge());
        Assertions.assertEquals("29", authorList.get(1).getAge());
    }

    @Test
    void saveCategoriesTest(){
        SaveCategories saveCategories = new SaveCategories();
        List<Categories> categoriesList = new ArrayList<>();
        categoriesList.add(new Categories(1,"Java", 1));
        categoriesList.add(new Categories(2,"Java2", 2));
        saveCategories.save(categoriesList, "testCategories2");
        List<Categories> categories = reader.readCategories("testCategories2");
        Assertions.assertEquals("Java", categories.get(0).getName());
        Assertions.assertEquals("Java2", categories.get(1).getName());
        Assertions.assertEquals(1, categories.get(0).getPriority());
        Assertions.assertEquals(2, categories.get(1).getPriority());
    }
}