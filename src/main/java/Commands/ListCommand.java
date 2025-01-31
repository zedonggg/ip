package Commands;

public class ListCommand extends Command{
    @Override
    public CommandResult execute() {
        tasks.listTasks();
        return new CommandResult("Commands.Command executed successfully!");
    }
}
