package Commands;

import Exceptions.AikhsuException;
import Tasks.TaskList;
import Tasks.Todo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteCommandTest {
    private static final String INVALID_INDEX_MESSAGE = "Please provide a number!";
    private static final String TASK_NOT_EXISTS_MESSAGE = "Tasks.Task does not exist!";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent)); // Redirect System.out to capture console output
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); // Restore original System.out
    }

    @Test
    void execute_validIndex_deletesTaskAndReturnsSuccessMessage() throws AikhsuException {
        // Set up TaskList with a Todo task
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("Read a book"));

        DeleteCommand command = new DeleteCommand("1");
        command.setTasks(taskList);

        CommandResult result = command.execute();

        // Verify console output
        String expectedOutput = "____________________________________________________________\n" +
                "Got it. I've added this task:\n" +
                "[T][ ] Read a book\n" +
                "Now you have 1 tasks in the list.\n" +
                "____________________________________________________________\n" +
                "____________________________________________________________\n" +
                "Noted. I've removed this task:\n" +
                "[T][ ] Read a book\n" +
                "Now you have 0 tasks in the list.\n" +
                "____________________________________________________________\n";
        assertEquals(expectedOutput, outContent.toString());

        // Verify CommandResult
        assertEquals("Task deleted successfully!", result.commandOutput);
    }

    @Test
    void execute_invalidIndexFormat_returnsInvalidIndexMessage() {
        // Set up TaskList (no tasks added)
        TaskList taskList = new TaskList();
        DeleteCommand command = new DeleteCommand("abc");
        command.setTasks(taskList);

        CommandResult result = command.execute();

        // Verify console output (no output expected for invalid index)
        assertEquals("", outContent.toString());

        // Verify CommandResult
        assertEquals(INVALID_INDEX_MESSAGE, result.commandOutput);
    }

    @Test
    void execute_taskIndexOutOfBounds_returnsTaskNotExistsMessage() throws AikhsuException {
        // Set up TaskList with one task
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("Read a book"));

        DeleteCommand command = new DeleteCommand("5"); // Index out of bounds
        command.setTasks(taskList);

        CommandResult result = command.execute();

        // Verify console output (only the add task output should be present)
        String expectedOutput = "____________________________________________________________\n" +
                "Got it. I've added this task:\n" +
                "[T][ ] Read a book\n" +
                "Now you have 1 tasks in the list.\n" +
                "____________________________________________________________\n";
        assertEquals(expectedOutput, outContent.toString());

        // Verify CommandResult
        assertEquals(TASK_NOT_EXISTS_MESSAGE, result.commandOutput);
    }

    @Test
    void execute_indexZero_returnsTaskNotExistsMessage() throws AikhsuException {
        // Set up TaskList with one task
        TaskList taskList = new TaskList();
        taskList.addTask(new Todo("Read a book"));

        DeleteCommand command = new DeleteCommand("0"); // Invalid index
        command.setTasks(taskList);

        CommandResult result = command.execute();

        // Verify console output (only the add task output should be present)
        String expectedOutput = "____________________________________________________________\n" +
                "Got it. I've added this task:\n" +
                "[T][ ] Read a book\n" +
                "Now you have 1 tasks in the list.\n" +
                "____________________________________________________________\n";
        assertEquals(expectedOutput, outContent.toString());

        // Verify CommandResult
        assertEquals(TASK_NOT_EXISTS_MESSAGE, result.commandOutput);
    }

    @Test
    void execute_emptyTaskList_returnsTaskNotExistsMessage() throws AikhsuException {
        // Set up empty TaskList
        TaskList taskList = new TaskList();
        DeleteCommand command = new DeleteCommand("1"); // No tasks exist
        command.setTasks(taskList);

        CommandResult result = command.execute();

        // Verify console output (no output expected for empty list)
        assertEquals("", outContent.toString());

        // Verify CommandResult
        assertEquals(TASK_NOT_EXISTS_MESSAGE, result.commandOutput);
    }
}