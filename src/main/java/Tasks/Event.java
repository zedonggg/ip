package Tasks;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task that occurs within a specific time frame.
 * An event has a description, start time, and end time.
 */
public class Event extends Task {

    protected String from;
    protected String to;

    protected LocalDateTime fromDateTime;
    protected LocalTime toTime;

    /**
     * Constructs an Event task with a description and time period specified as strings.
     *
     * @param description The description of the event.
     * @param from        The start time of the event in string format.
     * @param to          The end time of the event in string format.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs an Event task with a description, start and end times as both LocalDateTime and LocalTime.
     *
     * @param description  The description of the event.
     * @param fromDateTime The start date and time of the event.
     * @param to           The end time of the event.
     * @param fromStr      The string representation of the start time.
     * @param toStr        The string representation of the end time.
     */
    public Event(String description, LocalDateTime fromDateTime, LocalTime to, String fromStr, String toStr) {
        super(description);
        this.fromDateTime = fromDateTime;
        this.toTime = to;
        this.from = fromStr;
        this.to = toStr;
    }

    /**
     * Constructs an Event task with a description, completion status, and time details.
     *
     * @param description  The description of the event.
     * @param isDone       The completion status of the event.
     * @param from         The start time of the event in string format.
     * @param to           The end time of the event in string format.
     * @param fromDateTime The start date and time of the event.
     * @param toTime       The end time of the event.
     */
    public Event(String description, boolean isDone, String from, String to, LocalDateTime fromDateTime, LocalTime toTime) {
        super(description, isDone);
        this.from = from;
        this.to = to;
        this.toTime = toTime;
        this.fromDateTime = fromDateTime;
    }

    /**
     * Returns a string representation of the event, including its status, description, and time period.
     *
     * @return A formatted string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + fromDateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a"))
                + " to: " + toTime.format(DateTimeFormatter.ofPattern("h:mm a")) + ")";
    }

    /**
     * Converts the event into a string format suitable for file storage.
     *
     * @return A string representation of the event for file storage.
     */
    @Override
    public String toFileString() {
        return "E" + " | " + super.isDone + " | " + super.description + " | " + from + " | " + to;
    }
}
