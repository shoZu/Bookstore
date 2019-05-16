import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
            listOfBooks.get(set).setYear(year);
        } else {
            System.out.println("Nie ma ksiazki o podanym tytule");
        }
    }

    private void addBook() {
        System.out.println("Podaj tytuł ksiązki");
        String title = scanner.next();
        System.out.println("Podaj ISBN ksiązki");
        String isbn = scanner.next();
        System.out.println("Podaj rok wydania ksiązki");
        String year = scanner.next();
        System.out.println("Podaj typ oprawy M/T");
        String type = scanner.next();
        System.out.println("Wybierz autorów ksiazki podajac ich id po ,");
        System.out.println(listOfAuthor);
        String author = scanner.next();
        List<Author> listAuthor = new ArrayList<>();
        String[] authors = author.split(",");
        for (String number : authors) {
            listAuthor.add(listOfAuthor.get(Integer.parseInt(number) - 1));
        }
        System.out.println("Podaj kategorie ksiazki po jej id");
        System.out.println(listOfCategories);
        int category = scanner.nextInt();
        listOfBooks.add(new Book(listOfBooks.size() + 1, title, isbn, year, type, listAuthor, listOfCategories.get(category - 1)));
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
