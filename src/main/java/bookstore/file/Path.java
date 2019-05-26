package bookstore.file;

public enum Path {
    AUTHORS("authors.csv"),
    BOOKS("books.csv"),
    CATEGORIES("categories.csv");

    String path;

    Path(String path) {
        this.path = path;
    }

   public String getPath(){
        return path;
   }
}
