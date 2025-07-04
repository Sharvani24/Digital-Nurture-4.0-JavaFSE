public class Main {
    public static void main(String[] args) {
        // Model
        Student student = new Student("Alice", "S123", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        // Initial view
        controller.updateView();

        // Update student info
        controller.setStudentName("Bob");
        controller.setStudentGrade("A+");

        // Updated view
        controller.updateView();
    }
}
