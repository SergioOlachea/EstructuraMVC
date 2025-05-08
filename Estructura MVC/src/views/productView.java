package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import controllers.productController;
import models.productModel;


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
	 		
	 		JPanel botones = new JPanel();
	 		//botones.setMaximumSize(new Dimension(80,50));
	 		botones.setMaximumSize(new Dimension(50,50));
	 		botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));
	 		botones.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
	 		botones.add(Box.createHorizontalGlue());
	 		
	 		JButton btnNewProduct = new JButton("Añadir");
	 		btnNewProduct.setPreferredSize(new Dimension(70,50));
	 		btnNewProduct.setAlignmentX(Component.RIGHT_ALIGNMENT);
	 		btnNewProduct.addActionListener(e->{
	 			ventana.dispose();
				
				productController pc = new productController();
				pc.add();
	 		});
	 		botones.add(btnNewProduct);
	 		ventana.getContentPane().add(botones);
	 		
	 		botones.add(Box.createRigidArea(new Dimension(10, 0)));
	 		
	 		JButton btnDeleteProduct = new JButton("Eliminar");
	 		btnDeleteProduct.setPreferredSize(new Dimension(90,50));
	 		btnDeleteProduct.setAlignmentX(Component.RIGHT_ALIGNMENT);
	 		btnDeleteProduct.addActionListener(e->{
	 			((JButton) e.getSource()).getName();
				
				System.out.println("Hola: "+((JButton) e.getSource()).getName());
			
				productModel pm = new productModel();
				pm.remove();
	 		});
	 		botones.add(btnDeleteProduct);
	 		ventana.getContentPane().add(botones);
	 		
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
	 		ventana.getContentPane().add(scrollPane, BorderLayout.SOUTH);
	 		
	 		
	 		
	 	}
		
	public void add()
		{
		JFrame ventana = new JFrame();
		
		ventana.setBounds(100, 100, 442, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);
		
		JPanel contenedor = new JPanel();
		contenedor.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(null);
		
		JLabel titulo = new JLabel("Añaidr producto");
		titulo.setFont(new Font("Wide Latin", Font.ITALIC, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(100, 10, 200, 40);
		contenedor.add(titulo);
		
		JLabel lblIdeProducto = new JLabel("Id del producto");
		lblIdeProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdeProducto.setBounds(100, 74, 200, 40);
		contenedor.add(lblIdeProducto);
		
		JTextField txtId = new JTextField();
		txtId.setBounds(100, 104, 200, 40);
		contenedor.add(txtId);
		
		JLabel lblNombreProducto = new JLabel("Nombre Producto");
		lblNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProducto.setBounds(100, 156, 200, 40);
		contenedor.add(lblNombreProducto);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(100, 239, 200, 40);
		contenedor.add(lblStock);
		
		JTextField textField = new JTextField();
		textField.setBounds(100, 189, 200, 40);
		contenedor.add(textField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(100, 271, 200, 40);
		contenedor.add(textField_1);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(100, 321, 200, 40);
		contenedor.add(lblPrecio);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(100, 356, 200, 40);
		contenedor.add(textField_2);
	 
		JButton add = new JButton("añadir producto");
		add.setBounds(100, 450, 200, 40);
		add.addActionListener(e->{
				String Id = txtId.getText();
				String name = textField.getText();
				String Stock = textField_1.getText();
				String Price = textField_2.getText();
				
				
				productModel pm = new productModel();
				pm.addProduct(Id,name,Stock,Price);
				
				ventana.dispose();
				
				productController pc = new productController();
				pc.products();
				
			});
		contenedor.add(add); 
		ventana.getContentPane().add(contenedor);
		
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
