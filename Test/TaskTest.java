// TaskTest.java
// Unit tests for the Task class.
// Anthony De Casas Mata: Implement tests to ensure that the Task class methods
// (constructor, getters, toString) work as expected.
// Key variables:
// - `task` (Task) to test task creation and methods.

// TaskTest.java
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

    private Task task;

    // Setup method to create a task object before each test
    @BeforeEach
    public void setUp() {
        task = new Task("Test Task", 5);
    }

    // Test the constructor and getters
    @Test
    public void testTaskConstructorAndGetters() {
        assertEquals("Test Task", task.getDescription(), "Description should match the one passed in the constructor");
        assertEquals(5, task.getPriority(), "Priority should match the one passed in the constructor");
    }

    // Test the setters
    @Test
    public void testSetDescription() {
        task.setDescription("New Task Description");
        assertEquals("New Task Description", task.getDescription(), "Description should be updated correctly");
    }

    @Test
    public void testSetPriority() {
        task.setPriority(10);
        assertEquals(10, task.getPriority(), "Priority should be updated correctly");
    }

    // Test the toString method
    @Test
    public void testToString() {
        String expectedString = "Task{description='Test Task', priority=5}";
        assertEquals(expectedString, task.toString(), "toString() should return the correct string format");
    }

    // Test the compareTo method (comparing priority)
    @Test
    public void testCompareTo() {
        Task higherPriorityTask = new Task("High Priority Task", 10);
        Task lowerPriorityTask = new Task("Low Priority Task", 1);

        assertTrue(higherPriorityTask.compareTo(task) > 0, "Task with higher priority should come first");
        assertTrue(task.compareTo(lowerPriorityTask) > 0, "Task with higher priority should come first");
        assertEquals(0, task.compareTo(task), "Task should be equal when compared to itself");
    }
}
