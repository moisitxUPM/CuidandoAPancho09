package org.pancho.view;

import org.pancho.model.Caretaker;
import org.pancho.model.IUser;
import org.pancho.model.Owner;
import org.pancho.model.User;

import java.util.ArrayList;

/** */
public class UserView {

	public static void display(IUser user) {
		System.out.println("User details:");
		System.out.println("ID: " + user.getId());
		System.out.println("Email: " + user.getEmail());
		System.out.println("OAuth Provider: " + user.getOauthProvider());
		System.out.println("OAuth ID: " + user.getOauthId());
		System.out.println("Name: " + user.getName());
		System.out.println("Address: " + user.getAddress());
		System.out.println("Language: " + user.getLanguage());
		System.out.println();
	}

	public static void listUsers(ArrayList<User> users) {
		for (User user : users) {
			display(user);
		}
	}

	public static String userToString(IUser user) {
		return user.getId() + ";" +
				user.getEmail() + ";" +
				user.getOauthProvider() + ";" +
				user.getOauthId() + ";" +
				user.getName() + ";" +
				user.getAddress() + ";" +
				user.getLanguage() + ";" +
				user.getPhoto() + ";" +
				user.getDescription() + ";" +
				user.getRate() + ";" +
				user.getMaxDistance() + ";" +
				user.getIBAN() + ";" +
				user.getAccreditingDocument();
	}
}
