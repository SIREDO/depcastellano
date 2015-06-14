package vistas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class Portada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Portada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Portada.class.getResource("/imagenes/icono2.png")));
		setResizable(false);
		setTitle("Departamento de Lengua castellana y Literatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 635);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu profesores = new JMenu("Profesores");
		menuBar.add(profesores);
		
		JMenu materiales = new JMenu("Materiales");
		menuBar.add(materiales);
		
		JMenuItem listadoMateriales = new JMenuItem("Listado general");
		materiales.add(listadoMateriales);
		
		JMenuItem prestados = new JMenuItem("Prestados actualmente");
		materiales.add(prestados);
		
		JMenu prestamos = new JMenu("Pr\u00E9stamos");
		menuBar.add(prestamos);
		
		JMenuItem realizPrestamo = new JMenuItem("Realizar pr\u00E9stamo");
		prestamos.add(realizPrestamo);
		
		JMenuItem modifPrestamo = new JMenuItem("Anular o finalizar pr\u00E9stamo");
		prestamos.add(modifPrestamo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
