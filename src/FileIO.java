import java.util.List;
import java.io.*;
import java.util.ArrayList;

public class FileIO {
    private String filename;
    private List<Task> tasks;

    public FileIO(String filename) {
        this.filename = filename;
        this.tasks = new ArrayList<>();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(tasks);
            System.out.println("Tasks have been saved to file.");
            System.out.println(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Task> loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            tasks = (List<Task>) in.readObject();
            System.out.println("Tasks have been loaded from file.");
            return tasks;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks from file or file not found: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
