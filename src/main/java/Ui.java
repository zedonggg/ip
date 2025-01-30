import java.util.Scanner;

public class Ui {
    private static final String LOGO = "____________________________________________________________\n" +
            " Hello! I'm Aik Hsu\n" +
            " What can I do for you?\n" +
            "____________________________________________________________";

    private static final String DIVIDER = "____________________________________________________________";
    private static final String PROMPT = "Enter your command below:";
    private static final String GOODBYE = "Bye. Hope to see you again soon!";

    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine().strip();
    }

    public void printHello() {
        System.out.println(LOGO);
    }

    public void printPrompt() {
        System.out.println(PROMPT);
    }

    public void printGoodbye() {
        Utils.printLine();
        System.out.println(GOODBYE);
        Utils.printLine();
        scanner.close();
    }
}
