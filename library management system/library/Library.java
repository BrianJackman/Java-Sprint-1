// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library;

import library.people.Author;
import library.people.Patron;
import library.items.LibraryItem;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<LibraryItem> items;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // Methods to add items, authors, and patrons
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Methods to edit items, authors, and patrons
    public void editItem(String id, LibraryItem updatedItem) {
        Optional<LibraryItem> itemOpt = items.stream().filter(item -> item.getId().equals(id)).findFirst();
        itemOpt.ifPresent(item -> {
            items.remove(item);
            items.add(updatedItem);
        });
    }

    public void editAuthor(String name, Author updatedAuthor) {
        Optional<Author> authorOpt = authors.stream().filter(author -> author.getName().equals(name)).findFirst();
        authorOpt.ifPresent(author -> {
            authors.remove(author);
            authors.add(updatedAuthor);
        });
    }

    public void editPatron(String name, Patron updatedPatron) {
        Optional<Patron> patronOpt = patrons.stream().filter(patron -> patron.getName().equals(name)).findFirst();
        patronOpt.ifPresent(patron -> {
            patrons.remove(patron);
            patrons.add(updatedPatron);
        });
    }

    // Methods to delete items, authors, and patrons
    public void deleteItem(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    public void deleteAuthor(String name) {
        authors.removeIf(author -> author.getName().equals(name));
    }

    public void deletePatron(String name) {
        patrons.removeIf(patron -> patron.getName().equals(name));
    }

    // Methods to borrow and return items
    public void borrowItem(String itemId, String patronName) {
        Optional<LibraryItem> itemOpt = items.stream().filter(item -> item.getId().equals(itemId)).findFirst();
        Optional<Patron> patronOpt = patrons.stream().filter(patron -> patron.getName().equals(patronName)).findFirst();

        if (itemOpt.isPresent() && patronOpt.isPresent()) {
            LibraryItem item = itemOpt.get();
            Patron patron = patronOpt.get();

            if (item.getNumberOfCopies() > 0) {
                item.setNumberOfCopies(item.getNumberOfCopies() - 1);
                patron.getBorrowedItems().add(item);
            } else {
                throw new IllegalStateException("Item is currently checked out.");
            }
        } else {
            throw new IllegalStateException("Item or Patron not found.");
        }
    }

    public void returnItem(String itemId, String patronName) {
        Optional<LibraryItem> itemOpt = items.stream().filter(item -> item.getId().equals(itemId)).findFirst();
        Optional<Patron> patronOpt = patrons.stream().filter(patron -> patron.getName().equals(patronName)).findFirst();

        if (itemOpt.isPresent() && patronOpt.isPresent()) {
            LibraryItem item = itemOpt.get();
            Patron patron = patronOpt.get();

            if (patron.getBorrowedItems().remove(item)) {
                item.setNumberOfCopies(item.getNumberOfCopies() + 1);
            } else {
                throw new IllegalStateException("Item was not borrowed by this patron.");
            }
        } else {
            throw new IllegalStateException("Item or Patron not found.");
        }
    }

    // Methods to search for items
    public List<LibraryItem> searchItemsByTitle(String title) {
        return items.stream().filter(item -> item.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public List<LibraryItem> searchItemsByAuthor(String authorName) {
        return items.stream().filter(item -> item.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }

    public List<LibraryItem> searchItemsByISBN(String isbn) {
        return items.stream().filter(item -> item.getIsbn().equalsIgnoreCase(isbn)).collect(Collectors.toList());
    }

    // Getters for items, authors, and patrons
    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    // Method to get an item by ID
    public LibraryItem getItemById(String id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }
}