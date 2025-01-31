package Tasks;

/**
 * Represents an abstract task with a description and completion status.
 * This class provides methods to manipulate and retrieve task information.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new task with the specified description and marks it as not done by default.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructs a new task with the specified description and completion status.
     *
     * @param description The description of the task.
     * @param isDone      The completion status of the task.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns the status icon of the task.
     * "X" indicates the task is done, and a space (" ") indicates it is not done.
     *
     * @return The status icon representing the completion status.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as done by setting the completion status to true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done by setting the completion status to false.
     */
    public void markNotDone() {
        this.isDone = false;
    }

    /**
     * Returns a string representation of the task, including its status icon and description.
     *
     * @return A formatted string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "]" + " " + this.description;
    }

    /**
     * Converts the task into a string format suitable for file storage.
     * This method must be implemented by subclasses.
     *
     * @return A string representation of the task for file storage.
     */
    public abstract String toFileString();

    public String getDescription() {
        return this.description;
    }
}
