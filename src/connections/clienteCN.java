package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Containers.Container;
import Models.ClienteModels;

public class clienteCN {
	// Create a variable for the connection string.
	private static String connectionUrl = "jdbc:sqlserver://MSI\\SERGIOPLA:1433;"
			+ "databaseName=Taller;user=sergio;password=1234";

	/**
	 * Carga todos los clientes en una lista
	 */
	public static void cargarClientes() {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM [Taller].[dbo].[Cliente]";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
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
	 * Busca un cliente a traves de su DNI
	 * 
	 * @param dniCliente
	 *            DNI que buscar
	 * @return Cliente encontrado con dicho DNI
	 */
	@SuppressWarnings("finally")
	public static ClienteModels getCliente(String dniCliente) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ClienteModels clienteAux = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT TOP 1 * FROM [Taller].[dbo].[Cliente] WHERE DNI LIKE '" + dniCliente + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

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
			return clienteAux;
		}
	}

	/**
	 * Inserta un cliente dentro de la BBDD
	 * 
	 * @param c
	 *            Cliente a insertar
	 */
	public static void insertarCliente(ClienteModels c) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "INSERT INTO [dbo].[Cliente] VALUES('" + c.getDni() + "','" + c.getNombre() + "','"
					+ c.getApellidos() + "','" + c.getTelefono() + "','" + c.getEmail() + "','" + c.getDireccion()
					+ "')";
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
	 * ACtualiza un cliente dentro de la BBDD
	 * 
	 * @param c
	 *            Cliente a modificar con los cambios ya realizados
	 */
	public static void actualizarCliente(ClienteModels c) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[Cliente] SET [Nombre] = '" + c.getNombre() + "' ,[Apellido] = '"
					+ c.getApellidos() + "' ,[Telefono] = '" + c.getTelefono() + "' ,[Email] = '" + c.getEmail()
					+ "' ,[direccion] = '" + c.getDireccion() + "'WHERE DNI = '" + c.getDni() + "'";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos en actualizarCliente().");

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
