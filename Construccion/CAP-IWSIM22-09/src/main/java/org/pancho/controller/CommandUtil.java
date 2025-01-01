package org.pancho.controller;

public class CommandUtil {
    public static String[] tokenizerArgs(String args) {
        String[] parts = args.split(" ", 2);
        String command = parts[0];
        String[] arguments;

        if (parts.length > 1) {
            arguments = parts[1].split(";");
        } else {
            arguments = new String[0];
        }

        // Initialize an array to hold the result
        String[] result = new String[arguments.length + 1];

        // The first element of the result is the command
        result[0] = command;

        // Copy the arguments into the result array, starting from the second position
        for (int i = 0; i < arguments.length; i++) {
            result[i + 1] = arguments[i];
        }

        // Return the result array
        return result;
    }
}