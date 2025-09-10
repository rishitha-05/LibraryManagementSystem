import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * A simple console-based Library Management System
 * Features:
 *  - Add book
 *  - Remove book
 *  - Search book by title/author
 *  - Display all books
 *  - Issue and return books
 */
public class LibraryManagementSystem {

    /**
     * Utility to read all input first and then provide it line by line.
     * Helps prevent runtime errors in online IDEs where interactive input is limited.
     */
    static class FastScanner {
        private final List<String> lines = new ArrayList<>();
        private int idx = 0;

        FastScanner() {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            sc.close();
        }

        // Get the next non-empty line; returns null if no more input
        String nextNonEmptyLine() {
            while (idx < lines.size()) {
                String s = lines.get(idx++);
                if (s != null && !s.trim().isEmpty()) return s;
            }
            return null;
        }

        // Parse the next non-empty line as an integer
        Integer nextIntOrNull() {
            String s = nextNonEmptyLine();
            if (s == null) return null;
            try {
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }

    /**
     * Represents a single Book with id, title, author, and issue status.
     */
    static class Book {
        private int id;
        private String title;
        private String author;
        private boolean isIssued;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public int getId() { return id; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public boolean isIssued() { return isIssued; }

        public void issue() { isIssued = true; }
        public void returnBook() { isIssued = false; }

        @Override
        public String toString() {
            return id + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available");
        }
    }

    /**
     * Library class manages all books and operations.
     */
    static class Library {
        private List<Book> books = new ArrayList<>();
        private int nextId = 1;  // Auto-increment book ID

        // Add a new book
        public void addBook(String title, String author) {
            Book book = new Book(nextId++, title, author);
            books.add(book);
            System.out.println("Book added successfully: " + book);
        }

        // Remove a book by its ID
        public void removeBook(int id) {
            Iterator<Book> it = books.iterator();
            while (it.hasNext()) {
                Book book = it.next();
                if (book.getId() == id) {
                    it.remove();
                    System.out.println("Book with ID " + id + " removed.");
                    return;
                }
            }
            System.out.println("Book with ID " + id + " not found.");
        }

        // Search book by keyword in title or author
        public void searchBook(String keyword) {
            boolean found = false;
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(book);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No book found for keyword: " + keyword);
            }
        }

        // Display all available books
        public void displayBooks() {
            if (books.isEmpty()) {
                System.out.println("No books available.");
                return;
            }
            for (Book book : books) {
                System.out.println(book);
            }
        }

        // Issue a book by ID
        public void issueBook(int id) {
            for (Book book : books) {
                if (book.getId() == id && !book.isIssued()) {
                    book.issue();
                    System.out.println("Book issued: " + book);
                    return;
                }
            }
            System.out.println("Book not available or already issued.");
        }

        // Return a book by ID
        public void returnBook(int id) {
            for (Book book : books) {
                if (book.getId() == id && book.isIssued()) {
                    book.returnBook();
                    System.out.println("Book returned: " + book);
                    return;
                }
            }
            System.out.println("Book not found or not issued.");
        }
    }

    /**
     * Main program: menu-driven console interface
     */
    public static void main (String[] args) throws java.lang.Exception {
        FastScanner fs = new FastScanner();
        Library library = new Library();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            Integer choice = fs.nextIntOrNull();
            if (choice == null) {
                System.out.println("No more input. Exiting.");
                return;
            }

            switch (choice) {
                case 1: {
                    String title = fs.nextNonEmptyLine();
                    if (title == null) return;
                    String author = fs.nextNonEmptyLine();
                    if (author == null) return;
                    library.addBook(title, author);
                    break;
                }
                case 2: {
                    Integer removeId = fs.nextIntOrNull();
                    if (removeId == null) return;
                    library.removeBook(removeId);
                    break;
                }
                case 3: {
                    String keyword = fs.nextNonEmptyLine();
                    if (keyword == null) return;
                    library.searchBook(keyword);
                    break;
                }
                case 4:
                    library.displayBooks();
                    break;
                case 5: {
                    Integer issueId = fs.nextIntOrNull();
                    if (issueId == null) return;
                    library.issueBook(issueId);
                    break;
                }
                case 6: {
                    Integer returnId = fs.nextIntOrNull();
                    if (returnId == null) return;
                    library.returnBook(returnId);
                    break;
                }
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
