package org.pancho.model;


import org.pancho.model.enums.LanguageEnum;

import java.util.ArrayList;

/** */
public class Caretaker extends User {
	/** */
	private String photo;

	/** */
	private String description;

	/** */
	private Double rate;

	/** */
	private Double maxDistance;

	/** */
	private String IBAN;

	/** */
	private String accreditingDocument;

	/** */
	private int panchoPoints;

	private ArrayList<Care> cares;

	private ArrayList<Pet> pets;


	/** */
	public Caretaker(String name, String address, String photo, double rate, double maxDistance, LanguageEnum language, String email) {
		super(name, address, language, email);
		this.photo = photo;
		this.description = description;
		this.rate = rate;
		this.maxDistance = maxDistance;
		this.IBAN = IBAN;
		this.accreditingDocument = accreditingDocument;
		this.panchoPoints = 0;
		this.cares = new ArrayList<Care>();
		this.pets = new ArrayList<Pet>();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(Double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	public String getAccreditingDocument() {
		return accreditingDocument;
	}

	public void setAccreditingDocument(String accreditingDocument) {
		this.accreditingDocument = accreditingDocument;
	}

	public void setPanchoPoints(int panchoPoints) {
		this.panchoPoints = panchoPoints;
	}

	public ArrayList<Care> getCares() {
		return cares;
	}

	public void setCares(ArrayList<Care> cares) {
		this.cares = cares;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
}
