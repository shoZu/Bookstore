package bookstore.menu.functions;

import bookstore.Lists;
import bookstore.structure.Book;

import java.util.List;
import java.util.Scanner;

public class EditBook {
    private final Scanner scanner = new Scanner(System.in);
    private final Lists lists = Lists.getInstance();

    public void edit(List<Book> listOfBooks) {
        System.out.println("Podaj tytul ksiazki do zaminy roku wydania");
        String option = scanner.nextLine();
        int set = -1;
        for (int i = 0; i < listOfBooks.size(); i++) {
            Book book = listOfBooks.get(i);
            if (book.getTitle().equals(option)) {
                set = i;
            }
        }
        if (set >= 0) {
            System.out.println("Aktualny rok wydania to: " + listOfBooks.get(set).getYear());
            System.out.println("Podaj nowy rok wydania:");
            String year = scanner.next();
            listOfBooks.get(set).setYear(Integer.parseInt(year));
        } else {
            System.out.println("Nie ma ksiazki o podanym tytule");
        }
        lists.setListOfBooks(listOfBooks);
    }
}
