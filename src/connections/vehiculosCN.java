package connections;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Containers.Container;
import Models.Vehiculo;

public class vehiculosCN {

	/**
	 * Carga todos los vehiculos en una lista
	 */
	public static void cargarVehiculos() {
		// Declare the JDBC objects.
		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM Vehiculo";
			rs = connect.stmt.executeQuery(SQL);
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

		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[Vehiculo] SET " + "[Marca] = '" + v.getMarca() + "',[Modelo] = '"
					+ v.getModelo() + "',[Puertas] = " + v.getPuertas() + ",[Color] = '" + v.getColor()
					+ "',[Combustible] = '" + v.getCombustible() + "',[Anio_Matriculacion] = '"
					+ v.getAnioMatriculacion().toString() + "',[CV] =" + v.getCV() + ",[tipo_vehiculo] = '"
					+ v.getTipovheiculo() + "' WHERE Matricula='" + v.getMatricula() + "'";
			connect.stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

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
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "INSERT INTO [dbo].[Vehiculo]([Matricula],[Marca],[Modelo],[Puertas],[Color],[Combustible],[Anio_Matriculacion],[CV],[DNI_Cliente],[tipo_vehiculo])VALUES"
					+ "('" + v.getMatricula() + "','" + v.getMarca() + "','" + v.getModelo() + "'," + v.getPuertas()
					+ ",'" + v.getColor() + "','" + v.getCombustible() + "','" + v.getAnioMatriculacion().toString()
					+ "'," + v.getCV() + "," + v.getDniDuenio() + ",'" + v.getTipovheiculo() + "')";
			connect.stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

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
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[Vehiculo] SET [DNI_Cliente] = '" + c.getDni() + "' WHERE Matricula='"
					+ v.getMatricula() + "'";
			connect.stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR en asignarDuenio.");

		}
	}
}
