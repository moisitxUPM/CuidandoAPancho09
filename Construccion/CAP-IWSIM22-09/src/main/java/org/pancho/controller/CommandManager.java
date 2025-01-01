package org.pancho.controller;

import org.pancho.model.commands.*;
import org.pancho.model.ICommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    private static CommandManager commandManager;

    private static final List<ICommand> COMMANDS = new ArrayList<>();

    private CommandManager() {
        registCommand(new ExitCommand());
        registCommand(new RegisterOwnerCommand());
        registCommand(new RegisterCaretakerCommand());
        registCommand(new ListPetsCommand());
        registCommand(new ListCaresCommand());
        registCommand(new ListUsersCommand());
        registCommand(new LoginCommand());
        registCommand(new CreateCareCommand());
        registCommand(new HelpCommand());
        registCommand(new LogoutCommand());
        registCommand(new NotFoundCommand());
        registCommand(new RegisterPetCommand());
        registCommand(new LogoutCommand());
    }

    public static CommandManager getInstance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
    }

    public ICommand getCommand(String commandName) {
        for (ICommand command : COMMANDS) {
            if (command.getCommandName().equalsIgnoreCase(commandName)) {
                return command;
            }
        }
        return new NotFoundCommand();
    }

    public void registCommand(ICommand command) {
        COMMANDS.add(command);
    }
}