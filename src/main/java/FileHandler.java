import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static String FILE_PATH;

    public static void saveTasks(TaskList tasks, String path) {
        ArrayList<Task> tmp = tasks.getTasks();
        FILE_PATH = path;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task t : tmp) {
                writer.write(t.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks(String path) {
        ArrayList<Task> tasks = new ArrayList<>();
        FILE_PATH = path;
        File save = new File(path);

        try {
            Scanner scanner = new Scanner(save);
            while (scanner.hasNextLine()) {
                Task tmp = parseTask(scanner.nextLine());
                if (tmp != null) {
                    tasks.add(tmp);
                }
            }
        } catch (FileNotFoundException e) {
            return tasks;
        }

        return tasks;
    }

    private static Task parseTask(String taskText) {
        String[] segments = taskText.split(" \\| ");
        if (segments.length < 3) {
            return null;
        }

        switch(segments[0]) {
            case "T":
                return new Todo(segments[2], segments[1].equals("true"));
            case "D":
                if (segments.length < 4) {
                    return null;
                }
                try {
                    LocalDateTime deadlineDateTime = DateTimeParser.parseDateTime(segments[3]);
                    return new Deadline(segments[2], segments[1].equals("true"), segments[3], deadlineDateTime);
                } catch (AikhsuException e) {
                    return null;
                }

            case "E":
                if (segments.length < 5) {
                    return null;
                }
                try {
                    LocalDateTime eventDateTime = DateTimeParser.parseDateTime(segments[3]);
                    LocalTime eventTime = DateTimeParser.parseTime(segments[4]);
                    return new Event(segments[2], segments[1].equals("true"), segments[3], segments[4], eventDateTime, eventTime);
                } catch (AikhsuException e) {
                    return null;
                }
            default:
                return null;
        }
    }

}
