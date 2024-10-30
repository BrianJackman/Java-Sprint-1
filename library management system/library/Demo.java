// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library;

import library.items.*;
import library.people.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Demo {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    editItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    addAuthor();
                    break;
                case 5:
                    editAuthor();
                    break;
                case 6:
                    deleteAuthor();
                    break;
                case 7:
                    addPatron();
                    break;
                case 8:
                    editPatron();
                    break;
                case 9:
                    deletePatron();
                    break;
                case 10:
                    borrowItem();
                    break;
                case 11:
                    returnItem();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add Item");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Add Author");
        System.out.println("5. Edit Author");
        System.out.println("6. Delete Author");
        System.out.println("7. Add Patron");
        System.out.println("8. Edit Patron");
        System.out.println("9. Delete Patron");
        System.out.println("10. Borrow Item");
        System.out.println("11. Return Item");
        System.out.println("12. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void loadData() {
        // Add authors
        Author author1 = new Author("Author One", convertToDate(LocalDate.of(1970, 1, 1)), new ArrayList<>());
        Author author2 = new Author("Author Two", convertToDate(LocalDate.of(1980, 2, 2)), new ArrayList<>());
        library.addAuthor(author1);
        library.addAuthor(author2);

        // Add library items
        library.addItem(new Book("1", "Book One", author1, "ISBN001", "Publisher One", 5, new Status("Available"),
                "Fiction", 300, "Paperback"));
        library.addItem(new PrintedBook("2", "Printed Book One", author1, "ISBN002", "Publisher Two", 3,
                new Status("Available"), "Non-Fiction", 200, "Hardcover", "Glossy", "8x11"));
        library.addItem(new ElectronicBook("3", "E-Book One", author2, "ISBN003", "Publisher Three", 10,
                new Status("Available"), "Science", 150, "PDF", "5MB", "EPUB", true));
        library.addItem(new AudioBook("4", "Audio Book One", author2, "ISBN004", "Publisher Four", 2,
                new Status("Available"), "History", 100, "MP3", "2 hours", "Narrator One", "MP3"));
        library.addItem(new Periodical("5", "Periodical One", author1, "ISBN005", "Publisher Five", 7,
                new Status("Available"), "Issue 1", convertToDate(LocalDate.of(2023, 1, 1)), "Monthly"));
        library.addItem(new PrintedPeriodical("6", "Printed Periodical One", author2, "ISBN006", "Publisher Six", 4,
                new Status("Available"), "Issue 2", convertToDate(LocalDate.of(2023, 2, 1)), "Weekly", "Matte", "8x10",
                0.5));
        library.addItem(new ElectronicPeriodical("7", "E-Periodical One", author1, "ISBN007", "Publisher Seven", 6,
                new Status("Available"), "Issue 3", convertToDate(LocalDate.of(2023, 3, 1)), "Daily", "10MB", "PDF",
                "http://example.com"));
    }

    private static void addItem() {
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String authorName = scanner.nextLine();
        Author author = library.getAuthors().stream()
                .filter(a -> a.getName().equals(authorName))
                .findFirst()
                .orElse(null);

        if (author == null) {
            System.out.println("Author not found. Please add the author first.");
            return;
        }

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();

        System.out.print("Enter Number of Copies: ");
        int numberOfCopies = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Status: ");
        String statusString = scanner.nextLine();
        Status status = new Status(statusString);

        System.out.print(
                "Enter Item Type (1: Book, 2: PrintedBook, 3: ElectronicBook, 4: AudioBook, 5: Periodical, 6: PrintedPeriodical, 7: ElectronicPeriodical): ");
        int itemType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        LibraryItem item = null;

        switch (itemType) {
            case 1:
                System.out.print("Enter Genre: ");
                String genre = scanner.nextLine();

                System.out.print("Enter Number of Pages: ");
                int numberOfPages = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Format: ");
                String format = scanner.nextLine();

                item = new Book(id, title, author, isbn, publisher, numberOfCopies, status, genre, numberOfPages,
                        format);
                break;

            case 2:
                System.out.print("Enter Genre: ");
                genre = scanner.nextLine();

                System.out.print("Enter Number of Pages: ");
                numberOfPages = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Format: ");
                format = scanner.nextLine();

                System.out.print("Enter Cover Type: ");
                String coverType = scanner.nextLine();

                System.out.print("Enter Dimensions: ");
                String dimensions = scanner.nextLine();

                item = new PrintedBook(id, title, author, isbn, publisher, numberOfCopies, status, genre, numberOfPages,
                        format, coverType, dimensions);
                break;

            case 3:
                System.out.print("Enter Genre: ");
                genre = scanner.nextLine();

                System.out.print("Enter Number of Pages: ");
                numberOfPages = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Format: ");
                format = scanner.nextLine();

                System.out.print("Enter File Size: ");
                String fileSize = scanner.nextLine();

                System.out.print("Enter eBook Format: ");
                String ebookFormat = scanner.nextLine();

                System.out.print("Is DRM Protected (true/false): ");
                boolean drmProtected = scanner.nextBoolean();
                scanner.nextLine(); // Consume newline

                item = new ElectronicBook(id, title, author, isbn, publisher, numberOfCopies, status, genre,
                        numberOfPages, format, fileSize, ebookFormat, drmProtected);
                break;

            case 4:
                System.out.print("Enter Genre: ");
                genre = scanner.nextLine();

                System.out.print("Enter Number of Pages: ");
                numberOfPages = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Format: ");
                format = scanner.nextLine();

                System.out.print("Enter Duration: ");
                String duration = scanner.nextLine();

                System.out.print("Enter Narrator: ");
                String narrator = scanner.nextLine();

                System.out.print("Enter Audio Format: ");
                String audioFormat = scanner.nextLine();

                item = new AudioBook(id, title, author, isbn, publisher, numberOfCopies, status, genre, numberOfPages,
                        format, duration, narrator, audioFormat);
                break;

            case 5:
                System.out.print("Enter Issue Number: ");
                String issueNumber = scanner.nextLine();

                System.out.print("Enter Publication Date: ");
                String publicationDate = scanner.nextLine();

                System.out.print("Enter Frequency: ");
                String frequency = scanner.nextLine();

                item = new Periodical(id, title, author, isbn, publisher, numberOfCopies, status, issueNumber,
                        publicationDate, frequency);
                break;

            case 6:
                System.out.print("Enter Issue Number: ");
                issueNumber = scanner.nextLine();

                System.out.print("Enter Publication Date: ");
                publicationDate = scanner.nextLine();

                System.out.print("Enter Frequency: ");
                frequency = scanner.nextLine();

                System.out.print("Enter Cover Type: ");
                coverType = scanner.nextLine();

                System.out.print("Enter Dimensions: ");
                dimensions = scanner.nextLine();

                System.out.print("Enter Weight: ");
                double weight = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                item = new PrintedPeriodical(id, title, author, isbn, publisher, numberOfCopies, status, issueNumber,
                        publicationDate, frequency, coverType, dimensions, weight);
                break;

            case 7:
                System.out.print("Enter Issue Number: ");
                issueNumber = scanner.nextLine();

                System.out.print("Enter Publication Date: ");
                publicationDate = scanner.nextLine();

                System.out.print("Enter Frequency: ");
                frequency = scanner.nextLine();

                System.out.print("Enter File Size: ");
                fileSize = scanner.nextLine();

                System.out.print("Enter Format: ");
                format = scanner.nextLine();

                System.out.print("Enter Access Link: ");
                String accessLink = scanner.nextLine();

                item = new ElectronicPeriodical(id, title, author, isbn, publisher, numberOfCopies, status, issueNumber,
                        publicationDate, frequency, fileSize, format, accessLink);
                break;

            default:
                System.out.println("Invalid item type.");
                return;
        }

        library.addItem(item);
        System.out.println("Item added successfully.");
    }

    private static void editItem() {
        System.out.print("Enter the ID of the item to edit: ");
        String id = scanner.nextLine();
        LibraryItem item = library.getItemById(id);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        System.out.println("Editing item: " + item.getTitle());

        System.out.print("Enter new title (leave blank to keep current): ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) {
            item.setTitle(title);
        }

        System.out.print("Enter new ISBN (leave blank to keep current): ");
        String isbn = scanner.nextLine();
        if (!isbn.isEmpty()) {
            item.setIsbn(isbn);
        }

        System.out.print("Enter new publisher (leave blank to keep current): ");
        String publisher = scanner.nextLine();
        if (!publisher.isEmpty()) {
            item.setPublisher(publisher);
        }

        System.out.print("Enter new number of copies (leave blank to keep current): ");
        String numberOfCopiesStr = scanner.nextLine();
        if (!numberOfCopiesStr.isEmpty()) {
            int numberOfCopies = Integer.parseInt(numberOfCopiesStr);
            item.setNumberOfCopies(numberOfCopies);
        }

        System.out.print("Enter new status (leave blank to keep current): ");
        String statusStr = scanner.nextLine();
        if (!statusStr.isEmpty()) {
            item.setStatus(new Status(statusStr));
        }

        // Update the item in the library
        library.editItem(id, item);
        System.out.println("Item updated successfully.");
    }

    private static void deleteItem() {
        System.out.print("Enter the ID of the item to delete: ");
        String id = scanner.nextLine();
        library.deleteItem(id);
        System.out.println("Item deleted successfully.");
    }

    private static void addAuthor() {
        System.out.print("Enter author name: ");
        String name = scanner.nextLine();

        System.out.print("Enter author date of birth (yyyy-mm-dd): ");
        String dobString = scanner.nextLine();
        Date dateOfBirth = convertToDate(LocalDate.parse(dobString));

        Author author = new Author(name, dateOfBirth, new ArrayList<>());
        library.addAuthor(author);
        System.out.println("Author added successfully.");
    }

    private static void editAuthor() {
        System.out.print("Enter the name of the author to edit: ");
        String name = scanner.nextLine();
        Author author = library.getAuthors().stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (author == null) {
            System.out.println("Author not found.");
            return;
        }

        System.out.println("Editing author: " + author.getName());

        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            author.setName(newName);
        }

        System.out.print("Enter new date of birth (leave blank to keep current): ");
        String dobString = scanner.nextLine();
        if (!dobString.isEmpty()) {
            Date dateOfBirth = convertToDate(LocalDate.parse(dobString));
            author.setDateOfBirth(dateOfBirth);
        }

        // Update the author in the library
        library.editAuthor(name, author);
        System.out.println("Author updated successfully.");
    }

    private static void deleteAuthor() {
        System.out.print("Enter the name of the author to delete: ");
        String name = scanner.nextLine();
        library.deleteAuthor(name);
        System.out.println("Author deleted successfully.");
    }

    private static void addPatron() {
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();

        System.out.print("Enter patron address: ");
        String address = scanner.nextLine();

        System.out.print("Enter patron phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Is the patron a student or an employee? (student/employee): ");
        String type = scanner.nextLine();

        Patron patron;
        if (type.equalsIgnoreCase("student")) {
            System.out.print("Enter student ID: ");
            String studentId = scanner.nextLine();

            System.out.print("Enter major: ");
            String major = scanner.nextLine();

            patron = new Student(name, address, phoneNumber, new ArrayList<>(), studentId, major);
        } else {
            System.out.print("Enter employee ID: ");
            String employeeId = scanner.nextLine();

            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            patron = new Employee(name, address, phoneNumber, new ArrayList<>(), employeeId, department);
        }

        library.addPatron(patron);
        System.out.println("Patron added successfully.");
    }

    private static void editPatron() {
        System.out.print("Enter the name of the patron to edit: ");
        String name = scanner.nextLine();
        Patron patron = library.getPatrons().stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.println("Editing patron: " + patron.getName());

        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            patron.setName(newName);
        }

        System.out.print("Enter new address (leave blank to keep current): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            patron.setAddress(address);
        }

        System.out.print("Enter new phone number (leave blank to keep current): ");
        String phoneNumber = scanner.nextLine();
        if (!phoneNumber.isEmpty()) {
            patron.setPhoneNumber(phoneNumber);
        }

        // Update the patron in the library
        library.editPatron(name, patron);
        System.out.println("Patron updated successfully.");
    }

    private static void deletePatron() {
        System.out.print("Enter the name of the patron to delete: ");
        String name = scanner.nextLine();
        library.deletePatron(name);
        System.out.println("Patron deleted successfully.");
    }

    private static void borrowItem() {
        System.out.print("Enter the ID of the item to borrow: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter the name of the patron borrowing the item: ");
        String patronName = scanner.nextLine();

        try {
            library.borrowItem(itemId, patronName);
            System.out.println("Item borrowed successfully.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnItem() {
        System.out.print("Enter the ID of the item to return: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter the name of the patron returning the item: ");
        String patronName = scanner.nextLine();

        try {
            library.returnItem(itemId, patronName);
            System.out.println("Item returned successfully.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}