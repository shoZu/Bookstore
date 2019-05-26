package bookstore.menu.functions;

import bookstore.structure.Author;

import java.util.List;

public class ShowAuthors {
    public void authors(List<Author> listOfAuthor) {
        for (Author author : listOfAuthor) {
            System.out.println(author.toString2());
        }
    }
}
