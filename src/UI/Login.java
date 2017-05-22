package UI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import res.Constants;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 391, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setBounds(40, 32, 108, 34);
		frame.getContentPane().add(lblLogin);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(40, 97, 297, 45);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasenia = new JTextField();
		txtContrasenia.setBounds(40, 171, 297, 45);
		frame.getContentPane().add(txtContrasenia);
		txtContrasenia.setColumns(10);

		JButton btnNewButton = new JButton(Constants.go);
		btnNewButton.setBounds(40, 248, 297, 45);
		frame.getContentPane().add(btnNewButton);
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

	}

	private void setComponentAdapters() {

	}
}
