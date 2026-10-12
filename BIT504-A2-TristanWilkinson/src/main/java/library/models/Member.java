/**
 * Library Application
 
 * Member Class
 *
 * Represents a single library member. Each member contains identifying
 * information such as ID, first name, last name, and age. This class is
 * used by LibraryManager to perform operations such as displaying members,
 * adding new members, validating borrowing age, and searching the member list.
 *
 * Author: Tristan Wilkinson
 * Date: October 2026
 */

package library.models;

/**
 * Represents a member of the library.
 * Stores basic personal information used for borrowing and searching.
 */
public class Member {

    // Unique identifier for the member
    private String id;

    // Member's first name
    private String firstName;

    // Member's last name
    private String lastName;

    // Member's age (used for age-restricted books)
    private int age;

    /**
     * Constructs a new Member object with all required fields.
     *
     * @param id Unique member ID
     * @param firstName Member's first name
     * @param lastName Member's last name
     * @param age Member's age
     */
    public Member(String id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // ============================
    // GETTERS AND SETTERS
    // ============================

    /** Returns the member ID. */
    public String getId() {
        return id;
    }

    /** Returns the member's first name. */
    public String getFirstName() {
        return firstName;
    }

    /** Returns the member's last name. */
    public String getLastName() {
        return lastName;
    }

    /** Returns the member's age. */
    public int getAge() {
        return age;
    }

    // ============================
    // DISPLAY FORMAT
    // ============================

    /**
     * Returns a readable string representation of the member.
     * Used when displaying members and search results.
     */
    @Override
    public String toString() {
        return String.format(
            "ID: %s | Name: %s %s | Age: %d",
            id, firstName, lastName, age
        );
    }
}
