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
import javax.swing.SwingConstants;

public class Inicial extends JPanel {

	private JLabel lbMiembros, fondo;
	
	private DatosProfesores profLista= new DatosProfesores();
	/**
	 * Create the panel.
	 */
	public Inicial() {
		setLayout(null);
			
			JLabel lbltitulo = new JLabel("Departamento de Lengua ");
			lbltitulo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
			lbltitulo.setBounds(44, 217, 474, 60);
			add(lbltitulo);
			
			JLabel lblTitulo2 = new JLabel("castellana y Literatura");
			lblTitulo2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTitulo2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
			lblTitulo2.setBounds(54, 275, 451, 60);
			add(lblTitulo2);
		
			fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Inicial.class.getResource("/imagenes/fondoliso.png")));
		fondo.setBounds(0, 0, 800, 600);
		this.add(fondo);
		

	}
}
