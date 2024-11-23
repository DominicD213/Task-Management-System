// TaskManagementSystem.java
// This is the main program that allows the user to interact with the task manager.
// Miriam Cooper: Implement the user interface (CLI) that lets the user 
// add tasks, view tasks, and remove tasks interactively.
// Key variables:
// - `scanner` (Scanner) to get input from the user
// - `taskManager` (TaskManager) to manage the task queue.

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TaskManagementSystem {
	
	private Queue<Task> taskQueue;
	
	public TaskManagementSystem() {
		taskQueue = new PriorityQueue<>();
	}
	
	// Add a new task to the queue
	public void addTask(String description, int priority) {
		if (priority < 0) {
			System.out.println("Error: Priority must be a non-negative integer.");
			return;
		}
		
		Task newTask = new Task(description, priority);
		taskQueue.offer(newTask);
		Sytstem.out.println("Task added: " + newTask);
	
	}
	
	// View all tasks in priority order
	public void viewTasks() {
		if (taskQueue.isEmpty()) {
			System.out.println("No tasks in the queue.");
		} else {
			System.out.println("Tasks in the queue (priority order):");
			// Display tasks sorted by priority
			for (Task task : taskQueue) {
				System.out.println(task);
			}
		}
	}
	
	// Complete the highest priority task
	public void completeTask() {
		Task completedTask = taskQueue.poll();
		if (completedTask != null) {
			System.out.println("Completed task: " + completedTask);
		} else {
			System.out.println("No tasks to complete.");
		}
	}
	
	// Main menu and user interaction logic
	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			System.out.println("\nTask Management System");
			System.out.println("1. Add Task");
			System.out.println("2. View Tasks");
			System.out.println("3. Complete Task");
			System.out.println("4. Exit");
			System.out.println("Enter your choice: ");
			int choice = 0;
		
		
		// Handle invalid input for choice
		    try {
			    choice = Integer.parseInt(scanner.nextLine());
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid input, please input a valid number.");
			    continue;
		    }
		
		    switch (choice) {
		        case 1:
		    	    // Add Task
		    	    System.out.print("Enter task description: ");
		    	    String description = scanner.nextLine();
		    	    int priority = -1;
		    	
		    	    // Handle invalid priority input
			        while (priority < 0) {
			    	    System.out.println("Enter task priority (a non-negative integer): ");
			    	    try {
			    		    priority = Integer.parseInt(scanner.nextLine());
			    		    if (priority < 0) {
			    			    System.out.println("Priority must be a non-negative integer.");
			    		    }
			    	    } catch (NumberFormatException e) {
			    		    System.out.println("Invalid priority. Please enter a valid non-negative integer.");
			    	    }
			        }
			        addTask(description, priority);
			        break;
		        case 2:
		    	    // View tasks
		    	    viewTasks();
		    	    break;
		        case 3:
		    	    // Complete task
		    	    completeTask();
		    	    break;
		        case 4:
		    	    // Exit
		    	    System.out.println("Exiting Task Managment System");
		    	    running = false;
		    	    break;
		        default:
		    	    System.out.println("Invalid choice. Please try again.");
		    }	
	    }
	
	    scanner.close();
	    
	}
	
	public static void Main(String[] args) {
		TaskManagementSystem system = new TaskManagementSystem();
		system.showMenu();
	}

}
