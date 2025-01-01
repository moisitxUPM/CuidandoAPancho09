package org.pancho.model.commands;

import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.ICommand;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;

public class LogoutCommand implements ICommand {
    public static final String COMMAND_NAME = "logout";
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        UserController userController = UserController.getUserController();

        if (Utilities.validNumberOfParameters(args, 0)){
            if(userController.whoIsLoggedIn() != null){
                userController.logout();
                SystemMessagePrinter.print(SuccessMessage.LOGOUT_SUCCESSFUL);
            } else {
                SystemMessagePrinter.print(ErrorMessage.INVALID_LOGIN);
            }
        }
        else {
            SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
        }
    }
}

