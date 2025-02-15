package Handlers;

import Exceptions.AikhsuException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility class for parsing date and time strings into Java time objects.
 * Provides methods to convert formatted date/time strings into {@code LocalDateTime}, {@code LocalDate}, and {@code LocalTime}.
 */
public class DateTimeParser {
    /**
     * Parses a date-time string into a {@code LocalDateTime} object.
     *
     * @param dateTime The date-time string to be parsed, expected in the format {@code dd/MM/yyyy HH:mm}.
     * @return A {@code LocalDateTime} object representing the parsed date and time.
     * @throws AikhsuException If the input format is invalid.
     */
    public static LocalDateTime parseDateTime(String dateTime) throws AikhsuException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            return LocalDateTime.parse(dateTime, format);
        } catch (DateTimeParseException e) {
            throw new AikhsuException("Invalid date and time format! Format must be in the form dd/mm/yyyy xx:xx eg 01/01/2025 16:59");
        }
    }

    /**
     * Parses a date string into a {@code LocalDate} object.
     *
     * @param date The date string to be parsed, expected in the format {@code dd/MM/yyyy}.
     * @return A {@code LocalDate} object representing the parsed date.
     * @throws AikhsuException If the input format is invalid.
     */
    public static LocalDate parseDate(String date) throws AikhsuException {
        assert date != null && !date.trim().isEmpty() : "Date cannot be null or empty!";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(date, format);
        } catch (DateTimeParseException e) {
            throw new AikhsuException("Invalid date format! Format must be of the form dd/mm/yyyy");
        }
    }

    /**
     * Parses a time string into a {@code LocalTime} object.
     *
     * @param time The time string to be parsed, expected in the format {@code HH:mm}.
     * @return A {@code LocalTime} object representing the parsed time.
     * @throws AikhsuException If the input format is invalid.
     */
    public static LocalTime parseTime(String time) throws AikhsuException {
        assert time != null && !time.trim().isEmpty() : "Date cannot be null or empty!";
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            throw new AikhsuException("Invalid time format! Format must be of the form xx:xx");
        }
    }
}
