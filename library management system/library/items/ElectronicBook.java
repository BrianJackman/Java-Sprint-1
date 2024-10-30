// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.items;

import library.people.Author;
import library.Status;

public class ElectronicBook extends Book {
    private String fileSize;
    private String ebookFormat;
    private boolean drmProtected;

    // Constructor
    public ElectronicBook(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            Status status, String genre, int numberOfPages, String format, String fileSize, String ebookFormat,
            boolean drmProtected) {
        super(id, title, author, isbn, publisher, numberOfCopies, status, genre, numberOfPages, format);
        this.fileSize = fileSize;
        this.ebookFormat = ebookFormat;
        this.drmProtected = drmProtected;
    }

    // Getters and Setters
    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getEbookFormat() {
        return ebookFormat;
    }

    public void setEbookFormat(String ebookFormat) {
        this.ebookFormat = ebookFormat;
    }

    public boolean isDrmProtected() {
        return drmProtected;
    }

    public void setDrmProtected(boolean drmProtected) {
        this.drmProtected = drmProtected;
    }
}