import java.util.List;

public class Book {
    int id;
    String title;
    String isbn;
    String year;
    String type;
    List<Author> authors;
    Categories category;


    public Book(int id, String title, String isbn, String year, String type,  List<Author> authors, Categories category) {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getYear() {
        return year;
    }

}
