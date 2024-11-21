// Task.java
// This class represents a task with a description and a priority.
// Bobby Cooper: Implement the Task class with the following fields and methods:
// - `description` (String) to store the task description
// - `priority` (int) to store the task's priority
// Implement constructors, getters, setters, and toString() method.


public class Task implements Comparable<Task> {
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

    // toString method
    @Override
    public String toString() {
        return "Task{" +
        		"description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }

    /* Comparable implementation to prioritize tasks (higher priority first)
       I wanted to keep all sorting logic in TaskManager.java but putting this
       here seemed easier than writing a custom comparator. Plese let me know if
       you know of a better way to do this.*/
    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority);
    }
}
