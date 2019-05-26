package bookstore.menu.functions;

import bookstore.structure.Author;
import bookstore.structure.Book;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShowBooksByAuthors {

    public void show(List<Author> authorList, List<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID autora, którego ksiazki chcesz wyswietlic: ");
        for (Author author : authorList) {
            System.out.println(author.toString2());
        }
        String id = scanner.next();
        Author findAuthor = authorList.stream()
                .filter(author -> author.getId()==Integer.parseInt(id))
                .findFirst()
                .get();

        List<Book> list = bookList.stream()
               .filter(book -> book.getAuthors().contains(findAuthor))
               .collect(Collectors.toList());

        System.out.println(list);

    }
}
