package bookstore;

import bookstore.file.SaveAuthors;
import bookstore.file.SaveBooks;
import bookstore.file.SaveCategories;
import bookstore.menu.functions.*;
import bookstore.menu.functions.book.strategy.BookPrintStrategy;
import bookstore.menu.functions.book.strategy.IsbnTitleYearBookPrintStrategy;
import bookstore.menu.functions.book.strategy.TitleYearIsbnBookPrintStrategy;
import bookstore.menu.functions.book.strategy.YearTitleIsbnBookPrintStrategy;

import java.util.Scanner;

import static bookstore.file.Path.*;

class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final BookFunctions bookFunctions = new BookFunctions();
    private final Lists list = Lists.getInstance();
    private final ShowMenu show = new ShowMenu();
    private final AddBooks addBook = new AddBooks();
    private final DeleteBook deleteBook = new DeleteBook();
    private final EditBook editBook = new EditBook();
    private final ShowCategories categories = new ShowCategories();
    private final ShowAuthors authors = new ShowAuthors();
    private final DeleteCategory deleteCategory = new DeleteCategory();
    private final SaveBooks saveBooks = new SaveBooks();
    private BookPrintStrategy bookPrintStrategy = new TitleYearIsbnBookPrintStrategy();
    private final ShowBooksByAuthors showBooksByAuthors = new ShowBooksByAuthors();
    private final SaveCategories saveCategories = new SaveCategories();
    private final AddAuthor addAuthor = new AddAuthor();
    private final SaveAuthors saveAuthors= new SaveAuthors();

    public void chooseOption() {
        show.printMenu();
        String option = scanner.next();
        switch (option) {
            case "1":
                bookPrintStrategy.print(list.getListOfBooks());
                chooseOption();
                break;
            case "2":
                addBook.addBook(list.getListOfBooks(), list.getListOfAuthor(), list.getListOfCategories());
                chooseOption();
                break;
            case "3":
                deleteBook.deleteBook(list.getListOfBooks());
                chooseOption();
                break;
            case "4":
                editBook.edit(list.getListOfBooks());
                chooseOption();
                break;
            case "5":
                list.setListOfBooks(bookFunctions.sortBook(list.getListOfBooks()));
                chooseOption();
                break;
            case "6":
                list.setListOfBooks(bookFunctions.sortBookReverseOrder(list.getListOfBooks()));
                chooseOption();
                break;
            case "7":
                System.out.println("Liczba ksiązek wydanych po 2007r : "
                        + bookFunctions.booksReleasedAfter2007Stream(list.getListOfBooks()));
                chooseOption();
                break;
            case "8":
                categories.show(list.getListOfCategories());
                chooseOption();
                break;
            case "9":
                authors.authors(list.getListOfAuthor());
                chooseOption();
                break;
            case "10":
                deleteCategory.delete(list.getListOfBooks(), list.getListOfCategories());
                chooseOption();
                break;
            case "11":
                addAuthor.add(list.getListOfAuthor());
                chooseOption();
                break;
            case "12":
                showBooksByAuthors.show(list.getListOfAuthor(), list.getListOfBooks());
                chooseOption();
                break;
            case "13":
                System.out.println("Formatowanie zmienione na Tytul, ISBN, Rok");
                bookPrintStrategy = new TitleYearIsbnBookPrintStrategy();
                chooseOption();
                break;
            case "14":
                System.out.println("Formatowanie zmienione na Rok, Tytul, ISBN");
                bookPrintStrategy = new YearTitleIsbnBookPrintStrategy();
                chooseOption();
                break;
            case "15":
                System.out.println("Formatowanie zmienione na ISBN, Rok, Tytul");
                bookPrintStrategy = new IsbnTitleYearBookPrintStrategy();
                chooseOption();
                break;
            case "16":
                saveCategories.save(list.getListOfCategories(), CATEGORIES.getPath());
                chooseOption();
                break;
            case "17":
                saveBooks.save(list.getListOfBooks(), BOOKS.getPath());
                chooseOption();
                break;
            case "18":
                saveAuthors.save(list.getListOfAuthor(),AUTHORS.getPath());
                chooseOption();
                break;
            case "19":
                saveBooks.save(list.getListOfBooks(), BOOKS.getPath());
                saveCategories.save(list.getListOfCategories(), CATEGORIES.getPath());
                saveAuthors.save(list.getListOfAuthor(),AUTHORS.getPath());
                chooseOption();
                break;
            case "20":
                System.out.println("Koniec programu");
                break;
            default:
                System.out.println("Podales zly znak ");
                chooseOption();
                break;
        }
    }
}
