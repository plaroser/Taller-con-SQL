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

import Models.Usuario;
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

	private Collection<Usuario> listaMecanicos;

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
		listaMecanicos = new ArrayList();
		lblLogin = new JLabel("Login");
		txtUsuario = new JTextField();
		txtContrasenia = new JPasswordField();
		btnLogin = new JButton(Constants.go);
		setComponetProperties();
		setComponentAdapters();

	}

	private void setComponetProperties() {

		listaMecanicos.add(new Usuario("usuario", "1234"));

		frame = new JFrame();
		frame.setBounds(100, 100, 391, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login");

		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(40, 32, 108, 34);
		frame.getContentPane().add(lblLogin);

		txtUsuario.setBounds(40, 97, 297, 45);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasenia.setBounds(40, 171, 297, 45);
		frame.getContentPane().add(txtContrasenia);
		txtContrasenia.setColumns(10);

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
			JOptionPane.showMessageDialog(null, "El usuario o la contrase�a no pueden estar vacios.");
			return false;
		}
		if (!Constants.CONSTRAINT_CONTRASENIA.matcher(new String(txtContrasenia.getPassword())).matches()) {
			JOptionPane.showMessageDialog(null, "La contrase�a no coincide con el patron necesario");
			return false;
		}

		if (listaMecanicos.contains(new Usuario(usuario, new String(txtContrasenia.getPassword())))) {

			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El usuario o la contrase�a no son correctos.");
			return false;
		}

	}
}
