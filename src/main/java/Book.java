public class Book {
    String title;
    String isbn;
    String year;

    @Override
    public String toString() {
        return  "Tytul: " + title + ' ' +
                "ISBN: " + isbn + ' ' +
                "Data wydania: " + year + ' ' +
                '\n';
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

    public Book(String title, String isbn, String year) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
    }

}
