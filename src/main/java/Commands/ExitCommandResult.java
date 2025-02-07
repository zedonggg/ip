package Commands;

public class ExitCommandResult extends CommandResult{
    public ExitCommandResult(String s) {
        super(s);
    }

    public void quit() {
        System.exit(0);
    }
}
