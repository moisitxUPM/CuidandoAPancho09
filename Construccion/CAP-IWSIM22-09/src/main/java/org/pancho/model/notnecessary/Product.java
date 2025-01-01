package org.pancho.model.notnecessary;

import java.util.Date;

/** */
public class Product extends Prize {
	/** */
	private String name;

	/** */
	private String description;

	/** */
	public Product(int id, Double cost, Date purchaseDate, String name, String description) {
		super(id, cost, purchaseDate);
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
