// Authors: Patrick Brown
// Last modified: 11/22/2024

// InputValidator.java
// This class contains methods for validating user input.
// Patrick Brown: Implement input validation methods to ensure that
// task priority is between 1 and 10.
// Key variable:
// - `priority` (int) to validate the user input for task priority.

import java.util.Scanner;

public class InputValidator {
    /**
     * Validates the priority input, ensuring it is within the range of 1 to 10.
     * If the priority is outside this range, prompts the user to enter a valid priority.
     *
     * @param priority the initial priority value to validate
     * @return a valid priority value between 1 and 10 (inclusive)
     */
    public static int validatePriority(int priority) {
        while (priority < 1 || priority > 10) {
            System.out.println("Priority must be between 1 and 10. Please enter a valid priority:");
            Scanner scanner = new Scanner(System.in);
            priority = scanner.nextInt();
            scanner.close();
        }
        return priority;
    }

    /**
     * Validates the description input, ensuring it is not empty.
     * If the description is empty, prompts the user to enter a valid description.
     *
     * @param description the initial description value to validate
     * @return a valid description that is not empty
     */
    public static String validateDescription(String description) {
        while (description.isEmpty()) {
            System.out.println("Task description cannot be empty. Please enter a valid description:");
            Scanner scanner = new Scanner(System.in);
            description = scanner.nextLine();
            scanner.close();
        }
        return description;
    }

    /**
     * Validates the file name input, ensuring it is not empty.
     * If the file name is empty, prompts the user to enter a valid file name.
     *
     * @param fileName the initial file name value to validate
     * @return a valid file name that is not empty
     */
    public static String validateFileName(String fileName) {
        while (fileName.isEmpty()) {
            System.out.println("File name cannot be empty. Please enter a valid file name:");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.nextLine();
            scanner.close();
        }
        return fileName;
    }

    /**
     * Validates the task name input, ensuring it is not empty.
     * If the task name is empty, prompts the user to enter a valid task name.
     *
     * @param taskName the initial task name value to validate
     * @return a valid task name that is not empty
     */
    public static String validateTaskName(String taskName) {
        while (taskName.isEmpty()) {
            System.out.println("Task name cannot be empty. Please enter a valid task name:");
            Scanner scanner = new Scanner(System.in);
            taskName = scanner.nextLine();
            scanner.close();
        }
        return taskName;
    }
}