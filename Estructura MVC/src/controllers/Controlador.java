package controllers;

import views.Vista;

public class Controlador {
	
	public Vista view;
	
	public Controlador() {
		
		view = new Vista();
	}
	
	
	
	public void login(){
		
		view.login();
		
	}
	
	
	/*public void register() {
		
		view.registro();
	}*/
	

}