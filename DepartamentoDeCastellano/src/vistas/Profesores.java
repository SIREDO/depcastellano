package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;

import modelo.DatosProfesores;
import javax.swing.JComboBox;

public class Profesores extends JPanel {

	private JLabel lbMiembros, fondo;
	
	private DatosProfesores profLista= new DatosProfesores();
	/**
	 * Create the panel.
	 */
	public Profesores() {
		setLayout(null);
		
		lbMiembros = new JLabel("Miembros del Departamento");
		lbMiembros.setFont(new Font("Calibri", Font.BOLD, 26));
		lbMiembros.setBounds(94, 174, 320, 42);
		add(lbMiembros);
		
		JComboBox boxProfes = new JComboBox();
		boxProfes.setFont(new Font("Calibri", Font.BOLD, 24));
		boxProfes.setBounds(94, 240, 260, 36);
		add(boxProfes);
		
		
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Profesores.class.getResource("/imagenes/fondoliso.png")));
		fondo.setBounds(0, 0, 800, 600);
		this.add(fondo);
		

	}
}
