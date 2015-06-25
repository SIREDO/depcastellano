package vistas;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.toedter.calendar.JDateChooser;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.util.Iterator;

import modelo.DatosProfesores;
import modelo.DatosMateriales;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class RealizaPrestamo extends JPanel {

	private Calendar c;
	private JComboBox boxProfes, boxMatdisp;
	private JLabel lblNomProfesor, lblMatDisp,lblInicioPrstamo,lblFinPrstamo,lblFormulario, fondo;
	private JDateChooser chooserDiaInicio, chooserDiaFin;
	private JButton btnReserva;
	private DatosProfesores profLista= new DatosProfesores();
	private DatosMateriales matdat= new DatosMateriales();
	
	/**
	 * Create the panel.
	 */
	public RealizaPrestamo() {
		setBackground(SystemColor.textHighlightText);
		setForeground(Color.WHITE);
		setLayout(null);
		
		lblFormulario = DefaultComponentFactory.getInstance().createTitle("Formulario de pr\u00E9stamo");
		lblFormulario.setForeground(SystemColor.desktop);
		lblFormulario.setBackground(SystemColor.window);
		lblFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormulario.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblFormulario.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblFormulario.setBounds(103, 46, 593, 92);
		this.add(lblFormulario);
		
		//etiqueta y combobox de profesor
		lblNomProfesor = new JLabel("Profesor/a:");
		lblNomProfesor.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblNomProfesor.setBounds(67, 173, 161, 31);
		this.add(lblNomProfesor);
		
		boxProfes = new JComboBox();
		Iterator<String> recorredor1=profLista.getProfApellidos().iterator();
		while (recorredor1.hasNext()){
			boxProfes.addItem(recorredor1.next().toString()); 
		}
		boxProfes.setBounds(67, 215, 266, 20);
		this.add(boxProfes);
		
		//etiqueta y combobox de materiales
		lblMatDisp = new JLabel("Materiales disponibles:");
		lblMatDisp.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblMatDisp.setBounds(67, 246, 290, 31);
		this.add(lblMatDisp);
		
		boxMatdisp = new JComboBox();
		Iterator<String> recorredor=matdat.getMaterialDisp().iterator();
		while (recorredor.hasNext()){
			boxMatdisp.addItem(recorredor.next().toString()); 
		}
		boxMatdisp.setBounds(67, 288, 266, 20);
		this.add(boxMatdisp);
		
		//etiquetas de chooserdia: inicio y fin prestamo
		lblInicioPrstamo = new JLabel("Inicio Pr\u00E9stamo:");
		lblInicioPrstamo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblInicioPrstamo.setBounds(67, 326, 201, 31);
		this.add(lblInicioPrstamo);	
		
		c= new GregorianCalendar();
		chooserDiaInicio = new JDateChooser();
		chooserDiaInicio.setDateFormatString("yyyy-MMMM-dd");
		chooserDiaInicio.setBounds(67, 368, 161, 20);
		this.add(chooserDiaInicio);
		chooserDiaInicio.setCalendar(c); 
		
		lblFinPrstamo = new JLabel("Fin Pr\u00E9stamo:");
		lblFinPrstamo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblFinPrstamo.setBounds(67, 410, 175, 31);
		this.add(lblFinPrstamo);
		
		chooserDiaFin = new JDateChooser(); 
		chooserDiaFin.setDateFormatString("yyyy-MMMM-dd");
		chooserDiaFin.setBounds(67, 452, 161, 20);
		this.add(chooserDiaFin);
		
		//boton que ejecutara el insert en la base de datos
		btnReserva = new JButton("Reservar");
		btnReserva.addActionListener(new ActionListener() {
			private Object ejem2;

			public void actionPerformed(ActionEvent arg0) {
				String idMat= matdat.getIdPrest(boxMatdisp.getSelectedItem().toString());
				String idprof= profLista.getIdProf(boxProfes.getSelectedItem().toString());
				int año1 = chooserDiaInicio.getCalendar().get(Calendar.YEAR);
                int mes1 = chooserDiaInicio.getCalendar().get(Calendar.MONTH) ;
                int dia1 = chooserDiaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                String fechaini= año1+"-"+(mes1+1)+"-"+dia1;
                int año2 = chooserDiaFin.getCalendar().get(Calendar.YEAR);
                int mes2 = chooserDiaFin.getCalendar().get(Calendar.MONTH) ;
                int dia2 = chooserDiaFin.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fechafin= año2+"-"+(mes2+1)+"-"+dia2;
				matdat.realizarPrestamo( idMat, idprof, fechaini, fechafin);
				matdat.actualizaMaterialPrestado(boxMatdisp.getSelectedItem().toString());
			
			}
		});
		btnReserva.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnReserva.setBounds(67, 504, 103, 23);
		this.add(btnReserva);
		
				
		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(RealizaPrestamo.class.getResource("/imagenes/prestamo.png")));
		fondo.setBounds(311, 149, 438, 405);
		this.add(fondo);
		
	}
}
