import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Aikhsu {
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        String logo = "____________________________________________________________\n" +
                " Hello! I'm Aik Hsu\n" +
                " What can I do for you?\n" +
                "____________________________________________________________";
        System.out.println(logo);

        //System.out.println(new File("input.txt").getAbsolutePath());
//        List<String[]> tmp = new ArrayList<>();
//        try (Scanner scanner = new Scanner(new File("Aikhsu.txt"))) {
//            while (scanner.hasNextLine()) {
//                tmp.add(scanner.nextLine().split(", "));
//            }
//            for (String[] s : tmp) {
//                for (String t : s) {
//                    System.out.print(t);
//                };
//                printLine();
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("no file");
//        }

        Scanner cin = new Scanner(System.in);
        ArrayList<Task> saved = FileHandler.loadTasks("Aikhsu.txt");
        TaskList tasks = new TaskList(saved);
        String command;

        while(true) {
            command = cin.nextLine();
            String[] segments = command.split(" ");

            switch(segments[0]){
                case "bye":
                    printLine();
                    System.out.println("Bye. Hope to see you again soon!");
                    printLine();
                    FileHandler.saveTasks(tasks, "Aikhsu.txt");
                    cin.close();
                    return;

                case "list":
                    tasks.listTasks();
                    break;

                case "mark":
                    if (segments.length < 2) {
                        System.out.println("Please indicate the task number to mark!");
                        break;
                    }
                    try {
                        int id = Integer.parseInt(segments[1]);
                        tasks.markTask(id);
                        FileHandler.saveTasks(tasks, "Aikhsu.txt");
                    } catch (AikhsuException | NumberFormatException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                case "unmark":
                    if (segments.length < 2) {
                        System.out.println("Please indicate the task number to mark!");
                        break;
                    }
                    try {
                        int id = Integer.parseInt(segments[1]);
                        tasks.unmarkTask(id);
                        FileHandler.saveTasks(tasks, "Aikhsu.txt");
                    } catch (AikhsuException | NumberFormatException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                case "delete":
                    if (segments.length < 2) {
                        System.out.println("Please indicate the task number to mark!");
                        break;
                    }

                    try {
                        int id = Integer.parseInt(segments[1]) - 1;
                        tasks.deleteTask(id);
                        FileHandler.saveTasks(tasks, "Aikhsu.txt");
                    } catch (AikhsuException | NumberFormatException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                case "deadline":
                    String[] deadlineSegments = command.split("/by ", 2);
                    if (deadlineSegments.length < 2) {
                        System.out.println("Deadline task must have a due date!");
                        break;
                    }

                    String[] deadlineDescription = deadlineSegments[0].split(" ", 2);
                    if (deadlineDescription.length < 2) {
                        System.out.println("Deadline description cannot be empty!");
                        break;
                    }

                    Deadline tmpDeadline = new Deadline(deadlineDescription[1].trim(), deadlineSegments[1].trim());
                    tasks.addTask(tmpDeadline);
                    FileHandler.saveTasks(tasks, "Aikhsu.txt");
                    break;

                case "todo":
                    String[] todoDescription = command.split(" ", 2);
                    if (todoDescription.length < 2) {
                        System.out.println("Todo description cannot be empty!");
                        break;
                    }
                    Todo tmpTodo = new Todo(todoDescription[1]);
                    tasks.addTask(tmpTodo);
                    FileHandler.saveTasks(tasks, "Aikhsu.txt");
                    break;

                case "event":
                    String[] eventSegments = command.split("/", 3);
                    if (eventSegments.length < 3) {
                        System.out.println("Invalid usage. Event task must have from and to date!");
                        break;
                    }
                    String[] eventFrom = eventSegments[1].split(" ", 2);
                    String[] eventTo = eventSegments[2].split(" ", 2);
                    if (eventFrom.length < 2 || eventTo.length < 2) {
                        System.out.println("Invalid from or to timing!");
                        break;
                    }
                    String[] eventDescription = eventSegments[0].split(" ", 2);
                    if (eventDescription.length < 2) {
                        System.out.println("Event description cannot be empty!");
                        break;
                    }

                    Event tmpEvent = new Event(eventDescription[1], eventFrom[1], eventTo[1]);
                    tasks.addTask(tmpEvent);
                    FileHandler.saveTasks(tasks, "Aikhsu.txt");
                    break;

                default:
                    printLine();
                    System.out.println("Invalid command! Try again!");
                    printLine();
            }
        }
    }
}
