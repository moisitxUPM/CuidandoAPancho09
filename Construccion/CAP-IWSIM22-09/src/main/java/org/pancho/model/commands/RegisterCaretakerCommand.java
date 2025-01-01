package org.pancho.model.commands;

import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.ICommand;
import org.pancho.model.enums.LanguageEnum;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;
import servidor.Correo;

// register-caretaker moi;vallecas;youngmoi.jpg;100;10;en;moi@gmail;123456

public class RegisterCaretakerCommand implements ICommand {
    public static final String COMMAND_NAME = "register-caretaker";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) { //name, address, photo, rate, maxDistance, language, email
        UserController userController = UserController.getUserController();

        if (Utilities.validNumberOfParameters(args, 7)){
            if (Utilities.validLanguage(args[5])) {
                if(Utilities.upmEmail(args[6])) {
                    if(Utilities.isAPicture(args[2])) {
                        if(Utilities.isDouble(args[3]) && Utilities.isDouble(args[4])) {
                            if(!userController.existsUser(args[6])) {
                                userController.createCaretaker(args[0], args[1], args[2], Double.parseDouble(args[3]), Double.parseDouble(args[4]), LanguageEnum.fromValue(args[5]), args[6]);
                                //String email, String usuario
                                //correo.enviarEmail(args[6], args[0], args[7]);
                                SystemMessagePrinter.print(SuccessMessage.CARETAKER_CREATED);
                            } else {
                                SystemMessagePrinter.print(ErrorMessage.USER_ALREADY_EXISTS);
                            }
                        } else {
                            SystemMessagePrinter.print(ErrorMessage.INVALID_TYPE_OF_DATA);
                        }
                    } else {
                        SystemMessagePrinter.print(ErrorMessage.INVALID_PHOTO);
                    }
                } else {
                    SystemMessagePrinter.print(ErrorMessage.NO_UPM_EMAIL);
                }
            }
            else {
                SystemMessagePrinter.print(ErrorMessage.INVALID_LANGUAGE);
            }
        }
        else {
            SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
        }
    }
}
