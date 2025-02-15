package commands;

import exceptions.AikhsuException;

public class DeleteCommand extends Command {
    private static final String INVALID_INDEX_MESSAGE = "Please provide a number!";
    private static final String TASK_NOT_EXISTS_MESSAGE = "Task does not exist!";
    private final String indexString;

    public DeleteCommand(String indexString) {
        assert indexString != null && !indexString.trim().isEmpty() : "Command cannot be null or empty!";
        this.indexString = indexString.strip();
    }

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
