package models;


import java.io.FileReader;
import java.io.FileWriter;
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
 	
public JSONArray get() {
    JSONParser jsonParser = new JSONParser();

    try {
        Object obj = jsonParser.parse(new FileReader("src/files/productos.json"));
        JSONArray productList = (JSONArray) obj;

        productList.forEach(emp -> parseTestData((JSONObject) emp));
        return productList;

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }

    return new JSONArray(); // Retornar array vacío en caso de error
}
 	
 	public boolean addProduct(String id,String n,String s,String p)
	{
		
		JSONArray productList = get();
		JSONObject jsonObject = new JSONObject();
		
		String url = "src/files/productos.json";
		
		
		jsonObject.put("id", id);
		jsonObject.put("nombre", n);
		jsonObject.put("stock", s);
		jsonObject.put("precio", p);
		
		productList.add(jsonObject);
		
		try (FileWriter file = new FileWriter(url)) {
            file.write(productList.toString()); // Use toString(2) for pretty printing
            file.flush();
            file.close();
            System.out.println("JSON array written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return false;
	}
 	
 	public void remove(String id)
	{
		
		JSONArray productList = get();
		
		JSONParser jsonParser = new JSONParser();
		String url = "src/files/productos.json";
		 JSONObject toRemove = null;

		    for (Object obj : productList) {
		        JSONObject product = (JSONObject) obj;
		        String currentId = (String) product.get("id");

		        if (currentId.equals(id)) {
		            toRemove = product;
		            break; 
		        }
		    }

		    if (toRemove != null) {
		        productList.remove(toRemove);
		        System.out.println("Producto eliminado: " + toRemove);

		        try (FileWriter file = new FileWriter(url)) {
		            file.write(productList.toJSONString()); 
		            file.flush();
		            System.out.println("JSON actualizado correctamente.");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("Producto con ID " + id + " no encontrado.");
		    }
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
