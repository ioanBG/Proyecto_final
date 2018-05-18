import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

	@SuppressWarnings("unused")
	public class CONEXIONBBDD {

		private String bd;
		private String url;
		private String usr; 
		private String pwd;
		private String esquema; 
		private Connection conexion;
		

		public CONEXIONBBDD()  {
			Ficheroini();
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
			String [] columnas = {"ID_producto","Nombre","Precio","Caducidad"};
			String [] registro = new String[5];
			DefaultTableModel Productos = new DefaultTableModel(null,columnas);
			String query = "SELECT id_producto, nombre, precio, caducidad FROM " + esquema + ".productos p, " + esquema + ".categoria c WHERE p.id_categoria = c.id_categoria";
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
		
		
		public void Aumentar(String id, String nombre, String precio, String caducidad, String categoria) {
			if(id != "" && nombre != "" && precio != "" && caducidad != "" && categoria != "") {
				String query = "INSERT INTO " + esquema + ".productos VALUES (" + id + ", '" + nombre + "', " + precio + ", '" + caducidad + "', " + categoria + ")";
				try {
					System.out.println(query);
					Statement stmt = conexion.createStatement();
					stmt.executeUpdate(query);
					stmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error, necesita rellenar todos los campos");
			}
		}
		
		
		public void Eliminar(String eliminar) {
			String query = "DELETE FROM " + esquema + ".productos WHERE ID_producto = " + eliminar + "";
			try {
				Statement stmt = conexion.createStatement();
				stmt.executeUpdate(query);
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public void Modificar(String id, String nombre, String precio, String caducidad, String categoria) {
			if(id != "") {
				if(nombre != "") {
					String query =  "UPDATE " + esquema + ".productos SET nombre = '" + nombre + "' WHERE ID_producto = " + id + "";
					try {
						Statement stmt = conexion.createStatement();
						stmt.executeUpdate(query);
						stmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(precio != "") {
					String query = "UPDATE " + esquema + ".productos SET precio = " + precio + " WHERE ID_producto = " + id + "";
					try {
						Statement stmt = conexion.createStatement();
						stmt.executeUpdate(query);
						stmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(caducidad != "") {
					String query =  "UPDATE " + esquema + ".productos SET caducidad = '" + caducidad + "' WHERE ID_producto = " + id + "";
					try {
						Statement stmt = conexion.createStatement();
						stmt.executeUpdate(query);
						stmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(categoria != "") {
					String query = "UPDATE " + esquema + ".productos SET id_categoria = " + categoria + " WHERE ID_producto = " + id + "";
					try {
						Statement stmt = conexion.createStatement();
						stmt.executeUpdate(query);
						stmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
				}
			}
		}
			}
		
		
		public DefaultTableModel Agregar(String id, DefaultTableModel Agregar) {
			String [] registro = new String[2];
			String query = "SELECT id_producto, nombre FROM " + esquema + ".productos WHERE id_producto = " + id + "";
			if(id != "") {
				try {
					Statement stmt = conexion.createStatement();
					ResultSet rset = stmt.executeQuery(query);
					while(rset.next()) {
						 registro[0]=rset.getString("id_producto");
						 registro[1]=rset.getString("nombre");
				         Agregar.addRow(registro);
					}
					rset.close();
					stmt.close();
					
				}catch (SQLException s){
					s.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error, necesita rellenar el campo 'ID'");
			}
		return Agregar;
		}
		
		
		public void Guardar(DefaultTableModel tabla, String numero) {
			if(numero != "") {
				for(int i = 0; i < tabla.getRowCount(); i++) {
					String producto = tabla.getValueAt(i, 0).toString();
					String query = "INSERT INTO " + esquema + ".pedidos VALUES (" + numero + ", " + producto + ")";
					try {
						System.out.println(query);
						Statement stmt = conexion.createStatement();
						stmt.executeUpdate(query);
						stmt.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Algo ha salido mal");
			}
		}
		
		
		public int Cobrar(String pedido) {
			int total = 0;
			String query = "SELECT SUM (precio) FROM " + esquema + ".productos p, " + esquema + ".pedidos e WHERE p.id_producto = e.id_producto AND e.id_pedido = " + pedido + "";
			try {
				System.out.println(query);
				Statement stmt = conexion.createStatement();
				ResultSet rset= stmt.executeQuery(query);
				while(rset.next()) {
					total = rset.getInt("SUM(precio)");
				}
				rset.close();
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return total;
		}

		
		public DefaultTableModel Actualizar() {
			String [] columnas = {"Pedidos_existentes"};
			String [] registro = new String[1];
			DefaultTableModel Productos = new DefaultTableModel(null,columnas);
			String query = "SELECT DISTINCT id_pedido FROM pedidos";
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(query);
				while(rset.next()) {
					 registro[0]=rset.getString("id_pedido");
			         Productos.addRow(registro);
				}
				rset.close();
				stmt.close();
			}catch (SQLException s){
				s.printStackTrace();
			}
			return Productos;
		}
		
		
		public DefaultTableModel Ok(String texto) {
			String [] columnas = {"ID_producto, Nombre"};
			String [] registro = new String[2];
			DefaultTableModel Ok = new DefaultTableModel(null,columnas);
			String query = "SELECT id_producto, nombre FROM " + esquema + ".productos p, " + esquema + ".pedidos e WHERE e.id_pedido = " + texto + "";
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(query);
				while(rset.next()) {
					 registro[0]=rset.getString("id_producto");
					 registro[1]=rset.getString("nombre");
			         Ok.addRow(registro);
				}
				rset.close();
				stmt.close();
			}catch (SQLException s){
				s.printStackTrace();
			}
			return Ok;
		}
		
		
		public void Ficheroini() {
			Properties propiedades = new Properties();
			InputStream entrada = null;
			try {
				File miFichero = new File("src/BBDD.ini");
				if(miFichero.exists()) {
					entrada = new FileInputStream(miFichero);
					propiedades.load(entrada);
					url = propiedades.getProperty("BaseDeDatos");
					usr = propiedades.getProperty("Usuario");
					pwd = propiedades.getProperty("Contraseña");
					esquema = propiedades.getProperty("Esquema");
				}
				else {
					System.err.println("Fichero no encontrado");
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			} finally {
				if(entrada != null) {
					try {
						entrada.close();
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

