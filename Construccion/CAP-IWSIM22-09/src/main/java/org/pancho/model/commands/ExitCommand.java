package org.pancho.model.commands;

import org.pancho.controller.*;
import org.pancho.model.ICommand;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;

//exit

public class ExitCommand implements ICommand {

    public static final String COMMAND_NAME = "exit";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {

        if(Utilities.validNumberOfParameters(args, 0)){
            Persistance.getInstance().saveData();
            SystemMessagePrinter.print(SuccessMessage.BACKUP_SAVED);
            System.exit(0);
        }
        else {
            SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
        }
    }
}
