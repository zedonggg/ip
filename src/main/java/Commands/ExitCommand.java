package Commands;

public class ExitCommand extends Command{
    @Override
    public CommandResult execute() {
        System.out.println("Exiting application...\n");
        return new ExitCommandResult("Bye-bye!");
    }

}
