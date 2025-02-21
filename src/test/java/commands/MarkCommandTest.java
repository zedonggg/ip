package commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tasks.TaskList;
import tasks.Todo;

public class MarkCommandTest {

    private TaskList taskList;

    @BeforeEach
    public void setup() {
        // Create a TaskList and add one Todo task.
        taskList = new TaskList();
        taskList.addTask(new Todo("read book"));
    }

    @Test
    public void testExecuteValidMark() {
        // Test with a valid index ("1")
        MarkCommand markCommand = new MarkCommand("1");
        markCommand.setTasks(taskList);
        CommandResult result = markCommand.execute();
        // The expected output is based on the Todo's toString:
        // Todo.toString() returns "[T]" + super.toString(), and Task.toString() returns
        // "[" + getStatusIcon() + "] " + description, so once marked as done,
        // the task becomes "[T][X] read book".
        String expected = "Nice! I've marked this task as done:\n[T][X] read book\n";
        assertEquals(expected, result.getCommandOutput());
    }

    @Test
    public void testExecuteInvalidIndexFormat() {
        // Test with a non-numeric index which should produce an error message.
        MarkCommand markCommand = new MarkCommand("abc");
        markCommand.setTasks(taskList);
        CommandResult result = markCommand.execute();
        String expected = "Please provide a number!";
        assertEquals(expected, result.getCommandOutput());
    }

    @Test
    public void testExecuteNonExistentTask() {
        // Test with an index ("2") that doesn't correspond to any task in the TaskList.
        MarkCommand markCommand = new MarkCommand("2");
        markCommand.setTasks(taskList);
        CommandResult result = markCommand.execute();
        String expected = "Tasks.Task does not exist!";
        assertEquals(expected, result.getCommandOutput());
    }
}
