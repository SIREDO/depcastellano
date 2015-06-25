package vistas;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.DatosMateriales;
import modelo.DatosProfesores;

import javax.swing.JTextField;
import java.awt.ComponentOrientation;

public class MaterialesPrestados extends JPanel {

	private JLabel fondo;
	private JTable table;
	private JComboBox boxMateriales;
	private DatosMateriales matLista;
	private Iterator<String[]> infoMateriales;
	private String[] material;   
	private JTextField profe;
	private JTextField id;
	
	//private String[] nombreColumnas;
	/**
	 * Create the panel.
	 */
	public MaterialesPrestados(DatosMateriales materiales){
		setBackground(SystemColor.window);
		setLayout(null);
		this.matLista=materiales;
		
		/*id = new JTextField();
		id.setBackground(SystemColor.controlHighlight);
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Arial", Font.BOLD, 14));
		id.setBorder(new LineBorder(Color.BLACK, 2));
		id.setBounds(44, 331, 86, 20);
		add(id);
		id.setColumns(10);
		
		profe = new JTextField();
		profe.setBackground(SystemColor.controlHighlight);
		profe.setHorizontalAlignment(SwingConstants.CENTER);
		profe.setFont(new Font("Arial", Font.BOLD, 14));
		profe.setBorder(new LineBorder(Color.BLACK, 2));
		profe.setBounds(44, 373, 286, 33);
		add(profe);
		profe.setColumns(10);*/
		
	//String[] materialesnombres= matLista.getNombrePrestado().toArray(new String[matLista.getNombrePrestado().size()]);
	
	/*JList listMaterialPrestado = new JList();
	listMaterialPrestado.setBackground(SystemColor.controlHighlight);
	listMaterialPrestado.setFont(new Font("Arial", Font.BOLD, 14));
	listMaterialPrestado.setBorder(null);
	listMaterialPrestado.setBounds(0, 570, 374, -263);
	listMaterialPrestado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	listMaterialPrestado.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent e) {
		//System.out.println(listMaterial.getSelectedValue());
		infoMateriales = materiales.getMatPrest().iterator();
		//(String)listMaterialPrestado.getSelectedValue()
		while(infoMateriales.hasNext()){
			material=infoMateriales.next();
			//id.setText(material[1]);
			//profe.setText(material[2]);
			
			
		}
		
	}
});
	JScrollPane scrollMat = new JScrollPane(listMaterialPrestado);
	scrollMat.setBorder(new LineBorder(SystemColor.desktop, 2));
	scrollMat.setLocation(44, 90);
	scrollMat.setSize(324, 200);
	add(scrollMat);*/
		boxMateriales = new JComboBox();
		boxMateriales.setMaximumRowCount(2);
		Iterator<String> recorredor=matLista.getMaterialesPrestados().iterator();
		while (recorredor.hasNext()){
			boxMateriales.addItem(recorredor.next().toString()); 
		}
		
		JLabel lblNewLabel = new JLabel("Materiales prestados actualmente");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblNewLabel.setBounds(31, 121, 406, 44);
		add(lblNewLabel);
		boxMateriales.setFont(new Font("Calibri", Font.BOLD, 14));
		boxMateriales.setBounds(31, 213, 382, 36);
		add(boxMateriales);
		
		

		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(MaterialesPrestados.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(311, 149, 438, 405);
		add(fondo);

	}
}
