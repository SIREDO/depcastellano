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
import java.awt.SystemColor;

public class Profesores extends JPanel {

	private JLabel lbMiembros, fondo;
	private JComboBox boxProfes;
	
	private DatosProfesores profLista= new DatosProfesores();
	/**
	 * Create the panel.
	 */
	public Profesores() {
		setBackground(SystemColor.textHighlightText);
		setLayout(null);
		
		lbMiembros = new JLabel("Miembros del Departamento");
		lbMiembros.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lbMiembros.setBounds(57, 187, 340, 42);
		add(lbMiembros);
		
		boxProfes = new JComboBox();
		boxProfes.setMaximumRowCount(2);
		Iterator<String> recorredor=profLista.getProfesores().iterator();
		while (recorredor.hasNext()){
			boxProfes.addItem(recorredor.next().toString()); 
		}
		boxProfes.setFont(new Font("Calibri", Font.BOLD, 24));
		boxProfes.setBounds(94, 240, 260, 36);
		add(boxProfes);
		
		
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Profesores.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(352, 110, 459, 504);
		this.add(fondo);
		

	}
}
