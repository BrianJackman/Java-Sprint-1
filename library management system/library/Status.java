// Java Sprint 1
// By: Brian Jackman
// 2024/10/29

package library;

public class Status {
    public static final Status AVAILABLE = null;
    public static final Status CHECKED_OUT = null;
    private String status;

    public Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}