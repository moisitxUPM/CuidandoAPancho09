package org.pancho.model.notnecessary;

import org.pancho.model.enums.OfferStatus;

/** */
public class Offer {
	/** */
	private int id;
	private static int counter = 0;

	/** */
	private OfferStatus status;

	/** */
	public Offer(int id, OfferStatus status) {
		this.id = ++counter;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OfferStatus getStatus() {
		return status;
	}

	public void setStatus(OfferStatus status) {
		this.status = status;
	}
}
