package commands;

/**
 * Represents a command result that indicates the program should exit.
 */
public class ExitCommandResult extends CommandResult {
    /**
     * Constructs an ExitCommandResult with the given output message.
     *
     * @param s The output message associated with the exit command.
     */
    public ExitCommandResult(String s) {
        super(s);
    }

    /**
     * Terminates the program by calling {@code System.exit(0)}.
     */
    public void quit() {
        System.exit(0);
    }
}
