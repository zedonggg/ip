package ui;

import java.util.Scanner;

import commons.Utils;

/**
 * Handles user interface interactions for the application, including displaying messages
 * and reading user input from the console.
 */
public class Ui {
    private static final String LOGO = "____________________________________________________________\n"
            +
            " Hello! I'm Aik Hsu\n"
            +
            " What can I do for you?\n"
            +
            "____________________________________________________________";

    private static final String DIVIDER = "____________________________________________________________";
    private static final String PROMPT = "Enter your command below:";
    private static final String GOODBYE = "Bye. Hope to see you again soon!";

    private final Scanner scanner;

    /**
     * Constructs a new Ui instance and initializes the scanner
     * for reading user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads the next command from user input.
     *
     * @return A trimmed string containing the user's input.
     */
    public String readCommand() {
        return scanner.nextLine().strip();
    }

    /**
     * Prints the application logo to the console.
     */
    public void printHello() {
        System.out.println(LOGO);
    }

    /**
     * Prints the prompt symbol to indicate readiness for user input.
     */
    public void printPrompt() {
        System.out.println(PROMPT);
    }

    /**
     * Prints the goodbye message, enclosed within lines, and closes the scanner.
     */
    public void printGoodbye() {
        Utils.printLine();
        System.out.println(GOODBYE);
        Utils.printLine();
        scanner.close();
    }
}
