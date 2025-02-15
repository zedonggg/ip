package tasks;

public class Todo extends Task {
    /**
     * Constructs a Todo task with the given description.
     * The task is initially marked as not done.
     *
     * @param description The description of the Todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Constructs a Todo task with the given description and completion status (Useful for loading from local save).
     *
     * @param description The description of the Todo task.
     * @param isDone      The completion status of the task (true if done, false otherwise).
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * Returns a string representation of the Todo task.
     * The format is "[T]" followed by the superclass's string representation.
     *
     * @return A string representation of the Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a string representation of the Todo task suitable for saving to a file.
     * The format is "T | <isDone> | <description>".
     *
     * @return A string representation of the Todo task for file storage.
     */
    @Override
    public String toFileString() {
        return "T" + " | " + super.isDone + " | " + super.description;
    }
}
