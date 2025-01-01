package org.pancho.model;

import java.util.ArrayList;

/** */
public class Pet implements IPet{
	/** */
	private String RIACCode;

	/** */
	private String name;

	/** */
	private String address;

	/** */
	private String description;

	/** */
	private int policyNumber;

	/** */
	private String type;

	private Owner owner;

	private ArrayList<Care> cares;

	private ArrayList<Caretaker> caretaker;

	/** */
	public Pet(String RIACCode, String name, String address, String description, int policyNumber, String type, Owner owner) {
		this.cares = new ArrayList<Care>();
		this.RIACCode = RIACCode;
		this.name = name;
		this.address = address;
		this.description = description;
		this.policyNumber = policyNumber;
		this.type = type;
		this.owner = owner;
	}

	public String getRIACCode() {
		return RIACCode;
	}

	public void setRIACCode(String RIACCode) {
		this.RIACCode = RIACCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public ArrayList<Care> getCares() {
		return cares;
	}

	public void setCares(ArrayList<Care> cares) {
		this.cares = cares;
	}

	public void addCare(Care care){
		cares.add(care);
	}

	public ArrayList<Caretaker> getCaretaker() {
		return caretaker;
	}

	public void setCaretaker(ArrayList<Caretaker> caretaker) {
		this.caretaker = caretaker;
	}
}
