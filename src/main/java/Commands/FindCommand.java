package Commands;

public class FindCommand extends Command {
    String finder;

    public FindCommand(String finder) {
        this.finder = finder;
    }

    @Override
    public CommandResult execute() {
        this.tasks.findTasks(finder);
        return new CommandResult("Command executed successfully!");
    }
}
