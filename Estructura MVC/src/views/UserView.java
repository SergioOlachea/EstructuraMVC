package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controllers.UserController;
import models.User;
import models.UserModel;

public class UserView {
	JTextField txtRol,txtEmail,txtNombre;
	public UserView() {
		
	}
	
	public void showUsers(ArrayList<User> users)
	{
		JFrame ventana = new JFrame();
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true); 
		
		JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        ventana.getContentPane().add(panel); 
        
        // ---------- TÍTULO ----------
        JLabel lblTitle = new JLabel("USUARIOS", SwingConstants.CENTER);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(lblTitle, BorderLayout.NORTH);
        
        JPanel contenido = new JPanel();
        panel.add(contenido, BorderLayout.CENTER);
        contenido.setLayout(null);
        
        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(e->{
        	UserController uc = new UserController();
        	ventana.dispose();
        	uc.add();
        });
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.add(btnNuevo);
        
     // Tabla
        String[] columnas = {"Identificador", "Nombre completo", "email", "rol"};
        Object[][] datos = new Object[users.size()][columnas.length];
       
        for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			    
	            datos[i][0] = String.format("%03d", i + 1);
	            datos[i][1] = user.getName();
	            datos[i][2] = user.getEmail();
	            datos[i][3] = user.getRole();
	           
	        }

	        DefaultTableModel model = new DefaultTableModel(datos, columnas);

	        JTable tabla = new JTable(model);
	        tabla.setRowHeight(30);
	        
	        JScrollPane scrollPane = new JScrollPane(tabla);
	        scrollPane.setBackground(Color.white);
	        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        contenido.add(scrollPane);
	        
		}  
	
	public void addUsers() {

		JFrame ventana = new JFrame();
		
		ventana.setBounds(100, 100, 230, 419);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);
		
		JPanel contenedor = new JPanel();
		contenedor.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(contenedor, BorderLayout.CENTER);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(0, 93, 216, 19);
		contenedor.add(lblNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(30, 122, 152, 19);
		contenedor.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(0, 164, 216, 13);
		contenedor.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(30, 187, 152, 19);
		contenedor.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblRol.setBounds(0, 230, 216, 13);
		contenedor.add(lblRol);
		
		JTextField txtRol = new JTextField();
		txtRol.setBounds(30, 256, 152, 19);
		contenedor.add(txtRol);
		txtRol.setColumns(10);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(72, 295, 85, 21);
		btnAñadir.addActionListener(e->{
			String nombre= txtNombre.getText();
			String email = txtEmail.getText();
			String rol = txtRol.getText();
			UserModel m = new UserModel();
			m.add(nombre,email,rol);
			ventana.dispose();
			UserController uc = new UserController();
			uc.users();
		});
		contenedor.add(btnAñadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(72, 326, 85, 21);
		contenedor.add(btnCancelar);
		
		JLabel lblTitulo = new JLabel("Añadir usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 22, 216, 32);
		contenedor.add(lblTitulo);
		
		ventana.add(contenedor);
		ventana.setLocationRelativeTo(null);
	}
}
