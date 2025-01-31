package Tasks;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected String from;
    protected String to;

    protected LocalDateTime fromDateTime;
    protected LocalTime toTime;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public Event(String description, LocalDateTime fromDateTime, LocalTime to, String fromStr, String toStr) {
        super(description);
        this.fromDateTime = fromDateTime;
        this.toTime = to;
        this.from = fromStr;
        this.to = toStr;
    }

    public Event(String description, boolean isDone, String from, String to, LocalDateTime fromDateTime, LocalTime toTime) {
        super(description, isDone);
        this.from = from;
        this.to = to;
        this.toTime = toTime;
        this.fromDateTime = fromDateTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + fromDateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a"))
                + " to: " + toTime.format(DateTimeFormatter.ofPattern("h:mm a")) + ")";
    }

    @Override
    public String toFileString() {
        return "E" + " | " + super.isDone + " | " + super.description + " | " + from + " | " + to;
    }
}
