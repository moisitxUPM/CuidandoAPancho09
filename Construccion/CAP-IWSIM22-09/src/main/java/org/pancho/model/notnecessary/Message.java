package org.pancho.model.notnecessary;

import java.util.Date;

/** */
public class Message {
	/** */
	private int id;

	/** */
	private Date date;

	/** */
	private String text;

	/** */
	private Boolean read;

	/** */
	public Message(int id, Date date, String text, Boolean read) {
		this.id = id;
		this.date = date;
		this.text = text;
		this.read = read;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}
}
