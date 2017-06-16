package connections;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Containers.Container;
import Models.Usuario;

public class mecanicoCN {

	/**
	 * Carga todos los mecanicos en una lista
	 */
	public static void cargarMecanicos() {
		// Declare the JDBC objects.
		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM Mecanico";
			rs = connect.stmt.executeQuery(SQL);
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
		}
	}
}
