package org.pancho.model.commands;

import org.pancho.controller.CareController;
import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.Caretaker;
import org.pancho.model.ICommand;
import org.pancho.model.Owner;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.view.SystemMessagePrinter;

public class ListCaresCommand implements ICommand {
    public static final String COMMAND_NAME = "list-cares";
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        CareController careController = CareController.getCareController();
        UserController userController = UserController.getUserController();
        if(Utilities.validNumberOfParameters(args, 0)) {
            if (userController.whoIsLoggedIn() != null) {
                if (userController.whoIsLoggedIn() instanceof Owner) {
                    careController.showCareList();
                } else {
                    SystemMessagePrinter.print(ErrorMessage.USER_NOT_OWNER);
                }
            } else {
                SystemMessagePrinter.print(ErrorMessage.INVALID_LOGIN);
            }
        }else{
            SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
        }
    }

}
