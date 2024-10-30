// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.items;

import library.people.Author;

import java.util.Date;

import library.Status;

public class PrintedPeriodical extends Periodical {
    private String coverType;
    private String dimensions;
    private double weight;

    // Constructor
    public PrintedPeriodical(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            Status status, String issueNumber, String publicationDate, String frequency, String coverType,
            String dimensions, double weight) {
        super(id, title, author, isbn, publisher, numberOfCopies, status, issueNumber, publicationDate, frequency);
        this.coverType = coverType;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    // Removed duplicate constructor

    public PrintedPeriodical(String id, String title, Author author2, String isbn, String publisher, int numberOfCopies,
            Status status, String issueNumber, Date convertToDate, String frequency, String coverType2,
            String dimensions2, double weight2) {
        super(id, title, author2, isbn, publisher, numberOfCopies, status, issueNumber, convertToDate.toString(),
                frequency);
        this.coverType = coverType2;
        this.dimensions = dimensions2;
        this.weight = weight2;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}