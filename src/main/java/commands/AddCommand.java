package commands;

import exceptions.AikhsuException;
import handlers.DateTimeParser;
import tasks.Deadline;
import tasks.Event;
import tasks.Todo;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AddCommand extends Command {
    private static final String NO_COMMAND_BODY_MESSAGE = "Task body cannot be empty!";
    private static final String DEADLINE_FORMAT_MESSAGE = "Deadline task format: deadline <task name> " +
            "/by DD/MM/YYYY HH:MM";
    private static final String EVENT_FORMAT_MESSAGE = "Event task format: event <task name> " +
            "/from DD/MM/YYYY HH:MM /to HH:MM";
    private static final String INVALID_COMMAND_MESSAGE = "Command not recognised!";
    private final String commandType;
    private final String commandString;


    public AddCommand(String commandType, String commandString) {
        this.commandType = commandType;
        this.commandString = commandString.strip();
    }

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
                Event tmpEvent = new Event(eventSegments[0], eventDateTime, eventTime, eventTimings[0], eventTimings[1]);
                return new CommandResult(tasks.addTask(tmpEvent));
            } catch (AikhsuException e) {
                return new CommandResult(e.getMessage());
            }

        default:
            return new CommandResult(INVALID_COMMAND_MESSAGE);
        }
    }
}
