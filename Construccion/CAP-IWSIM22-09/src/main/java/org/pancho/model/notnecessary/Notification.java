package org.pancho.model.notnecessary;

import java.util.Date;

/** */
public class Notification {
	/** */
	private int id;
	
	/** */
	private Date fechaLectura;

	public Notification(int id, Date fechaLectura) {
		this.id = id;
		this.fechaLectura = fechaLectura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaLectura() {
		return fechaLectura;
	}

	public void setFechaLectura(Date fechaLectura) {
		this.fechaLectura = fechaLectura;
	}
}
