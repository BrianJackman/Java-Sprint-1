// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library.items;

import library.people.Author;
import library.Status;

public class AudioBook extends Book {
    private String duration;
    private String narrator;
    private String audioFormat;

    // Constructor
    public AudioBook(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            Status status, String genre, int numberOfPages, String format, String duration, String narrator,
            String audioFormat) {
        super(id, title, author, isbn, publisher, numberOfCopies, status, genre, numberOfPages, format);
        this.duration = duration;
        this.narrator = narrator;
        this.audioFormat = audioFormat;
    }

    // Getters and Setters
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public String getAudioFormat() {
        return audioFormat;
    }

    public void setAudioFormat(String audioFormat) {
        this.audioFormat = audioFormat;
    }
}