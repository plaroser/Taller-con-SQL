package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Containers.Container;
import Models.Usuario;

public class mecanicoCN {
	// Create a variable for the connection string.
	private static String connectionUrl = "jdbc:sqlserver://MSI\\SERGIOPLA:1433;"
			+ "databaseName=Taller;user=sergio;password=1234";

	/**
	 * Carga todos los mecanicos en una lista
	 */
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
			Container.listaMecanicos = new ArrayList<>();
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
}
