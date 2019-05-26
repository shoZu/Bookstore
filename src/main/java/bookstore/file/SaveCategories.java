package bookstore.file;

import bookstore.structure.Categories;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SaveCategories {
    public void save(List<Categories> categoriesList, String fileWithCategories) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileWithCategories);
        } catch (FileNotFoundException e) {
            System.out.println("Nie mozna zapisac do pliku categories.csv");
        }
        for (Categories categories : categoriesList) {
            out.println(categories.getId() + ";" + categories.getName() + ";" + categories.getPriority());
        }
        out.close();
    }
}

