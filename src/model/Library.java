package model;

import enums.BookStatus;

import java.util.*;

public class Library {
    private final Map<String, Book> booksByISBN;
    private final Map<String, List<BookItem>> bookCopiesByISBN;

    public Library() {
        this.booksByISBN = new HashMap<>();
        this.bookCopiesByISBN = new HashMap<>();
    }

    public void addBook(Book book, List<BookItem> items) {
        booksByISBN.putIfAbsent(book.getISBN(), book);
        bookCopiesByISBN.computeIfAbsent(book.getISBN(), k -> new ArrayList<>()).addAll(items);
    }

    public void removeBook(BookItem bookItem) {
        List<BookItem> items = bookCopiesByISBN.get(bookItem.getBook().getISBN());
        if(items != null) items.remove(bookItem);
    }

    public List<BookItem> getAvailableCopies(String isbn) {
        return bookCopiesByISBN.getOrDefault(isbn, Collections.emptyList())
                .stream()
                .filter(b -> b.getStatus() == BookStatus.AVAILABLE)
                .toList();
    }

    public Book getBookByISBN(String isbn) {
        return booksByISBN.get(isbn);
    }
}
