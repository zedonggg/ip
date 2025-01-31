package Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task that must be completed by a specific date and time.
 */
public class Deadline extends Task {

    protected String by;
    protected LocalDateTime dateTime;

    /**
     * Constructs a Deadline task with a description and due date specified as a string.
     *
     * @param description The description of the deadline task.
     * @param by          The due date of the task in string format.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Constructs a Deadline task with a description, completion status, and due date.
     *
     * @param description The description of the deadline task.
     * @param isDone      The completion status of the task.
     * @param by          The due date of the task in string format.
     * @param dateTime    The due date and time of the task.
     */
    public Deadline(String description, boolean isDone, String by, LocalDateTime dateTime) {
        super(description, isDone);
        this.by = by;
        this.dateTime = dateTime;
    }

    /**
     * Constructs a Deadline task with a description and due date specified as both a LocalDateTime object and a string.
     *
     * @param description The description of the deadline task.
     * @param dateTime    The due date and time of the task.
     * @param by          The due date of the task in string format.
     */
    public Deadline(String description, LocalDateTime dateTime, String by) {
        super(description);
        this.by = by;
        this.dateTime = dateTime;
    }

    /**
     * Returns a string representation of the deadline task, including its status, description, and due date.
     *
     * @return A formatted string representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a")) + ")";
    }

    /**
     * Converts the deadline task into a string format suitable for file storage.
     *
     * @return A string representation of the deadline task for file storage.
     */
    @Override
    public String toFileString() {
        return "D" + " | " + super.isDone + " | " + super.description + " | " + by;
    }
}
