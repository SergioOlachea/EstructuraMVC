package models;

public class Modelo {
 
 	public Modelo() {
 		
 	}
 	
 	public boolean access(String u, String p){
 		
 		if(u.equals("smariano@mail.com")|| u.equals("sergio") ) {
 			if(p.equals("232425")) {
 				
 				return true; 
 				
 			}else {
 				return false;
 				
 			}
 		}else {
 			return false; 
 		}
 		 
 	}
 }
