package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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

	
	private JComboBox boxProfes, boxMatPrest;
	private JLabel lblNomProfesor, lblMatPrest,lblFormulario, fondo;
	private JButton btnFinaliza;
	private DatosProfesores profLista= new DatosProfesores();
	private DatosMateriales matdat= new DatosMateriales();
	/**
	 * Create the panel.
	 */
	public ModificaPrestamo() {
		setBackground(SystemColor.textHighlightText);
		setForeground(Color.WHITE);
		setLayout(null);
		
		lblNomProfesor = new JLabel("Profesor/a:");
		lblNomProfesor.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblNomProfesor.setBounds(67, 201, 161, 31);
		this.add(lblNomProfesor);
		
		boxProfes = new JComboBox();
		Iterator<String> recorredor1=profLista.getProfesores().iterator();
		while (recorredor1.hasNext()){
			boxProfes.addItem(recorredor1.next().toString()); 
		}
		boxProfes.setBounds(67, 254, 266, 20);
		this.add(boxProfes);
		
		lblMatPrest = new JLabel("Materiales prestados:");
		lblMatPrest.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblMatPrest.setBounds(67, 293, 266, 31);
		this.add(lblMatPrest);
		
		boxMatPrest = new JComboBox();
		Iterator<String> recorredor=matdat.getNombrePrestado().iterator();
		while (recorredor.hasNext()){
			boxMatPrest.addItem(recorredor.next().toString()); 
		}
		boxMatPrest.setBounds(67, 346, 266, 20);
		this.add(boxMatPrest);
		
	
		
		btnFinaliza = new JButton("Finalizar");
		btnFinaliza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				matdat.anulaMaterialPrestado(boxMatPrest.getSelectedItem().toString());
			}
		});
		btnFinaliza.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnFinaliza.setBounds(65, 411, 103, 23);
		this.add(btnFinaliza);
		
		lblFormulario = DefaultComponentFactory.getInstance().createTitle("Finalizar reserva");
		lblFormulario.setForeground(SystemColor.desktop);
		lblFormulario.setBackground(SystemColor.window);
		lblFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormulario.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblFormulario.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblFormulario.setBounds(195, 46, 410, 92);
		this.add(lblFormulario);
		
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(RealizaPrestamo.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(311, 149, 438, 405);
		this.add(fondo);
		
	}

}
