class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

public class TaskManager {
    private Task head;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added.");
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task current = head;
        Task prev = null;

        while (current != null && current.taskId != taskId) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask(1, "Design UI", "Pending");
        manager.addTask(2, "Implement backend", "In Progress");
        manager.addTask(3, "Write tests", "Pending");

        System.out.println("All Tasks:");
        manager.traverseTasks();

        System.out.println("\\nSearching for Task ID 2:");
        Task found = manager.searchTask(2);
        System.out.println(found != null ? found : "Task not found.");

        System.out.println("\\nDeleting Task ID 1:");
        manager.deleteTask(1);

        System.out.println("\\nAll Tasks after deletion:");
        manager.traverseTasks();
    }
}
