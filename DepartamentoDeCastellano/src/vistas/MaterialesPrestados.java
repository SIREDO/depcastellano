package vistas;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.SystemColor;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.DatosMateriales;
import modelo.DatosProfesores;

public class MaterialesPrestados extends JPanel {

	private JLabel fondo;
	private JTable table;
	private DatosMateriales matLista;
	private Iterator<String[]> infoMateriales;
	private String[] material;
	
	//private String[] nombreColumnas;
	/**
	 * Create the panel.
	 */
	public MaterialesPrestados(DatosMateriales materiales){
		setBackground(SystemColor.window);
		setLayout(null);
		this.matLista=materiales;
		
	String[] materialesnombres= matLista.getNombrePrestado().toArray(new String[matLista.getNombrePrestado().size()]);
	
	JList listMaterialPrestado = new JList(materialesnombres);
	listMaterialPrestado.setBackground(SystemColor.controlHighlight);
	listMaterialPrestado.setFont(new Font("Arial", Font.BOLD, 14));
	listMaterialPrestado.setBorder(null);
	listMaterialPrestado.setBounds(0, 570, 374, -263);
	listMaterialPrestado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	listMaterialPrestado.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent e) {
		//System.out.println(listMaterial.getSelectedValue());
		infoMateriales = materiales.getMateriales((String)listMaterialPrestado.getSelectedValue()).iterator();
		while(infoMateriales.hasNext()){
			material=infoMateriales.next();
			
			
			
		}
		
	}
});
	JScrollPane scrollMat = new JScrollPane(listMaterialPrestado);
	scrollMat.setBorder(new LineBorder(SystemColor.desktop, 2));
	scrollMat.setLocation(44, 90);
	scrollMat.setSize(324, 200);
	add(scrollMat);
		

		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(MaterialesPrestados.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(365, 207, 447, 393);
		add(fondo);

	}
}
