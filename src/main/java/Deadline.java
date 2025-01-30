import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected String by;
    protected LocalDateTime dateTime;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, boolean isDone, String by, LocalDateTime dateTime) {
        super(description, isDone);
        this.by = by;
        this.dateTime = dateTime;
    }

    public Deadline(String description, LocalDateTime dateTime, String by) {
        super(description);
        this.by = by;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a")) + ")";
    }

    @Override
    public String toFileString() {
        return "D" + " | " + super.isDone + " | " + super.description + " | " + by;
    }
}
