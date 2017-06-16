package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Containers.Container;
import Models.Vehiculo;

public class vehiculosCN {
	// Create a variable for the connection string.
	private static String connectionUrl = "jdbc:sqlserver://MSI\\SERGIOPLA:1433;"
			+ "databaseName=Taller;user=sergio;password=1234";

	/**
	 * Carga todos los vehiculos en una lista
	 */
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
			Container.listaVehiculos = new ArrayList<>();
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				Container.listaVehiculos.add(new Vehiculo(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getDate(7).toLocalDate(), rs.getInt(8), rs.getString(6),
						rs.getString(10), rs.getString(9)));
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

	/**
	 * Actualiza un vehiculo en la base de datos con sus nuevos valores
	 * 
	 * @param v
	 *            vehiculo cambiado para actualizarlo
	 */
	public static void actualizarVehiculo(Models.Vehiculo v) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[Vehiculo] SET " + "[Marca] = '" + v.getMarca() + "',[Modelo] = '"
					+ v.getModelo() + "',[Puertas] = " + v.getPuertas() + ",[Color] = '" + v.getColor()
					+ "',[Combustible] = '" + v.getCombustible() + "',[Anio_Matriculacion] = '"
					+ v.getAnioMatriculacion().toString() + "',[CV] =" + v.getCV() + ",[tipo_vehiculo] = '"
					+ v.getTipovheiculo() + "' WHERE Matricula='" + v.getMatricula() + "'";
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

	/**
	 * Inserta un vehiculo en la BBDD
	 * 
	 * @param v
	 *            Vehiculo a insertar
	 */
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
			String SQL = "INSERT INTO [dbo].[Vehiculo]([Matricula],[Marca],[Modelo],[Puertas],[Color],[Combustible],[Anio_Matriculacion],[CV],[DNI_Cliente],[tipo_vehiculo])VALUES"
					+ "('" + v.getMatricula() + "','" + v.getMarca() + "','" + v.getModelo() + "'," + v.getPuertas()
					+ ",'" + v.getColor() + "','" + v.getCombustible() + "','" + v.getAnioMatriculacion().toString()
					+ "'," + v.getCV() + "," + v.getDniDuenio() + ",'" + v.getTipovheiculo() + "')";
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

	/**
	 * Le asigna a un vehiculo su cliente dueño
	 * 
	 * @param c
	 *            cliente para asignar
	 * @param v
	 *            vahiculo que recive el cliente
	 */
	public static void asignarDuenio(Models.ClienteModels c, Models.Vehiculo v) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[Vehiculo] SET [DNI_Cliente] = '" + c.getDni() + "' WHERE Matricula='"
					+ v.getMatricula() + "'";
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
