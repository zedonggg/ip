package commands;

import exceptions.AikhsuException;

/**
 * Represents a command to delete a task from the task list based on its index.
 * Extends the Command class to provide specific deletion functionality.
 */
public class DeleteCommand extends Command {
    private static final String INVALID_INDEX_MESSAGE = "Please provide a number!";
    private static final String TASK_NOT_EXISTS_MESSAGE = "Task does not exist!";
    private final String indexString;

    /**
     * Constructs a DeleteCommand with the specified index string.
     * The index string is trimmed to remove leading and trailing whitespace.
     *
     * @param indexString The string representing the 1-based index of the task to delete.
     * @throws AssertionError If the indexString is null or empty after trimming.
     */
    public DeleteCommand(String indexString) {
        assert indexString != null && !indexString.trim().isEmpty() : "Command cannot be null or empty!";
        this.indexString = indexString.strip();
    }

    /**
     * Executes the delete command by removing the task at the specified index from the task list.
     * Converts the index string to an integer (adjusting from 1-based to 0-based) and attempts deletion.
     *
     * @return A CommandResult containing the result message of the deletion operation.
     * @throws NumberFormatException If the index string cannot be parsed into an integer.
     * @throws AikhsuException If the task index is out of bounds or invalid.
     */
    @Override
    public CommandResult execute() {
        try {
            int id = Integer.parseInt(indexString) - 1;
            return new CommandResult(this.tasks.deleteTask(id));
        } catch (NumberFormatException e) {
            return new CommandResult(INVALID_INDEX_MESSAGE);
        } catch (AikhsuException e) {
            return new CommandResult(TASK_NOT_EXISTS_MESSAGE);
        }

    }
}
