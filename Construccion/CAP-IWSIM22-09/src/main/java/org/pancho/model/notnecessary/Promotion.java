package org.pancho.model.notnecessary;

import java.util.Date;

/** */
public class Promotion extends Prize {
	/** */
	private Date fechaInicio;

	/** */
	private Date fechaFin;

	public Promotion(int id, Double coste, Date fechaCompra, Date fechaInicio, Date fechaFin) {
		super(id, coste, fechaCompra);
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	/** */
	//Crea getter de fechaInicio
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	/** */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/** */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}
