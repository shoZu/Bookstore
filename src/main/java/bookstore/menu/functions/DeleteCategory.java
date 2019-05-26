package bookstore.menu.functions;

import bookstore.Lists;
import bookstore.structure.Book;
import bookstore.structure.Categories;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeleteCategory {
    private final Scanner scanner = new Scanner(System.in);
    private final Lists lists = Lists.getInstance();

    public void delete(List<Book> listOfBooks, List<Categories> listOfCategories) {
        System.out.println("Podaj ID kategorii do usunięcia");
        for (Categories categories : listOfCategories) {
            System.out.println(categories.getId() + ": " + categories.getName());
        }

        String option = scanner.next();
        listOfBooks = listOfBooks.stream()
                .filter(book -> book.getCategory().getId() != Integer.parseInt(option))
                .collect(Collectors.toList());
        listOfCategories = listOfCategories.stream()
                .filter(categories -> categories.getId() != Integer.parseInt(option))
                .collect(Collectors.toList());

        lists.setListOfBooks(listOfBooks);
        lists.setListOfCategories(listOfCategories);
    }
}
