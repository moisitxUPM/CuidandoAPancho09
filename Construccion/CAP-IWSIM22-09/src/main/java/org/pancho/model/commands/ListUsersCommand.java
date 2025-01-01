package org.pancho.model.commands;

import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.ICommand;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.view.SystemMessagePrinter;

public class ListUsersCommand implements ICommand {
    public static final String COMMAND_NAME = "list-users";
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        UserController userController = UserController.getUserController();
        if(Utilities.validNumberOfParameters(args, 0)){
            userController.showUserList();
        }
        else {
            SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
        }
    }
}
