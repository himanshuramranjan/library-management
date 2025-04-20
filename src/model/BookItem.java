package model;

import enums.BookStatus;

import java.time.LocalDate;

public class BookItem {
    public final String barcode;
    private final Book book;
    private BookStatus status;
    private LocalDate dueDate;

    public BookItem(String barcode, Book book) {
        this.barcode = barcode;
        this.book = book;
        this.status = BookStatus.AVAILABLE;
        this.dueDate = LocalDate.MAX;
    }

    public void borrowBook() {
        this.status = BookStatus.BORROWED;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    public void extendBorrowing(int noOfDays) {
        this.dueDate = this.dueDate.plusDays(noOfDays);
    }

    public void markAvailable() {
        this.status = BookStatus.AVAILABLE;
        this.dueDate = LocalDate.MAX;
    }

    public String getBarcode() {
        return barcode;
    }

    public Book getBook() {
        return book;
    }

    public BookStatus getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
