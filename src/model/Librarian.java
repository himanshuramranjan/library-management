package model;

import enums.UserRole;

import java.util.List;

public class Librarian extends User {

    public void addBook(Book book, List<BookItem> items, Library library) {
        library.addBook(book, items);
    }

    public void removeBook(BookItem bookItem, Library library) {
        library.removeBook(bookItem);
    }

    public Librarian(String name, String email) {
        super(name, email);
    }

    @Override
    public UserRole getRole() {
        return UserRole.LIBRARIAN;
    }
}
