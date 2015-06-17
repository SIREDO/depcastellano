package modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;


public class DatosProfesores {
	
	//SQL
	private static String PROFESORES="SELECT nombre, apellidos FROM profesores";
	//private static String APELLIDOS="SELECT apellidos FROM profesores";
	//	
	private Connection conexion=null;
	private Statement sql = null;
	private ResultSet resultados = null;
	
	
	public DatosProfesores(){
		this.conexion=ConexionDB.getConexion();
	}
	
	public ArrayList<String> getProfesores(){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String> profesores=new ArrayList<String>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(PROFESORES);
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ) {
				profesores.add(resultados.getString("nombre")+" "+resultados.getString("apellidos"));
			}
			
		}catch( SQLException excepcionSql ) {
			excepcionSql.printStackTrace();
		}finally{
			try{
				resultados.close();
				sql.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		return profesores;
	}
}
