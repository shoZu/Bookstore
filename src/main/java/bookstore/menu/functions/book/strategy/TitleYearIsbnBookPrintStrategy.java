package bookstore.menu.functions.book.strategy;

import bookstore.structure.Book;

import java.util.List;

public class TitleYearIsbnBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getId() +
                    ". Tytuł: " + book.getTitle() +
                    ", Rok wydania: " + book.getYear() +
                    ", ISBN: " + book.getIsbn() +
                    ", Typ okładki: " + book.getType() +
                    ", Autor: " + book.getAuthors() +
                    ", Kategoria: " + book.getCategory());
        }
    }
}
