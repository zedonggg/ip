public class ListCommand extends Command{
    @Override
    public CommandResult execute() {
        tasks.listTasks();
        return new CommandResult("Command executed successfully!");
    }
}
