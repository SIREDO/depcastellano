package vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

public class RealizaPrestamo extends JPanel {

	/**
	 * Create the panel.
	 */
	public RealizaPrestamo() {
		setForeground(Color.WHITE);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(67, 288, 256, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(67, 215, 256, 20);
		add(comboBox_1);
		
		JLabel lblNomProfesor = new JLabel("Profesor/a:");
		lblNomProfesor.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNomProfesor.setBounds(67, 173, 131, 31);
		add(lblNomProfesor);
		
		JLabel lblMatDisp = new JLabel("Materiales disponibles:");
		lblMatDisp.setFont(new Font("Calibri", Font.BOLD, 26));
		lblMatDisp.setBounds(67, 246, 256, 31);
		add(lblMatDisp);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(RealizaPrestamo.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(357, 197, 438, 405);
		add(fondo);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(67, 368, 161, 20);
		add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(67, 452, 161, 20);
		add(dateChooser_1);
		
		JLabel lblInicioPrstamo = new JLabel("Inicio Pr\u00E9stamo:");
		lblInicioPrstamo.setFont(new Font("Calibri", Font.BOLD, 26));
		lblInicioPrstamo.setBounds(67, 326, 188, 31);
		add(lblInicioPrstamo);
		
		JLabel lblFinPrstamo = new JLabel("Fin Pr\u00E9stamo:");
		lblFinPrstamo.setFont(new Font("Calibri", Font.BOLD, 26));
		lblFinPrstamo.setBounds(67, 410, 155, 31);
		add(lblFinPrstamo);
		
		JButton btnReserva = new JButton("Reservar");
		btnReserva.setFont(new Font("Calibri", Font.BOLD, 16));
		btnReserva.setBounds(67, 504, 103, 23);
		add(btnReserva);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Formulario de reserva");
		lblNewJgoodiesTitle.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblNewJgoodiesTitle.setBounds(239, 46, 322, 40);
		add(lblNewJgoodiesTitle);

	}
}
