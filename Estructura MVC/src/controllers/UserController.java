package controllers;

import java.util.ArrayList;

import models.User;
import models.UserModel;
import views.UserView;

public class UserController {
	private UserView uv;
	public UserController(){
		uv= new UserView();
	}
	public void users() {
			UserModel um = new UserModel();
			ArrayList<User> users = um.get();
			
			uv.showUsers(users);
	}
	public void add() {
		uv.addUsers();
	}

}
