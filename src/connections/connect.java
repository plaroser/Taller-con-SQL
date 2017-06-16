package connections;

import java.sql.Connection;
import java.sql.Statement;

public class connect {
	// Create a variable for the connection string.
	public final static String connectionUrl = "jdbc:sqlserver://MSI\\SERGIOPLA:1433;"
			+ "databaseName=Taller;user=sergio;password=1234";
	// Declare the JDBC objects.

	public static Connection con = null;
	public static Statement stmt = null;

}
