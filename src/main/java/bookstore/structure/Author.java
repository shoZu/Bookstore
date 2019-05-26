package bookstore.structure;

import java.util.Objects;

public class Author {
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
                ", Wiek autora: " + age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(name, author.name) &&
                Objects.equals(age, author.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
