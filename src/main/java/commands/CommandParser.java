package commands;

/**
 * Parses user input strings into corresponding Command objects for execution in the Aikhsu application.
 * Supports a variety of task management commands such as listing, marking, deleting, and adding tasks.
 */
public class CommandParser {
    /**
     * Parses a command string into an appropriate Command object based on the first word.
     * Handles various commands including "bye", "list", "mark", "unmark", "delete", "find",
     * "findbydate", "deadline", "todo", and "event". Returns a DefaultCommand for unrecognized
     * commands or invalid syntax.
     *
     * @param commandString The raw input string from the user, containing the command and optional arguments.
     * @return A Command object corresponding to the parsed command, or a DefaultCommand if parsing fails.
     */
    public static Command parseCommand(String commandString) {
        String[] segments = commandString.split(" ");
        switch (segments[0]) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            if (segments.length < 2) {
                return new DefaultCommand("Please indicate the task number to mark!");
            }
            return new MarkCommand(segments[1]);
        case "unmark":
            if (segments.length < 2) {
                return new DefaultCommand("Please indicate the task number to unmark!");
            }
            return new UnmarkCommand(segments[1]);
        case "delete":
            if (segments.length < 2) {
                return new DefaultCommand("Please indicate the task number to delete!");
            }
            return new DeleteCommand(segments[1]);
        case "find":
            if (segments.length < 2) {
                return new DefaultCommand("Please type the task you want to find!");
            }
            return new FindCommand(segments[1]);
        case "findbydate":
            if (segments.length < 2) {
                return new DefaultCommand("Please indicate the date with the format DD/MM/YYYY");
            }
            return new FindDateCommand(segments[1]);
        case "deadline":
        case "todo":
        case "event":
            return new AddCommand(segments[0], commandString);
        default:
            return new DefaultCommand("Command not recognised!");
        }
    }
}
