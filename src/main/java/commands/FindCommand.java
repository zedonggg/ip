package commands;

/**
 * Represents a command to search for tasks in the task list that match a given keyword or phrase.
 * Extends the Command class to provide task-finding functionality.
 */
public class FindCommand extends Command {
    private final String finder;

    /**
     * Constructs a FindCommand with the specified search keyword or phrase.
     *
     * @param finder The string to search for in task descriptions.
     */
    public FindCommand(String finder) {
        this.finder = finder;
    }

    /**
     * Executes the find command by searching the task list for tasks containing the specified keyword.
     *
     * @return A CommandResult containing a formatted string of matching tasks.
     */
    @Override
    public CommandResult execute() {
        return new CommandResult(this.tasks.findTasks(finder));
    }
}
