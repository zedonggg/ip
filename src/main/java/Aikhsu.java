import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Aikhsu {
    private Ui ui;
    private TaskList tasks;
    private String filepath;


    public static void main(String[] args) {
        new Aikhsu("Aikhsu.txt").run();
    }

    public Aikhsu(String filepath) {
        this.tasks = new TaskList(FileHandler.loadTasks(filepath));
        this.filepath = filepath;
        this.ui = new Ui();
    }

    private CommandResult runCommand(Command c) {
        c.setTasks(this.tasks);
        CommandResult r = c.execute();
        FileHandler.saveTasks(this.tasks, this.filepath);
        return r;
    }
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
            System.out.println(r.commandOutput);
        }
        exit();
    }
    private void exit() {
        ui.printGoodbye();
        System.exit(0);
    }
}
