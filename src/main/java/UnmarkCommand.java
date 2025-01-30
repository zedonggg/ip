public class UnmarkCommand extends Command {
    private static final String INVALID_INDEX_MESSAGE = "Please provide a number!";
    private static final String TASK_NOT_EXISTS_MESSAGE = "Task does not exist!";
    private final String indexString;

    public UnmarkCommand(String indexString) {
        this.indexString = indexString.strip();
    }

    @Override
    public CommandResult execute() {
        try {
            int id = Integer.parseInt(indexString);
            this.tasks.unmarkTask(id);
        } catch (NumberFormatException e) {
            return new CommandResult(INVALID_INDEX_MESSAGE);
        } catch (AikhsuException e) {
            return new CommandResult(TASK_NOT_EXISTS_MESSAGE);
        }
        return new CommandResult("Task unmarked successfully!");
    }
}
