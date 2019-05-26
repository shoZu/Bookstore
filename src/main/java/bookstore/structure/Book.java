package bookstore.structure;

import java.util.List;

public class Book {
    private final int id;
    private final String type;
    private final List<Author> authors;
    private final Categories category;
    private String title;
    private String isbn;
    private int year;


    public Book(int id, String title, String isbn, int year, String type, List<Author> authors, Categories category) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.type = type;
        this.authors = authors;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Categories getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return id + ". Tytuł: " + title +
                ", ISBN: " + isbn +
                ", Rok wydania: " + year +
                ", Typ okładki: " + type +
                ", Autor: " + authors +
                ", Kategoria: " + category + '\n';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
