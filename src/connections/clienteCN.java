package connections;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Containers.Container;
import Models.ClienteModels;

public class clienteCN {

	/**
	 * Carga todos los clientes en una lista
	 */
	public static void cargarClientes() {
		// Declare the JDBC objects.

		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM [Taller].[dbo].[Cliente]";
			rs = connect.stmt.executeQuery(SQL);
			Container.listaClientes = new ArrayList<>();
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				Container.listaClientes.add(new ClienteModels(rs.getString(2), rs.getString(1), rs.getString(3),
						rs.getString(6), String.valueOf(rs.getInt(4)), rs.getString(5)));
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se puede conectar con la base de datos, se cargara un usuario por defecto.");

		}
	}

	/**
	 * Busca un cliente a traves de su DNI
	 * 
	 * @param dniCliente
	 *            DNI que buscar
	 * @return Cliente encontrado con dicho DNI
	 */
	public static ClienteModels getCliente(String dniCliente) {
		// Declare the JDBC objects.
		ResultSet rs = null;
		ClienteModels clienteAux = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT TOP 1 * FROM [Taller].[dbo].[Cliente] WHERE DNI LIKE '" + dniCliente + "'";
			rs = connect.stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				clienteAux = new ClienteModels(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(6),
						String.valueOf(rs.getString(4)), rs.getString(5));
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

		}
		return clienteAux;
	}

	/**
	 * Inserta un cliente dentro de la BBDD
	 * 
	 * @param c
	 *            Cliente a insertar
	 */
	public static void insertarCliente(ClienteModels c) {

		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "INSERT INTO [dbo].[Cliente] VALUES('" + c.getDni() + "','" + c.getNombre() + "','"
					+ c.getApellidos() + "','" + c.getTelefono() + "','" + c.getEmail() + "','" + c.getDireccion()
					+ "')";
			connect.stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

		}
	}

	/**
	 * ACtualiza un cliente dentro de la BBDD
	 * 
	 * @param c
	 *            Cliente a modificar con los cambios ya realizados
	 */
	public static void actualizarCliente(ClienteModels c) {
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[Cliente] SET [Nombre] = '" + c.getNombre() + "' ,[Apellido] = '"
					+ c.getApellidos() + "' ,[Telefono] = '" + c.getTelefono() + "' ,[Email] = '" + c.getEmail()
					+ "' ,[direccion] = '" + c.getDireccion() + "'WHERE DNI = '" + c.getDni() + "'";
			connect.stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos en actualizarCliente().");

		}
	}
}
