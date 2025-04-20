package model;

import enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private final int MAX_ALLOWED_BOOKS = 5;
    private final List<BookItem> borrowedBooks;
    private final List<BookItem> reservedBooks;

    public Member(String name, String email) {
        super(name, email);
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    @Override
    public UserRole getRole() {
        return UserRole.MEMBER;
    }

    public void borrowBooks(List<BookItem> bookItems) {
        if(bookItems.size() + borrowedBooks.size() > MAX_ALLOWED_BOOKS) {
            System.out.println("you are exceeding your max booking capacity of " + MAX_ALLOWED_BOOKS);
            return;
        }
        borrowedBooks.addAll(bookItems);
    }

    public void returnBooks(List<BookItem> bookItems) {
        borrowedBooks.removeAll(bookItems);
    }
}
