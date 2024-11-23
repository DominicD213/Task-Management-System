// Authors: Patrick brown
// Last modified: 11/22/2024

// FileIO.java
// This class handles saving tasks to a file and loading them from a file.
// Patrick Brown: Implement methods to save tasks to a file and load tasks from a file.
// Key variables:
// - `tasks` (List<Task>) to store the list of tasks
// - `fileName` (String) to specify the file name for saving/loading.

// imports
import java.io.*;
import java.util.*;

public class FileIO {
    private List<Task> tasks;
    private String fileName;

    public FileIO(List<Task> tasks, String fileName) {
        this.tasks = tasks;
        this.fileName = fileName;
    }

    /**
     * Save the tasks to a file. Each task is saved as a line
     * containing the task description and priority separated by a comma.
     * For example: "Write project description, 10"
     */
    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (Task task : tasks) {
                fileWriter.write(task.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving tasks to file.");
        }
    }

    /**
     * Load tasks from a file and return them as a list.
     * Each line of the file should contain a task description and priority separated by a comma.
     * For example: "Write project description, 10"
     * @return a list of tasks loaded from the file
     */
    public List<Task> loadFromFile() {
        List<Task> loadedTasks = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String description = parts[0];
                int priority = Integer.parseInt(parts[1]);
                Task task = new Task(description, priority);
                loadedTasks.add(task);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while loading tasks from file.");
        }
        return loadedTasks;
    }

    /**
     * Set the list of tasks to be used for saving and loading from a file.
     * @param tasks the list of tasks to use
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    } 

    /**
     * Set the file name to be used for saving and loading tasks.
     * 
     * @param fileName the name of the file to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}