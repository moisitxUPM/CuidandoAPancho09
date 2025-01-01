package org.pancho.model.commands;

import org.pancho.controller.CareController;
import org.pancho.controller.PetController;
import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.ICommand;
import org.pancho.model.Owner;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;

public class CreateCareCommand implements ICommand {

        public static final String COMMAND_NAME = "create-care";

        @Override
        public String getCommandName() {
            return COMMAND_NAME;
        }

        @Override
        public void execute(String[] args) {
            CareController careController = CareController.getCareController();
            PetController petController = PetController.getPetController();
            UserController userController = UserController.getUserController();

            //Date startDate, Date endDate, Double cost, boolean paid, int panchoPoints, Pet pet
            if (Utilities.validNumberOfParameters(args, 5)){
                if (Utilities.isValidDate(args[0], args[1])){
                    if(Utilities.isDouble(args[2])){
                        if (Utilities.isInteger(args[3])){
                            if (petController.getPet(args[4])!=null) {
                                if (userController.whoIsLoggedIn()!=null){
                                    if (userController.whoIsLoggedIn() instanceof Owner){
                                        if(careController.getCare(petController.getPet(args[4]))==null){
                                            if(petController.userHasPet((Owner) userController.whoIsLoggedIn(), args[4])){
                                                careController.createCare(Utilities.stringToDate(args[0]), Utilities.stringToDate(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), petController.getPet(args[4]));                                                SystemMessagePrinter.print(SuccessMessage.CARE_CREATED);
                                            }else{
                                                SystemMessagePrinter.print(ErrorMessage.USER_NOT_OWNER_OF_PET);
                                            }
                                        }else{
                                            SystemMessagePrinter.print(ErrorMessage.PET_ALREADY_HAS_CARE);
                                        }
                                    }else{
                                        SystemMessagePrinter.print(ErrorMessage.USER_NOT_OWNER);
                                    }
                                }else{
                                    SystemMessagePrinter.print(ErrorMessage.INVALID_LOGIN);
                                }
                            }
                            else {
                                SystemMessagePrinter.print(ErrorMessage.INVALID_PET);
                            }
                        }
                        else {
                            SystemMessagePrinter.print(ErrorMessage.INVALID_PANCHO_POINTS);
                        }
                    }
                    else {
                        SystemMessagePrinter.print(ErrorMessage.INVALID_COST);
                    }
                }
                else {
                    SystemMessagePrinter.print(ErrorMessage.INVALID_DATE);
                }
            }
            else {
                SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
            }
        }
}
