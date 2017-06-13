package connections;

import java.awt.Frame;
import java.sql.*;

import javax.swing.JOptionPane;

import Containers.*;
import Models.Usuario;
import Models.Vehiculo;

public class connect {
	// Create a variable for the connection string.
	private static String connectionUrl = "jdbc:sqlserver://MSI\\SERGIOPLA:1433;"
			+ "databaseName=Taller;user=sergio;password=1234";

	// Declare the JDBC objects.

	public static void main(String[] args) {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://JR\\PAN/localhost:1433;"
				+ "databaseName=jardineria;user=admin;password=1234";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT Nombre FROM Empleados";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(1));
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	public static void cargarMecanicos() {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM Mecanico";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				Container.listaMecanicos.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getDate(7).toLocalDate()));
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se puede conectar con la base de datos, se cargara un usuario por defecto.");

			Container.listaMecanicos.add(new Usuario("usuario", "1234"));
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	public static void cargarVehiculos() {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM Vehiculo";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				Container.listaVehiculos
						.add(new Vehiculo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
								rs.getString(5), rs.getDate(7).toLocalDate(), rs.getInt(8), rs.getString(6), null));
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	public static void actualizarVehiculo(Models.Vehiculo v) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs ;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[Vehiculo] SET " + "[Marca] = '" + v.getMarca() + "',[Modelo] = '"
					+ v.getModelo() + "',[Puertas] = " + v.getPuertas() + ",[Color] = '" + v.getColor()
					+ "',[Combustible] = '" + v.getCombustible() + "',[Anio_Matriculacion] = '"
					+ v.getAnioMatriculacion().toString() + "',[CV] =" + v.getCV() +
					"WHERE Matricula='" + v.getMatricula()+"'";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

		} finally {
			
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	public static void insertarVehiculo(Models.Vehiculo v) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "INSERT INTO [dbo].[Vehiculo]([Matricula],[Marca],[Modelo],[Puertas],[Color],[Combustible],[Anio_Matriculacion],[CV],[DNI_Cliente])VALUES"
					+ "('" + v.getMatricula() + "','" + v.getMarca() + "','" + v.getModelo() + "'," + v.getPuertas() + ",'"
					+ v.getColor() + "','" + v.getCombustible() + "','" + v.getAnioMatriculacion().toString() + "',"
					+ v.getCV() + ",null)";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

		} finally {
			
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

}
