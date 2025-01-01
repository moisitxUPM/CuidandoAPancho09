package org.pancho.model;

import java.util.Date;

/** */
public class Care implements ICare{
	/** */
	private int id;
	/** */
	private static int counter = 0;

	/** */
	private Date startDate;

	/** */
	private Date endDate;

	/** */
	private Double cost;

	/** */
	private boolean paid;

	/** */
	private int panchoPoints;

	private Caretaker caretaker; //No se necesita para implementar crear cuidados y listar cuidados

	private Pet pet;

	/** */
	public Care(Date startDate, Date endDate, Double cost, int panchoPoints, Pet pet) {
		this.id = ++counter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cost = cost;
		this.paid = false;
		this.panchoPoints = panchoPoints;
		this.pet = pet;
		this.caretaker = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Care.counter = counter;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public int getPanchoPoints() {
		return panchoPoints;
	}

	public void setPanchoPoints(int panchoPoints) {
		this.panchoPoints = panchoPoints;
	}

	public Caretaker getCaretaker() {
		return caretaker;
	}

	public void setCaretaker(Caretaker caretaker) {
		this.caretaker = caretaker;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}


}
