package csc372module8;

public class Book {

    // Private member variables
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int numberOfPages;

    // Default constructor
    public Book() {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.numberOfPages = 0;
    }

    // Parameterized constructor
    public Book(int id, String title, String author, String isbn, int numberOfPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    // Display book information
    public void printBookInfo() {
        System.out.println("------------------------------");
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("------------------------------");
    }
}