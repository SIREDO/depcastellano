package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;

public class Profesores extends JPanel {

	private JLabel miembros, fondo;
	private JList listaProfes;
	private JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public Profesores() {
		setLayout(null);
		
		miembros = new JLabel("Miembros del Departamento");
		miembros.setFont(new Font("Calibri", Font.BOLD, 26));
		miembros.setBounds(37, 45, 320, 42);
		add(miembros);
		
		listaProfes = new JList();
		
		listaProfes.setForeground(Color.ORANGE);
		listaProfes.setBackground(Color.LIGHT_GRAY);
		listaProfes.setBounds(180, 155, 256, 279);
		scrollPane = new JScrollPane(listaProfes);
		scrollPane.setBounds(148, 155, 288, 279);
		add(scrollPane);
		
		
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Profesores.class.getResource("/imagenes/fondoliso.png")));
		fondo.setBounds(0, 0, 800, 600);
		add(fondo);
		

	}
}
