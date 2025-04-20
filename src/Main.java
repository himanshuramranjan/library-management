import model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Catalog catalog = new Catalog();

        // Librarian adds books
        Librarian librarian = new Librarian("Alice", "alice@library.com");
        Book book1 = new Book("ISBN001", "Joshua Bloch","Effective Java", "Addison-Wesley", "Programming");
        BookItem bookItem1 = new BookItem("BC001", book1);
        BookItem bookItem2 = new BookItem("BC002", book1);

        librarian.addBook(book1, List.of(bookItem1, bookItem2), library);
        catalog.addBook(book1);

        // Member searches and borrows a book
        Member member = new Member( "Bob", "bob@gmail.com");
        List<Book> books = catalog.searchByTitle("Effective Java");

        if (!books.isEmpty()) {
            List<BookItem> availableCopies = library.getAvailableCopies(books.get(0).getISBN());
            if (!availableCopies.isEmpty()) {
                // we can also get a list of books and iterate them to mark them Borrowed
                List<BookItem> toBorrow = availableCopies;
                toBorrow.get(0).borrowBook();

                member.borrowBooks(toBorrow);
                System.out.println(member.getName() + " borrowed book: " + toBorrow.get(0).getBook().getTitle());
                member.returnBooks(toBorrow);
                System.out.println(member.getName() + " returned the book " + toBorrow.get(0).getBook().getTitle());
            }
        }
    }
}