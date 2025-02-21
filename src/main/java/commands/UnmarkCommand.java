package commands;

import exceptions.AikhsuException;

/**
 * Represents a command to mark a task as not done (unmark) in the task list based on its index.
 * Extends the Command class to provide specific unmarking functionality.
 */
public class UnmarkCommand extends Command {
    /** Message displayed when the provided index is not a valid number. */
    private static final String INVALID_INDEX_MESSAGE = "Please provide a number!";

    /** Message displayed when the task at the specified index does not exist. */
    private static final String TASK_NOT_EXISTS_MESSAGE = "Task does not exist!";

    /** The string representation of the task index to unmark. */
    private final String indexString;

    /**
     * Constructs an UnmarkCommand with the specified index string.
     * The index string is trimmed to remove leading and trailing whitespace.
     *
     * @param indexString The string representing the 1-based index of the task to unmark.
     * @throws AssertionError If the indexString is null or empty after trimming.
     */
    public UnmarkCommand(String indexString) {
        assert indexString != null && !indexString.trim().isEmpty() : "Command cannot be null or empty!";
        this.indexString = indexString.strip();
    }

    /**
     * Executes the unmark command by marking the task at the specified index as not done.
     * Converts the index string to an integer and attempts to unmark the task.
     *
     * @return A CommandResult containing the result message of the unmark operation.
     * @throws NumberFormatException If the index string cannot be parsed into an integer.
     * @throws AikhsuException If the task index is out of bounds or invalid.
     */
    @Override
    public CommandResult execute() {
        try {
            int id = Integer.parseInt(indexString);
            return new CommandResult(this.tasks.unmarkTask(id));
        } catch (NumberFormatException e) {
            return new CommandResult(INVALID_INDEX_MESSAGE);
        } catch (AikhsuException e) {
            return new CommandResult(TASK_NOT_EXISTS_MESSAGE);
        }
    }
}
