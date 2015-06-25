package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DatosMateriales {

	//private static String MATERIALES="SELECT * FROM materiales where codigo='"+materialSeleccionado+"'";
	//private static String IDPREST="SELECT id FROM materiales where codigo='"+matSeleccionado+"'"; 
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
	
	//metodo que devuelve un listado de materiales del departamento, que cuando seleccionas uno muestra su descripcion y localizacion
	public ArrayList<String[]> getMateriales(String materialSeleccionado){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String[]> materiales=new ArrayList<String[]>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery("SELECT * FROM materiales where codigo='"+materialSeleccionado+"'" ); 
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ) {
				String[] material=new String[3];
				material[0]=resultados.getString("codigo");
				material[1]=resultados.getString("descripcion");
				material[2]=resultados.getString("situacion");
				materiales.add(material);
				
				
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
	
	//metodo que devuelve listado de los nombres de los materiales del departamento
	
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
	
	
	//metodo que devuelve listado de nombres de materiales disponibles
	
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
	
	//metodo que devuelve listado de nombres y sus id de los materiales disponibles
	
	public ArrayList<String[]> getMaterialesDisponibles(){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String[]> materiales=new ArrayList<String[]>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery(MATERIALDISPONIBLE); 
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ) {
				String[] material=new String[2];
				material[0]=resultados.getString("codigo");
				material[1]=resultados.getString("id");
			
				materiales.add(material);
				
				
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
	
	//metodo que inserta el la tabla de la bbdd un nuevo prestamo
	
	public void realizarPrestamo(String idMat, String idProf, String fechaini, String fechafin){
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			sql.executeUpdate("INSERT INTO prestamo (idmaterial, idprofesor, fechaprestamo, fechadevolucion) VALUES ('"+idMat+"','"+idProf+"','"+fechaini+"','"+fechafin+"')");
			
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
	}
	
	//metodo que actualiza la tabla materiales de la bbdd cuando uno es prestado
	
	public void actualizaMaterialPrestado(String codigoMat){
		
			try{
				//sentencia sql
				this.sql = this.conexion.createStatement();
				sql.executeUpdate("update materiales set prestado='1' where codigo='"+codigoMat+"'");
						
							
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
		}
	
	//medotodo que devuelve el id de un material prestado
	
	public String getIdPrest(String matSeleccionado){
		String idPrest = new String();
		 
		try {
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery("SELECT id FROM materiales where codigo='"+matSeleccionado+"'" );
			
			while(resultados.next()){
			       idPrest=resultados.getString("id");
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
		return idPrest;
		
	}
	
	/*metodo que actualiza la tabla materiales de la bbdd cuando se finaliza un prestamo
	 * y borra de la tabla prestamo el material devuelto
	 */
	
	public void anulaMaterialPrestado(String codigoMat, String idMat){
		
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			sql.executeUpdate("update materiales set prestado='0' where codigo='"+codigoMat+"'");
			sql.executeUpdate("delete from prestamo where idmaterial='"+idMat+"'");		
						
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
	}
	
	
	//metodo que los devuelve listado de materiales prestados y profesor que lo tiene
	
	public ArrayList<String> getMaterialesPrestados(){
		//creo arrayList para almacenar resultado de la consulta
		ArrayList<String> materiales=new ArrayList<String>();
		try{
			//sentencia sql
			this.sql = this.conexion.createStatement();
			this.resultados = sql.executeQuery("SELECT `materiales`.`codigo`, `profesores`.`nombre`,`profesores`.`apellidos` FROM `materiales`  INNER JOIN `prestamo`ON `materiales`.`id`=`prestamo`.`idmaterial` INNER JOIN `profesores`ON `profesores`.`id`=`prestamo`.`idprofesor`");
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			
			while( resultados.next() ) {
				materiales.add(resultados.getString("codigo")+" "+resultados.getString("nombre")+" "+resultados.getString("apellidos"));
				
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
	
	
	//metodo que los devuelve listado de materiales prestados
		
	public ArrayList<String> getMaterialPrestado(){
			//creo arrayList para almacenar resultado de la consulta
			ArrayList<String> materiales=new ArrayList<String>();
			try{
				//sentencia sql
				this.sql = this.conexion.createStatement();
				this.resultados = sql.executeQuery("SELECT `materiales`.`codigo`, `profesores`.`nombre`,`profesores`.`apellidos` FROM `materiales`  INNER JOIN `prestamo`ON `materiales`.`id`=`prestamo`.`idmaterial` INNER JOIN `profesores`ON `profesores`.`id`=`prestamo`.`idprofesor`");
						
				//Recorremos los resultados y los almacenamos en un ArrayList
				
				while( resultados.next() ) {
					materiales.add(resultados.getString("codigo"));
					
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
		
	
	}

