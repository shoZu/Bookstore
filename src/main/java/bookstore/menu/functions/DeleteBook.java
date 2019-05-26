package bookstore.menu.functions;

import bookstore.Lists;
import bookstore.structure.Book;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeleteBook {
    private final Lists lists = Lists.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void deleteBook(List<Book> listOfBooks) {
        System.out.println("Podaj tytul ksiazki do usuniecia");
        String option = scanner.next();
        if (listOfBooks.stream().anyMatch(book -> book.getTitle().equals(option))) {
            listOfBooks = listOfBooks.stream()
                    .filter(book -> !book.getTitle().equals(option))
                    .collect(Collectors.toList());
            System.out.println("Ksiazka zostala usunieta");
        } else {
            System.out.println("Nie ma ksiazki o podanym tytule");
        }
        lists.setListOfBooks(listOfBooks);
    }
}
