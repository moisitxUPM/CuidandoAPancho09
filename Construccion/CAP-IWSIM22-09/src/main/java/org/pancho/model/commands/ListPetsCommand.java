package org.pancho.model.commands;import org.pancho.controller.PetController;
import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.ICommand;
import org.pancho.model.Owner;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;

//list-pets

public class ListPetsCommand implements ICommand {
    public static final String COMMAND_NAME = "list-pets";
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        PetController petController = PetController.getPetController();
        UserController userController = UserController.getUserController();
        if(Utilities.validNumberOfParameters(args, 0)) {
            if (userController.whoIsLoggedIn() != null) {
                if (userController.whoIsLoggedIn() instanceof Owner) {
                    petController.showPetList((Owner) userController.whoIsLoggedIn());
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
