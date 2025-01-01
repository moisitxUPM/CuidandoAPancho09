package org.pancho.controller;

import org.pancho.model.ICommand;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persistance.getInstance().loadData();
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║     Welcome to Cuidando a Pancho!!!     ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println("Type 'help' to see the list of available commands");
        CommandManager manager = CommandManager.getInstance();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String line = in.nextLine();

            String[] commands = CommandUtil.tokenizerArgs(line);
            String commandName = commands[0];
            String[] commandArgs = null;
            if (commands.length > 1) {
                commandArgs = Arrays.copyOfRange(commands, 1, commands.length);
            }
            ICommand command = manager.getCommand(commandName);
            command.execute(commandArgs);
            System.out.println("");
        }
    }
}
