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

        while(true) {
            command = cin.nextLine();
            if (command.equals("bye")) {
                System.out.println("____________________________________________________________\n" +
                        "Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________\n");
                break;
            } else {
                System.out.println("____________________________________________________________\n" +
                        command + "\n" +
                        "____________________________________________________________\n");
            }
        }

        cin.close();
    }
}
