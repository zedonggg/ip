package commands;

import exceptions.AikhsuException;
import handlers.DateTimeParser;

import java.time.LocalDate;

public class FindDateCommand extends Command{

    private String dateString;
    public FindDateCommand(String dateString) {
        this.dateString = dateString;
    }
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
