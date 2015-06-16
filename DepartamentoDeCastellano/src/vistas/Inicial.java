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

public class Inicial extends JPanel {

	private JLabel lbMiembros, fondo;
	
	private DatosProfesores profLista= new DatosProfesores();
	/**
	 * Create the panel.
	 */
	public Inicial() {
		setLayout(null);
		
			fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Inicial.class.getResource("/imagenes/fondoDept.png")));
		fondo.setBounds(0, 0, 800, 600);
		this.add(fondo);
		

	}
}
