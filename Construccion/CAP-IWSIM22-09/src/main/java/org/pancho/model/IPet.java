package org.pancho.model;

import java.util.ArrayList;

public interface IPet {
    String getRIACCode();
    String getName();
    String getAddress();
    String getDescription();
    int getPolicyNumber();
    String getType();
    Owner getOwner();
}
