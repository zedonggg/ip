package commands;

import exceptions.AikhsuException;

/**
 * Represents a command to mark a task as completed.
 */
public class MarkCommand extends Command {
    private static final String INVALID_INDEX_MESSAGE = "Please provide a number!";
    private static final String TASK_NOT_EXISTS_MESSAGE = "Task does not exist!";
    private final String indexString;

    /**
     * Constructs a MarkCommand with the given task index as a string.
     *
     * @param indexString The index of the task to be marked as completed.
     * @throws AssertionError if the indexString is null or empty.
     */
    public MarkCommand(String indexString) {
        assert indexString != null && !indexString.trim().isEmpty() : "Command cannot be null or empty!";
        this.indexString = indexString.strip();
    }

    /**
     * Executes the mark command, marking the specified task as completed.
     *
     * @return A {@code CommandResult} containing the success or error message.
     */
    @Override
    public CommandResult execute() {
        try {
            int id = Integer.parseInt(indexString);
            return new CommandResult(this.tasks.markTask(id));
        } catch (NumberFormatException e) {
            return new CommandResult(INVALID_INDEX_MESSAGE);
        } catch (AikhsuException e) {
            return new CommandResult(TASK_NOT_EXISTS_MESSAGE);
        }
    }
}
