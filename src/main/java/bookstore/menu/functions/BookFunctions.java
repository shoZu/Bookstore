package bookstore.menu.functions;

import bookstore.structure.Book;

import java.util.*;
import java.util.stream.Collectors;


public class BookFunctions {

    //    Znajdź książkę o podanym ISBN. Metoda przyjmuje 2 parametry (isbn, lista wszystkich książek) i zwraca podaną książkę.
    public Book findIsbn(List<Book> list, String isbn) {
        Book findBook = null;
        for (Book book : list) {
            if (book.getIsbn().equals(isbn)) {
                findBook = book;
            }
        }
        return findBook;
    }

    public Optional<Book> findIsbnStream(List<Book> list, String isbn) {
        return list.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }

    //    Zwróć dwie ostatnie książki.
    public List<Book> lastTwoBooks(List<Book> list) {
        return list.subList(list.size() - 2, list.size());
    }

    public List<Book> lastTwoBooksStream(List<Book> list) {
        return list.stream()
                .skip(list.size() - 2)
                .collect(Collectors.toList());
    }

    //    Zwróć najwcześniej wydana książkę.
    public Book getEarliestReleasedBook(List<Book> list) {
        Book firstbook = list.get(0);
        for (Book book : list) {
            if (firstbook.getYear() > book.getYear()) {
                firstbook = book;
            }
        }
        return firstbook;
    }

    public Optional<Book> getEarliestReleasedBookStream(List<Book> list) {
        return list.stream()
                .min(Comparator.comparingInt(Book::getYear));
    }

    //    Zwróć najpóźniej wydana książkę.
    public Book getLateestReleasedBook(List<Book> list) {
        Book firstbook = list.get(0);
        for (Book book : list) {
            if (firstbook.getYear() < book.getYear()) {
                firstbook = book;
            }
        }
        return firstbook;
    }

    public Optional<Book> getLateestReleasedBookStream(List<Book> list) {
        return list.stream()
                .max(Comparator.comparingInt(Book::getYear));
    }

    //    Zwróć sumę lat wydania wszystkich książek.
    public int sumOfYears(List<Book> list) {
        int sumYears = 0;
        for (Book book : list) {
            sumYears += book.getYear();
        }
        return sumYears;
    }

    public int sumOfYearsStream(List<Book> list) {
        return list.stream()
                .mapToInt(Book::getYear)
                .sum();
    }

    //    Zwróć liczbę książek wydanych po 2007 roku.
    public int booksReleasedAfter2007(List<Book> list) {
        int after2007 = 0;
        for (Book book : list) {
            if (book.getYear() > 2007) {
                after2007 = after2007 + 1;
            }
        }
        return after2007;
    }

    public double booksReleasedAfter2007Stream(List<Book> list) {
        return list.stream()
                .filter(book -> book.getYear() > 2007)
                .count();
    }

    //    Zwróć informacje o tym czy wszystkie książki w naszym katalogu są wydane po 2000 roku.
    public boolean releasedAfter2000(List<Book> list) {
        boolean booksReleasedAfter2000 = true;
        for (Book book : list) {
            if (book.getYear() > 2000) {
                booksReleasedAfter2000 = false;
            }
        }
        return booksReleasedAfter2000;
    }

    public boolean releasedAfter2000Stream(List<Book> list) {
        return list.stream()
                .allMatch(book -> book.getYear() > 2000);
    }


    // Zwróć średni rok wydania książki w naszym katalogu.
    public double averageYearsOfBooks(List<Book> list) {
        double sum = 0;
        for (Book book : list) {
            sum = sum + book.getYear();
        }
        return sum / list.size();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public double averageYearsOfBooksStream(List<Book> list) {
        return list.stream()
                .mapToInt(Book::getYear)
                .average()
                .getAsDouble();
    }

    // Zwróć informacje o tym czy jakakolwiek książka w naszym katalogu jest wydana przed  2003 rokiem.
    public boolean releasedBefore2003(List<Book> list) {
        int booksReleasedBefore2003 = 0;
        for (Book book : list) {
            if (book.getYear() < 2003) {
                booksReleasedBefore2003++;
            }
        }
        return booksReleasedBefore2003 > 0;
    }

    public boolean releasedBefore2003Stream(List<Book> list) {
        return list.stream()
                .anyMatch(book -> book.getYear() < 2003);
    }

    // Zwróć wszystkie książki, których tytuł zaczyna się od litery “C” i były one wydane po 2007 roku.
    public List<Book> booksStartsCAndRealeasdAfter2007(List<Book> list, int year) {
        return list.stream()
                .filter(book -> book.getTitle().startsWith("C"))
                .filter(book -> book.getYear() > year)
                .collect(Collectors.toList());
    }

    //Zwróć tytuły wszystkich książek, których rok jest podzielny przez 2.
    public List<Book> yearOfBooksDividedBy2(List<Book> list) {
        return list.stream()
                .filter(book -> book.getYear() % 2 == 0)
                .collect(Collectors.toList());
    }

    // Zwróć mapę, która będzie miała klucz isbn i wartość obiekt bookstore.structure.Book (Map<String, bookstore.structure.Book>).
    public Map<String, Book> mapOfbooks(List<Book> list) {
        return list.stream()
                .collect(Collectors.toMap(Book::getIsbn, book -> book));
    }

    //Posortuj książki po roku wydania zaczynając od wydanej najpóźniej.
    public List<Book> sortBookReverseOrder(List<Book> list) {
        return list.stream()
                .sorted(Comparator.comparing(Book::getYear, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    // Posortuj książki po roku wydania zaczynając od wydanej najwcześniej
    public List<Book> sortBook(List<Book> list) {
        return list.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .collect(Collectors.toList());
    }

    // Podziel listę książek na 3 listy po 2 książki i zwróć z metody. (*) (bez streama)
    public List<List<Book>> divideList(List<Book> list) {
        List<List<Book>> finalList = new ArrayList<>();
        for (int i = 0; i <= list.size() / 2 + 1; i = i + 2) {
            finalList.add(list.subList(i, i + 2));
        }
        return finalList;
    }

    // Pogrupuj książki po roku wydania. Metoda powinna zwrócić Map<Integer, bookstore.List<bookstore.structure.Book>>
    // gdzie kluczem jest rok wydania a wartością lista książek wydana w tym roku. (*)
    public Map<Integer, List<Book>> mapOfBooksByYear(List<Book> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Book::getYear));
    }

    public Map<Integer, List<Book>> mapOfBooksByYearByLoop(List<Book> list) {
        Map<Integer, List<Book>> collect = new HashMap<>();
        for (Book book : list) {
            if (collect.containsKey(book.getYear())) {
                collect.get(book.getYear()).add(book);
            } else {
                List<Book> books = new ArrayList<>();
                books.add(book);
                collect.put(book.getYear(), books);
            }
        }
        return collect;
    }

    // Podziel książki na te wydane po 2009 roku i pozostałe.
    // Metoda powinna zwrócić Map<Boolean, bookstore.List<bookstore.structure.Book>> gdzie kluczem jest
    // boolean oznaczający czy została wydana po 2009 a wartością będą listy książek. (*)
    public Map<Boolean, List<Book>> mapOfBooksAfter2009(List<Book> list) {
        return list.stream()
                .collect(Collectors.groupingBy(o -> o.getYear() > 2009));
    }

}
