package com.typee.logic.commands;

import java.time.LocalDate;

import com.typee.model.Model;

/**
 * Displays the engagements list for a particular date in the calendar window.
 */
public class CalendarDateDisplayEngagementsCommand extends CalendarCommand {

    public static final String COMMAND_WORD = "display";
    public static final String MESSAGE_SUCCESS = "Displaying engagements for ";
    public static final String INVALID_COMMAND_FORMAT = "Invalid calendar display command format.\n"
            + "Usage: calendar display DD/MM/YYYY\n";

    private LocalDate date;

    public CalendarDateDisplayEngagementsCommand(LocalDate date) {
        this.date = date;
    }

    @Override
    public CommandResult execute(Model model) {
        String dayString = String.format("%02d", date.getDayOfMonth());
        String monthString = String.format("%02d", date.getMonthValue());
        String yearString = String.format("%04d", date.getYear());
        String formattedDateString = String.format("%s/%s/%s", dayString, monthString, yearString);
        return new CommandResult(MESSAGE_SUCCESS + formattedDateString, true, date, COMMAND_WORD);
    }

}
