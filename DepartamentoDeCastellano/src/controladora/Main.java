package controladora;
import modelo.ConexionDB;
import vistas.*;

public class Main {
	
	private static ConexionDB conexion;
	
	public static void main(String[] args) {
								
		conexion=ConexionDB.getInstance("localhost","materialdepartamento","root","silphp");
		conexion.connectDB();
		
		//se crea la ventana de la portada de la aplicación y se hace visible
		Portada ventana=new Portada();
		ventana.setVisible(true);

	}

}