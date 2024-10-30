// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library;

import library.items.*;
import library.people.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
        private static Library library = new Library();

        public static void main(String[] args) {
                loadData();
                demonstrateFeatures();
        }

        private static void loadData() {
                // Add authors
                Author author1 = new Author("Author One", convertToDate(LocalDate.of(1970, 1, 1)), new ArrayList<>());
                Author author2 = new Author("Author Two", convertToDate(LocalDate.of(1980, 2, 2)), new ArrayList<>());
                library.addAuthor(author1);
                library.addAuthor(author2);

                // Add library items
                library.addItem(new Book("1", "Book One", author1, "ISBN001", "Publisher One", 5,
                                new Status("Available"),
                                "Fiction", 300, "Paperback"));
                library.addItem(new PrintedBook("2", "Printed Book One", author1, "ISBN002", "Publisher Two", 3,
                                new Status("Available"), "Non-Fiction", 200, "Hardcover", "Glossy", "8x11"));
                library.addItem(new ElectronicBook("3", "E-Book One", author2, "ISBN003", "Publisher Three", 10,
                                new Status("Available"), "Science", 150, "PDF", "5MB", "EPUB", true));
                library.addItem(new AudioBook("4", "Audio Book One", author2, "ISBN004", "Publisher Four", 2,
                                new Status("Available"), "History", 100, "MP3", "2 hours", "Narrator One", "MP3"));
                library.addItem(new Periodical("5", "Periodical One", author1, "ISBN005", "Publisher Five", 7,
                                new Status("Available"), "Issue 1", convertToDate(LocalDate.of(2023, 1, 1)),
                                "Monthly"));
                library.addItem(new PrintedPeriodical("6", "Printed Periodical One", author2, "ISBN006",
                                "Publisher Six", 4,
                                new Status("Available"), "Issue 2", convertToDate(LocalDate.of(2023, 2, 1)), "Weekly",
                                "Matte", "8x10",
                                0.5));
                library.addItem(new ElectronicPeriodical("7", "E-Periodical One", author1, "ISBN007", "Publisher Seven",
                                6,
                                new Status("Available"), "Issue 3", convertToDate(LocalDate.of(2023, 3, 1)), "Daily",
                                "10MB", "PDF",
                                "http://example.com"));

                // Add patrons
                Patron student1 = new Student("Student One", "Address One", "1234567890", new ArrayList<>(), "S001",
                                "Computer Science");
                Patron employee1 = new Employee("Employee One", "Address Two", "0987654321", new ArrayList<>(), "E001",
                                "Library");
                library.addPatron(student1);
                library.addPatron(employee1);
        }

        private static void demonstrateFeatures() {
                // Demonstrate adding a new item
                Author author3 = new Author("Author Three", convertToDate(LocalDate.of(1990, 3, 3)), new ArrayList<>());
                library.addAuthor(author3);
                LibraryItem newBook = new Book("8", "New Book", author3, "ISBN008", "Publisher Eight", 5,
                                new Status("Available"), "Fantasy", 400, "Hardcover");
                library.addItem(newBook);
                System.out.println("Added new book: " + newBook.getTitle());

                // Demonstrate editing an item
                LibraryItem itemToEdit = library.getItemById("1");
                itemToEdit.setTitle("Edited Book One");
                library.editItem("1", itemToEdit);
                System.out.println("Edited item title: " + library.getItemById("1").getTitle());

                // Demonstrate deleting an item
                library.deleteItem("2");
                System.out.println("Deleted item with ID 2");

                // Demonstrate borrowing an item
                library.borrowItem("3", "Student One");
                System.out.println("Borrowed item with ID 3 by Student One");

                // Demonstrate returning an item
                library.returnItem("3", "Student One");
                System.out.println("Returned item with ID 3 by Student One");

                // Demonstrate searching for items
                System.out.println(
                                "Search results for title 'New Book': " + library.searchItemsByTitle("New Book").size()
                                                + " item(s) found");
                System.out.println("Search results for author 'Author One': "
                                + library.searchItemsByAuthor("Author One").size()
                                + " item(s) found");
                System.out.println(
                                "Search results for ISBN 'ISBN003': " + library.searchItemsByISBN("ISBN003").size()
                                                + " item(s) found");
        }

        private static Date convertToDate(LocalDate localDate) {
                return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
}