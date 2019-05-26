package bookstore.menu.functions;

import bookstore.structure.Categories;

import java.util.List;

public class ShowCategories {

    public void show(List<Categories> listOfCategories) {
        for (Categories categories : listOfCategories) {
            System.out.println(categories.toString2());
        }
    }
}
