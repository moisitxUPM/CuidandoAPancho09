package org.pancho.model.commands;

import org.pancho.model.ICommand;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelpCommand implements ICommand{

    public static final String COMMAND_NAME = "help";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        // Get current date in the desired format
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);

        // Print available commands with the current date
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║             Available commands:         ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Current Date: " + formattedDate);
        System.out.println();
        System.out.println(" ➜ register-owner name;address;language;email");
        System.out.println(" ➜ register-caretaker name;address;photo;rate;maxDistance;language;email");
        System.out.println(" ➜ register-pet RIACcode;name;address;description;policyNumber;type");
        System.out.println(" ➜ create-care startDate;endDate;cost;panchoPoints;pet");
        System.out.println(" ➜ login");
        System.out.println(" ➜ logout");
        System.out.println(" ➜ list-pets");
        System.out.println(" ➜ list-cares");
        System.out.println(" ➜ list-users");
        System.out.println(" ➜ exit");
    }
}
