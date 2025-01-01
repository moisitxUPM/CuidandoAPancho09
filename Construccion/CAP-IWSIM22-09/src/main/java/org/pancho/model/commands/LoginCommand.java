package org.pancho.model.commands;

import org.pancho.controller.UserController;
import org.pancho.controller.Utilities;
import org.pancho.model.ICommand;
import org.pancho.model.User;
import org.pancho.model.enums.ErrorMessage;
import org.pancho.model.enums.SuccessMessage;
import org.pancho.view.SystemMessagePrinter;
import utilidades.Cifrado;

import java.util.UUID;

public class LoginCommand implements ICommand {

    public static final String COMMAND_NAME = "login";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    private String generateOAuthToken() {
        return UUID.randomUUID().toString();
    }


    @Override
    public void execute(String[] args) { //email, password
        UserController userController = UserController.getUserController();

        if (Utilities.validNumberOfParameters(args, 0)){
            if(userController.whoIsLoggedIn()==null){
                User user = userController.logUser();
                if(user!=null){
                    user.setOauthId(Cifrado.cifrar(user.getEmail()+"I'm a pufferfish'"));
                    SystemMessagePrinter.print(SuccessMessage.LOGIN_SUCCESSFUL);
                }else{
                    SystemMessagePrinter.print(ErrorMessage.INVALID_LOGIN);
                }
            }else{
                SystemMessagePrinter.print(ErrorMessage.ALREADY_LOGGED_IN);
            }
        } else {
            SystemMessagePrinter.print(ErrorMessage.INVALID_NUMBER_OF_PARAMETERS);
        }
    }
}