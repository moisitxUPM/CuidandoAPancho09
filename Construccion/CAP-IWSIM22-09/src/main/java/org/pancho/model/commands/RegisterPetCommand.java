package org.pancho.model.commands;

import org.pancho.controller.PetController;
import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.ICommand;
import org.pancho.model.Owner;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;

public class RegisterPetCommand implements ICommand {
    //register-pet RIACcode;name;address;description;policyNumber;type

    public static final String COMMAND_NAME = "register-pet";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {//String RIACCode, String name, String address, String description, int policyNumber, String type, Owner owner
        PetController petController = PetController.getPetController();
        UserController userController = UserController.getUserController();
        if (Utilities.validNumberOfParameters(args, 6)){
            if (petController.validRIAC(args[0])){
                if (Utilities.isInteger(args[4])){
                    if (userController.whoIsLoggedIn()!=null){
                        if (userController.whoIsLoggedIn() instanceof Owner){
                            if(petController.getPet(args[0])==null){
                                petController.registerPet(args[0], args[1], args[2], args[3], Integer.parseInt(args[4]), args[5], (Owner) userController.whoIsLoggedIn());
                                SystemMessagePrinter.print(SuccessMessage.PET_CREATED);
                            }else{
                                SystemMessagePrinter.print(ErrorMessage.PET_ALREADY_EXISTS);
                            }
                        }else{
                            SystemMessagePrinter.print(ErrorMessage.USER_NOT_OWNER);
                        }
                    }else{
                        SystemMessagePrinter.print(ErrorMessage.INVALID_LOGIN);
                    }
                }else{
                    SystemMessagePrinter.print(ErrorMessage.INVALID_POLICY_NUMBER);
                }
            }else{
                SystemMessagePrinter.print(ErrorMessage.INVALID_RIAC_CODE);
            }
        } else {
            SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
        }
    }
}
