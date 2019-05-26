import bookstore.structure.Book;
import bookstore.menu.functions.BookFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class BookFunctionsTest {
    private final BookFunctions bookFunctions = new BookFunctions();
    private final List<Book> listOfBooks = new ArrayList<>();

    {
        listOfBooks.add(new Book(1, "Java1", "1234567890123", 2001, "M", null, null));
        listOfBooks.add(new Book(2, "Java2", "1234567890124", 2002, "M", null, null));
        listOfBooks.add(new Book(3, "Java3", "1234567890125", 2003, "M", null, null));
        listOfBooks.add(new Book(4, "Cjav4", "1234567890126", 2001, "T", null, null));
        listOfBooks.add(new Book(5, "Java5", "1234567890127", 2005, "T", null, null));
        listOfBooks.add(new Book(6, "Java6", "1234567890128", 2006, "T", null, null));
    }


    @Test
    void findIsbnTest() {
        Book book = bookFunctions.findIsbn(listOfBooks, "1234567890123");
        Assertions.assertEquals("Java1", book.getTitle());
    }

    @Test
    void shouldNotFindBookByIsbn() {
        Optional<Book> optionalBook = bookFunctions.findIsbnStream(listOfBooks, "asd");
        Assertions.assertFalse(optionalBook.isPresent());
    }

    @Test
    void findIsbnStreamTest() {
        Optional<Book> book = bookFunctions.findIsbnStream(listOfBooks, "1234567890123");
        Assertions.assertEquals("Java1", book.get().getTitle());
    }

    @Test
    void lastTwoBooksTest() {
        List<Book> lastBooks = bookFunctions.lastTwoBooks(listOfBooks);
        assertThat(lastBooks).contains(listOfBooks.get(listOfBooks.size() - 1));
    }

    @Test
    void lastTwoBooksStreamTest() {
        List<Book> lastBooks = bookFunctions.lastTwoBooks(listOfBooks);
        Assertions.assertEquals(listOfBooks.get(listOfBooks.size() - 2).getTitle(), lastBooks.get(0).getTitle());
        Assertions.assertEquals(listOfBooks.get(listOfBooks.size() - 1).getTitle(), lastBooks.get(1).getTitle());
        assertThat(lastBooks).contains(listOfBooks.get(listOfBooks.size() - 1));
    }

    @Test
    void getLatestReleasedBookTest() {
        Book book = bookFunctions.getLateestReleasedBook(listOfBooks);
        Assertions.assertEquals(2006, book.getYear());
    }

    @Test
    void getLatestReleasedBookStreamTest() {
        Optional<Book> book = bookFunctions.getLateestReleasedBookStream(listOfBooks);
        Assertions.assertEquals(2006, book.get().getYear());
    }


    @Test
    void getEarliestReleasedBookStreamTest() {
        Optional<Book> book = bookFunctions.getEarliestReleasedBookStream(listOfBooks);
        Assertions.assertEquals(2001, book.get().getYear());
    }

    @Test
    void getEarliestReleasedBookTest() {
        Book book = bookFunctions.getEarliestReleasedBook(listOfBooks);
        Assertions.assertEquals(2001, book.getYear());
    }

    @Test
    void sumOfYearsTest() {
        int sum = bookFunctions.sumOfYears(listOfBooks);
        Assertions.assertEquals(12018, sum);
    }

    @Test
    void sumOfYearsStreamTest() {
        int sum = bookFunctions.sumOfYearsStream(listOfBooks);
        Assertions.assertEquals(12018, sum);
    }

    @Test
    void booksAfter2007Test() {
        int books = bookFunctions.booksReleasedAfter2007(listOfBooks);
        Assertions.assertEquals(0, books);
    }

    @Test
    void booksAfter2007StreamTest() {
        double books = bookFunctions.booksReleasedAfter2007Stream(listOfBooks);
        Assertions.assertEquals(0, books);
    }

    @Test
    void releasedAfter2000Test() {
        boolean books = bookFunctions.releasedAfter2000(listOfBooks);
        Assertions.assertFalse(books);
    }

    @Test
    void releasedAfter2000TestStreamTest() {
        boolean books = bookFunctions.releasedAfter2000Stream(listOfBooks);
        Assertions.assertTrue(books);
    }

    @Test
    void averageYearsOfBooksTest() {
        double year = bookFunctions.averageYearsOfBooks(listOfBooks);
        Assertions.assertEquals(2003, year);
    }

    @Test
    void averageYearsOfBooksStreamTest() {
        double year = bookFunctions.averageYearsOfBooksStream(listOfBooks);
        Assertions.assertEquals(2003, year);
    }

    @Test
    void releasedBefore2003StreamTest() {
        boolean year = bookFunctions.releasedBefore2003Stream(listOfBooks);
        Assertions.assertTrue(year);
    }

    @Test
    void releasedBefore2003Test() {
        boolean year = bookFunctions.releasedBefore2003(listOfBooks);
        Assertions.assertTrue(year);
    }

    @Test
    void booksStartsCAndRealeasdAfter2007Test() {
        List<Book> books = bookFunctions.booksStartsCAndRealeasdAfter2007(listOfBooks, 2007);
        Assertions.assertTrue(books.isEmpty());
    }

    @Test
    void booksStartsCAndRealeasdAfter2003Test() {
        List<Book> books = bookFunctions.booksStartsCAndRealeasdAfter2007(listOfBooks, 2000);
        Assertions.assertTrue(books.contains(listOfBooks.get(3)));
    }


    @Test
    void yearOfBooksDividedBy2Test() {
        List<Book> books = bookFunctions.yearOfBooksDividedBy2(listOfBooks);
        assertThat(books).contains(listOfBooks.get(1),  listOfBooks.get(5));
    }

    @Test
    void mapOfbooks() {
        Map<String, Book> lastBooks = bookFunctions.mapOfbooks(listOfBooks);
        Assertions.assertEquals(lastBooks.get("1234567890123").getTitle(), listOfBooks.get(0).getTitle());
    }

    @Test
    void sortBookReverseOrderTest() {
        List<Book> books = bookFunctions.sortBookReverseOrder(listOfBooks);
        System.out.println(books);
        Assertions.assertEquals(books.get(0).getTitle(), listOfBooks.get(5).getTitle());
        Assertions.assertEquals(books.get(2).getTitle(), listOfBooks.get(2).getTitle());
        Assertions.assertEquals(books.get(5).getTitle(), listOfBooks.get(3).getTitle());
    }

    @Test
    void sortBook() {
        List<Book> books = bookFunctions.sortBook(listOfBooks);
        Assertions.assertEquals(books.get(0).getTitle(), listOfBooks.get(0).getTitle());
        Assertions.assertEquals(books.get(3).getTitle(), listOfBooks.get(2).getTitle());
        Assertions.assertEquals(books.get(5).getTitle(), listOfBooks.get(5).getTitle());
    }

    @Test
    void divideListTest() {
        List<List<Book>> books = bookFunctions.divideList(listOfBooks);
        List<Book> testList = listOfBooks.subList(0, 2);
        List<Book> testList2 = listOfBooks.subList(2, 4);
        Assertions.assertEquals(books.get(0), testList);
        Assertions.assertEquals(books.get(1), testList2);
    }

    @Test
    void mapOfBooksByYearTest() {
        Map<Integer, List<Book>> integerListMap = bookFunctions.mapOfBooksByYear(listOfBooks);
        List<Book> testList = listOfBooks.stream()
                .filter(book -> book.getYear()==2001)
                .collect(Collectors.toList());
        Assertions.assertEquals(testList, integerListMap.get(2001));
    }

    @Test
    void mapOfBooksAfter2009Test(){
        Map<Boolean, List<Book>> booleanListMap = bookFunctions.mapOfBooksAfter2009(listOfBooks);
        List<Book> testList = listOfBooks.stream()
                .filter(book -> book.getYear()<2009)
                .collect(Collectors.toList());
        Assertions.assertEquals(testList, booleanListMap.get(false));

    }

}