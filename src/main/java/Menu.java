import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Reader reader = new Reader();
    private final List<Book> listOfBooks = reader.readBook();
    private final List<Author> listOfAuthor = reader.readAuthor();
    private final List<Categories> listOfCategories = reader.readCategories();
    private String option;

    public void chooseOption() {
        printMenu();
        option = scanner.next();
        switch (option) {
            case "1":
                BooksList();
                chooseOption();
                break;
            case "2":
                addBook();
                chooseOption();
                break;
            case "3":
                deleteBook();
                chooseOption();
                break;
            case "4":
                edit();
                chooseOption();
                break;
            case "5":
                save();
                chooseOption();
                break;
            case "6":
                System.out.println("Koniec programu");
                break;
            default:
                System.out.println("Podales zly znak ");
                chooseOption();
                break;
        }
    }

    private void printMenu() {
        System.out.println("Menu");
        System.out.println("1. Wyswietl liste ksiazek");
        System.out.println("2. Dodaj nowa książkę");
        System.out.println("3. Usuniecie ksiazki po nazwie");
        System.out.println("4. Edycja roku wydania książki ");
        System.out.println("5. Zapisz liste ksiazek do pliku .csv");
        System.out.println("6. Wyjdz");
    }

    private void BooksList() {
        for (Book book : listOfBooks) {
            System.out.print(book);
        }
    }

    private void deleteBook() {
        System.out.println("Podaj tytul ksiazki do usuniecia");
        option = scanner.next();
        int delete = -1;
        for (int i = 0; i < listOfBooks.size(); i++) {
            Book book = listOfBooks.get(i);
            if (book.getTitle().equals(option)) {
                delete = i;
            }
        }
        if (delete > 0) {
            listOfBooks.remove(delete);
        } else {
            System.out.println("Nie ma ksiazki o podanym tytule");
        }
    }

    private void edit() {
        System.out.println("Podaj tytul ksiazki do zaminy roku wydania");
        option = scanner.next();
        int set = -1;
        for (int i = 0; i < listOfBooks.size(); i++) {
            Book book = listOfBooks.get(i);
            if (book.getTitle().equals(option)) {
                set = i;
            }
        }
        if (set > 0) {
            System.out.println("Aktualny rok wydania to: " + listOfBooks.get(set).getYear());
            System.out.println("Podaj nowy rok wydania:");
            String year = scanner.next();
            listOfBooks.get(set).setYear(Integer.parseInt(year));
        } else {
            System.out.println("Nie ma ksiazki o podanym tytule");
        }
    }

    private void addBook() {
        System.out.println("Podaj tytuł ksiązki");
        String title = scanner.next();
        System.out.println("Podaj ISBN ksiązki");
        String isbn = scanner.next();
        while (!StringUtils.isNumeric(isbn)) {
            System.out.println("Podles zly ISBN ksiązki, sprobuj jeszcze raz");
            isbn = scanner.next();
        }
        System.out.println("Podaj rok wydania ksiązki");
        String year = scanner.next();
        while (!StringUtils.isNumeric(year)) {
            System.out.println("Podles zly rok wydania ksiązki, sprobuj jeszcze raz");
            year = scanner.next();
        }
        while (!(Integer.parseInt(year) > 0 && Integer.parseInt(year) <= LocalDate.now().getYear())) {
            System.out.println("Podles zly rok wydania ksiązki, sprobuj jeszcze raz");
            year = scanner.next();
        }
        System.out.println("Podaj typ oprawy M/T");
        String type = scanner.next();
        while (type.equalsIgnoreCase("M") || type.equalsIgnoreCase("T")) {
            System.out.println("Podales zly typ oprawy, sprobuj jeszcze raz wybierajac M (miekka) lub T (twarda) oprawa");
            type = scanner.next();
        }
        System.out.println("Wybierz autorów ksiazki podajac ich id po ,");
        for (Author author : listOfAuthor) {
            System.out.println(author.getId() + ": " + author.getName() + ", ");
        }
        String author = scanner.next();
        List<Author> listAuthor = new ArrayList<>();
        String[] authors = author.split(",");
        for (String number : authors) {
            listAuthor.add(listOfAuthor.get(Integer.parseInt(number) - 1));
        }
        System.out.println("Podaj kategorie ksiazki po jej id");
        for (Categories categories : listOfCategories) {
            System.out.println(categories.getId() + ": " + categories.getName());
        }
        int category = scanner.nextInt();
        int max = 0;
        for (Book book : listOfBooks) {
            if (book.getId() > max) {
                max = book.getId();
            }
        }
        listOfBooks.add(new Book(max + 1, title, isbn, Integer.parseInt(year), type,
                listAuthor, listOfCategories.get(category - 1)));
        System.out.println("Ksiazka dodana pomyslnie");
    }

    private void save() {
        try {
            PrintWriter out = new PrintWriter("books.csv");
            for (Book book : listOfBooks) {
                StringBuilder stringBuilder = new StringBuilder();
                List<Author> authors = book.getAuthors();
                for (int i = 0; i < authors.size(); i++) {
                    Author author = authors.get(i);
                    stringBuilder.append(author.getId());
                    if (i < authors.size() - 1) {
                        stringBuilder.append(",");
                    }
                }

                out.println(book.getId() + ";" + book.getTitle() + ";" + book.getIsbn() + ";"
                        + book.getYear() + ";" + book.getType() + ";" + stringBuilder + ";"
                        + book.getCategory().getId());
            }
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Niestety, nie mogę utworzyć pliku!");
        }
    }
}
