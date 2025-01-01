package org.pancho.controller;

import org.pancho.model.Owner;
import org.pancho.model.Pet;
import org.pancho.view.PetView;
import servidor.ExternalRIAC;
import servidor.ExternalRRSS;

import java.util.ArrayList;

/** */
public class PetController {
	//singleton
	private static PetController petController;
	private ArrayList<Pet> petList;

	private PetController(){
		this.petList = new ArrayList<>();
	}

	public static PetController getPetController(){
		if(petController == null){
			petController = new PetController();
		}
		return petController;
	}

	public void showPetList(Owner owner){
		for (Pet pet : owner.getPets()) {
			PetView.display(pet);
		}
	}
	public String petToString(Pet pet) {
		return PetView.petToString(pet);
	}


	public Pet getPet(String RIACCode){
		for(Pet pet : petList){
			if(pet.getRIACCode().equals(RIACCode)){
				return pet;
			}
		}
		return null;
	}

	public boolean userHasPet(Owner owner, String RIACCode){
		for(Pet pet : owner.getPets()){
			if(pet.getRIACCode().equals(RIACCode)){
				return true;
			}
		}
		return false;
	}

	public boolean validRIAC(String riac){
		return ExternalRIAC.RIAC(riac);
	}

	public void registerPet(String RIACCode, String name, String address, String description, int policyNumber, String type, Owner owner) {
		Pet pet = new Pet(RIACCode, name, address, description, policyNumber, type, owner);
		owner.getPets().add(pet);
		petList.add(pet);
	}

	public void addCareToPet(){

	}

	public ArrayList<Pet> getPetList() {
		return petList;
	}
}