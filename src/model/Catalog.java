package model;

import java.util.*;

public class Catalog {
    private final Map<String, List<Book>> booksByTitle;
    private final Map<String, List<Book>> booksByAuthor;
    private final Map<String, List<Book>> booksByGenre;

    public Catalog() {
        this.booksByTitle = new HashMap<>();
        this.booksByAuthor = new HashMap<>();
        this.booksByGenre = new HashMap<>();
    }

    public void addBook(Book book) {
        booksByTitle.computeIfAbsent(book.getTitle(), k -> new ArrayList<>()).add(book);
        booksByAuthor.computeIfAbsent(book.getAuthor(), k -> new ArrayList<>()).add(book);
        booksByGenre.computeIfAbsent(book.getGenre(), k -> new ArrayList<>()).add(book);
    }

    public List<Book> searchByTitle(String title) {
        return booksByTitle.getOrDefault(title, Collections.emptyList());
    }

    public List<Book> searchByAuthor(String author) {
        return booksByAuthor.getOrDefault(author, Collections.emptyList());
    }

    public List<Book> searchByGenre(String genre) {
        return booksByGenre.getOrDefault(genre, Collections.emptyList());
    }
}
