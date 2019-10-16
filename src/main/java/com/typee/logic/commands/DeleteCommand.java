package com.typee.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import com.typee.commons.core.Messages;
import com.typee.commons.core.index.Index;
import com.typee.logic.commands.exceptions.CommandException;
import com.typee.model.Model;
import com.typee.model.engagement.Engagement;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person identified by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Person: %1$s";

    private final Index targetIndex;

    public DeleteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Engagement> lastShownList = model.getFilteredEngagementList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }


        Engagement engagementToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteEngagement(engagementToDelete);
        model.saveEngagementList();
        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, engagementToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand) other).targetIndex)); // state check
    }
}
