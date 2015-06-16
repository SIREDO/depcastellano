package vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import vistas.*;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class Portada extends JFrame {

	private JPanel contenedor, panelInicial, panel1, panel2, panel3, panel4, panel5;
	private JMenuBar menuBar;
	private JMenu profesores, materiales, prestamos;
	private JMenuItem profes, listadoMateriales, prestados, realizPrestamo, modifPrestamo;

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
		setBounds(100, 100, 802, 645);
		
		contenedor=new JPanel();
		getContentPane().add(contenedor);
		contenedor.setBounds(0, 23, 800, 600);
		contenedor.setLayout(new CardLayout(0, 0));
		panelInicial= new Inicial();
		panel1=new Profesores();
		panel2=new ListadoMateriales();
		panel3=new MaterialesPrestados();
		panel4=new RealizaPrestamo();
		panel5=new ModificaPrestamo();
		contenedor.add(panelInicial, "inicial");
		contenedor.add(panel1,"profesores");
		contenedor.add(panel2,"listMateriales");
		contenedor.add(panel3,"prestados");
		contenedor.add(panel4,"prestar");
		contenedor.add(panel5,"modifPrestamo");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		profesores = new JMenu("Profesores");
		menuBar.add(profesores);
		
		profes = new JMenuItem("Profesorado");
		profes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout) contenedor.getLayout();
				c.show(contenedor, "profesores");
			}
		});
		profesores.add(profes);
		
		materiales = new JMenu("Materiales");
		menuBar.add(materiales);
		
		listadoMateriales = new JMenuItem("Listado general");
		listadoMateriales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout) contenedor.getLayout();
				c.show(contenedor, "listMateriales");
			}
		});
		materiales.add(listadoMateriales);
		
		prestados = new JMenuItem("Prestados actualmente");
		prestados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout) contenedor.getLayout();
				c.show(contenedor, "prestados");
			}
		});
		
		materiales.add(prestados);
		
		prestamos = new JMenu("Pr\u00E9stamos");
		menuBar.add(prestamos);
		
		realizPrestamo = new JMenuItem("Realizar pr\u00E9stamo");
		realizPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout) contenedor.getLayout();
				c.show(contenedor, "prestar");
			}
		});
		prestamos.add(realizPrestamo);
		
		modifPrestamo = new JMenuItem("Anular o finalizar pr\u00E9stamo");
		modifPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c=(CardLayout) contenedor.getLayout();
				c.show(contenedor, "modifPrestamo");
			}
		});
		prestamos.add(modifPrestamo);
		
		
		
	}
}
