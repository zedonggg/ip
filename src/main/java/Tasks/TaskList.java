package Tasks;

import Exceptions.AikhsuException;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    private int counter;

    public TaskList() {
        this.tasks = new ArrayList<>();
        this.counter = 0;
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.counter = tasks.size();
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public void deleteTask(int i) throws AikhsuException {
        try {
            Task tmp = this.tasks.get(i);
            this.tasks.remove(i);
            counter -= 1;
            printLine();
            System.out.println("Noted. I've removed this task:\n" + tmp + '\n' +
                    "Now you have " + counter + " tasks in the list.");
            printLine();
        } catch (IndexOutOfBoundsException e) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    public void markTask(int i) throws AikhsuException {
        try {
            i -= 1;
            Task tmp = this.tasks.get(i);
            tmp.markAsDone();
            printLine();
            System.out.println("Nice! I've marked this task as done:\n" + tmp);
            printLine();
        } catch (IndexOutOfBoundsException e) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    public void unmarkTask(int i) throws AikhsuException {
        try {
            i -= 1;
            Task tmp = this.tasks.get(i);
            tmp.markNotDone();
            printLine();
            System.out.println("OK, I've marked this task as not done yet:\n" + tmp);
            printLine();
        } catch (IndexOutOfBoundsException e) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    public void addTask(Task t) {
        this.tasks.add(t);
        counter += 1;
        printLine();
        System.out.println("Got it. I've added this task:\n" + t + '\n' +
                "Now you have " + counter + " tasks in the list.");
        printLine();
    }

    public void listTasks() {
        printLine();
        if (counter == 0) {
            System.out.println("No tasks saved!");
            printLine();
            return;
        }

        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < counter; i++) {
            System.out.print(i+1);
            System.out.println(". " + tasks.get(i));
        }
        printLine();
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}
