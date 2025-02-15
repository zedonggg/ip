package commands;

import tasks.TaskList;

/**
 * Represents an abstract command that can be executed within the application.
 * Commands typically manipulate the task list and return a result upon execution.
 */
public abstract class Command {

    /** The list of tasks that the command will operate on. */
    protected TaskList tasks;

    /**
     * Executes the command and returns the result of the execution.
     *
     * @return A {@code CommandResult} representing the outcome of the command execution.
     */
    public abstract CommandResult execute();

    /**
     * Sets the task list for the command to operate on.
     *
     * @param tasks The {@code TaskList} instance to be used by the command.
     */
    public void setTasks(TaskList tasks) {
        this.tasks = tasks;
    }

}
