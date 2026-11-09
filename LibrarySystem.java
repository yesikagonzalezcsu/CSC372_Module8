package csc372module8;

import java.util.Scanner;

public class LibrarySystem {

    // Read and validate integer input
    public static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean running = true;

        System.out.println("================================");
        System.out.println("       BASIC LIBRARY SYSTEM");
        System.out.println("================================");

        while (running) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");
            System.out.println("================================");

            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {

                // Add Book
                case 1: {
                    System.out.println("\n--- Add New Book ---");

                    int id = readInt(scanner, "Enter book ID: ");

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN number: ");
                    String isbn = scanner.nextLine();

                    int pages = readInt(scanner, "Enter number of pages: ");

                    if (id <= 0 || pages <= 0 || title.trim().isEmpty()
                            || author.trim().isEmpty() || isbn.trim().isEmpty()) {
                        System.out.println("Invalid book information. Please try again.");
                    } else if (inventory.addBook(id, title, author, isbn, pages)) {
                        System.out.println("Book added to the library.");
                    } else {
                        System.out.println("A book with this ID already exists.");
                    }
                    break;
                }

                // Borrow Book
                case 2: {
                    System.out.println("\n--- Borrow Book ---");

                    int borrowId = readInt(scanner, "Enter book ID to borrow: ");

                    if (inventory.borrowBook(borrowId)) {
                        System.out.println("Book successfully borrowed.");
                    } else {
                        System.out.println("Book not found or already borrowed.");
                    }
                    break;
                }

                // Return Book
                case 3: {
                    System.out.println("\n--- Return Book ---");

                    int returnId = readInt(scanner, "Enter book ID to return: ");

                    if (inventory.returnBook(returnId)) {
                        System.out.println("Book successfully returned.");
                    } else {
                        System.out.println("Book not found in the lending inventory.");
                    }
                    break;
                }

                // Search by Title
                case 4: {
                    System.out.println("\n--- Search Books ---");
                    System.out.print("Enter full or partial book title: ");
                    String searchTitle = scanner.nextLine();

                    if (searchTitle.trim().isEmpty()) {
                        System.out.println("Please enter a book title.");
                    } else {
                        inventory.searchByTitle(searchTitle);
                    }
                    break;
                }

                // Print All Books
                case 5: {
                    inventory.printAll();
                    System.out.println("Available books: "
                            + inventory.getMainInventoryCount());
                    System.out.println("Borrowed books: "
                            + inventory.getLendingInventoryCount());
                    break;
                }

                // Exit
                case 6: {
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;
                }

                // Invalid Menu Option
                default: {
                    System.out.println("Invalid option. Please select 1 through 6.");
                    break;
                }
            }
        }

        scanner.close();
    }
}