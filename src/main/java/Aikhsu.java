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

        Scanner cin = new Scanner(System.in);
        String command = "";
        Task[] tasks = new Task[100];
        int counter = 0;

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
                    if (segments.length > 1) {
                        int id = Integer.parseInt(segments[1]) - 1;
                        if (id >= counter || id < 0) {
                            printLine();
                            System.out.println("Task does not exist!");
                            printLine();
                        } else {
                            tasks[id].markAsDone();
                            printLine();
                            System.out.println("Nice! I've marked this task as done:\n" + tasks[id]);
                            printLine();
                        }
                    }
                    break;

                case "unmark":
                    if (segments.length > 1) {
                        int id = Integer.parseInt(segments[1]) - 1;
                        if (id >= counter || id < 0) {
                            printLine();
                            System.out.println("Task does not exist!");
                            printLine();
                        } else {
                            tasks[id].markNotDone();
                            printLine();
                            System.out.println("OK, I've marked this task as not done yet:\n" + tasks[id]);
                            printLine();
                        }
                    }
                    break;

                case "deadline":
                    String[] deadlineSegments = command.split("/by ", 2);
                    String[] deadlineDescription = deadlineSegments[0].split(" ", 2);

                    tasks[counter] = new Deadline(deadlineDescription[1], deadlineSegments[1]);
                    counter += 1;
                    printLine();
                    System.out.println("Got it. I've added this task:\n" + tasks[counter-1] + '\n' +
                            "Now you have " + counter + " tasks in the list.");
                    printLine();
                    break;

                case "todo":
                    String[] todoDescription = command.split(" ", 2);
                    tasks[counter] = new Todo(todoDescription[1]);
                    counter += 1;
                    printLine();
                    System.out.println("Got it. I've added this task:\n" + tasks[counter-1] + '\n' +
                            "Now you have " + counter + " tasks in the list.");
                    printLine();
                    break;

                case "event":
                    String[] eventSegments = command.split("/", 3);
                    String eventFrom = eventSegments[1].split(" ", 2)[1];
                    String eventTo = eventSegments[2].split(" ", 2)[1];
                    String eventDescription = eventSegments[0].split(" ", 2)[1];

                    tasks[counter] = new Event(eventDescription, eventFrom, eventTo);
                    counter += 1;
                    printLine();
                    System.out.println("Got it. I've added this task:\n" + tasks[counter-1] + '\n' +
                            "Now you have " + counter + " tasks in the list.");
                    printLine();
                    break;

                default:
                    printLine();
                    System.out.println("Invalid command!");
                    printLine();
            }
        }


    }
}
