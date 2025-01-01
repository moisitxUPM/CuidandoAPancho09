package org.pancho.controller;

import org.pancho.model.Care;
import org.pancho.model.Pet;
import org.pancho.view.CareView;

import java.util.ArrayList;
import java.util.Date;

/** */
public class CareController {
	//singleton
	private static CareController careController;
	private ArrayList<Care> careList;

	private CareController(){
		this.careList = new ArrayList<>();
	}

	public static CareController getCareController(){
		if(careController == null){
			careController = new CareController();
		}
		return careController;
	}

	public void showCareList(){
		for (Care care : careList) {
			CareView.display(care);
		}
	}

	public String careToString(Care care) {
		return CareView.careToString(care);
	}

	public void createCare(Date startDate, Date endDate, Double cost, int panchoPoints, Pet pet){
		PetController petController = PetController.getPetController();
		Care care = new Care(startDate, endDate, cost, panchoPoints, pet);

		addCare(care);
		pet.addCare(care);
	}

	public ArrayList<Care> getCareList() {
		return careList;
	}

	public Care getCare(Pet pet){
		for (Care care : careList){
			if (care.getPet().equals(pet)){
				return care;
			}
		}
		return null;
	}

	public void setCareList(ArrayList<Care> careList) {
		this.careList = careList;
	}

	public void addCare(Care care) {
		careList.add(care);
	}

	public void removeCare(Care care) {
		careList.remove(care);
	}
}
