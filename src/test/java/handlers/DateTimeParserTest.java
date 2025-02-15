package handlers;

import exceptions.AikhsuException;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class DateTimeParserTest {

    // Tests for parseDateTime method
    @Test
    void parseDateTime_validInput_parsedCorrectly() throws AikhsuException {
        String input = "01/01/2025 16:59";
        LocalDateTime expected = LocalDateTime.of(2025, 1, 1, 16, 59);
        LocalDateTime actual = DateTimeParser.parseDateTime(input);
        assertEquals(expected, actual, "Valid date-time should parse correctly");
    }

    @Test
    void parseDateTime_invalidFormat_throwsException() {
        String input = "01-01-2025 16:59";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseDateTime(input));
        assertEquals("Invalid date and time format! Format must be in the form dd/mm/yyyy xx:xx eg 01/01/2025 16:59",
                exception.getMessage(), "Exception message should match for invalid format");
    }

    @Test
    void parseDateTime_invalidDay_throwsException() {
        String input = "32/01/2025 16:59";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseDateTime(input));
        assertEquals("Invalid date and time format! Format must be in the form dd/mm/yyyy xx:xx eg 01/01/2025 16:59",
                exception.getMessage());
    }

    @Test
    void parseDateTime_invalidHour_throwsException() {
        String input = "01/01/2025 25:59";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseDateTime(input));
        assertEquals("Invalid date and time format! Format must be in the form dd/mm/yyyy xx:xx eg 01/01/2025 16:59",
                exception.getMessage());
    }

    @Test
    void parseDateTime_invalidMinute_throwsException() {
        String input = "01/01/2025 16:60";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseDateTime(input));
        assertEquals("Invalid date and time format! Format must be in the form dd/mm/yyyy xx:xx eg 01/01/2025 16:59",
                exception.getMessage());
    }

    @Test
    void parseDateTime_validLeapDay_parsedCorrectly() throws AikhsuException {
        String input = "29/02/2024 12:00";
        LocalDateTime expected = LocalDateTime.of(2024, 2, 29, 12, 0);
        LocalDateTime actual = DateTimeParser.parseDateTime(input);
        assertEquals(expected, actual, "Valid leap day should parse correctly");
    }

    // Tests for parseDate method
    @Test
    void parseDate_validInput_parsedCorrectly() throws AikhsuException {
        String input = "01/01/2025";
        LocalDate expected = LocalDate.of(2025, 1, 1);
        LocalDate actual = DateTimeParser.parseDate(input);
        assertEquals(expected, actual, "Valid date should parse correctly");
    }

    @Test
    void parseDate_invalidFormat_throwsException() {
        String input = "2025/01/01";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseDate(input));
        assertEquals("Invalid date format! Format must be of the form dd/mm/yyyy",
                exception.getMessage(), "Exception message should match for invalid format");
    }

    @Test
    void parseDate_invalidDay_throwsException() {
        String input = "32/01/2025";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseDate(input));
        assertEquals("Invalid date format! Format must be of the form dd/mm/yyyy",
                exception.getMessage());
    }

    @Test
    void parseDate_invalidMonth_throwsException() {
        String input = "01/13/2025";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseDate(input));
        assertEquals("Invalid date format! Format must be of the form dd/mm/yyyy",
                exception.getMessage());
    }

    @Test
    void parseDate_validLeapDay_parsedCorrectly() throws AikhsuException {
        String input = "29/02/2024";
        LocalDate expected = LocalDate.of(2024, 2, 29);
        LocalDate actual = DateTimeParser.parseDate(input);
        assertEquals(expected, actual, "Valid leap day should parse correctly");
    }

    // Tests for parseTime method
    @Test
    void parseTime_validInput_parsedCorrectly() throws AikhsuException {
        String input = "16:59";
        LocalTime expected = LocalTime.of(16, 59);
        LocalTime actual = DateTimeParser.parseTime(input);
        assertEquals(expected, actual, "Valid time should parse correctly");
    }

    @Test
    void parseTime_invalidHour_throwsException() {
        String input = "25:00";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseTime(input));
        assertEquals("Invalid time format! Format must be of the form xx:xx",
                exception.getMessage(), "Exception message should match for invalid hour");
    }

    @Test
    void parseTime_invalidMinute_throwsException() {
        String input = "12:60";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseTime(input));
        assertEquals("Invalid time format! Format must be of the form xx:xx",
                exception.getMessage());
    }

    @Test
    void parseTime_singleDigitHour_throwsException() {
        String input = "1:05";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseTime(input));
        assertEquals("Invalid time format! Format must be of the form xx:xx",
                exception.getMessage());
    }

    @Test
    void parseTime_singleDigitMinute_throwsException() {
        String input = "12:5";
        AikhsuException exception = assertThrows(AikhsuException.class, () -> DateTimeParser.parseTime(input));
        assertEquals("Invalid time format! Format must be of the form xx:xx",
                exception.getMessage());
    }
}