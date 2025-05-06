package models;


import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class productModel {

public productModel() {
 		
 	}
 	
 	public JSONArray get()
 	{
 		
 		JSONParser jsonParser = new JSONParser();
 		
         
         try 
         {
        	 Object obj = jsonParser.parse(new FileReader("src/files/productos.json"));
        	 JSONObject jsonObject =  (JSONObject) obj;
   
             JSONArray productList = (JSONArray) jsonObject.get("productos");
                          
            //Iterate over  array
            productList.forEach( emp -> parseTestData( (JSONObject) emp ) );
            return productList;
   
         } catch (FileNotFoundException e) 
         {
             e.printStackTrace();
         } catch (IOException e) 
         {
             e.printStackTrace();
         } catch (ParseException e) 
         {
             e.printStackTrace();
         }
 	
         
         return null;
 		
 	}
 	
 	private static void parseTestData(JSONObject product)
     {
 		
 		// Obtener valores directamente del objeto producto
 		String id = (String) product.get("id");   
 	    System.out.println("Id: " + id);
 		
 	    String nombre = (String) product.get("nombre");   
 	    System.out.println("Producto: " + nombre);
 	      
 	    String precio = (String) product.get("precio");   
 	    System.out.println("Precio: " + precio);
 	      
 	    String stock = (String) product.get("stock"); 
 	    System.out.println("Stock: " + stock); 
 	    
     }
}
