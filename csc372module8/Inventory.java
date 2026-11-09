package csc372module8;

import java.util.ArrayList;

public class Inventory {

    // Lists for available and borrowed books
    private ArrayList<Book> mainInventory;
    private ArrayList<Book> lendingInventory;

    // Constructor
    public Inventory() {
        mainInventory = new ArrayList<>();
        lendingInventory = new ArrayList<>();
    }

    // Add a new book to the library
    public boolean addBook(int id, String title, String author,
                           String isbn, int numberOfPages) {

        // Check for duplicate IDs
        if (findBookById(id) != null) {
            return false;
        }

        Book book = new Book(id, title, author, isbn, numberOfPages);
        mainInventory.add(book);
        return true;
    }

    // Find a book by its unique ID (checks both lists)
    private Book findBookById(int id) {
        for (Book book : mainInventory) {
            if (book.getId() == id) {
                return book;
            }
        }

        for (Book book : lendingInventory) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    // Borrow book: move it from the main inventory to the lending inventory
    public boolean borrowBook(int id) {
        for (int i = 0; i < mainInventory.size(); i++) {
            if (mainInventory.get(i).getId() == id) {
                lendingInventory.add(mainInventory.remove(i));
                return true;
            }
        }
        return false;
    }

    // Return borrowed book: move it from the lending inventory back to the main inventory
    public boolean returnBook(int id) {
        for (int i = 0; i < lendingInventory.size(); i++) {
            if (lendingInventory.get(i).getId() == id) {
                mainInventory.add(lendingInventory.remove(i));
                return true;
            }
        }
        return false;
    }

    // Print all available books
    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("No books are currently available.");
            return;
        }

        System.out.println("\n--- Available Books ---");
        for (Book book : mainInventory) {
            book.printBookInfo();
        }
    }

    // Search books by full or partial title (case-insensitive)
    public void searchByTitle(String title) {
        boolean found = false;

        System.out.println("\n--- Search Results ---");
        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {
                book.printBookInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    // Get the number of available books
    public int getMainInventoryCount() {
        return mainInventory.size();
    }

    // Get the number of borrowed books
    public int getLendingInventoryCount() {
        return lendingInventory.size();
    }
}