package connections;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.joda.time.LocalDateTime;

import Containers.Container;
import Models.Reparar;

public class reparacionCN {

	/**
	 * Carga en una lista todas las reparaciones de un vehiculo
	 * 
	 * @param v
	 *            Vehiculo del que buscar las reparaciones
	 */
	@SuppressWarnings("deprecation")
	public static void cargarReparacionesVehiculo(Models.Vehiculo v) {
		// Declare the JDBC objects.
		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM [Taller].[dbo].[REPARACION] WHERE Matricula LIKE '" + v.getMatricula() + "'";
			rs = connect.stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			// LocalDateTime(int year, int monthOfYear, int dayOfMonth, int
			// hourOfDay, int minuteOfHour)
			Container.listaReparaciones = new ArrayList<>();
			while (rs.next()) {
				LocalDateTime momentoEntrada, momentoSalida;
				try {
					momentoEntrada = new LocalDateTime(rs.getDate(4).getYear(), rs.getDate(4).getMonth(),
							rs.getDate(4).getDay(), rs.getTime(4).getHours(), rs.getTime(4).getMinutes());
				} catch (Exception e) {
					momentoEntrada = null;
				}
				try {
					momentoSalida = new LocalDateTime(rs.getDate(5).getYear(), rs.getDate(5).getMonth(),
							rs.getDate(5).getDay(), rs.getTime(5).getHours(), rs.getTime(5).getMinutes());
				} catch (Exception e) {
					momentoSalida = null;
				}

				Container.listaReparaciones.add(new Reparar(momentoEntrada, momentoSalida, rs.getFloat(6),
						rs.getString(3), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(1)));
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos.");

		}
	}

	/**
	 * Inserta una reparacion en la BBDD
	 * 
	 * @param r
	 *            Reparacion a insertar
	 */
	public static void insertarReparacion(Models.Reparar r) {
		// Declare the JDBC objects.
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println(r.getMatricula());
			// Create and execute an SQL statement that returns some data.
			String SQL = "INSERT INTO [dbo].[REPARACION] ([Matricula],[Cod_Reparacion],[piezas],[Precio],[Precio_reparacion],[usuario_mecanico],[estado],[comentarios]) VALUES"
					+ "('" + r.getMatricula() + "',(NEWID())" + ",'" + r.getPiezas() + "'" + "," + r.getPrecio() + ","
					+ 0 + ",'" + Container.mecanicoActivo.getUsuario() + "'" + ",'" + r.getEstado() + "'" + ",'"
					+ r.getComentario() + "')";
			connect.stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en insertarReparacion.");

		}
	}

	/**
	 * Actualiza una reparacion en la BBDD
	 * 
	 * @param r
	 *            Reparacion con los cambios a realizar
	 */
	public static void actualizarReparacion(Models.Reparar r) {
		// Declare the JDBC objects.
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println(r.getMatricula());
			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[REPARACION]SET " + "[piezas] = '" + r.getPiezas() + "'" + ",[Precio] = '"
					+ r.getPrecio() + "'" + ",[estado] = '" + r.getEstado() + "'" + ",[comentarios] = '"
					+ r.getComentario() + "'" + "WHERE [Matricula] LIKE '" + r.getMatricula() + "'";

			connect.stmt.executeUpdate(SQL);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en actualizarReparacion.");

		}
	}
}
