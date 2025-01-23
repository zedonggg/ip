import java.util.Scanner;
public class Aikhsu {
    public static void main(String[] args) {
        String logo = "____________________________________________________________\n" +
                " Hello! I'm Aik Hsu\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";
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
                    System.out.println("____________________________________________________________\n" +
                            "Bye. Hope to see you again soon!\n" +
                            "____________________________________________________________\n");
                    cin.close();
                    return;

                case "list":
                    if (counter == 0) {
                        System.out.println("____________________________________________________________\n" +
                                "No tasks saved!\n" + "____________________________________________________________\n");
                    } else {
                        System.out.println("____________________________________________________________\n");
                        System.out.println("Here are the tasks in your list:\n");
                        for (int i = 0; i < counter; i++) {
                            System.out.print(i+1);
                            System.out.println(". " + tasks[i] + "\n");
                        }
                        System.out.println("____________________________________________________________\n");
                    }
                    break;

                case "mark":
                    if (segments.length > 1) {
                        int id = Integer.parseInt(segments[1]);
                        if (id >= counter) {
                            System.out.println("____________________________________________________________\n");
                            System.out.println("Task does not exist!\n");
                            System.out.println("____________________________________________________________\n");
                        } else {
                            tasks[id].markAsDone();
                            System.out.println("____________________________________________________________\n");
                            System.out.println("Nice! I've marked this task as done:\n" + tasks[id] + "\n");
                            System.out.println("____________________________________________________________\n");
                        }
                    }
                    break;

                case "unmark":
                    if (segments.length > 1) {
                        int id = Integer.parseInt(segments[1]);
                        if (id >= counter) {
                            System.out.println("____________________________________________________________\n");
                            System.out.println("Task does not exist!\n");
                            System.out.println("____________________________________________________________\n");
                        } else {
                            tasks[id].markNotDone();
                            System.out.println("____________________________________________________________\n");
                            System.out.println("OK, I've marked this task as not done yet:\n" + tasks[id] + "\n");
                            System.out.println("____________________________________________________________\n");
                        }
                    }
                    break;

                default:
                    tasks[counter] = new Task(command);
                    counter += 1;
                    System.out.println("____________________________________________________________\n" +
                            "added: " + command + "\n" +
                            "____________________________________________________________\n");

            }
//            if (command.equals("bye")) {
//                System.out.println("____________________________________________________________\n" +
//                        "Bye. Hope to see you again soon!\n" +
//                        "____________________________________________________________\n");
//                break;
//            } else if (command.equals("list")) {
//                if (counter == 0) {
//                    System.out.println("____________________________________________________________\n" +
//                            "No tasks saved!\n" + "____________________________________________________________\n");
//                } else {
//                    System.out.println("____________________________________________________________\n");
//                    for (int i = 0; i < counter; i++) {
//                        System.out.print(i+1);
//                        System.out.println(". " + tasks[i] + "\n");
//                    }
//                    System.out.println("____________________________________________________________\n");
//                }
//            } else {
//                tasks[counter] = command;
//                counter += 1;
//                System.out.println("____________________________________________________________\n" +
//                        "added: " + command + "\n" +
//                        "____________________________________________________________\n");
//            }
        }


    }
}
