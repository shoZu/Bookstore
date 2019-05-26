package bookstore.structure;

public class Categories {
    private final int id;
    private final String name;
    private final int priority;

    public Categories(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toString2() {
        return id + ": " + name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
