package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modelo.DatosMateriales;
import modelo.DatosProfesores;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaPrestamo extends JPanel {

	
	private JComboBox boxMatPrest;
	private JLabel lblMatPrest,lblFormulario, fondo;
	private JButton btnFinaliza;
	private DatosMateriales matdat= new DatosMateriales();
	/**
	 * Create the panel.
	 */
	public ModificaPrestamo() {
		setBackground(SystemColor.textHighlightText);
		setForeground(Color.WHITE);
		setLayout(null);
		
		lblFormulario = DefaultComponentFactory.getInstance().createTitle("Finalizar pr\u00E9stamo");
		lblFormulario.setForeground(SystemColor.desktop);
		lblFormulario.setBackground(SystemColor.window);
		lblFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormulario.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblFormulario.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblFormulario.setBounds(195, 46, 410, 92);
		this.add(lblFormulario);
		
		//etiqueta y combobox que muestra un listado de materiales
		lblMatPrest = new JLabel("Selecciona Material:");
		lblMatPrest.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblMatPrest.setBounds(104, 229, 236, 31);
		this.add(lblMatPrest);
		
		boxMatPrest = new JComboBox();
		Iterator<String> recorredor=matdat.getMaterialPrestado().iterator();
		while (recorredor.hasNext()){
			boxMatPrest.addItem(recorredor.next().toString()); 
		}
		boxMatPrest.setBounds(28, 295, 312, 20);
		this.add(boxMatPrest);
		
	
		
		btnFinaliza = new JButton("Finalizar");
		btnFinaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id= matdat.getIdPrest(boxMatPrest.getSelectedItem().toString());
				matdat.anulaMaterialPrestado(boxMatPrest.getSelectedItem().toString(), id);
				
			}
		});
		btnFinaliza.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnFinaliza.setBounds(237, 345, 103, 23);
		this.add(btnFinaliza);
		
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(RealizaPrestamo.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(311, 149, 438, 405);
		this.add(fondo);
		
	}

}
