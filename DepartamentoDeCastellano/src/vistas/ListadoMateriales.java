package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ListadoMateriales extends JPanel {

	private JLabel lbMateriales, fondo;
	/**
	 * Create the panel.
	 */
	public ListadoMateriales() {
		setLayout(null);
		
		lbMateriales = new JLabel("Materiales disponibles");
		lbMateriales.setFont(new Font("Calibri", Font.BOLD, 26));
		lbMateriales.setBounds(141, 110, 256, 35);
		add(lbMateriales);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(ListadoMateriales.class.getResource("/imagenes/fondoliso.png")));
		fondo.setBounds(0, 0, 800, 600);
		add(fondo);

	}

}
