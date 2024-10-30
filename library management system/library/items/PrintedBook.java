// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.items;

import library.people.Author;
import library.Status;

public class PrintedBook extends Book {
    private String coverType;
    private String dimensions;

    // Constructor
    public PrintedBook(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            Status status, String genre, int numberOfPages, String format, String coverType, String dimensions) {
        super(id, title, author, isbn, publisher, numberOfCopies, status, genre, numberOfPages, format);
        this.coverType = coverType;
        this.dimensions = dimensions;
    }

    // Getters and Setters
    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}