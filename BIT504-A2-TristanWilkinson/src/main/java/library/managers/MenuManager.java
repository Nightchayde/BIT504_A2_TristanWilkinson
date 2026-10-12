/**
 * Library Application
 
 * MenuManager Class
 *
 * This class controls all menu navigation and user interaction for the
 * console-based library system. It displays menus, handles user input,
 * and calls the appropriate LibraryManager methods to perform actions.
 *
 * The design focuses on simplicity, readability, and user friendliness.
 * Screen clearing is done only when entering menus to avoid autoscrolling
 * issues in Windows terminals. A pause method is used to allow users to
 * read output before returning to a menu.
 *
 * Author: Tristan Wilkinson
 * Date: October 2026
 */

package library.managers;

import java.util.Scanner;

/**
 * Handles all menu navigation and user input.
 * Provides a simple, clear console interface for the library system.
 */
public class MenuManager {

    // Access the singleton LibraryManager instance
    private final LibraryManager libraryManager = LibraryManager.getInstance();

    // Scanner for user input
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Clears the console screen by printing multiple blank lines.
     * This method is Windows-safe and avoids ANSI escape code issues.
     */
    private void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Pauses the program so the user can read output before continuing.
     */
    private void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    /**
     * Displays the main menu and handles user selections.
     * This is the entry point for all menu navigation.
     */
    public void displayMainMenu() {
        while (true) {
            clearScreen();  // Clear screen only when entering a menu

            System.out.println("====================================");
            System.out.println("           LIBRARY SYSTEM           ");
            System.out.println("====================================");
            System.out.println("1. Book Management");
            System.out.println("2. Member Management");
            System.out.println("3. Loan Management");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayBookMenu();
                    break;
                case "2":
                    displayMemberMenu();
                    break;
                case "3":
                    displayLoanMenu();
                    break;
                case "4":
                    displaySearchMenu();
                    break;
                case "5":
                    clearScreen();
                    System.out.println("Exiting program...");
                    return; // End program
                default:
                    System.out.println("Invalid option.");
                    pause();
            }
        }
    }

    /**
     * Displays the Book Management menu and handles user selections.
     */
    private void displayBookMenu() {
        while (true) {
            clearScreen();

            System.out.println("====================================");
            System.out.println("           BOOK MANAGEMENT          ");
            System.out.println("====================================");
            System.out.println("1. Display all books");
            System.out.println("2. Display borrowed books");
            System.out.println("3. Display unborrowed books");
            System.out.println("4. Add a new book");
            System.out.println("5. Return");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    libraryManager.displayAllBooks();
                    pause();
                    break;
                case "2":
                    libraryManager.displayBorrowedBooks();
                    pause();
                    break;
                case "3":
                    libraryManager.displayUnborrowedBooks();
                    pause();
                    break;
                case "4":
                    libraryManager.addNewBook(scanner);
                    pause();
                    break;
                case "5":
                    return; // Return to main menu
                default:
                    System.out.println("Invalid option.");
                    pause();
            }
        }
    }

    /**
     * Displays the Member Management menu and handles user selections.
     */
    private void displayMemberMenu() {
        while (true) {
            clearScreen();

            System.out.println("====================================");
            System.out.println("          MEMBER MANAGEMENT         ");
            System.out.println("====================================");
            System.out.println("1. Display all members");
            System.out.println("2. Add a new member");
            System.out.println("3. Return");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    libraryManager.displayAllMembers();
                    pause();
                    break;
                case "2":
                    libraryManager.addNewMember(scanner);
                    pause();
                    break;
                case "3":
                    return; // Return to main menu
                default:
                    System.out.println("Invalid option.");
                    pause();
            }
        }
    }

    /**
     * Displays the Loan Management menu and handles user selections.
     */
    private void displayLoanMenu() {
        while (true) {
            clearScreen();

            System.out.println("====================================");
            System.out.println("           LOAN MANAGEMENT          ");
            System.out.println("====================================");
            System.out.println("1. Check out a book");
            System.out.println("2. Check in a book");
            System.out.println("3. Return");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    libraryManager.checkOutBook(scanner);
                    pause();
                    break;
                case "2":
                    libraryManager.checkInBook(scanner);
                    pause();
                    break;
                case "3":
                    return; // Return to main menu
                default:
                    System.out.println("Invalid option.");
                    pause();
            }
        }
    }

    /**
     * Displays the Search menu and handles user selections.
     */
    private void displaySearchMenu() {
        while (true) {
            clearScreen();

            System.out.println("====================================");
            System.out.println("               SEARCH               ");
            System.out.println("====================================");
            System.out.println("1. Find a member");
            System.out.println("2. Find a book");
            System.out.println("3. Return");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    libraryManager.searchMember(scanner);
                    pause();
                    break;
                case "2":
                    libraryManager.searchBook(scanner);
                    pause();
                    break;
                case "3":
                    return; // Return to main menu
                default:
                    System.out.println("Invalid option.");
                    pause();
            }
        }
    }
}
