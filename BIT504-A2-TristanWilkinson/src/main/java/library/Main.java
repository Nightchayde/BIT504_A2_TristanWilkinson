package library;

import library.managers.MenuManager;

/**
 * Entry point for the Library Application.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Library System Loaded.");
        MenuManager menuManager = new MenuManager();
        menuManager.displayMainMenu();
    }
}
