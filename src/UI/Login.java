package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Models.Mecanico;
import res.Constants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;

	private JLabel lblLogin;

	private JButton btnLogin;

	private Collection<Mecanico> listaMecanicos;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setComponetProperties();
		setComponentAdapters();

	}

	private void setComponetProperties() {
		listaMecanicos = new ArrayList();
		listaMecanicos.add(new Mecanico("usuario", "1234"));

		frame = new JFrame();
		frame.setBounds(100, 100, 391, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(40, 32, 108, 34);
		frame.getContentPane().add(lblLogin);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(40, 97, 297, 45);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(40, 171, 297, 45);
		frame.getContentPane().add(txtContrasenia);
		txtContrasenia.setColumns(10);

		btnLogin = new JButton(Constants.go);
		btnLogin.setBounds(40, 248, 297, 45);
		frame.getContentPane().add(btnLogin);
	}

	private void setComponentAdapters() {
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validarLogin()) {
					PantallaPrincipal pantallita = new PantallaPrincipal();
					pantallita.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
	}

	private boolean validarLogin() {
		String usuario = txtUsuario.getText();

		if (usuario.isEmpty() || new String(txtContrasenia.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña no pueden estar vacios.");
			return false;
		}
		if (!Constants.CONSTRAINT_CONTRASENIA.matcher(new String(txtContrasenia.getPassword())).matches()) {
			JOptionPane.showMessageDialog(null, "La contraseña no coincide con el patron necesario");
			return false;
		}

		if (listaMecanicos.contains(new Mecanico(usuario, new String(txtContrasenia.getPassword())))) {

			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña no son correctos.");
			return false;
		}

	}
}
