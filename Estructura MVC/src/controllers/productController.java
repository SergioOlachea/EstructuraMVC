package controllers;

import java.awt.Component;

import org.json.simple.JSONArray;

import models.productModel;
import views.productView;

public class productController {

		public productView view;
	 	
	 	public productController() {
	 		
	 		view = new productView();
	 	}
	 	
	 	public void products() {
	 		
	 		productModel pm = new productModel();
	 		JSONArray data = pm.get();
	 		
	 		view.products(data);
	 		
	 	}
	 	public void add () {
	 		view.add();
	 	}
}
