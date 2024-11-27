import java.io.Serializable;

public class Task implements Comparable<Task>, Serializable {
    private static final long serialVersionUID = 1L; // A unique identifier for serialization

    private String description;
    private int priority;

    // Constructor
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for priority
    public int getPriority() {
        return priority;
    }

    // Setter for priority
    public void setPriority(int priority) {
        this.priority = priority;
    }

    // toString method for printing Task objects
    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }

    // Comparable implementation to prioritize tasks (higher priority first)
    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority); // Reverse order (higher priority first)
    }
}
