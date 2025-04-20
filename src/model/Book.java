package model;

public class Book {
    private final String ISBN;
    private final String author;
    private final String title;
    private final String publisher;
    private final String genre;

    public Book(String ISBN, String author, String title, String publisher, String genre) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }
}
