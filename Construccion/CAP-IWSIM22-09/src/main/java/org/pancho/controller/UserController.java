package org.pancho.controller;

import org.pancho.model.Caretaker;
import org.pancho.model.Owner;
import org.pancho.model.User;
import org.pancho.model.enums.LanguageEnum;
import org.pancho.view.UserView;
import servidor.ExternalRRSS;

import java.util.ArrayList;

/** */
public class UserController {
	//singleton
	private static UserController userController;
	private ArrayList<User> userList;

	private UserController(){
		this.userList = new ArrayList<>();
	}

	public static UserController getUserController(){
		if(userController == null){
			userController = new UserController();
		}
		return userController;
	}

	public void showUserList(){
		for (User user : userList) {
			UserView.display(user);
		}
	}

	public String userToString(User user) {
		return UserView.userToString(user);
	}

	public boolean existsUser(String email){
		for(User user : userList){
			if(user.getEmail().equals(email)){
				return true;
			}
		}
		return false;
	}


	public User logUser() {
		String token = ExternalRRSS.LoginRRSS();
		for (User user : this.userList) {
			if (user.getId().equals(token)) {
				return user;
			}
		}
		return null;
	}

	public User getUser(String email){
		for(User user : userList){
			if(user.getEmail().equals(email)){
				return user;
			}
		}
		return null;
	}

	public User whoIsLoggedIn(){
		for(User user : userList){
			if(user.getOauthId() != null){
				return user;
			}
		}
		return null;
	}

	public void logout(){
		for(User user : userList){
			if(user.getOauthId() != null){
				user.setOauthId(null);
			}
		}
	}

	public void createOwner(String name, String address, LanguageEnum language, String email) {
		User user = new Owner(name, address, language, email);
		addUser(user);
	}

	public void createCaretaker(String name, String address, String photo, double rate, double maxDistance, LanguageEnum language, String email){
		User user = new Caretaker(name, address, photo, rate, maxDistance, language, email);
		addUser(user);
	}

	public void addUser(User user){
		this.userList.add(user);
	}

	public ArrayList<User> getUserList(){
		return this.userList;
	}
}
