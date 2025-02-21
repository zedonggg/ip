package commands;

/**
 * Represents a command to list all tasks in the task list.
 * Extends the Command class to provide task-listing functionality.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command by retrieving and returning a string representation of all tasks.
     *
     * @return A CommandResult containing a formatted string of all tasks in the task list.
     */
    @Override
    public CommandResult execute() {
        String res = tasks.listTasks();
        return new CommandResult(res);
    }
}
