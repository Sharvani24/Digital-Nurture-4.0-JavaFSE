
public class AssertionsTest {

    public static void main(String[] args) {
        // Simulate assertEquals
        if (2 + 3 != 5) throw new AssertionError("Failed assertEquals");

        // Simulate assertTrue
        if (!(5 > 3)) throw new AssertionError("Failed assertTrue");

        // Simulate assertFalse
        if (5 < 3) throw new AssertionError("Failed assertFalse");

        // Simulate assertNull
        Object nullObj = null;
        if (nullObj != null) throw new AssertionError("Failed assertNull");

        // Simulate assertNotNull
        Object notNullObj = new Object();
        if (notNullObj == null) throw new AssertionError("Failed assertNotNull");

        System.out.println("All assertions passed.");
    }
}
