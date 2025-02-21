package commands;

import java.time.LocalDate;

import exceptions.AikhsuException;
import handlers.DateTimeParser;

/**
 * Represents a command to find tasks that match a given date.
 */
public class FindDateCommand extends Command {

    private String dateString;

    /**
     * Constructs a FindDateCommand with the specified date string.
     *
     * @param dateString The date string used to find tasks.
     */
    public FindDateCommand(String dateString) {
        this.dateString = dateString;
    }

    /**
     * Executes the find date command, searching for tasks that match the specified date.
     *
     * @return A {@code CommandResult} containing the matching tasks or an error message.
     */
    @Override
    public CommandResult execute() {
        try {
            LocalDate date = DateTimeParser.parseDate(dateString);
            return new CommandResult(tasks.findTasksByDate(date));
        } catch (AikhsuException e) {
            return new CommandResult(e.getMessage());
        }
    }
}
