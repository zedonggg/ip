package commons;

/**
 * Provides utility methods and constants for common operations, such as printing divider lines.
 */
public class Utils {
    /** A constant string representing a horizontal divider line followed by a newline. */
    public static final String DIVIDER = "____________________________________________________________\n";

    /**
     * Prints a horizontal divider line to the console, followed by a newline.
     */
    public static void printLine() {
        System.out.println(DIVIDER);
    }
}
