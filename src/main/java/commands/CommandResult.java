package commands;

/**
 * Represents the result of executing a command.
 */
public class CommandResult {
    private final String commandOutput;

    /**
     * Constructs a CommandResult with the given output.
     *
     * @param commandOutput The output of the executed command.
     */
    public CommandResult(String commandOutput) {
        this.commandOutput = commandOutput;
    }

    /**
     * Returns the output of the executed command.
     *
     * @return The command output as a String.
     */
    public String getCommandOutput() {
        return this.commandOutput;
    }
}
