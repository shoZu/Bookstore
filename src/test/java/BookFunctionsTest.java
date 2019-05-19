import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class BookFunctionsTest {
    BookFunctions bookFunctions = new BookFunctions();
    private List<Book> listOfBooks = new ArrayList<>();

    {
        listOfBooks.add(new Book(1, "Java1", "1234567890123", 2001, "1", null, null));
        listOfBooks.add(new Book(2, "Java2", "1234567890124", 2002, "2", null, null));
        listOfBooks.add(new Book(3, "Java3", "1234567890125", 2003, "3", null, null));
        listOfBooks.add(new Book(4, "Cjav4", "1234567890126", 2008, "1", null, null));
        listOfBooks.add(new Book(5, "Java5", "1234567890127", 2005, "2", null, null));
        listOfBooks.add(new Book(6, "Java6", "1234567890128", 2006, "3", null, null));
    }


    @Test
    public void findIsbnTest() {
        Book book = bookFunctions.findIsbn(listOfBooks, "1234567890123");
        Assertions.assertEquals("Java1", book.getTitle());
    }

    @Test
    public void shouldNotFindBookByIsbn() {
        Optional<Book> optionalBook = bookFunctions.findIsbnStream(listOfBooks, "asd");
        Assertions.assertFalse(optionalBook.isPresent());
    }

    @Test
    public void findIsbnStreamTest() {
        Optional<Book> book = bookFunctions.findIsbnStream(listOfBooks, "1234567890123");
        Assertions.assertEquals("Java1", book.get().getTitle());
    }

    @Test
    public void lastTwoBooksTest() {
        List<Book> lastBooks = bookFunctions.lastTwoBooks(listOfBooks);
        Assertions.assertEquals(listOfBooks.get(listOfBooks.size() - 2).getTitle(), lastBooks.get(0).getTitle());
        Assertions.assertEquals(listOfBooks.get(listOfBooks.size() - 1).getTitle(), lastBooks.get(1).getTitle());
        assertThat(lastBooks).contains(listOfBooks.get(listOfBooks.size() - 1));
    }

    @Test
    public void lastTwoBooksStreamTest() {
        List<Book> lastBooks = bookFunctions.lastTwoBooks(listOfBooks);
        Assertions.assertEquals(listOfBooks.get(listOfBooks.size() - 2).getTitle(), lastBooks.get(0).getTitle());
        Assertions.assertEquals(listOfBooks.get(listOfBooks.size() - 1).getTitle(), lastBooks.get(1).getTitle());
        assertThat(lastBooks).contains(listOfBooks.get(listOfBooks.size() - 1));
    }

    @Test
    public void getLatestReleasedBookTest() {
        Book book = bookFunctions.getLateestReleasedBook(listOfBooks);
        Assertions.assertEquals(2006, book.getYear());
    }

    @Test
    public void getLatestReleasedBookStreamTest() {
        Optional<Book> book = bookFunctions.getLateestReleasedBookStream(listOfBooks);
        Assertions.assertEquals(2006, book.get().getYear());
    }


    @Test
    public void getEarliestReleasedBookStreamTest() {
        Optional<Book> book = bookFunctions.getEarliestReleasedBookStream(listOfBooks);
        Assertions.assertEquals(2001, book.get().getYear());
    }

    @Test
    public void getEarliestReleasedBookTest() {
        Book book = bookFunctions.getEarliestReleasedBook(listOfBooks);
        Assertions.assertEquals(2001, book.getYear());
    }

    @Test
    public void sumOfYearsTest() {
        int sum = bookFunctions.sumOfYears(listOfBooks);
        Assertions.assertEquals(12021, sum);
    }

    @Test
    public void sumOfYearsStreamTest() {
        int sum = bookFunctions.sumOfYearsStream(listOfBooks);
        Assertions.assertEquals(12021, sum);
    }

    @Test

    public void booksAfter2007Test() {
        int books = bookFunctions.booksReleasedAfter2007(listOfBooks);
        Assertions.assertEquals(0, books);
    }

    @Test
    public void booksAfter2007StreamTest() {
        double books = bookFunctions.booksReleasedAfter2007Stream(listOfBooks);
        Assertions.assertEquals(0, books);
    }

    @Test
    public void releasedAfter2000Test() {
        boolean books = bookFunctions.releasedAfter2000(listOfBooks);
        Assertions.assertTrue(books);
    }

    @Test
    public void releasedAfter2000TestStreamTest() {
        boolean books = bookFunctions.releasedAfter2000Stream(listOfBooks);
        Assertions.assertTrue(books);
    }

    @Test
    public void averageYearsOfBooksTest() {
        double year = bookFunctions.averageYearsOfBooks(listOfBooks);
        Assertions.assertEquals(2003.5 , year);
    }

    @Test
    public void averageYearsOfBooksStreamTest() {
        double year = bookFunctions.averageYearsOfBooksStream(listOfBooks);
        Assertions.assertEquals(2003.5 , year);
    }

    @Test
    public void releasedBefore2003StreamTest() {
        boolean year = bookFunctions.releasedBefore2003Stream(listOfBooks);
        Assertions.assertTrue(year);
    }

    @Test
    public void releasedBefore2003Test() {
        boolean year = bookFunctions.releasedBefore2003(listOfBooks);
        Assertions.assertTrue(year);
    }

    @Test
    public void booksStartsCAndRealeasdAfter2007Test() {
        List<Book> books = bookFunctions.booksStartsCAndRealeasdAfter2007(listOfBooks);
        assertThat(books).contains(listOfBooks.get(3));
    }

//    @Test
////    public void booksStartsCAndRealeasdAfter2007Test2() {
////        List<Book> books = bookFunctions.booksStartsCAndRealeasdAfter2007(new ArrayList<>());
////        assertThat(books.size()).isEqualTo(0);
////    }

    @Test
    public void yearOfBooksDividedBy2Test() {
        List<Book> books = bookFunctions.yearOfBooksDividedBy2(listOfBooks);
        assertThat(books).contains(listOfBooks.get(1),listOfBooks.get(3),listOfBooks.get(5));
    }

    @Test
    public void mapOfbooks() {
        Map<String, Book> lastBooks = bookFunctions.mapOfbooks(listOfBooks);

    }



}