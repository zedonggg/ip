package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import exceptions.AikhsuException;
import javafx.util.Pair;

/**
 * Manages a list of tasks, providing functionality to add, delete, mark, unmark, list, and search tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    private int counter;

    /**
     * Constructs an empty TaskList with no tasks and a counter set to 0.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
        this.counter = 0;
    }

    /**
     * Constructs a TaskList with the given list of tasks and sets the counter to the size of the list.
     *
     * @param tasks The list of tasks to initialize the TaskList with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.counter = tasks.size();
    }

    /**
     * Deletes the task at the specified index from the TaskList.
     * If the index is invalid, throws an AikhsuException.
     *
     * @param i The index of the task to delete.
     * @throws AikhsuException If the index is out of bounds.
     */
    public String deleteTask(int i) throws AikhsuException {
        try {
            Task tmp = this.tasks.get(i);
            this.tasks.remove(i);
            counter -= 1;
            String taskStr = "Noted. I've removed this task:\n"
                    + tmp + '\n'
                    + "Now you have " + counter + " tasks in the list.\n";
            return taskStr;
        } catch (IndexOutOfBoundsException e) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    /**
     * Marks the task at the specified index as done.
     * If the index is invalid, throws an AikhsuException.
     *
     * @param i The index of the task to mark as done.
     * @throws AikhsuException If the index is out of bounds.
     */
    public String markTask(int i) throws AikhsuException {
        try {
            i -= 1;
            Task tmp = this.tasks.get(i);
            tmp.markAsDone();
            String taskStr = "Nice! I've marked this task as done:\n" + tmp + "\n";
            return taskStr;
        } catch (IndexOutOfBoundsException e) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    /**
     * Marks the task at the specified index as not done.
     * If the index is invalid, throws an AikhsuException.
     *
     * @param i The index of the task to mark as not done.
     * @throws AikhsuException If the index is out of bounds.
     */
    public String unmarkTask(int i) throws AikhsuException {
        try {
            i -= 1;
            Task tmp = this.tasks.get(i);
            tmp.markNotDone();
            String taskStr = "OK, I've marked this task as not done yet:\n" + tmp + "\n";
            return taskStr;
        } catch (IndexOutOfBoundsException e) {
            throw new AikhsuException("Invalid task number!");
        }
    }

    /**
     * Adds a task to the TaskList and increments the counter.
     *
     * @param t The task to add to the TaskList.
     */
    public String addTask(Task t) {
        this.tasks.add(t);
        counter += 1;
        String taskStr = "Got it. I've added this task:\n" + t + '\n'
                + "Now you have " + counter + " tasks in the list.\n";
        return taskStr;
    }

    /**
     * Lists all tasks in the TaskList. If no tasks are present, prints a message indicating so.
     */
    public String listTasks() {
        String taskStr;
        if (counter == 0) {
            taskStr = "No tasks saved!\n";
            return taskStr;
        }
        taskStr = "Here are the tasks in your list:\n";
        for (int i = 0; i < counter; i++) {
            taskStr += (i + 1) + ". " + tasks.get(i) + "\n";
        }
        return taskStr;
    }

    /**
     * Finds and lists tasks whose descriptions contain the specified search string.
     *
     * @param finder The string to search for in task descriptions.
     * @return A string listing the matching tasks, or a message if none are found.
     */
    public String findTasks(String finder) {
        String taskStr = "Here are the matching tasks in your list:\n";
        int index = 1;
        for (int i = 0; i < counter; i++) {
            Task tmp = tasks.get(i);
            if (!tmp.getDescription().contains(finder)) {
                continue;
            }
            String tmpStr = index + ". " + tmp + "\n";
            taskStr += tmpStr;
            index += 1;
        }
        return taskStr;
    }

    /**
     * Finds and lists tasks scheduled for the specified date (for Deadline and Event tasks).
     * Tasks are sorted by their date and time.
     *
     * @param date The date to search for tasks.
     * @return A string listing the tasks for the given date, or a message if none are found.
     */
    public String findTasksByDate(LocalDate date) {
        ArrayList<Pair<Task, LocalDateTime>> res = new ArrayList<>();

        for (Task tmp : tasks) {
            if (!(tmp instanceof Deadline) && !(tmp instanceof Event)) {
                continue;
            }

            LocalDateTime tmpDateTime = null;
            if (tmp instanceof Deadline) {
                Deadline deadlineTmp = (Deadline) tmp;
                tmpDateTime = deadlineTmp.getDateTime();
            }
            if (tmp instanceof Event) {
                Event eventTmp = (Event) tmp;
                tmpDateTime = eventTmp.getDateTime();
            }

            if (tmpDateTime == null || !(tmpDateTime.toLocalDate().equals(date))) {
                continue;
            }

            res.add(new Pair<>(tmp, tmpDateTime));
        }

        if (res.isEmpty()) {
            return "There are no tasks on that Date!\n";
        }

        res.sort((d1, d2) -> d1.getValue().compareTo(d2.getValue()));
        String resString = "Here are your tasks for " + date + ":\n";
        for (int i = 0; i < res.size(); i++) {
            Task tmp = res.get(i).getKey();
            resString += tmp + "\n";
        }
        return resString;
    }

    /**
     * Returns the list of tasks in the TaskList.
     *
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}
