package org.pancho.view;

import org.pancho.model.ISystemMessage;

public class SystemMessagePrinter {
    public static void print(ISystemMessage message) {
        System.out.println(message.getMessage());
    }
}
