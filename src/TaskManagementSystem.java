import java.util.Scanner;

public class TaskManagementSystem {
    private TaskManager taskManager;
    private FileIO fileIO;

    public TaskManagementSystem() {
        taskManager = new TaskManager("tasks.txt");  // Pass filename for task persistence
        fileIO = new FileIO("tasks.txt");
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Check Task count");
            System.out.println("5. Save Tasks to File");
            System.out.println("6. Load Tasks from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (a non-negative integer): ");
                    int priority = scanner.nextInt();
                    Task task = new Task(description, priority);
                    system.taskManager.addTask(task);
                    break;
                case 2:
                    system.taskManager.viewTasks();
                    break;
                case 3:
                    Task completedTask = system.taskManager.removeHighestPriorityTask();
                    if (completedTask != null) {
                        System.out.println("Completed: " + completedTask);
                    }
                    break;
                case 4:
                    System.out.println("Task count: " + system.taskManager.getTaskCount());
                    break;
                case 5:
                    system.fileIO.saveToFile();
                    break;
                case 6:
                    system.fileIO.loadFromFile();
                    break;
                case 7:
                    System.out.println("Exiting Task Management System");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
