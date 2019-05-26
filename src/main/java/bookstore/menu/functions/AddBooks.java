package bookstore.menu.functions;

import bookstore.Lists;
import bookstore.structure.Author;
import bookstore.structure.Book;
import bookstore.structure.Categories;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBooks {
    private final Scanner scanner = new Scanner(System.in);
    private final Lists list = Lists.getInstance();

    public void addBook(List<Book> listOfBooks, List<Author> listOfAuthor, List<Categories> listOfCategories) {
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
        while (!(type.equalsIgnoreCase("M") || type.equalsIgnoreCase("T"))) {
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
        list.setListOfBooks(listOfBooks);
        System.out.println("Ksiazka dodana pomyslnie");
    }
}
