package org.pancho.view;

import org.pancho.model.IPet;
import org.pancho.model.Pet;

import java.util.ArrayList;

/** */
public class PetView {

	public static void display(IPet pet) {
		System.out.println("Pet: " + pet.getName()+ " | " + "Owner: " + pet.getOwner().getName() + " | " + "RIAC Code: " +
				pet.getRIACCode() + " | " + "Address: " + pet.getAddress() + " | " + "Description: " +
				pet.getDescription() + " | " + "Policy Number: " + pet.getPolicyNumber() + " | " + "Type: " + pet.getType());
	}

	public static void listPets(ArrayList<Pet> pets) {
		for (Pet pet : pets) {
			display(pet);
		}
	}

	public static String petToString(IPet pet) {
		return pet.getRIACCode() + ";" +
				pet.getName() + ";" +
				pet.getAddress() + ";" +
				pet.getDescription() + ";" +
				pet.getPolicyNumber() + ";" +
				pet.getType() + ";" +
				pet.getOwner().getEmail();
	}
}