package connections;

import java.awt.Frame;
import java.sql.*;

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

	@SuppressWarnings("deprecation")
	public void cargarReparacionesVehiculo(Models.Vehiculo v) {
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
			while (rs.next()) {
				@SuppressWarnings("deprecation")
				LocalDateTime momentoEntrada = new LocalDateTime(rs.getDate(4).getYear(), rs.getDate(4).getMonth(),
						rs.getDate(4).getDay(), rs.getTime(4).getHours(), rs.getTime(4).getMinutes());
				LocalDateTime momentoSalida = new LocalDateTime(rs.getDate(5).getYear(), rs.getDate(5).getMonth(),
						rs.getDate(5).getDay(), rs.getTime(5).getHours(), rs.getTime(5).getMinutes());

				Container.listaReparaciones.add(new Reparar(momentoEntrada, momentoSalida, rs.getFloat(6),
						Container.mecanicoActivo.getUsuario(), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(1)));
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

	public void insertarReparacion(Models.Reparar r) {
		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {

			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// Create and execute an SQL statement that returns some data.
			String SQL = "INSERT INTO [dbo].[REPARACION] VALUES" + "('" + r.getMatricula() + "'" + ",(NEWID())" + ",'"
					+ r.getPiezas() + "'" + ",'" + r.getFecha_Entrada().toString() + "'" + ",'"
					+ r.getFecha_Salida().toString() + "'" + "," + r.getPrecio() + "," + 0 + ",'"
					+ Container.mecanicoActivo.getUsuario() + "'" + ",'" + r.getEstado() + "'" + ",'"
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
}
