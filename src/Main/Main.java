package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Containers.Container;
import Models.Usuario;
import UI.Login;
import connections.connect;
import connections.mecanicoCN;

public class Main {

	public static void main(String[] args) {
		Login login = new Login();
		mecanicoCN.cargarMecanicos();
		login.getFrame().setVisible(true);
	}

}
