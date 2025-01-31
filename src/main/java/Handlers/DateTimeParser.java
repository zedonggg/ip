package Handlers;

import Exceptions.AikhsuException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeParser {
    public static LocalDateTime parseDateTime(String dateTime) throws AikhsuException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            return LocalDateTime.parse(dateTime, format);
        } catch (DateTimeParseException e) {
            throw new AikhsuException("Invalid date and time format! Format must be in the form dd/mm/yyyy xx:xx eg 01/01/2025 16:59");
        }
    }

    public static LocalDate parseDate(String date) throws AikhsuException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(date, format);
        } catch (DateTimeParseException e) {
            throw new AikhsuException("Invalid date format! Format must be of the form dd/mm/yyyy");
        }
    }

    public static LocalTime parseTime(String time) throws AikhsuException {
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            throw new AikhsuException("Invalid time format! Format must be of the form xx:xx");
        }
    }
}
