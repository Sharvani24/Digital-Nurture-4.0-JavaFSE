
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);
        manager.addEmployee(new Employee(1, "Alice", "Developer", 70000));
        manager.addEmployee(new Employee(2, "Bob", "Designer", 65000));
        manager.addEmployee(new Employee(3, "Charlie", "Manager", 80000));

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee ID 2:");
        Employee found = manager.searchEmployee(2);
        System.out.println(found != null ? found : "Employee not found.");

        System.out.println("\nDeleting Employee ID 1:");
        manager.deleteEmployee(1);

        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}
