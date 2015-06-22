package vistas;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import modelo.DatosMateriales;
import modelo.DatosProfesores;

import java.awt.Font;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ListadoMateriales extends JPanel {

	//private static final ListModel matLista = null;
	private JLabel lbMateriales, fondo;
	private JComboBox boxMateriales;
	private DatosMateriales matLista;
	private Iterator<String[]> infoMateriales;
	private String[] material;
	private JTextArea textDescripcion; 
	private JTextField textLocalizacion;
	/**
	 * Create the panel.
	 * @param materialesnombres 
	 */
	public ListadoMateriales(DatosMateriales materiales) {
		setBackground(SystemColor.window);
		setLayout(null);
		this.matLista=materiales;
		
		lbMateriales = new JLabel("Materiales disponibles");
		lbMateriales.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lbMateriales.setBounds(44, 44, 266, 35);
		add(lbMateriales);
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblDescripcion.setBounds(44, 321, 126, 25);
		add(lblDescripcion);
		
		textDescripcion = new JTextArea();
		textDescripcion.setBackground(SystemColor.controlHighlight);
		textDescripcion.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textDescripcion.setFont(new Font("Arial", Font.BOLD, 14));
		textDescripcion.setRows(3);
		textDescripcion.setLineWrap(true);
		textDescripcion.setWrapStyleWord(true);
		textDescripcion.setBounds(44, 354, 278, 74);
		add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblLocalizacin = new JLabel("Localizaci\u00F3n");
		lblLocalizacin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblLocalizacin.setBounds(44, 451, 143, 25);
		add(lblLocalizacin);
		
		textLocalizacion = new JTextField();
		textLocalizacion.setBackground(SystemColor.controlHighlight);
		textLocalizacion.setHorizontalAlignment(SwingConstants.CENTER);
		textLocalizacion.setFont(new Font("Arial", Font.BOLD, 14));
		textLocalizacion.setBorder(new LineBorder(Color.BLACK, 2));
		textLocalizacion.setBounds(44, 487, 278, 35);
		add(textLocalizacion);
		textLocalizacion.setColumns(10);
		
		
		String[] materialesnombres= matLista.getNombre().toArray(new String[matLista.getNombre().size()]);
		
		JList listMaterial = new JList(materialesnombres);
		listMaterial.setBackground(SystemColor.controlHighlight);
		listMaterial.setFont(new Font("Arial", Font.BOLD, 14));
		listMaterial.setBorder(null);
		listMaterial.setBounds(0, 570, 374, -263);
		listMaterial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		listMaterial.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			//System.out.println(listMaterial.getSelectedValue());
			infoMateriales = materiales.getMateriales((String)listMaterial.getSelectedValue()).iterator();
			while(infoMateriales.hasNext()){
				material=infoMateriales.next();
				
				textDescripcion.setText(material[1]);
				textLocalizacion.setText(material[2]);
				
			}
			
		}
	});
		JScrollPane scrollMat = new JScrollPane(listMaterial);
		scrollMat.setBorder(new LineBorder(SystemColor.desktop, 2));
		scrollMat.setLocation(44, 90);
		scrollMat.setSize(324, 200);
		add(scrollMat);
		
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(ListadoMateriales.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(332, 158, 428, 442);
		add(fondo);

	}
}
