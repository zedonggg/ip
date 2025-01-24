import java.util.Scanner;
public class Aikhsu {
    public static int counter = 0;

    public static Task[] tasks = new Task[100];
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void markTask(String[] segments) throws AikhsuException {
        if (segments.length < 2) {
            throw new AikhsuException("Please indicate the task number to mark!");
        }

        try {
            int id = Integer.parseInt(segments[1]) - 1;
            if (id >= counter) {
                throw new ArrayIndexOutOfBoundsException();
            }
            tasks[id].markAsDone();
            printLine();
            System.out.println("Nice! I've marked this task as done:\n" + tasks[id]);
            printLine();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException a) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    public static void unmarkTask(String[] segments) throws AikhsuException {
        if (segments.length < 2) {
            throw new AikhsuException("Please indicate the task number to unmark!");
        }

        try {
            int id = Integer.parseInt(segments[1]) - 1;
            if (id >= counter) {
                throw new ArrayIndexOutOfBoundsException();
            }
            tasks[id].markNotDone();
            printLine();
            System.out.println("OK, I've marked this task as not done yet:\n" + tasks[id]);
            printLine();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException a) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    public static void deadline(String command) throws AikhsuException {
        String[] deadlineSegments = command.split("/by ", 2);
        if (deadlineSegments.length < 2) {
            throw new AikhsuException("Deadline task must have a due date!");
        }

        String[] deadlineDescription = deadlineSegments[0].split(" ", 2);
        if (deadlineDescription.length < 2) {
            throw new AikhsuException("Deadline description cannot be empty!");
        }

        tasks[counter] = new Deadline(deadlineDescription[1].trim(), deadlineSegments[1].trim());
        counter += 1;
        printLine();
        System.out.println("Got it. I've added this task:\n" + tasks[counter-1] + '\n' +
                "Now you have " + counter + " tasks in the list.");
        printLine();
    }

    public static void event(String command) throws AikhsuException {
        String[] eventSegments = command.split("/", 3);
        if (eventSegments.length < 3) {
            throw new AikhsuException("Invalid usage. Event task must have from and to date!");
        }
        String[] eventFrom = eventSegments[1].split(" ", 2);
        String[] eventTo = eventSegments[2].split(" ", 2);
        if (eventFrom.length < 2 || eventTo.length < 2) {
            throw new AikhsuException("Invalid from or to timing!");
        }
        String[] eventDescription = eventSegments[0].split(" ", 2);
        if (eventDescription.length < 2) {
            throw new AikhsuException("Event description cannot be empty!");
        }

        tasks[counter] = new Event(eventDescription[1], eventFrom[1], eventTo[1]);
        counter += 1;
        printLine();
        System.out.println("Got it. I've added this task:\n" + tasks[counter-1] + '\n' +
                "Now you have " + counter + " tasks in the list.");
        printLine();
    }

    public static void todo(String command) throws AikhsuException {
        String[] todoDescription = command.split(" ", 2);
        if (todoDescription.length < 2) {
            throw new AikhsuException("Todo description cannot be empty!");
        }
        tasks[counter] = new Todo(todoDescription[1]);
        counter += 1;
        printLine();
        System.out.println("Got it. I've added this task:\n" + tasks[counter-1] + '\n' +
                "Now you have " + counter + " tasks in the list.");
        printLine();
    }
    public static void main(String[] args) {
        String logo = "____________________________________________________________\n" +
                " Hello! I'm Aik Hsu\n" +
                " What can I do for you?\n" +
                "____________________________________________________________";
        System.out.println(logo);

        Scanner cin = new Scanner(System.in);
        String command = "";

        while(true) {
            command = cin.nextLine();
            String[] segments = command.split(" ");

            switch(segments[0]){

                case "bye":
                    printLine();
                    System.out.println("Bye. Hope to see you again soon!");
                    printLine();
                    cin.close();
                    return;

                case "list":
                    if (counter == 0) {
                        printLine();
                        System.out.println("No tasks saved!");
                        printLine();
                    } else {
                        printLine();
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < counter; i++) {
                            System.out.print(i+1);
                            System.out.println(". " + tasks[i]);
                        }
                        printLine();
                    }
                    break;

                case "mark":
                    try {
                        markTask(segments);
                    } catch (AikhsuException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                case "unmark":
                    try {
                        unmarkTask(segments);
                    } catch (AikhsuException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                case "deadline":
                    try {
                        deadline(command);
                    } catch (AikhsuException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                case "todo":
                    try {
                        todo(command);
                    } catch (AikhsuException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                case "event":
                    try {
                        event(command);
                    } catch (AikhsuException e) {
                        printLine();
                        System.out.println(e.getMessage());
                        printLine();
                    }
                    break;

                default:
                    printLine();
                    System.out.println("Invalid command! Try again!");
                    printLine();
            }
        }2
    }
}
