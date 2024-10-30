// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.items;

import library.people.Author;

import java.util.Date;

import library.Status;

public class ElectronicPeriodical extends Periodical {
    private String fileSize;
    private String format;
    private String accessLink;

    // Constructor
    public ElectronicPeriodical(String id, String title, Author author, String isbn, String publisher,
            int numberOfCopies, Status status, String issueNumber, String publicationDate, String frequency,
            String fileSize, String format, String accessLink) {
        super(id, title, author, isbn, publisher, numberOfCopies, status, issueNumber, publicationDate, frequency);
        this.fileSize = fileSize;
        this.format = format;
        this.accessLink = accessLink;
    }

    public ElectronicPeriodical(String id, String title, Author author, String isbn, String publisher,
            int numberOfCopies, Status status, String issueNumber, Date convertToDate, String frequency,
            String fileSize, String format, String accessLink) {
        super(id, title, author, isbn, publisher, numberOfCopies, status, issueNumber, convertToDate.toString(),
                frequency);
        this.fileSize = fileSize;
        this.format = format;
        this.accessLink = accessLink;
    }

    // Getters and Setters
    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAccessLink() {
        return accessLink;
    }

    public void setAccessLink(String accessLink) {
        this.accessLink = accessLink;
    }
}