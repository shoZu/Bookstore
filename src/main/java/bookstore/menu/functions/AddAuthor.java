package bookstore.menu.functions;

import bookstore.Lists;
import bookstore.structure.Author;

import java.util.List;
import java.util.Scanner;

public class AddAuthor {
    Lists lists = Lists.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void add(List<Author> authorList){
        System.out.println("Podaj imie autora");
        String name = scanner.next();
        System.out.println("Podaj nazwisko autora");
        String surname = scanner.next();
        System.out.println("Podaj wiek");
        String age = scanner.next();
        int max = authorList.stream().mapToInt(author -> author.getId()).max().getAsInt();
        authorList.add(new Author(max+1, name + " " + surname , age));
        lists.setListOfAuthor(authorList);
    }
}
