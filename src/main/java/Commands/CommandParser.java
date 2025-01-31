package Commands;

public class CommandParser {
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
        case "deadline":
        case "todo":
        case "event":
            return new AddCommand(segments[0], commandString);
        default:
            return new DefaultCommand("Commands.Command not recognised!");
        }

    }
}
