package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import models.Modelo;

public class Vista {
 	int y;
 	private JFrame frame;
 	private JTextField textField;
 	private JPasswordField passwordField;
 	private Modelo funciones;
 	 int c=0;
 
 	public Vista() {
 		
 		funciones = new Modelo();
 	}
 	
 	public void login()	{
 		
 		frame = new JFrame();
 		frame.setBounds(100, 100, 640, 600);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
 		
 		JPanel panel = new JPanel();
 		panel.setBackground(new Color(255, 165, 0));
 		frame.getContentPane().add(panel, BorderLayout.CENTER);
 		panel.setLayout(null);

         // Nombre de empresa
         JLabel lblCompany = new JLabel("XCOMPANY", SwingConstants.CENTER);
         lblCompany.setForeground(new Color(0, 77, 64));
         lblCompany.setFont(new Font("SansSerif", Font.BOLD, 32));
         lblCompany.setBounds(-151, 66, 920, 40);
         panel.add(lblCompany);

         // Tarjeta verde oscuro
         JPanel card = new JPanel();
         card.setBackground(new Color(0, 77, 64));  // rgb(0,77,64)
         card.setBounds(40, 116, 520, 374);
         card.setLayout(null);
         card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
         panel.add(card);

         // Campo usuario
         JTextField txtUsuario = new JTextField();
         txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
         txtUsuario.setBounds(60, 92, 400, 40);
         txtUsuario.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));  // rgb(128,203,196)
         txtUsuario.setBackground(new Color(0, 77, 64));
         txtUsuario.setForeground(new Color(128, 203, 196));
         txtUsuario.setCaretColor(new Color(128, 203, 196));
         txtUsuario.setToolTipText("Nombre de usuario");
         card.add(txtUsuario);

         // Icono de usuario (sólo símbolo Unicode aquí)
         JLabel usuario = new JLabel("");
         usuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
         usuario.setIcon(new ImageIcon(Vista.class.getResource("/images/Usuario.png")));
         usuario.setForeground(new Color(128, 203, 196));
         usuario.setBounds(30, 92, 30, 40);
         usuario.setVisible(true);
         card.add(usuario);

         JPasswordField contra = new JPasswordField();
         contra.setFont(new Font("SansSerif", Font.PLAIN, 18));
         contra.setBounds(60, 170, 400, 40);
         contra.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
         contra.setBackground(new Color(0, 77, 64));
         contra.setForeground(new Color(128, 203, 196));
         contra.setCaretColor(new Color(128, 203, 196));
         contra.setToolTipText("Contraseña");
         card.add(contra);

         // Icono de candado
         JLabel candado = new JLabel("");
         candado.setIcon(new ImageIcon(Vista.class.getResource("/images/Candado.png")));
         candado.setForeground(new Color(128, 203, 196));
         candado.setBounds(30, 170, 30, 40);
         card.add(candado);

         // Botón iniciar sesión
         JButton btnLogin = new JButton("Iniciar sesión");
         btnLogin.setFont(new Font("SansSerif", Font.BOLD, 20));
         btnLogin.setBackground(new Color(255, 165, 0));  // rgb(255,165,0)
         btnLogin.setForeground(new Color(0, 77, 64));
         btnLogin.setBounds(60, 270, 400, 50);
         btnLogin.setFocusPainted(false);
         btnLogin.addActionListener(e -> {
        	 String passText = new String(contra.getPassword());
				Boolean flag1 = false, flag2 = false;
				
				String username = txtUsuario.getText();
				
				if( passText.equals("") ) {
					
					contra.setBorder(BorderFactory.createLineBorder(Color.red,2));
					
				}else {
					
					contra.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag1 = true;
				}
				
				
				if(txtUsuario.getText().equals("")) {
					txtUsuario.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}else {
					
					txtUsuario.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag2 = true;
				}
				
				if(flag1 && flag2) {
					
					
					boolean user_auth = funciones.access(username,passText); 
					 
					if(user_auth) {
						
						JOptionPane.showMessageDialog(frame, "Bienvenido.");
						
					}else {
						JOptionPane.showMessageDialog(frame, "Verifique usuario y contraseña","Datos incorrectos",JOptionPane.WARNING_MESSAGE);
					}	
				}
        	});
         card.add(btnLogin);

         
         JButton contraseñaOlv = new JButton();
         contraseñaOlv.setText("¿Olvidaste tu contraseña?");
         contraseñaOlv.setForeground(new Color(0, 0, 0));
         contraseñaOlv.setBackground(new Color(0, 77, 64));
         contraseñaOlv.setFont(new Font("SansSerif", Font.PLAIN, 14));
         contraseñaOlv.setBounds(60, 220, 231, 20);
         contraseñaOlv.addActionListener(e -> {
        	 manager("ContraOlvidada");
        	});
         card.add(contraseñaOlv);
         
         JLabel lblTitle = new JLabel("Iniciar sesión", SwingConstants.CENTER);
         lblTitle.setForeground(Color.WHITE);
         lblTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
         lblTitle.setBounds(0, 10, 520, 40);
         card.add(lblTitle);
         
         JButton btnAunNoTienes = new JButton();
         btnAunNoTienes.setText("Aun no tienes Usuario? Registrate");
         btnAunNoTienes.setForeground(Color.BLACK);
         btnAunNoTienes.setFont(new Font("SansSerif", Font.PLAIN, 14));
         btnAunNoTienes.setBackground(new Color(0, 77, 64));
         btnAunNoTienes.setBounds(116, 330, 265, 20);
         btnAunNoTienes.addActionListener(e -> {
        	 manager("registro");
        	});
         card.add(btnAunNoTienes);
         
         JButton btnUsarNumeroDe = new JButton();
         btnUsarNumeroDe.setText("usar Numero de celular");
         btnUsarNumeroDe.setForeground(Color.BLACK);
         btnUsarNumeroDe.setFont(new Font("SansSerif", Font.PLAIN, 14));
         btnUsarNumeroDe.setBackground(new Color(0, 77, 64));
         btnUsarNumeroDe.setBounds(60, 142, 231, 20);
        
         btnUsarNumeroDe.addActionListener(e -> {
        	    if (c==0) {
        	    	btnUsarNumeroDe.setText("usar Numero de celular");
        	    	c=1;
        	    }else {
        	    	btnUsarNumeroDe.setText("usar correo electronico");
        	    	c=0;
        	    }
        	});
         card.add(btnUsarNumeroDe);
         
         frame.add(panel);
  		 frame.repaint();
  		 panel.repaint();
 		
 	}
 	
 	
 	public void registro() {
 		
 		frame = new JFrame();
 		frame.setBounds(100, 100, 920, 534);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		frame.setVisible(true);
 		
 		JPanel panel = new JPanel();
 		panel.setBackground(new Color(255, 255, 255));
 		frame.getContentPane().add(panel, BorderLayout.CENTER);
 		panel.setLayout(null);
 		
 		JLabel lblNewLabel_7 = new JLabel("New label");
 		lblNewLabel_7.setIcon(new ImageIcon(Vista.class.getResource("/images/logouabcs1.png")));
 		lblNewLabel_7.setBounds(642, 52, 137, 59);
 		panel.add(lblNewLabel_7);
 		
 		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
 		lblNewLabel.setForeground(new Color(0, 0, 0));
 		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
 		lblNewLabel.setBounds(107, 35, 210, 26);
 		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
 		panel.add(lblNewLabel);
 		
 		JLabel lblNewLabel_8 = new JLabel("");
 		lblNewLabel_8.setBounds(36, 186, 353, 81);
 		lblNewLabel_8.setBorder(BorderFactory.createTitledBorder("Correo electrónico"));
 		panel.add(lblNewLabel_8);
 		
 		textField = new JTextField();
 		textField.setBackground(new Color(218, 230, 225));
 		textField.setBounds(49, 211, 328, 42);
 		panel.add(textField);
 		textField.setBorder(new LineBorder(new Color(91, 253, 255), 1, true));
 		textField.setBorder(null);
 		textField.setColumns(10);
 		
 		passwordField = new JPasswordField();
 		passwordField.setBackground(new Color(218, 230, 225));
 		passwordField.setBounds(49, 300, 295, 42);
 		panel.add(passwordField);
 		
 		JButton btnNewButton = new JButton("Registro");
 		btnNewButton.setBackground(new Color(0, 0, 0));
 		btnNewButton.setOpaque(true);
 		btnNewButton.setForeground(new Color(255, 255, 255));
 		btnNewButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 				String passText = new String(passwordField.getPassword());
 				Boolean paso = false, paso2 = false;
 				
 				String username = textField.getText();
 				
 				if( passText.equals("") ) {
 					
 					passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
 					
 				}else {
 					
 					passwordField.setBorder(BorderFactory.createLineBorder(Color.green,2));
 					paso = true;
 				}
 				
 				
 				if(textField.getText().equals("")) {
 					textField.setBorder(BorderFactory.createLineBorder(Color.red,2));
 				}else {
 					
 					textField.setBorder(BorderFactory.createLineBorder(Color.green,2));
 					paso2 = true;
 				}
 				
 				if(paso && paso2) {
 					
 					
 					boolean user_auth = funciones.access(username,passText); 
 					 
 					if(user_auth) {
 						
 						JOptionPane.showMessageDialog(frame, "Bienvenido.");
 						
 					}else {
 						JOptionPane.showMessageDialog(frame, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
 					}
 					 
 					
 					
 				}
 				
 			}
 		});
 		btnNewButton.setBounds(36, 413, 341, 37);
 		panel.add(btnNewButton);
 		
 		JLabel lblNewLabel_1 = new JLabel("Sabiduría como meta, patria como destino ");
 		lblNewLabel_1.setBounds(69, 73, 308, 16);
 		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
 		panel.add(lblNewLabel_1);
 		
 		JLabel lblNewLabel_6 = new JLabel("");
 		lblNewLabel_6.setIcon(new ImageIcon(Vista.class.getResource("/images/redd-francisco-9o8YdYGTT64-unsplash.jpg")));
 		lblNewLabel_6.setBounds(531, 6, 383, 494);
 		lblNewLabel_6.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
 		panel.add(lblNewLabel_6);
 		
 		JLabel lblNewLabel_2_1 = new JLabel("Ingresa al panel administrador");
 		lblNewLabel_2_1.setForeground(Color.BLACK);
 		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
 		lblNewLabel_2_1.setBounds(49, 109, 340, 39);
 		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
 		panel.add(lblNewLabel_2_1);
 		
 		JLabel lblNewLabel_8_1 = new JLabel("");
 		lblNewLabel_8_1.setBorder(BorderFactory.createTitledBorder("Contraseña"));
 		lblNewLabel_8_1.setBounds(36, 279, 353, 81);
 		panel.add(lblNewLabel_8_1);
 		
 		JLabel lblNewLabel_2 = new JLabel("");
 		lblNewLabel_2.setIcon(new ImageIcon(Vista.class.getResource("/images/hidden.png")));
 		lblNewLabel_2.setBounds(351, 315, 24, 16);
 		panel.add(lblNewLabel_2);
 		
 		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar contraseña");
 		chckbxNewCheckBox.setBounds(36, 372, 180, 23);
 		panel.add(chckbxNewCheckBox);
 		
 		JLabel lblNewLabel_3 = new JLabel("¿Aún no tienes cuenta?");
 		lblNewLabel_3.setBounds(225, 462, 152, 16);
 		panel.add(lblNewLabel_3);
 		
 		frame.add(panel);
 		frame.repaint();
 		panel.repaint();
 	}
 	public void manager(String target) {
		  frame.dispose();
		  if(target.equals("registro")) {
			  registro();
	  }else if(target.equals("Login")) {
			 login();
	  }/*else if(target.equals("Recuperar cuenta")) {
		  ContraOlvidada();
	  }*/
 	}
 }
