package org.pancho.model;

import org.pancho.model.enums.LanguageEnum;

import java.util.ArrayList;

public class Owner extends User {
    private final ArrayList<Pet> pets;
    private ArrayList<Caretaker> favoriteCaretakers;


    public Owner(String name, String address, LanguageEnum language, String email) {
        super(name, address, language, email);
        this.pets = new ArrayList<Pet>();
    }

    public ArrayList<Pet> getPets() {
        return this.pets;
    }

    @Override
    public String getPhoto() {
        return "null";
    }

    @Override
    public String getDescription() {
        return "null";
    }

    @Override
    public Double getRate() {
        return 0.0;
    }

    @Override
    public Double getMaxDistance() {
        return 0.0;
    }

    @Override
    public String getIBAN() {
        return "null";
    }

    @Override
    public String getAccreditingDocument() {
        return "null";
    }
}