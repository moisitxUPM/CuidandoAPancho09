package org.pancho.model.commands;

import org.pancho.model.ICommand;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.view.SystemMessagePrinter;

public class NotFoundCommand implements ICommand {

        @Override
        public String getCommandName() {
            return "notfound";
        }

        @Override
        public void execute(String[] args) {
            SystemMessagePrinter.print(ErrorMessage.COMMAND_NOT_FOUND);
        }
}
