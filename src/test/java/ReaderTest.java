import bookstore.structure.Author;
import bookstore.structure.Book;
import bookstore.structure.Categories;
import bookstore.file.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ReaderTest {

    Reader reader = new Reader();
    List<Book> testlist = new ArrayList<>();

    @Test
    void readBookDoesntExist() {
       List<Book> list = reader.readBook("asd", "asd", "asd");
       Assertions.assertEquals(testlist, list);
    }

    @Test
    void readBookTest(){
        List <Book> list = reader.readBook("test.csv", "authors.csv", "categories.csv");
        Assertions.assertEquals("asd", list.get(0).getTitle());
        Assertions.assertEquals("123", list.get(0).getIsbn());
        Assertions.assertEquals(2009, list.get(0).getYear());
        Assertions.assertEquals("asdd", list.get(1).getTitle());
        Assertions.assertEquals("123445", list.get(1).getIsbn());
        Assertions.assertEquals(2020, list.get(1).getYear());
    }

    @Test
    void readAuthorDoesntExist() {
        List<Author> list = reader.readAuthor("asd");
        Assertions.assertEquals(testlist, list);
    }

    @Test
    void readAuthorTest(){
        List<Author> list = reader.readAuthor("testAuthors.csv");
        Assertions.assertEquals("Robert C. Martin", list.get(0).getName());
        Assertions.assertEquals("32", list.get(0).getAge());
        Assertions.assertEquals(1, list.get(0).getId());
        Assertions.assertEquals("Autor Autor", list.get(1).getName());
        Assertions.assertEquals("12", list.get(1).getAge());
        Assertions.assertEquals(2, list.get(1).getId());
    }

    @Test
    void readCategorieDoesntExists() {
        List<Categories> list = reader.readCategories("asd");
        Assertions.assertEquals(testlist, list);
    }

    @Test
    void readCategoriesTest(){
        List<Categories> list = reader.readCategories("testCategories.csv");
        Categories categories = list.get(0);
        Assertions.assertEquals("Cat1", categories.getName());
        Categories categories1 = list.get(1);
        Assertions.assertEquals("Cat2", categories1.getName());
        Assertions.assertEquals(1, categories.getId());
        Assertions.assertEquals(2, categories1.getId());
        Assertions.assertEquals(1, categories.getPriority());
        Assertions.assertEquals(2, categories1.getPriority());
    }


}