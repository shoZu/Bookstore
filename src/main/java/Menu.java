import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Reader reader = new Reader();
    String option;
    List<Book> listOfBooks = reader.read();

    public Menu() throws IOException {
    }

    public void chooseOption() {
        System.out.println("Menu");
        System.out.println("1. Wyswietl liste ksiazek");
        System.out.println("2. Dodaj nowa książkę");
        System.out.println("3. Usuniecie ksiazki po nazwie");
        System.out.println("4. Edycja roku wydania książki ");
        System.out.println("5. Zapisz liste ksiazek do pliku .csv");
        System.out.println("6. Wyjdz");
        option = scanner.next();
        switch (option) {
            case "1":
                BooksList();
                chooseOption();
            case "2":
                addBook();
                chooseOption();
            case "3":
                deleteBook();
                chooseOption();
            case "6":
                break;
            default:
                System.out.println("podales zly znak ");
                chooseOption();
        }
    }

    private void BooksList() {
        for (Book book : listOfBooks) {
            System.out.print(book);
        }
    }

    private void deleteBook() {
        System.out.println("Podaj tytul ksiazki do usuniecia");
        option = scanner.next();
        for (Book book:listOfBooks) {
            if(book.getTitle().equals(option)){
                System.out.println("Ksiazka o tytule " + book.getTitle() + " zostala usunieta");
                listOfBooks.remove(book);
            }
        }
    }

    private void addBook() {
        System.out.println("Podaj tytuł ksiązki");
        String title = scanner.next();
        System.out.println("Podaj ISBN ksiązki");
        String isbn = scanner.next();
        System.out.println("Podaj rok wydania ksiązki");
        String year = scanner.next();
        listOfBooks.add(new Book(title, isbn, year));
    }
}