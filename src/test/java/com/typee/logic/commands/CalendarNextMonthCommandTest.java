package com.typee.logic.commands;

import static com.typee.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import com.typee.model.Model;
import com.typee.model.ModelManager;

public class CalendarNextMonthCommandTest {

    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_calendarNextMonth_success() {
        CommandResult expectedCommandResult = new CommandResult(CalendarNextMonthCommand.MESSAGE_SUCCESS,
                true, CalendarNextMonthCommand.COMMAND_WORD);
        assertCommandSuccess(new CalendarNextMonthCommand(), model, expectedCommandResult, expectedModel);
    }

<<<<<<< HEAD
    @Test
    public void equals_identicalInstance_returnTrue() {
        final CalendarNextMonthCommand typicalInstance = new CalendarNextMonthCommand();
        assert(typicalInstance.equals(typicalInstance));
    }

=======
>>>>>>> 6cad22334ac04d02b3fb283714773a4db0717070
}
