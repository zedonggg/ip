import java.util.Scanner;

public class Aikhsu {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
        String logo = "____________________________________________________________\n" +
                " Hello! I'm Aik Hsu\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";
        System.out.println("Hello from\n" + logo);

        Scanner cin = new Scanner(System.in);
        String command = "";
        String[] tasks = new String[100];
        int counter = 0;

        while(true) {
            command = cin.nextLine();
            if (command.equals("bye")) {
                System.out.println("____________________________________________________________\n" +
                        "Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________\n");
                break;
            } else if (command.equals("list")) {
                if (counter == 0) {
                    System.out.println("____________________________________________________________\n" +
                            "No tasks saved!\n" + "____________________________________________________________\n");
                } else {
                    System.out.println("____________________________________________________________\n");
                    for (int i = 0; i < counter; i++) {
                        System.out.print(i+1);
                        System.out.println(". " + tasks[i] + "\n");
                    }
                    System.out.println("____________________________________________________________\n");
                }
            } else {
                tasks[counter] = command;
                counter += 1;
                System.out.println("____________________________________________________________\n" +
                        "added: " + command + "\n" +
                        "____________________________________________________________\n");
            }
        }

        cin.close();
    }
}
