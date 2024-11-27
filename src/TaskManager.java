import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class TaskManager {
    private PriorityQueue<Task> taskQueue;
    private FileIO fileIO;

    // Constructor that initializes the task queue and loads tasks from the file
    public TaskManager(String filename) {
        this.taskQueue = new PriorityQueue<>();
        this.fileIO = new FileIO(filename);
        List<Task> tasks = fileIO.loadFromFile();  // Load tasks from file

        if (tasks.isEmpty()) {
            System.out.println("No tasks loaded from file.");
        } else {
            System.out.println("Tasks loaded from file:");
            for (Task task : tasks) {
                taskQueue.add(task);  // Add each loaded task to the queue
            }
        }
    }

    // Method to add a new task to the queue and update the file
    public void addTask(Task task) {
        taskQueue.add(task);  // Add the new task to the priority queue
        updateFile();  // Update the file with the current task list
    }

    // Method to view all tasks in the queue, ordered by priority
    public void viewTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Tasks in priority order:");
        
        // Create a temporary copy of the task queue to display tasks in order
        PriorityQueue<Task> tempQueue = new PriorityQueue<>(taskQueue);
        
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.poll());  // Print tasks from highest to lowest priority
        }
    }

    // Method to remove and return the highest priority task from the queue
    public Task removeHighestPriorityTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to complete.");
            return null;
        }
        Task task = taskQueue.poll();  // Remove the task with the highest priority (top of the queue)
        updateFile();  // Update the file after removing the task
        return task;
    }

    // Helper method to update the file after any changes to the task queue
    private void updateFile() {
        // Convert the priority queue to a list and update the file with the current task list
        List<Task> taskList = new ArrayList<>(taskQueue);
        fileIO.setTasks(taskList);  // Set the tasks in FileIO
        fileIO.saveToFile();  // Save the tasks to the file
    }

    // Method to get the number of tasks in the queue
    public int getTaskCount() {
        return taskQueue.size();
    }
}
