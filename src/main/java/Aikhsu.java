import commands.Command;
import commands.CommandParser;
import commands.CommandResult;
import commands.DefaultCommand;
import commands.ExitCommand;
import handlers.FileHandler;
import tasks.TaskList;
import ui.Ui;

/**
 * The main application class for Aikhsu, a task management system.
 * Manages the user interface, task list, and file operations.
 *
 * @author Sun Ze Dong
 * @version 1.0
 * @since 2025-02-20
 */
public class Aikhsu {
    private Ui ui;
    private TaskList tasks;
    private String filepath;

    /**
     * Constructs an Aikhsu instance with the specified file path for task storage.
     * Initializes the task list by loading tasks from the file and sets up the user interface.
     *
     * @param filepath The path to the file where tasks are stored.
     */
    public Aikhsu(String filepath) {
        this.tasks = new TaskList(FileHandler.loadTasks(filepath));
        this.filepath = filepath;
        this.ui = new Ui();
    }

    /**
     * The entry point of the Aikhsu application.
     * Creates an instance of Aikhsu with a default file name and starts the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Aikhsu("Aikhsu.txt").run();
    }


    private CommandResult runCommand(Command c) {
        c.setTasks(this.tasks);
        CommandResult r = c.execute();
        FileHandler.saveTasks(this.tasks, this.filepath);
        return r;
    }

    /**
     * Processes a user input string as a command and returns the result for visual UI interaction.
     *
     * @param input The raw input string from the user.
     * @return The result of the executed command, including output to display.
     */
    public CommandResult visualUI(String input) {
        Command c = CommandParser.parseCommand(input.strip());
        return runCommand(c);
    }

    /**
     * Runs the main application loop, displaying the UI and processing user commands until an exit command is received.
     */
    private void run() {
        ui.printHello();
        Command c = new DefaultCommand("");
        CommandResult r;
        String commandStr = "";
        while (!(c instanceof ExitCommand)) {
            ui.printPrompt();
            commandStr = ui.readCommand();
            c = CommandParser.parseCommand(commandStr);
            r = runCommand(c);
            System.out.println(r.getCommandOutput());
        }
        exit();
    }
    private void exit() {
        ui.printGoodbye();
        System.exit(0);
    }
}
