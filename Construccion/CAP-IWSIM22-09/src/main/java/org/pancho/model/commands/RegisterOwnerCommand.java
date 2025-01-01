package org.pancho.model.commands;

import org.pancho.model.ICommand;
import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.enums.LanguageEnum;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;
import servidor.Correo;

//register-owner moi;vallecas;es;moi@gmail;1234

public class RegisterOwnerCommand implements ICommand {
    public static final String COMMAND_NAME = "register-owner";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) { //name, address, language, email
        UserController userController = UserController.getUserController();
        Correo correo = new Correo();

        if (Utilities.validNumberOfParameters(args, 4)){
            if (Utilities.validLanguage(args[2])) {
                if(Utilities.upmEmail(args[3])) {
                    if(!userController.existsUser(args[3])) {
                        userController.createOwner(args[0], args[1],LanguageEnum.fromValue(args[2]), args[3]);
                        //String email, String usuario
                        //correo.enviarEmail(args[3], args[0], args[4]);
                        SystemMessagePrinter.print(SuccessMessage.OWNER_CREATED);
                    } else {
                        SystemMessagePrinter.print(ErrorMessage.USER_ALREADY_EXISTS);
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
