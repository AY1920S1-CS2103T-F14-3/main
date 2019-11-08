package com.typee.logic.interactive.parser.state;

import static com.typee.testutil.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.typee.logic.commands.CalendarCloseDisplayCommand;
import com.typee.logic.commands.exceptions.CommandException;
import com.typee.logic.interactive.parser.ArgumentMultimap;
import com.typee.logic.interactive.parser.CliSyntax;
import com.typee.logic.interactive.parser.Prefix;
import com.typee.logic.interactive.parser.state.calendarstate.CalendarState;
import com.typee.logic.interactive.parser.state.calendarstate.CloseDisplayEndState;
import com.typee.logic.interactive.parser.state.exceptions.StateTransitionException;

public class CloseDisplayEndStateTest {

    private State closeDisplayEndState;

    @BeforeEach
    public void setup() {
        try {
            ArgumentMultimap argumentMultimap = new ArgumentMultimap();
            argumentMultimap.put(CliSyntax.PREFIX_CALENDAR, "closedisplay");
            closeDisplayEndState = new CalendarState(new ArgumentMultimap());
            closeDisplayEndState = closeDisplayEndState.transition(argumentMultimap);
            argumentMultimap.put(CliSyntax.PREFIX_DATE, "11/11/2019");
            closeDisplayEndState = closeDisplayEndState.transition(argumentMultimap);
        } catch (StateTransitionException e) {
            // StateTransitionException should not be thrown here.
        }
    }

    @Test
    public void buildCommand_validDate_returnsCalendarCloseDisplayCommand() {
        try {
            LocalDate validDate = LocalDate.of(2019, 11, 11);
            assertEquals(((CloseDisplayEndState) closeDisplayEndState).buildCommand(),
                    new CalendarCloseDisplayCommand(validDate));
        } catch (CommandException e) {
            // CommandException should not be thrown here.
        }
    }

    @Test
    public void transition() {
        ArgumentMultimap argumentMultimap = new ArgumentMultimap();
        State finalPostTransitionState = closeDisplayEndState;
        assertThrows(StateTransitionException.class, ()
            -> finalPostTransitionState.transition(argumentMultimap));
    }

    @Test
    public void getStateConstraints() {
        assertEquals(closeDisplayEndState.getStateConstraints(), "Closed engagement list window on the entered date.");
    }

    @Test
    public void isEndState() {
        assertTrue(closeDisplayEndState.isEndState());
    }

    @Test
    public void getPrefix() {
        assertEquals(closeDisplayEndState.getPrefix(), new Prefix(""));
    }

}
