package vistas;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import modelo.DatosMateriales;
import modelo.DatosProfesores;

import java.awt.Font;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.JTextField;

public class ListadoMateriales extends JPanel {

	//private static final ListModel matLista = null;
	private JLabel lbMateriales, fondo;
	private JComboBox boxMateriales;
	private DatosMateriales matLista= new DatosMateriales();
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public ListadoMateriales() {
		setLayout(null);
		
		lbMateriales = new JLabel("Materiales disponibles");
		lbMateriales.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lbMateriales.setBounds(91, 50, 266, 35);
		add(lbMateriales);
		
		/*boxMateriales = new JComboBox();
		boxMateriales.setMaximumRowCount(2);
		
		boxMateriales.setFont(new Font("Calibri", Font.BOLD, 24));
		boxMateriales.setBounds(65, 487, 317, 36);
		add(boxMateriales);*/
		
		JList listProfes = new JList();
		
		
		listProfes.setBounds(0, 570, 374, -263);
		JScrollPane scrollMat = new JScrollPane(listProfes);
		scrollMat.setLocation(44, 96);
		scrollMat.setSize(367, 258);
		add(scrollMat);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblDescripcion.setBounds(44, 367, 126, 25);
		add(lblDescripcion);
		
		textField = new JTextField();
		textField.setBounds(44, 403, 278, 53);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblLocalizacin = new JLabel("Localizaci\u00F3n");
		lblLocalizacin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblLocalizacin.setBounds(44, 467, 143, 25);
		add(lblLocalizacin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(44, 503, 278, 35);
		add(textField_1);
		textField_1.setColumns(10);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(ListadoMateriales.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(332, 158, 428, 442);
		add(fondo);

	}
}
