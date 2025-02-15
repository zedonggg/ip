package commands;

public class FindCommand extends Command {
    String finder;

    public FindCommand(String finder) {
        this.finder = finder;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(this.tasks.findTasks(finder));
    }
}
