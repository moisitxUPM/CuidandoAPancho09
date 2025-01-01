package org.pancho.view;


import org.pancho.model.Care;
import org.pancho.model.ICare;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/** */
public class CareView {


	public static void display(ICare care) {
		System.out.println("ID: " + care.getId());
		System.out.println("Start date: " + care.getStartDate());
		System.out.println("End date: " + care.getEndDate());
		System.out.println("Cost: " + care.getCost());
		System.out.println("Paid: " + care.isPaid());
		System.out.println("Pancho points: " + care.getPanchoPoints());
		System.out.println();
	}

	public static void listCares(ArrayList<Care> cares) {
		for (Care care : cares) {
			display(care);
		}
	}

	public static String careToString(ICare care) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String caretakerName = (care.getCaretaker() != null) ? care.getCaretaker().getName() : "null";
		String petRiac = (care.getPet() != null) ? care.getPet().getRIACCode() : "null";

		String startDate = (care.getStartDate() != null) ? formatter.format(care.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) : "null";
		String endDate = (care.getEndDate() != null) ? formatter.format(care.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) : "null";

		return care.getId() + ";" +
				startDate + ";" +
				endDate + ";" +
				care.getCost() + ";" +
				care.isPaid() + ";" +
				care.getPanchoPoints() + ";" +
				caretakerName + ";" +
				petRiac;
	}
}
