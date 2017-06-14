package connections;

import java.awt.Frame;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.joda.time.LocalDateTime;

import Containers.*;
import Models.ClienteModels;
import Models.Reparar;
import Models.Usuario;
import Models.Vehiculo;

public class connect {
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
	 * Avtualiza un vehiculo en la base de datos con sus nuevos valores
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
					+ "'," + v.getCV() + "," + v.getTipovheiculo() + ")";
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

	/**
	 * Carga en una lista todas las reparaciones de un vehiculo
	 * 
	 * @param v
	 *            Vehiculo del que buscar las reparaciones
	 */
	@SuppressWarnings("deprecation")
	public static void cargarReparacionesVehiculo(Models.Vehiculo v) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT * FROM [Taller].[dbo].[REPARACION] WHERE Matricula LIKE '" + v.getMatricula() + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);

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
	 * Inserta una reparacion en la BBDD
	 * 
	 * @param r
	 *            Reparacion a insertar
	 */
	public static void insertarReparacion(Models.Reparar r) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.println(r.getMatricula());
			// Create and execute an SQL statement that returns some data.
			String SQL = "INSERT INTO [dbo].[REPARACION] ([Matricula],[Cod_Reparacion],[piezas],[Precio],[Precio_reparacion],[usuario_mecanico],[estado],[comentarios]) VALUES"
					+ "('" + r.getMatricula() + "',(NEWID())" + ",'" + r.getPiezas() + "'" + "," + r.getPrecio() + ","
					+ 0 + ",'" + Container.mecanicoActivo.getUsuario() + "'" + ",'" + r.getEstado() + "'" + ",'"
					+ r.getComentario() + "')";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(SQL);

		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en insertarReparacion.");

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
	 * Actualiza una reparacion en la BBDD
	 * 
	 * @param r
	 *            Reparacion con los cambios a realizar
	 */
	public static void actualizarReparacion(Models.Reparar r) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.println(r.getMatricula());
			// Create and execute an SQL statement that returns some data.
			String SQL = "UPDATE [dbo].[REPARACION]SET " + "[piezas] = '" + r.getPiezas() + "'" + ",[Precio] = '"
					+ r.getPrecio() + "'" + ",[estado] = '" + r.getEstado() + "'" + ",[comentarios] = '"
					+ r.getComentario() + "'" + "WHERE [Matricula] LIKE '" + r.getMatricula() + "'";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(SQL);
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en actualizarReparacion.");

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
