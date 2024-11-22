// TaskManager.java
// This class handles the management of tasks using a priority queue.
// Bobby Cooper: Implement the task management logic such as adding, viewing, 
// removing tasks, and sorting tasks based on priority.
// Key variables:
// - `taskQueue` (PriorityQueue<Task>) to store the tasks in priority order.



import java.util.PriorityQueue;

public class TaskManager {
    private PriorityQueue<Task> taskQueue;

    // Constructor
    public TaskManager() {
        /* Initialize the PriorityQueue with natural ordering based on Task's compareTo method
            This seemed like the simplest way to order the queue but it relies on a method from
            Task.java.*/
        this.taskQueue = new PriorityQueue<>();
    }

    // Method to add a task
    public void addTask(String description, int priority) {
        Task newTask = new Task(description, priority);
        taskQueue.offer(newTask);
    }

    // Method to view all tasks
    public void viewTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Tasks in priority order:");
        for (Task task : taskQueue) {
            System.out.println(task);
        }
    }

    // Method to remove the highest-priority task
    public Task removeHighestPriorityTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to remove.");
            return null;
        }

        return taskQueue.poll();
    }

    // Method to check if the task queue is empty
    public boolean isEmpty() {
        return taskQueue.isEmpty();
    }

    // Method to get the number of tasks
    public int getTaskCount() {
        return taskQueue.size();
    }
}

