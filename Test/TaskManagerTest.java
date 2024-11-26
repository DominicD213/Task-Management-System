// TaskManagerTest.java
// Unit tests for the TaskManager class.
// Anthony De Casas Mata: Implement tests for methods like addTask(), viewTasks(), 
// and removeTask() to ensure they work correctly.
// Key variables:
// - `manager` (TaskManager) to test task management methods.


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TaskManagerTest {
    private TaskManager manager;

    // This method runs before each test to set up a new TaskManager
    @BeforeEach
    public void setUp() {
        manager = new TaskManager();
    }

    // Test to check if tasks can be added and the task count increases
    @Test
    public void testAddTask() {
        manager.addTask("Test Task 1", 1);
        manager.addTask("Test Task 2", 2);
        
        // After adding 2 tasks, task count should be 2
        assertEquals(2, manager.getTaskCount());
    }

    // Test to check if the highest priority task is removed first
    @Test
    public void testRemoveHighestPriorityTask() {
        manager.addTask("Task 1", 1);
        manager.addTask("Task 2", 2);
        
        Task removedTask = manager.removeHighestPriorityTask();
        
        // The highest priority task ("Task 2") should be removed
        assertEquals("Task 2", removedTask.getDescription());
    }

    // Test to check if removing from an empty TaskManager returns null
    @Test
    public void testRemoveFromEmpty() {
        Task removedTask = manager.removeHighestPriorityTask();
        // No task should be removed from an empty task manager
        assertNull(removedTask);
    }

    // Test to check if the TaskManager is empty after removal
    @Test
    public void testIsEmpty() {
        assertTrue(manager.isEmpty());  // Initially, it should be empty

        manager.addTask("Task 1", 1);
        
        assertFalse(manager.isEmpty());  // After adding a task, it should not be empty
    }

    // Test to check the task count after tasks are added and removed
    @Test
    public void testTaskCountAfterOperations() {
        manager.addTask("Task 1", 1);
        manager.addTask("Task 2", 2);
        
        assertEquals(2, manager.getTaskCount());
        
        // Remove one task
        manager.removeHighestPriorityTask();
        
        assertEquals(1, manager.getTaskCount());  // After removal, task count should be 1
    }

    // Test to check if viewTasks prints tasks correctly
    @Test
    public void testViewTasks() {
        // Add tasks to the manager
        manager.addTask("Task 1", 1);
        manager.addTask("Task 2", 2);
        
        // Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Call the viewTasks method
        manager.viewTasks();
        
        // Expected output after adding two tasks
        String expectedOutput = "Tasks in priority order:\nTask 1\nTask 2\n";
        
        // Check if the actual output matches the expected output
        assertEquals(expectedOutput, outContent.toString());
    }
}

