package Commands;

public class ListCommand extends Command{
    @Override
    public CommandResult execute() {
        String res = tasks.listTasks();
        return new CommandResult(res);
    }
}
