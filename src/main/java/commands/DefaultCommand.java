package commands;

public class DefaultCommand extends Command{
    String commandMessage;

    public DefaultCommand(String commandMessage) {
        assert commandMessage != null && !commandMessage.trim().isEmpty() : "Command cannot be null or empty!";
        this.commandMessage = commandMessage;
    }
    @Override
    public CommandResult execute() {
        return new CommandResult(commandMessage);
    }
}
