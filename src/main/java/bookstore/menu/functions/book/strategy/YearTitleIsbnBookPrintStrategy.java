package bookstore.menu.functions.book.strategy;

import bookstore.structure.Book;

import java.util.List;

public class YearTitleIsbnBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getId() +
                    ", Rok wydania: " + book.getYear() +
                    ". Tytuł: " + book.getTitle() +
                    ", ISBN: " + book.getIsbn() +
                    ", Typ okładki: " + book.getType() +
                    ", Autor: " + book.getAuthors() +
                    ", Kategoria: " + book.getCategory());
        }
    }
}
