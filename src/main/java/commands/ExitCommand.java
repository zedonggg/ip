package commands;

/**
 * Represents a command to exit the Aikhsu application.
 * Extends the Command class to provide application termination functionality.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by printing an exit message and returning a result to terminate the application.
     *
     * @return An ExitCommandResult containing a farewell message to signal the application’s closure.
     */
    @Override
    public CommandResult execute() {
        System.out.println("Exiting application...\n");
        return new ExitCommandResult("Bye-bye!");
    }
}
