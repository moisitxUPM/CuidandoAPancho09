package org.pancho.model;

public interface ICare {
    java.util.Date getStartDate();
    java.util.Date getEndDate();
    Double getCost();
    boolean isPaid();
    int getPanchoPoints();
    Caretaker getCaretaker();
    Pet getPet();
    int getId();
}
