class Author {
    private final int id;
    private final String name;
    private final String age;

    public Author(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return   name;

    }

    public String toString2() {
        return  id +
                ". Imie i nazwisko: " + name +
                ", Wiek autora: " + age + '\n';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
