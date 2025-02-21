package handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import exceptions.AikhsuException;

public class DateTimeParserTest {

    @Test
    public void testParseDateTimeValidInput() throws AikhsuException {
        String input = "01/01/2025 16:59";
        LocalDateTime expected = LocalDateTime.of(2025, 1, 1, 16, 59);
        assertEquals(expected, DateTimeParser.parseDateTime(input));
    }

    @Test
    public void testParseDateTimeInvalidInput() {
        String input = "invalid date time";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> {
            DateTimeParser.parseDateTime(input);
        });
        assertEquals("Invalid date and time format! "
                + "Format must be in the form dd/mm/yyyy xx:xx eg 01/01/2025 16:59", exception.getMessage());
    }

    @Test
    public void testParseDateValidInput() throws AikhsuException {
        String input = "01/01/2025";
        LocalDate expected = LocalDate.of(2025, 1, 1);
        assertEquals(expected, DateTimeParser.parseDate(input));
    }

    @Test
    public void testParseDateInvalidInput() {
        String input = "2025-01-01";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> {
            DateTimeParser.parseDate(input);
        });
        assertEquals("Invalid date format! Format must be of the form dd/mm/yyyy", exception.getMessage());
    }

    @Test
    public void testParseTimeValidInput() throws AikhsuException {
        String input = "16:59";
        LocalTime expected = LocalTime.of(16, 59);
        assertEquals(expected, DateTimeParser.parseTime(input));
    }

    @Test
    public void testParseTimeInvalidInput() {
        String input = "16.59";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> {
            DateTimeParser.parseTime(input);
        });
        assertEquals("Invalid time format! Format must be of the form xx:xx", exception.getMessage());
    }
}
