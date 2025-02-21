package commands;

/**
 * Represents a fallback command used when no specific command is recognized or input is invalid.
 * Extends the Command class to provide a simple response with a predefined message.
 */
public class DefaultCommand extends Command {
    private final String commandMessage;

    /**
     * Constructs a DefaultCommand with the specified message.
     * The message is used to inform the user of an issue or unrecognized command.
     *
     * @param commandMessage The message to display when the command is executed.
     * @throws AssertionError If the commandMessage is null or empty after trimming.
     */
    public DefaultCommand(String commandMessage) {
        assert commandMessage != null && !commandMessage.trim().isEmpty() : "Command cannot be null or empty!";
        this.commandMessage = commandMessage;
    }

    /**
     * Executes the default command by returning the predefined message.
     *
     * @return A CommandResult containing the command message.
     */
    @Override
    public CommandResult execute() {
        return new CommandResult(commandMessage);
    }
}
