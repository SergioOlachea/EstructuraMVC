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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
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
 	String rol = "";
 
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
 		
 		JFrame ventana = new JFrame("XCOMPANY - Crear cuenta");
        ventana.setBounds(50, 50, 640, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		ventana.setVisible(true);

        JPanel fondo = new JPanel();
        fondo.setBackground(new Color(255, 165, 0));
        fondo.setLayout(null);
        ventana.getContentPane().add(fondo, BorderLayout.CENTER);

        JLabel lblEmpresa = new JLabel("XCOMPANY", SwingConstants.CENTER);
        lblEmpresa.setForeground(new Color(0, 77, 64));
        lblEmpresa.setFont(new Font("SansSerif", Font.BOLD, 36));
        lblEmpresa.setBounds(-122, 44, 920, 40);
        fondo.add(lblEmpresa);

        JPanel tarjeta = new JPanel();
        tarjeta.setBackground(new Color(0, 77, 64));
        tarjeta.setLayout(null);
        tarjeta.setPreferredSize(new Dimension(520, 1100));

        JScrollPane scroll = new JScrollPane(tarjeta);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(37, 94, 547, 800);
        fondo.add(scroll);

        JLabel lblTitulo = new JLabel("Crear cuenta", SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblTitulo.setBounds(0, 20, 520, 40);
        tarjeta.add(lblTitulo);

        JLabel lblCorreo = new JLabel("Correo Electronico", SwingConstants.CENTER);
        lblCorreo.setForeground(Color.WHITE);
        lblCorreo.setFont(new Font("SansSerif", Font.ITALIC, 19));
        lblCorreo.setBounds(-10, 85, 520, 40);
 	    tarjeta.add(lblCorreo);
        
        JTextField txtCorreo = new JTextField();
        txtCorreo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtCorreo.setBounds(60, 122, 400, 40);
        txtCorreo.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtCorreo.setBackground(new Color(0, 77, 64));
        txtCorreo.setForeground(new Color(128, 203, 196));
        txtCorreo.setCaretColor(new Color(128, 203, 196));
        txtCorreo.setToolTipText("Correo electrónico");
        tarjeta.add(txtCorreo);

        JLabel lblNombreUsuario = new JLabel("Nombre", SwingConstants.CENTER);
 	    lblNombreUsuario.setForeground(Color.WHITE);
 	    lblNombreUsuario.setFont(new Font("SansSerif", Font.ITALIC, 19));
 	    lblNombreUsuario.setBounds(0, 303, 520, 40);
 	    tarjeta.add(lblNombreUsuario);
        
        JTextField txtNombre = new JTextField();
        txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtNombre.setBounds(60, 343, 400, 40);
        txtNombre.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtNombre.setBackground(new Color(0, 77, 64));
        txtNombre.setForeground(new Color(128, 203, 196));
        txtNombre.setCaretColor(new Color(128, 203, 196));
        txtNombre.setToolTipText("Nombre");
        txtNombre.setVisible(true);
        tarjeta.add(txtNombre);

        
        JLabel lblContrasea = new JLabel("contraseña", SwingConstants.CENTER);
 	    lblContrasea.setForeground(Color.WHITE);
 	    lblContrasea.setFont(new Font("SansSerif", Font.ITALIC, 19));
 	    lblContrasea.setBounds(0, 154, 520, 40);
 	    tarjeta.add(lblContrasea);
 	    
        JPasswordField txtContraseña = new JPasswordField();
        txtContraseña.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtContraseña.setBounds(60, 191, 400, 40);
        txtContraseña.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtContraseña.setBackground(new Color(0, 77, 64));
        txtContraseña.setForeground(new Color(128, 203, 196));
        txtContraseña.setCaretColor(new Color(128, 203, 196));
        txtContraseña.setToolTipText("Contraseña");
        tarjeta.add(txtContraseña);

        JLabel lblConfirmar = new JLabel("Confirmar contraseña", SwingConstants.CENTER);
        lblConfirmar.setForeground(Color.WHITE);
        lblConfirmar.setFont(new Font("SansSerif", Font.ITALIC, 19));
        lblConfirmar.setBounds(0, 231, 520, 40);
        tarjeta.add(lblConfirmar);
 	    
        JPasswordField txtConfirmar = new JPasswordField();
        txtConfirmar.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtConfirmar.setBounds(60, 266, 400, 40);
        txtConfirmar.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtConfirmar.setBackground(new Color(0, 77, 64));
        txtConfirmar.setForeground(new Color(128, 203, 196));
        txtConfirmar.setCaretColor(new Color(128, 203, 196));
        txtConfirmar.setToolTipText("Confirmar contraseña");
        tarjeta.add(txtConfirmar);

        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnRegistrar.setBackground(new Color(255, 165, 0));
        btnRegistrar.setForeground(new Color(0, 77, 64));
        btnRegistrar.setBounds(60, 800, 400, 50);
        tarjeta.add(btnRegistrar);

        JTextField txtApellidos = new JTextField();
        txtApellidos.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtApellidos.setBounds(60, 415, 400, 40);
        txtApellidos.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtApellidos.setBackground(new Color(0, 77, 64));
        txtApellidos.setForeground(new Color(128, 203, 196));
        txtApellidos.setCaretColor(new Color(128, 203, 196));
        txtApellidos.setToolTipText("Apellidos");
        tarjeta.add(txtApellidos);

        JLabel lblApellidos = new JLabel("Apellidos", SwingConstants.CENTER);
        lblApellidos.setForeground(Color.WHITE);
        lblApellidos.setFont(new Font("SansSerif", Font.ITALIC, 19));
        lblApellidos.setBounds(0, 380, 520, 40);
        tarjeta.add(lblApellidos);

        JTextField txtEmpresa = new JTextField();
        txtEmpresa.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtEmpresa.setBounds(60, 490, 400, 40);
        txtEmpresa.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtEmpresa.setBackground(new Color(0, 77, 64));
        txtEmpresa.setForeground(new Color(128, 203, 196));
        txtEmpresa.setCaretColor(new Color(128, 203, 196));
        txtEmpresa.setToolTipText("Empresa");
        tarjeta.add(txtEmpresa);

        JLabel lblEmpresaNombre = new JLabel("Empresa", SwingConstants.CENTER);
        lblEmpresaNombre.setForeground(Color.WHITE);
        lblEmpresaNombre.setFont(new Font("SansSerif", Font.ITALIC, 19));
        lblEmpresaNombre.setBounds(-25, 455, 520, 40);
        tarjeta.add(lblEmpresaNombre);

        String[] ambitos = {"Tecnología", "Salud", "Educación", "Comercio", "Otro"};
        JComboBox<String> cmbAmbito = new JComboBox<>(ambitos);
        cmbAmbito.setFont(new Font("SansSerif", Font.PLAIN, 18));
        cmbAmbito.setBounds(60, 565, 400, 40);
        cmbAmbito.setBackground(new Color(0, 77, 64));
        cmbAmbito.setForeground(new Color(128, 203, 196));
        cmbAmbito.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        tarjeta.add(cmbAmbito);

        JLabel lblAmbito = new JLabel("Ámbito Empresa", SwingConstants.CENTER);
        lblAmbito.setForeground(Color.WHITE);
        lblAmbito.setFont(new Font("SansSerif", Font.ITALIC, 19));
        lblAmbito.setBounds(0, 530, 520, 40);
        tarjeta.add(lblAmbito);

        JTextField txtCargo = new JTextField();
        txtCargo.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtCargo.setBounds(60, 640, 400, 40);
        txtCargo.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtCargo.setBackground(new Color(0, 77, 64));
        txtCargo.setForeground(new Color(128, 203, 196));
        txtCargo.setCaretColor(new Color(128, 203, 196));
        txtCargo.setToolTipText("Cargo");
        tarjeta.add(txtCargo);

        JLabel lblCargo = new JLabel("Cargo", SwingConstants.CENTER);
        lblCargo.setForeground(Color.WHITE);
        lblCargo.setFont(new Font("SansSerif", Font.ITALIC, 19));
        lblCargo.setBounds(0, 605, 520, 40);
        tarjeta.add(lblCargo);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtUsuario.setBounds(60, 715, 400, 40);
        txtUsuario.setBorder(BorderFactory.createLineBorder(new Color(128, 203, 196)));
        txtUsuario.setBackground(new Color(0, 77, 64));
        txtUsuario.setForeground(new Color(128, 203, 196));
        txtUsuario.setCaretColor(new Color(128, 203, 196));
        txtUsuario.setToolTipText("Nombre de Usuario");
        tarjeta.add(txtUsuario);

        JLabel lblUsuario = new JLabel("Nombre Usuario", SwingConstants.CENTER);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("SansSerif", Font.ITALIC, 19));
        lblUsuario.setBounds(0, 680, 520, 40);
        tarjeta.add(lblUsuario);

        tarjeta.setBounds(37, 94, 547, 800);
        ventana.setBounds(100, 100, 640, 950);

        btnRegistrar.addActionListener(e -> {
            String correo = txtCorreo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String empresa = txtEmpresa.getText().trim();
            String ambito = (String) cmbAmbito.getSelectedItem();
            String cargo = txtCargo.getText().trim();
            String usuario = txtUsuario.getText().trim();
            String contraseña = new String(txtContraseña.getPassword()).trim();
            String confirmar = new String(txtConfirmar.getPassword()).trim();

            boolean valido = true;
            
            //https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
            StringBuilder mensajeError = new StringBuilder("Corrige los siguientes errores:\n\n");

            //https://www.w3schools.com/java/ref_string_contains.asp
            if (correo.isEmpty() || correo.contains(" ")) {
                txtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Correo electrónico inválido.\n");
            } else {
                txtCorreo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            //https://www.w3schools.com/java/ref_string_matches.asp
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                txtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Nombre inválido (solo letras y espacios).\n");
            } else {
                txtNombre.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (!apellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                txtApellidos.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Apellidos inválidos (solo letras y espacios).\n");
            } else {
                txtApellidos.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (!empresa.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+")) {
                txtEmpresa.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Empresa inválida (solo letras, números y espacios).\n");
            } else {
                txtEmpresa.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (ambito == null || ambito.isEmpty()) {
                cmbAmbito.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Ámbito de empresa inválido.\n");
            } else {
                cmbAmbito.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (!cargo.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                txtCargo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Cargo inválido (solo letras y espacios).\n");
            } else {
                txtCargo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (!usuario.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+")) {
                txtUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Nombre de usuario inválido (solo letras, números y espacios).\n");
            } else {
                txtUsuario.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (!contraseña.matches("^(?=.*[!@#$%^&*()\\-_=+{};:,<.>]).{6,}$") || contraseña.contains(" ")) {
                txtContraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Contraseña inválida (debe tener letras, números y al menos un caracter especial, sin espacios).\n");
            } else {
                txtContraseña.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (!confirmar.equals(contraseña)) {
                txtConfirmar.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
                mensajeError.append("- Las contraseñas no coinciden.\n");
            } else {
                txtConfirmar.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (valido) {
                JOptionPane.showMessageDialog(frame,
                    "Registro exitoso.\n¡Bienvenido " + nombre + "!",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                funciones.agregarUsuario(nombre, apellidos, empresa, correo, usuario, contraseña, cargo);
                manager("login");
            } else {
                JOptionPane.showMessageDialog(frame,
                    mensajeError.toString(),
                    "Errores de Validación",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
 		ventana.setVisible(true);
 		
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
