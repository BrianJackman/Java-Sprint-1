// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.people;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;

import library.items.LibraryItem;

public class Author {
    private String name;
    private LocalDate dateOfBirth;
    private List<LibraryItem> itemsWritten;

    // Constructor
    public Author(String name, LocalDate dateOfBirth, List<LibraryItem> itemsWritten) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.itemsWritten = itemsWritten;
    }

    // Overloaded constructor to handle Date type for dateOfBirth
    public Author(String name, Date dateOfBirth, List<LibraryItem> itemsWritten) {
        this.name = name;
        this.dateOfBirth = convertToLocalDate(dateOfBirth);
        this.itemsWritten = itemsWritten;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<LibraryItem> getItemsWritten() {
        return itemsWritten;
    }

    public void setItemsWritten(List<LibraryItem> itemsWritten) {
        this.itemsWritten = itemsWritten;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = convertToLocalDate(dateOfBirth);
    }

    // Helper method to convert Date to LocalDate
    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}