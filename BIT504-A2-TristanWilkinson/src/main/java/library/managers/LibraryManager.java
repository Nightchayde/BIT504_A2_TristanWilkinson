/**
 * Library Application 

 * LibraryManager Class
 *
 * This class is responsible for storing and managing all library data,
 * including books and members. It provides methods for displaying data,
 * adding new records, checking books in and out, and performing search
 * operations. The class follows the Singleton design pattern to ensure
 * only one instance manages the library data throughout the application.
 *
 * Author: Tristan Wilkinson
 * Date: October 2026
 *
 * Key Concepts Demonstrated:
 * - Singleton pattern
 * - Collections (List)
 * - File input using utility classes
 * - User input validation
 * - Basic business logic (loan rules, age restrictions)
 * - Searching and filtering lists
 */

package library.managers;

import library.models.Book;
import library.models.Member;
import library.utils.FileReaderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Singleton class responsible for managing all library data and operations.
 * Provides methods for displaying books/members, adding new records,
 * checking books in/out, and performing search operations.
 */
public class LibraryManager {

    // Singleton instance
    private static LibraryManager instance;

    // Lists storing all books and members loaded from files
    private List<Book> books;
    private List<Member> members;

    /**
     * Private constructor to enforce Singleton pattern.
     * Loads books and members from text files using FileReaderUtil.
     */
    private LibraryManager() {
        books = FileReaderUtil.readBooks("src/main/resources/books.txt");
        members = FileReaderUtil.readMembers("src/main/resources/members.txt");
    }

