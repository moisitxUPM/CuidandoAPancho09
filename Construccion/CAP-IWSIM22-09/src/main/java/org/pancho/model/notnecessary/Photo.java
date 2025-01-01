package org.pancho.model.notnecessary;
/** */
public class Photo {
	/** */
	private final int id;
	private static int counter = 0;
	/** */
	private String address;

	/** */
	public Photo(String address) {
		this.id = ++counter;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
