package Main;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

import UI.Login;
import connections.connect;
import connections.mecanicoCN;

public class Main {

	public static void main(String[] args) {
		Login login = new Login();
		try {
			connect.con = DriverManager.getConnection(connect.connectionUrl);
			connect.stmt = connect.con.createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("Error en la conexion general de la BBDD.");
		}
		mecanicoCN.cargarMecanicos();
		login.getFrame().setVisible(true);
	}

}