    /**
     * Returns the single instance of LibraryManager.
     * Creates the instance if it does not already exist.
     */
    public static LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }

    // ============================================================
    // DISPLAY METHODS
    // ============================================================

    /**
     * Displays all books currently stored in the library.
     */
    public void displayAllBooks() {
        System.out.println("=== All Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Displays only books that are currently borrowed.
     */
    public void displayBorrowedBooks() {
        System.out.println("=== Borrowed Books ===");
        for (Book book : books) {
            if (book.getBorrowedByMemberId() != null) {
                System.out.println(book);
            }
        }
    }

    /**
     * Displays books that are not currently borrowed.
     */
    public void displayUnborrowedBooks() {
        System.out.println("=== Unborrowed Books ===");
        for (Book book : books) {
            if (book.getBorrowedByMemberId() == null) {
                System.out.println(book);
            }
        }
    }

    /**
     * Displays all members registered in the library.
     */
    public void displayAllMembers() {
        System.out.println("=== All Members ===");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    // ============================================================
    // ADD NEW BOOK
    // ============================================================

    /**
     * Adds a new book to the library.
     * Prompts the user for all required fields and performs validation
     * such as checking for duplicate IDs and ISBNs.
     */
    public void addNewBook(Scanner scanner) {
        System.out.println("=== Add New Book ===");

        // Book ID
        System.out.print("Enter ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty() || idExists(id)) {
            System.out.println("Invalid or duplicate ID.");
            return;
        }

        // ISBN
        System.out.print("Enter ISBN (10 characters): ");
        String isbn = scanner.nextLine().trim();
        if (isbn.length() != 10 || isbnExists(isbn)) {
            System.out.println("Invalid or duplicate ISBN.");
            return;
        }

        // Title
        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Title cannot be blank.");
            return;
        }

        // Author
        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("Author cannot be blank.");
            return;
        }

        // Publish Date
        System.out.print("Enter Publish Date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();
        if (date.isEmpty()) {
            System.out.println("Publish date cannot be blank.");
            return;
        }

        // Genre
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine().trim();
        if (genre.isEmpty()) {
            System.out.println("Genre cannot be blank.");
            return;
        }

        // Age Rating
        System.out.print("Enter Age Rating (number): ");
        String ageStr = scanner.nextLine().trim();
        int ageRating;
        try {
            ageRating = Integer.parseInt(ageStr);
        } catch (Exception e) {
            System.out.println("Age rating must be a number.");
            return;
        }

        // Create and add the new book
        Book newBook = new Book(id, isbn, title, author, date, genre, ageRating);
        books.add(newBook);

        System.out.println("Book added successfully.");
    }

    /**
     * Checks if a book ID already exists.
     */
    private boolean idExists(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return true;
        }
        return false;
    }

    /**
     * Checks if an ISBN already exists.
     */
    private boolean isbnExists(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return true;
        }
        return false;
    }

    // ============================================================
    // ADD NEW MEMBER
    // ============================================================

    /**
     * Adds a new member to the library.
     * Validates ID uniqueness and ensures age is within a realistic range.
     */
    public void addNewMember(Scanner scanner) {
        System.out.println("=== Add New Member ===");

        // Member ID
        System.out.print("Enter ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty() || memberIdExists(id)) {
            System.out.println("Invalid or duplicate ID.");
            return;
        }

        // First Name
        System.out.print("Enter First Name: ");
        String first = scanner.nextLine().trim();
        if (first.isEmpty()) {
            System.out.println("First name cannot be blank.");
            return;
        }

        // Last Name
        System.out.print("Enter Last Name: ");
        String last = scanner.nextLine().trim();
        if (last.isEmpty()) {
            System.out.println("Last name cannot be blank.");
            return;
        }

        // Age
        System.out.print("Enter Age (0–125): ");
        String ageStr = scanner.nextLine().trim();
        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 0 || age > 125) {
                System.out.println("Age must be between 0 and 125.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Age must be a number.");
            return;
        }

        // Create and add the new member
        Member newMember = new Member(id, first, last, age);
        members.add(newMember);

        System.out.println("Member added successfully.");
    }

    /**
     * Checks if a member ID already exists.
     */
    private boolean memberIdExists(String id) {
        for (Member m : members) {
            if (m.getId().equals(id)) return true;
        }
        return false;
    }

    // ============================================================
    // LOAN MANAGEMENT
    // ============================================================

    /**
     * Allows a member to borrow a book.
     * Validates book availability, member existence, and age rating.
     */
    public void checkOutBook(Scanner scanner) {
        System.out.println("=== Check Out Book ===");

        // Book ID
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine().trim();
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        // Check if already borrowed
        if (book.getBorrowedByMemberId() != null) {
            System.out.println("Book is already borrowed.");
            return;
        }

        // Member ID
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine().trim();
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        // Age restriction
        if (member.getAge() < book.getAgeRating()) {
            System.out.println("Member is too young to borrow this book.");
            return;
        }

        // Confirmation
        System.out.println("Borrow \"" + book.getTitle() + "\"? (yes/no)");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            book.setBorrowedByMemberId(memberId);
            System.out.println("Book successfully checked out.");
        } else {
            System.out.println("Cancelled.");
        }
    }

    /**
     * Returns a borrowed book to the library.
     * Ensures the book is currently borrowed before checking it in.
     */
    public void checkInBook(Scanner scanner) {
        System.out.println("=== Check In Book ===");

        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine().trim();
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.getBorrowedByMemberId() == null) {
            System.out.println("Book is not currently borrowed.");
            return;
        }

        // Return the book
        book.setBorrowedByMemberId(null);
        System.out.println("Book returned successfully.");
    }

    // ============================================================
    // SEARCH METHODS
    // ============================================================

    /**
     * Searches for members by last name.
     * Also displays any books currently borrowed by matching members.
     */
    public void searchMember(Scanner scanner) {
        System.out.println("=== Search Member ===");

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim().toLowerCase();

        List<Member> results = new ArrayList<>();

        // Find matching members
        for (Member m : members) {
            if (m.getLastName().toLowerCase().contains(lastName)) {
                results.add(m);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        // Display results
        for (Member m : results) {
            System.out.println(m);

            // Show books borrowed by this member
            for (Book b : books) {
                if (m.getId().equals(b.getBorrowedByMemberId())) {
                    System.out.println("  Borrowing: " + b.getTitle());
                }
            }
        }
    }

    /**
     * Searches for books by title.
     * Displays availability or the member currently borrowing the book.
     */
    public void searchBook(Scanner scanner) {
        System.out.println("=== Search Book ===");

        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim().toLowerCase();

        List<Book> results = new ArrayList<>();

        // Find matching books
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title)) {
                results.add(b);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        // Display results
        for (Book b : results) {
            System.out.println(b);

            if (b.getBorrowedByMemberId() != null) {
                Member borrower = findMemberById(b.getBorrowedByMemberId());
                System.out.println("  Borrowed by: " + borrower.getFirstName() + " " + borrower.getLastName());
            } else {
                System.out.println("  Available");
            }
        }
    }

    // ============================================================
    // HELPER METHODS
    // ============================================================

    /**
     * Finds a book by its ID.
     */
    private Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    /**
     * Finds a member by their ID.
     */
    private Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }
}
