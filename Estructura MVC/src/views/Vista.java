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
 		
 		JFrame frame = new JFrame("XCOMPANY - Crear cuenta");
 		frame.setBounds(100, 100,  640, 700);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.getContentPane().setLayout(new BorderLayout());

 		JPanel fondo = new JPanel();
 		fondo.setBackground(new Color(255, 165, 0));
 		fondo.setLayout(null);
 		frame.getContentPane().add(fondo, BorderLayout.CENTER);

 		JLabel lblEmpresa = new JLabel("XCOMPANY", SwingConstants.CENTER);
 		lblEmpresa.setForeground(new Color(0, 77, 64));
 		lblEmpresa.setFont(new Font("SansSerif", Font.BOLD, 36));
 		lblEmpresa.setBounds(-122, 44, 920, 40);
 		fondo.add(lblEmpresa);

 		JPanel tarjeta = new JPanel();
 		tarjeta.setBackground(new Color(0, 77, 64));
 		tarjeta.setLayout(null);
 		tarjeta.setBounds(64, 94, 520, 542);
 		tarjeta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 		fondo.add(tarjeta);

 		JLabel lblTitulo = new JLabel("Crear cuenta", SwingConstants.CENTER);
 		lblTitulo.setForeground(Color.WHITE);
 		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 28));
 		lblTitulo.setBounds(0, 20, 520, 40);
 		tarjeta.add(lblTitulo);

 		JTextField txtCorreo = new JTextField();
 		txtCorreo.setFont(new Font("SansSerif", Font.PLAIN, 18));
 		txtCorreo.setBounds(60, 122, 400, 40);
 		txtCorreo.setBorder(BorderFactory.createLineBorder(new Color(128,203,196)));
 		txtCorreo.setBackground(new Color(0,77,64));
 		txtCorreo.setForeground(new Color(128,203,196));
 		txtCorreo.setCaretColor(new Color(128,203,196));
 		txtCorreo.setToolTipText("Correo electrónico");
 		tarjeta.add(txtCorreo);

 		JTextField txtNombre = new JTextField();
 		txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
 		txtNombre.setBounds(60, 193, 400, 40);
 		txtNombre.setBorder(BorderFactory.createLineBorder(new Color(128,203,196)));
 		txtNombre.setBackground(new Color(0,77,64));
 		txtNombre.setForeground(new Color(128,203,196));
 		txtNombre.setCaretColor(new Color(128,203,196));
 		txtNombre.setToolTipText("Nombre");
 		tarjeta.add(txtNombre);

 		JPasswordField txtContrasena = new JPasswordField();
 		txtContrasena.setFont(new Font("SansSerif", Font.PLAIN, 18));
 		txtContrasena.setBounds(60, 268, 400, 40);
 		txtContrasena.setBorder(BorderFactory.createLineBorder(new Color(128,203,196)));
 		txtContrasena.setBackground(new Color(0,77,64));
 		txtContrasena.setForeground(new Color(128,203,196));
 		txtContrasena.setCaretColor(new Color(128,203,196));
 		txtContrasena.setToolTipText("Contraseña");
 		tarjeta.add(txtContrasena);

 		JPasswordField txtConfirmar = new JPasswordField();
 		txtConfirmar.setFont(new Font("SansSerif", Font.PLAIN, 18));
 		txtConfirmar.setBounds(60, 341, 400, 40);
 		txtConfirmar.setBorder(BorderFactory.createLineBorder(new Color(128,203,196)));
 		txtConfirmar.setBackground(new Color(0,77,64));
 		txtConfirmar.setForeground(new Color(128,203,196));
 		txtConfirmar.setCaretColor(new Color(128,203,196));
 		txtConfirmar.setToolTipText("Confirmar contraseña");
 		tarjeta.add(txtConfirmar);

 		JCheckBox chkTerminos = new JCheckBox("Acepto términos y condiciones");
 		chkTerminos.setBounds(60, 387, 400, 30);
 		chkTerminos.setBackground(new Color(0,77,64));
 		chkTerminos.setForeground(new Color(225,225,225));
 		tarjeta.add(chkTerminos);

 		JButton btnRegistrar = new JButton("Registrarse");
 		btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 20));
 		btnRegistrar.setBackground(new Color(255,165,0));
 		btnRegistrar.setForeground(new Color(0,77,64));
 		btnRegistrar.setBounds(60, 449, 400, 50);
 		btnRegistrar.setFocusPainted(false);
 		tarjeta.add(btnRegistrar);
 		
 		JLabel lblConfirmarContrasena = new JLabel("Confirmar contraseña", SwingConstants.CENTER);
 		lblConfirmarContrasena.setForeground(Color.WHITE);
 		lblConfirmarContrasena.setFont(new Font("SansSerif", Font.ITALIC, 19));
 		lblConfirmarContrasena.setBounds(10, 302, 520, 40);
 		tarjeta.add(lblConfirmarContrasena);
 		
 		JLabel lblContrasena = new JLabel("contraseña", SwingConstants.CENTER);
 		lblContrasena.setForeground(Color.WHITE);
 		lblContrasena.setFont(new Font("SansSerif", Font.ITALIC, 19));
 		lblContrasena.setBounds(0, 229, 520, 40);
 		tarjeta.add(lblContrasena);
 		
 		JLabel lblNombreUsuario = new JLabel("Nombre Usuario", SwingConstants.CENTER);
 		lblNombreUsuario.setForeground(Color.WHITE);
 		lblNombreUsuario.setFont(new Font("SansSerif", Font.ITALIC, 19));
 		lblNombreUsuario.setBounds(0, 158, 520, 40);
 		tarjeta.add(lblNombreUsuario);
 		
 		JLabel lblCorreoElectronico = new JLabel("Correo Electronico", SwingConstants.CENTER);
 		lblCorreoElectronico.setForeground(Color.WHITE);
 		lblCorreoElectronico.setFont(new Font("SansSerif", Font.ITALIC, 19));
 		lblCorreoElectronico.setBounds(-10, 85, 520, 40);
 		tarjeta.add(lblCorreoElectronico);

 		btnRegistrar.addActionListener(e -> {
 		    String correo = txtCorreo.getText();
 		    String nombre  = txtNombre.getText();
 		    String contrasena  = new String(txtContrasena.getPassword());
 		    String confirmar  = new String(txtConfirmar.getPassword());

 		    if (correo.equals("")) {
 		    	txtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED , 2));
 		    }else {
 		    		txtCorreo.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
 		    	} if (nombre.equals("")) {
 		           txtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
 		       } else {
 		           txtNombre.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
 		       }

 		       if (contrasena.equals("")) {
 		           txtContrasena.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
 		       } else {
 		           txtContrasena.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
 		       }

 		       if (!confirmar.equals(contrasena) || confirmar.equals("")) {
 		           txtConfirmar.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
 		       } else {
 		           txtConfirmar.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
 		       }

 		       if (correo.equals("") || nombre.equals("") || contrasena.equals("") || confirmar.equals("") || !confirmar.equals(contrasena) || !chkTerminos.isSelected()) {
 		           JOptionPane.showMessageDialog(frame,
 		               "Faltan datos o son inválidos. No se pudo registrar.",
 		               "Error de registro",
 		               JOptionPane.ERROR_MESSAGE);
 		           return;
 		       }

 		       System.out.println("Correo: " + correo);
 		       System.out.println("Nombre: " + nombre);
 		       System.out.println("Contraseña: " + contrasena);
 		       JOptionPane.showMessageDialog(frame,
 		           "Registro exitoso.",
 		           "Éxito",
 		           JOptionPane.INFORMATION_MESSAGE);
 		   });

 		frame.setVisible(true);

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
