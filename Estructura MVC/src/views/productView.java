package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class productView {

	public productView() {
	}
		public void products(JSONArray data) {
	 		
	 		JFrame ventana = new JFrame();
	 		
	 		ventana.setBounds(100, 100, 920, 534);
	 		ventana.setBackground(new Color(255, 165, 0));
	 		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		
	 		ventana.setVisible(true);
	 		
	 		JPanel panel = new JPanel();
	 		panel.setBackground(new Color(255, 165, 0));
	 		ventana.getContentPane().add(panel, BorderLayout.CENTER);
	 		panel.setLayout(null);
	 		
	 		JLabel lblNewLabel = new JLabel("PRODUCTOS");
	 		lblNewLabel.setForeground(new Color(0, 0, 0));
	 		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
	 		lblNewLabel.setBounds(107, 35, 210, 26);
	 		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
	 		ventana.add(lblNewLabel,BorderLayout.NORTH);
	 		
	 		int x = 70;
	 		
	 		// Creacion de Tabla con json
	 		String columnas[] = {"id","nombre","Precio","Stock"};
	 		DefaultTableModel modelo = new DefaultTableModel(columnas, 0); 
	 		JTable Productos = new JTable(modelo);
	 			
	 		data.forEach( emp -> {
		 		JSONObject product = (JSONObject)emp;
	 			String id = (String) product.get("id");  
	 			String nombre = (String) product.get("nombre"); 
	 			String precio = (String) product.get("precio"); 
	 			String stock = (String) product.get("stock"); 
	 			
	 			Object []filas ={id,nombre,precio,stock};
	 			modelo.addRow(filas);
	 		}); 
	 		
	 		Productos.setFont(new Font("Kefa", Font.PLAIN, 17));
	 		Productos.setRowHeight(20);
	 		JScrollPane scrollPane = new JScrollPane(Productos);
	 		ventana.add(scrollPane);
	 		
	 		
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
