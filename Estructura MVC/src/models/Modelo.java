package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;

public class Modelo {
 
 	public Modelo() {
 		
 	}
 	
 	public boolean access(String u, String p){
 		
		try { 
			FileReader fr = new FileReader("src/files/usuarios.txt");
			BufferedReader br = new BufferedReader(fr);
 			
 			String line;
             while ((line = br.readLine()) != null) {
            	 String[] parts = line.split(",");              
            	 if(u.equals(parts[0])) {
            		return true; 
            	 }
              } 
		    br.close();
		    return false;

		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("error");
		}
		return false;
 	}
 }
