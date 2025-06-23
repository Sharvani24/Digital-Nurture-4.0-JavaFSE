// Design principles & Patterns
// Exercise 1: Implementing the Singleton Pattern
public class SingletonPatternExample {

    // Singleton class: Logger
    static class Logger {
        // Step 1: Create a private static instance of Logger
        private static Logger instance;

        // Step 2: Make the constructor private to prevent external instantiation
        private Logger() {
            System.out.println("Logger initialized");
        }

        // Step 3: Provide a public static method to get the single instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger(); // Lazy initialization
            }
            return instance;
        }

        // Logging method to print messages
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Main class to test the Singleton pattern
    public static void main(String[] args) {
        // Creating first reference to Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        // Creating second reference to Logger
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Verifying both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Different logger instances exist.");
        }
    }
}
