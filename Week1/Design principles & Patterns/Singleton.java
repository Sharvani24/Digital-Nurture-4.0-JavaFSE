// Design principles & Patterns
// Exercise 1: Implementing the Singleton Pattern
public class Singleton {
    // static variable to hold single instance
    private static Singleton singleInstance = null;

    //private constructor
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    //public method to provide global access
    public static Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }

    //method for testing
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    // Main method to test the Singleton
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        obj1.showMessage();

        Singleton obj2 = Singleton.getInstance();
        obj2.showMessage();

        // Check if both references are the same
        System.out.println("Are both instances same? " + (obj1 == obj2));
    }
}
