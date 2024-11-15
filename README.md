# Task Management System

## Overview
This is a task management system that allows users to manage tasks with priorities. Users can add tasks, view them, and mark them as completed. The program uses a priority queue to organize tasks by their priority.

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone hub.com/DominicD213/Task-Management-System


## Overview
The **Task Management System** is a Java-based command-line application designed to help users manage tasks with different priority levels. It allows users to add tasks, view tasks, and mark tasks as completed. The system utilizes a **PriorityQueue** to ensure that tasks with higher priority are processed first.

## Features
1. **Add Task**: Add a task with a description and a priority level (between 1 and 10). Tasks with higher priority (larger numbers) are considered more important.
2. **View Tasks**: View all tasks currently in the system, showing each task's description and priority.
3. **Complete Task**: Mark the highest-priority task as completed by removing it from the queue.
4. **File I/O (Save/Load)**: Save and load tasks to and from a file. This allows users to save their tasks and resume later.
5. **Input Validation**: Ensures the priority is between 1 and 10 to prevent invalid input.

## Data Structures Used:
1. **PriorityQueue**: 
   - The **PriorityQueue** stores tasks, automatically sorting them based on priority. Higher-priority tasks are dequeued first.
   - Tasks are stored as `Task` objects with a description and priority.

2. **List**:
   - A `List<Task>` is used for storing tasks when loading or saving from/to a file.

3. **File I/O**:
   - The application uses `ObjectOutputStream` and `ObjectInputStream` for saving and loading tasks to/from a file.

## Task Breakdown and Responsibilities

### 1. `Task.java` - **Bobby Cooper**
This class represents a task with a description and priority.

**Responsibilities:**
- Implement the `Task` class.
- Fields: 
  - `description` (String): Description of the task.
  - `priority` (int): Priority of the task (1-10).
- Methods: 
  - Constructor, getters, setters, and `toString()`.

### 2. `TaskManager.java` - **Bobby Cooper**
This class manages the task queue, handling task additions, removals, and viewing tasks.

**Responsibilities:**
- Implement the `TaskManager` class.
- Use a **PriorityQueue** to manage tasks.
- Methods:
  - `addTask()`: Adds a task to the queue.
  - `viewTasks()`: Views all tasks.
  - `removeTask()`: Removes the highest-priority task.

### 3. `TaskManagementSystem.java` - **Miriam Cooper**
This is the main program that interacts with the user through a CLI, enabling task management actions.

**Responsibilities:**
- Implement the user interface for interacting with the task management system.
- Methods:
  - Display a menu for the user (Add Task, View Tasks, Complete Task, Exit).
  - Capture user input for adding tasks, viewing tasks, and completing tasks.
  
### 4. `FileIO.java` - **Patrick Brown**
This class handles saving and loading tasks from a file.

**Responsibilities:**
- Implement methods for saving tasks to a file and loading tasks from a file.
- Methods:
  - `saveTasksToFile()`: Save tasks to a file using **ObjectOutputStream**.
  - `loadTasksFromFile()`: Load tasks from a file using **ObjectInputStream**.

### 5. `InputValidator.java` - **Patrick Brown**
This class ensures the validity of user input (e.g., checking that the task priority is between 1 and 10).

**Responsibilities:**
- Implement input validation methods to ensure the priority input is within the valid range (1-10).
- Methods:
  - `isValidPriority()`: Validates that the priority is between 1 and 10.

### 6. `TaskTest.java` - **Bobby Cooper**
Unit tests for the `Task` class.

**Responsibilities:**
- Implement unit tests for the `Task` class to ensure its methods work correctly.
- Tests:
  - Task creation and getter methods.
  - The `toString()` method.

### 7. `TaskManagerTest.java` - **Bobby Cooper**
Unit tests for the `TaskManager` class.

**Responsibilities:**
- Implement unit tests for the `TaskManager` class methods.
- Tests:
  - Adding tasks to the queue.
  - Viewing tasks.
  - Removing tasks.

### 8. `README.md` - **Dominic Digiacomo**
Document the project, including its features, instructions, and system requirements.

**Responsibilities:**
- Write a clear and concise **README.md** file for the project.
- Include project description, setup instructions, and contribution guidelines.
  
### 9. `ProjectDescription.txt` - **Dominic Digiacomo**
This file includes the detailed project description, explaining the design, data structures used, and any additional context for the project.

**Responsibilities:**
- Write the project description, detailing the purpose, features, and learning outcomes of the project.

---

## Setup Instructions:
1. Clone the repository:
   ```bash
   git clone <repository_url>
