package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.logic.CommandList;
import seedu.address.logic.CommandRemark;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;


public class HistoryCommandTest {

    private final Model model = new ModelManager();

    @Test
    public void execute_historyForFourCommands_success() {
        CommandList.clearAllCommand();
        CommandList.record("find n/ John1");
        CommandList.record("find n/ John2");
        CommandList.record("find n/ John3");
        CommandList.record("find n/ John4");

        Model expectedModel = new ModelManager();

        CommandResult expectedCommandResult = new CommandResult(HistoryCommand.MESSAGE_ON_HISTORY_SUCCESS
                + "find n/ John4\nfind n/ John3\nfind n/ John2", CommandRemark.HISTORY);
        assertCommandSuccess(new HistoryCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_historyForOneCommands_success() {
        CommandList.clearAllCommand();
        CommandList.record("find n/ John1");

        Model expectedModel = new ModelManager();

        CommandResult expectedCommandResult =
                new CommandResult(HistoryCommand.MESSAGE_ON_HISTORY_SUCCESS
                + "find n/ John1", CommandRemark.HISTORY);
        assertCommandSuccess(new HistoryCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_historyForNoCommands_fail() {
        CommandList.clearAllCommand();
        assertThrows(CommandException.class, HistoryCommand.MESSAGE_ON_EMPTY_HISTORY, () ->
                new HistoryCommand().execute(model));
    }

}
