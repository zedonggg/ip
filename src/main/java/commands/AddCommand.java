package commands;

import java.time.LocalDateTime;
import java.time.LocalTime;

import exceptions.AikhsuException;
import handlers.DateTimeParser;
import tasks.Deadline;
import tasks.Event;
import tasks.Todo;

/**
 * Represents a command to add a new task (Todo, Deadline, or Event) to the task list.
 * Extends the Command class to provide task addition functionality based on the command type.
 */
public class AddCommand extends Command {
    private static final String NO_COMMAND_BODY_MESSAGE = "Task body cannot be empty!";
    private static final String DEADLINE_FORMAT_MESSAGE = "Deadline task format: deadline <task name> "
            + "/by DD/MM/YYYY HH:MM";
    private static final String EVENT_FORMAT_MESSAGE = "Event task format: event <task name> "
            + "/from DD/MM/YYYY HH:MM /to HH:MM";
    private static final String INVALID_COMMAND_MESSAGE = "Command not recognised!";
    private final String commandType;
    private final String commandString;

    /**
     * Constructs an AddCommand with the specified command type and full command string.
     * The command string is trimmed to remove leading and trailing whitespace.
     *
     * @param commandType  The type of task to add ("todo", "deadline", or "event").
     * @param commandString The full input string containing the command and task details.
     */
    public AddCommand(String commandType, String commandString) {
        this.commandType = commandType;
        this.commandString = commandString.strip();
    }

    /**
     * Executes the add command by creating and adding a new task to the task list.
     * Supports adding Todo, Deadline, or Event tasks based on the command type, parsing
     * the command string as needed. Returns an error message if the format is invalid or parsing fails.
     *
     * @return A CommandResult containing the result message of the task addition or an error message.
     * @throws AikhsuException If date/time parsing fails or task creation encounters an error.
     */
    @Override
    public CommandResult execute() {
        String[] commandSegments = commandString.split(" ", 2);
        if (commandSegments.length < 2) {
            return new CommandResult(NO_COMMAND_BODY_MESSAGE);
        }
        String commandBody = commandSegments[1];
        switch(commandType) {
        case "deadline":
            String[] deadlineSegments = commandBody.split(" /by ", 2);
            if (deadlineSegments.length < 2) {
                return new CommandResult(DEADLINE_FORMAT_MESSAGE);
            }

            try {
                LocalDateTime deadlineDateTime = DateTimeParser.parseDateTime(deadlineSegments[1]);
                Deadline tmpDeadline = new Deadline(deadlineSegments[0], deadlineDateTime, deadlineSegments[1]);
                return new CommandResult(tasks.addTask(tmpDeadline));
            } catch (AikhsuException e) {
                return new CommandResult(e.getMessage());
            }

        case "todo":
            Todo tmpTodo = new Todo(commandBody);
            return new CommandResult(tasks.addTask(tmpTodo));
        case "event":
            String[] eventSegments = commandString.split(" /from ", 2);
            if (eventSegments.length < 2) {
                return new CommandResult(EVENT_FORMAT_MESSAGE);
            }

            String[] eventTimings = eventSegments[1].split(" /to ", 2);
            if (eventTimings.length < 2) {
                return new CommandResult(EVENT_FORMAT_MESSAGE);
            }

            try {
                LocalDateTime eventDateTime = DateTimeParser.parseDateTime(eventTimings[0]);
                LocalTime eventTime = DateTimeParser.parseTime(eventTimings[1]);
                Event tmpEvent = new Event(eventSegments[0], eventDateTime,
                        eventTime, eventTimings[0], eventTimings[1]);
                return new CommandResult(tasks.addTask(tmpEvent));
            } catch (AikhsuException e) {
                return new CommandResult(e.getMessage());
            }

        default:
            return new CommandResult(INVALID_COMMAND_MESSAGE);
        }
    }
}
