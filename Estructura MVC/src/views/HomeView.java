package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class HomeView {

	JFrame ventana;
	public HomeView() {
		// TODO Auto-generated constructor stub
	}
	public void home() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 640, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
 		
		// Panel para widgets
 		JPanel widgets = new JPanel(new GridLayout(1, 3, 10, 10));
 		widgets.setBackground(new Color(255, 165, 0));
 		widgets.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
 		
 		JPanel widgetUsuarios = new JPanel(new BorderLayout());
	    widgetUsuarios.setBackground(Color.CYAN);
	    widgetUsuarios.setBorder(BorderFactory.createLineBorder(new Color(0, 77, 64), 2));
	    JLabel lblWidgetusuario = new JLabel("👥 Usuarios", SwingConstants.CENTER);
	    lblWidgetusuario.setFont(new Font("SansSerif", Font.BOLD, 14));
	    JLabel contenidoUsuarios = new JLabel("1245 registrados", SwingConstants.CENTER);
	    contenidoUsuarios.setFont(new Font("SansSerif", Font.PLAIN, 16));
	    widgetUsuarios.add(lblWidgetusuario, BorderLayout.NORTH);
	    widgetUsuarios.add(contenidoUsuarios, BorderLayout.CENTER);
	    widgets.add(widgetUsuarios);
	    
	    JPanel widgetNotificacion = new JPanel(new BorderLayout());
	    widgetNotificacion.setBackground(Color.ORANGE);
	    widgetNotificacion.setBorder(BorderFactory.createLineBorder(new Color(0, 77, 64), 2));
	    JLabel lblwidgetNotificacion = new JLabel("💬 Mensajes", SwingConstants.CENTER);
	    lblwidgetNotificacion.setFont(new Font("SansSerif", Font.BOLD, 14));
	    JLabel contenidoNotificaciones = new JLabel("3 mensajes nuevos", SwingConstants.CENTER);
	    contenidoNotificaciones.setFont(new Font("SansSerif", Font.PLAIN, 16));
	    widgetNotificacion.add(lblwidgetNotificacion, BorderLayout.NORTH);
	    widgetNotificacion.add(contenidoNotificaciones, BorderLayout.CENTER);
	    widgets.add(widgetNotificacion);
 		
	    JPanel widgetHora = new JPanel(new BorderLayout());
	    widgetHora.setBackground(Color.LIGHT_GRAY);
	    widgetHora.setBorder(BorderFactory.createLineBorder(new Color(0, 77, 64), 2));
	    JLabel lblwidgetHora = new JLabel("🕒 Hora", SwingConstants.CENTER);
	    lblwidgetHora.setFont(new Font("SansSerif", Font.BOLD, 14));
	    JLabel contenidoHora = new JLabel("", SwingConstants.CENTER);
	    contenidoHora.setFont(new Font("SansSerif", Font.PLAIN, 16));
	    widgetHora.add(lblwidgetHora, BorderLayout.NORTH);
	    widgetHora.add(contenidoHora, BorderLayout.CENTER);
	    widgets.add(widgetHora);

	    // Timer para actualizar hora
	    Timer timer = new Timer(1000, e -> {
	        LocalTime horaActual = LocalTime.now();
	        contenidoHora.setText(horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	    });
	    timer.start();
	    
	    ventana.add(widgets, BorderLayout.NORTH);
	    
	    // Panel de navegacion
	    JPanel  navegacion = new JPanel();
	    navegacion.setBackground(new Color(0, 77, 64));
	    navegacion.setLayout(new BoxLayout(navegacion, BoxLayout.Y_AXIS));
	    navegacion.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
	    
	    JButton btnUsuarios = new JButton("👤 Usuarios");
	    btnUsuarios.setMaximumSize(new Dimension(180, 40));
	    btnUsuarios.setBackground(new Color(255, 165, 0));
	    btnUsuarios.setForeground(new Color(0, 77, 64));
	    btnUsuarios.setFont(new Font("SansSerif", Font.BOLD, 16));
	    btnUsuarios.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	    btnUsuarios.addActionListener(e -> JOptionPane.showMessageDialog(null, "Ventana de usuarios"));
	    navegacion.add(btnUsuarios);
	    navegacion.add(Box.createVerticalStrut(10));
	    
	    JButton btnRegistros = new JButton("🗂️ Registros");
	    btnRegistros.setMaximumSize(new Dimension(180, 40));
	    btnRegistros.setBackground(new Color(255, 165, 0));
	    btnRegistros.setForeground(new Color(0, 77, 64));
	    btnRegistros.setFont(new Font("SansSerif", Font.BOLD, 16));
	    btnRegistros.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	    btnRegistros.addActionListener(e -> JOptionPane.showMessageDialog(null, "Ventana de registros"));
	    navegacion.add(btnRegistros);
	    navegacion.add(Box.createVerticalStrut(10));
	    
	    JButton btnConfiguracion = new JButton("⚙️ Configuración");
	    btnConfiguracion.setMaximumSize(new Dimension(180, 40));
	    btnConfiguracion.setBackground(new Color(255, 165, 0));
	    btnConfiguracion.setForeground(new Color(0, 77, 64));
	    btnConfiguracion.setFont(new Font("SansSerif", Font.BOLD, 16));
	    btnConfiguracion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	    btnConfiguracion.addActionListener(e -> JOptionPane.showMessageDialog(null, "Ventana de configuración"));
	    navegacion.add(btnConfiguracion);

	    ventana.add(navegacion, BorderLayout.WEST);
	    
	    JPanel contentPanel = new JPanel();
	    contentPanel.setBackground(Color.WHITE);
	    ventana.add(contentPanel, BorderLayout.CENTER);

	    ventana.setVisible(true);

	}
}
