/**
 * Library Application

 * Book Class
 *
 * Represents a single book in the library system. Each book contains
 * identifying information such as ID, ISBN, title, author, publish date,
 * genre, and age rating. The class also stores the ID of the member
 * currently borrowing the book (if any).
 *
 * This model class is used by LibraryManager to perform operations such
 * as displaying books, checking books in/out, and searching the catalogue.
 *
 * Author: Tristan Wilkinson
 * Date: October 2026
 */

package library.models;

/**
 * Represents a book in the library catalogue.
 * Contains basic metadata and borrowing status.
 */
public class Book {

    // Unique identifier for the book
    private String id;

    // ISBN number (10 characters)
    private String isbn;

    // Title of the book
    private String title;

    // Author of the book
    private String author;

    // Publish date in YYYY-MM-DD format
    private String publishDate;

    // Genre category (e.g., Fiction, Mystery, Sci-Fi)
    private String genre;

    // Minimum age required to borrow the book
    private int ageRating;

    // ID of the member currently borrowing the book (null if available)
    private String borrowedByMemberId;

    /**
     * Constructs a new Book object with all required fields.
     *
     * @param id Unique book ID
     * @param isbn ISBN number
     * @param title Book title
     * @param author Book author
     * @param publishDate Date the book was published
     * @param genre Book genre
     * @param ageRating Minimum age required to borrow the book
     */
    public Book(String id, String isbn, String title, String author,
                String publishDate, String genre, int ageRating) {

        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.genre = genre;
        this.ageRating = ageRating;
        this.borrowedByMemberId = null; // Book starts as available
    }

    // ============================
    // GETTERS AND SETTERS
    // ============================

    /** Returns the book ID. */
    public String getId() {
        return id;
    }

    /** Returns the ISBN number. */
    public String getIsbn() {
        return isbn;
    }

    /** Returns the book title. */
    public String getTitle() {
        return title;
    }

    /** Returns the book author. */
    public String getAuthor() {
        return author;
    }

    /** Returns the publish date. */
    public String getPublishDate() {
        return publishDate;
    }

    /** Returns the genre. */
    public String getGenre() {
        return genre;
    }

    /** Returns the minimum age required to borrow the book. */
    public int getAgeRating() {
        return ageRating;
    }

    /** Returns the ID of the member borrowing the book (or null). */
    public String getBorrowedByMemberId() {
        return borrowedByMemberId;
    }

    /** Sets the ID of the member borrowing the book (or null to return it). */
    public void setBorrowedByMemberId(String borrowedByMemberId) {
        this.borrowedByMemberId = borrowedByMemberId;
    }

    // ============================
    // DISPLAY FORMAT
    // ============================

    /**
     * Returns a readable string representation of the book.
     * Used when displaying books in menus and search results.
     */
    @Override
    public String toString() {
        return String.format(
            "ID: %s | ISBN: %s | Title: %s | Author: %s | Date: %s | Genre: %s | Age: %d | BorrowedBy: %s",
            id, isbn, title, author, publishDate, genre, ageRating,
            (borrowedByMemberId == null ? "Available" : borrowedByMemberId)
        );
    }
}
