import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

	public class CONEXIONBBDD {

		private String bd;
		private String url= "jdbc:oracle:thin:@localhost:1521:XE";
		private String usr = "lorca";
		private String pwd = "lorca";
		private Connection conexion;
		

		public CONEXIONBBDD()  {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, usr, pwd);
				
				if(!conexion.isClosed()) {
					System.out.println("Conexión establecida");
				}
				else
					System.out.println("Fallo en Conexión");	
				

			}catch (Exception e) {
				System.out.println("ERROR en conexión con ORACLE");	
				e.printStackTrace();
			}
			
		}
		
		public DefaultTableModel Productos() {
			String [] columnas={"ID_producto","Nombre","Precio","Caducidad"};
			String [] registro=new String[5];
			DefaultTableModel Productos = new DefaultTableModel(null,columnas);
			String query = "SELECT id_producto, nombre, precio, caducidad FROM lorca.productos p, lorca.categoria c WHERE p.id_categoria = c.id_categoria";
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(query);
				while(rset.next()) {
					 registro[0]=rset.getString("id_producto");
					 registro[1]=rset.getString("nombre");
			         registro[2]=rset.getString("precio");
			         registro[2]+=(" €");
			         registro[3]=rset.getString("caducidad");
			         Productos.addRow(registro);
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return Productos;
			
		}
		
		

	}

