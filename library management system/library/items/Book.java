// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.items;

import library.people.Author;
import library.Status;

public class Book extends LibraryItem {
    private String genre;
    private int numberOfPages;
    private String format;

    // Constructor
    public Book(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            Status status, String genre, int numberOfPages, String format) {
        super(id, title, author, isbn, publisher, numberOfCopies, status);
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.format = format;
    }

    // Getters and Setters
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}