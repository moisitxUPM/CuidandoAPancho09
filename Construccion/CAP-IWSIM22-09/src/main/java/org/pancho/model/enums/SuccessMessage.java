package org.pancho.model.enums;

import org.pancho.model.ISystemMessage;

import java.util.prefs.BackingStoreException;

public enum SuccessMessage implements ISystemMessage {

    LOGOUT_SUCCESSFUL("Logout successful."),
    CARE_CREATED("Care created successfully."),
    LOGIN_SUCCESSFUL("Logged in successfully."),
    CARETAKER_CREATED("Caretaker registered successfully."),
    OWNER_CREATED("Owner registered successfully."),
    PET_CREATED("Pet registered successfully."),
    BACKUP_SAVED("Backup created successfully for users, pets, and cares files.");

    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
