// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.people;

import java.util.List;
import library.items.LibraryItem;

public class Employee extends Patron {
    private String employeeId;
    private String department;

    // Constructor
    public Employee(String name, String address, String phoneNumber, List<LibraryItem> borrowedItems, String employeeId,
            String department) {
        super(name, address, phoneNumber, borrowedItems);
        this.employeeId = employeeId;
        this.department = department;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}