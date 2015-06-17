package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatosMateriales {

	private static String MATERIALES="SELECT * FROM materiales";
	private static String NOMBRE="SELECT codigo FROM materiales";	
	private Connection conexion=null;
	private Statement sql = null;
	private ResultSet resultados = null;
	
	
	public DatosMateriales(){
		this.conexion=ConexionDB.getConexion();
	}
	
	public ArrayList<String[]> getMateriales(){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String[]> materiales=new ArrayList<String[]>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(MATERIALES);
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ) {
				String[] material=new String[3];
				material[0]=resultados.getString("codigo");
				material[1]=resultados.getString("descripcion");
				material[2]=resultados.getString("situacion");
				materiales.add(material);
				
				//materiales.add(resultados.getString("descripcion"));
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
		return materiales;
	}
	
	public ArrayList<String> getNombre(){
		//Creo arraylist para almacenar resultado de la consulta
		ArrayList<String> nombres= new ArrayList<String>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(NOMBRE); 
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ){
				nombres.add(resultados.getString("codigo"));
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
		return nombres;
	}
}
