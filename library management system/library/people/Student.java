// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.people;

import java.util.List;
import library.items.LibraryItem;

public class Student extends Patron {
    private String studentId;
    private String major;

    // Constructor
    public Student(String name, String address, String phoneNumber, List<LibraryItem> borrowedItems, String studentId,
            String major) {
        super(name, address, phoneNumber, borrowedItems);
        this.studentId = studentId;
        this.major = major;
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}