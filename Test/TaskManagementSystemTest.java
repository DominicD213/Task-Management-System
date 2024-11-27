// TaskManagementSystem.java
// This is the main program that allows the user to interact with the task manager.
// Miriam Cooper: Implement the user interface (CLI) that lets the user 
// add tasks, view tasks, and remove tasks interactively.

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TaskManagementSystemTest {

    public static void main(String[] args) {
        // Test 1: Test adding tasks, viewing tasks, completing a task, and checking task count

        // Simulate user input
        String simulatedInput = 
            "1\n" + "Task 1\n" + "10\n" +  // Add Task 1 with priority 10
            "1\n" + "Task 2\n" + "20\n" +  // Add Task 2 with priority 20
            "1\n" + "Task 3\n" + "5\n" +   // Add Task 3 with priority 5
            "2\n" +                      // View tasks
            "3\n" +                      // Complete task
            "4\n" +                      // Check task count
            "5\n";                       // Exit
        
        // Redirect System.in to simulate user input
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Run the TaskManagementSystem
        TaskManagementSystem.main(null);

        // Get the captured output
        String output = outputStream.toString();

        // Print the output to the console (for debugging purposes)
        System.out.println("Captured Output: \n" + output);

        // Test Assertions (you can use actual testing frameworks like JUnit for this part)
        assert output.contains("Task 1 | Priority: 10");
        assert output.contains("Task 2 | Priority: 20");
        assert output.contains("Task 3 | Priority: 5");
        assert output.contains("Completed Task: Task 2 | Priority: 20");
        assert output.contains("Total tasks in the queue: 2");

        System.out.println("Test passed!");
    }
}
