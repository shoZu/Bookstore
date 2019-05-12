public class Categories {
    int id;
    String name;
    int priority;

    public Categories(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return  name;
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
