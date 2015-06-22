package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DatosMateriales {

	//private static String MATERIALES="SELECT * FROM materiales where codigo='"+materialSeleccionado+"'";
	private static String NOMBRE="SELECT codigo FROM materiales";	
	private static String MATERIALDISPONIBLE="SELECT codigo FROM materiales where prestado=0";
	private static String MATERIALPRESTADO="SELECT codigo FROM materiales where prestado=1";
	//private static String MATERIALESPRESTADOS="SELECT codigo, nombre FROM prestamo INNER JOIN materiales ON prestamo.idmaterial=materiales.id INNER JOIN profesores ON prestamo.idprofesor=profesor.id";
	private Connection conexion=null;
	private Statement sql = null;
	private ResultSet resultados = null;
	
	
	public DatosMateriales(){
		this.conexion=ConexionDB.getConexion();
	}
	//
	public ArrayList<String[]> getMateriales(String materialSeleccionado){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String[]> materiales=new ArrayList<String[]>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery("SELECT * FROM materiales where codigo='"+materialSeleccionado+"'" ); 
					//"
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
	public ArrayList<String> getNombrePrestado(){
		//Creo arraylist para almacenar resultado de la consulta
		ArrayList<String> nombres= new ArrayList<String>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(MATERIALPRESTADO); 
					
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
	
	
	public ArrayList<String> getMaterialDisp(){
		//Creo arraylist para almacenar resultado de la consulta
		ArrayList<String> disponibles= new ArrayList<String>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(MATERIALDISPONIBLE); 
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ){
				disponibles.add(resultados.getString("codigo"));
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
		return disponibles;
	}
	public ArrayList<String[]> getMaterialesDisponibles(String materialSelecc){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String[]> materiales=new ArrayList<String[]>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(MATERIALDISPONIBLE); 
					//"
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
	public void realizarPrestamo(int idMat, int idProf){
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			sql.executeUpdate("INSERT INTO prestamo (idmaterial,idprofesor, fechaprestamo, fechadevolucion) VALUES (?,?,?,?)");
			//sql.executeUpdate("update materiales set prestado='1' where codigo='"+nomMat+"'");
					
						
		}catch( SQLException excepcionSql ) {
			excepcionSql.printStackTrace();
		}finally{
			try{
				sql.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}
	public void actualizaMaterialPrestado(String codigoMat){
		
			try{
				//sentencia sql
				this.sql = this.conexion.createStatement();
				sql.executeUpdate("update materiales set prestado='1' where codigo='"+codigoMat+"'");
						
							
			}catch( SQLException excepcionSql ) {
				excepcionSql.printStackTrace();
			}finally{
				try{
					sql.close();
				}
				catch( SQLException excepcionSql ) 
				{
					excepcionSql.printStackTrace();
				}
			}
		}
	public void anulaMaterialPrestado(String codigoMat){
		
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			sql.executeUpdate("update materiales set prestado='0' where codigo='"+codigoMat+"'");
					
						
		}catch( SQLException excepcionSql ) {
			excepcionSql.printStackTrace();
		}finally{
			try{
				sql.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
	}
	}

