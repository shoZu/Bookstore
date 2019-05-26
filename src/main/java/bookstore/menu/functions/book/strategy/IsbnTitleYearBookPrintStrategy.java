package bookstore.menu.functions.book.strategy;

import bookstore.structure.Book;

import java.util.List;

public class IsbnTitleYearBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getId() +
                    ". ISBN: " + book.getIsbn() +
                    ", Tytuł: " + book.getTitle() +
                    ", Rok wydania: " + book.getYear() +
                    ", Typ okładki: " + book.getType() +
                    ", Autor: " + book.getAuthors() +
                    ", Kategoria: " + book.getCategory());
        }
    }
}
