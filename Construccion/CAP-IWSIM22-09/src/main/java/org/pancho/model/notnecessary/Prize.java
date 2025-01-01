package org.pancho.model.notnecessary;

import java.util.Date;

/** */
public class Prize {
	/** */
	private int id;

	/** */
	private Double cost;

	/** */
	private Date purchaseDate;

	/** */
	public Prize(int id, Double cost, Date purchaseDate) {
		this.id = id;
		this.cost = cost;
		this.purchaseDate = purchaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}