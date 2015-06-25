package modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;


public class DatosProfesores {
	
	//SQL
	private static String PROFESORES="SELECT  nombre, apellidos FROM profesores";
	private static String IDPROFESORES="SELECT id FROM profesores";
	//	
	private Connection conexion=null;
	private Statement sql = null;
	private ResultSet resultados = null;
	//private String id; 
	
	
	public DatosProfesores(){
		this.conexion=ConexionDB.getConexion();
	}
	
	//metodo que devuelve lista de profesores concatenando nombre y apellidos
	
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

	
	//metodo que devuelve lista de profesores concatenando nombre y apellidos
	
	public ArrayList<String> getProfApellidos(){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String> profesores=new ArrayList<String>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(PROFESORES);
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ) {
				profesores.add(resultados.getString("apellidos"));
				
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
	
	
	//medotodo que devuelve el id del profesor seleccionado
	
		public String getIdProf(String profSeleccionado){
			String idProf = new String();
			 
			try {
				this.sql = this.conexion.createStatement();
				this.resultados = sql.executeQuery("SELECT id FROM profesores where apellidos='"+profSeleccionado+"'" );
				
				while(resultados.next()){
				       idProf=resultados.getString("id");
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
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
			return idProf;
			
		}
	
}
