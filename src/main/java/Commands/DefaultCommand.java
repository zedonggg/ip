package Commands;

public class DefaultCommand extends Command{
    String commandMessage;

    public DefaultCommand(String commandMessage) {
        this.commandMessage = commandMessage;
    }
    @Override
    public CommandResult execute() {
        return new CommandResult(commandMessage);
    }
}
