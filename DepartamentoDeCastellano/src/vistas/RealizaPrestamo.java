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

public class RealizaPrestamo extends JPanel {

	/**
	 * Create the panel.
	 */
	public RealizaPrestamo() {
		setForeground(Color.WHITE);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(574, 91, 188, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(159, 197, 188, 20);
		add(comboBox_1);
		
		JLabel lblNomProfesor = new JLabel("Profesor/a:");
		lblNomProfesor.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNomProfesor.setBounds(631, 49, 131, 31);
		add(lblNomProfesor);
		
		JLabel lblMatDisp = new JLabel("Materiales disponibles:");
		lblMatDisp.setFont(new Font("Calibri", Font.BOLD, 26));
		lblMatDisp.setBounds(506, 144, 256, 31);
		add(lblMatDisp);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(RealizaPrestamo.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(372, 207, 438, 405);
		add(fondo);

	}

}
