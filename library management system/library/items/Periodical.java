// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.items;

import library.people.Author;

import java.util.Date;

import library.Status;

public class Periodical extends LibraryItem {
    private String issueNumber;
    private String publicationDate;
    private String frequency;

    // Constructor
    public Periodical(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            Status status, String issueNumber, String publicationDate, String frequency) {
        super(id, title, author, isbn, publisher, numberOfCopies, status);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.frequency = frequency;
    }

    public Periodical(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            Status status, String issueNumber, Date publicationDate, String frequency) {
        super(id, title, author, isbn, publisher, numberOfCopies, status);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate.toString(); // Assuming you want to store the date as a string
        this.frequency = frequency;
    }

    // Getters and Setters
    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}