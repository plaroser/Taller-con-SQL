package UI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Containers.Container;
import Models.Usuario;
import connections.mecanicoCN;
import res.Constants;

public class Login {
	/**
	 * ATRIBUTOS
	 */
	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;

	private JLabel lblLogin;

	private JButton btnLogin;

	private JLabel lblUsuario;

	private JLabel lblContrasenia;

	private JLabel Imagen;

	/**
	 * GET JFRAME
	 */
	public JFrame getFrame() {
		return frame;
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
		lblLogin = new JLabel("Login");
		txtUsuario = new JTextField();
		txtContrasenia = new JPasswordField();
		btnLogin = new JButton(Constants.go);
		lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblUsuario = new JLabel("Usuario:");
		Imagen = new JLabel(new ImageIcon(this.getClass().getResource("/Image/tech_icon.png")));
		setComponetProperties();
		setComponentAdapters();

	}

	/**
	 * PROPIEDADES DE LOS COMPONENTES
	 */
	private void setComponetProperties() {

		// listaMecanicos.add(new Usuario("usuario", "1234"));

		frame = new JFrame();
		frame.setBounds(100, 100, 601, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login");

		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(45, 23, 171, 45);
		frame.getContentPane().add(lblLogin);

		txtUsuario.setBounds(342, 99, 235, 45);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasenia.setBounds(342, 172, 235, 45);
		frame.getContentPane().add(txtContrasenia);
		txtContrasenia.setColumns(10);

		btnLogin.setBounds(98, 255, 343, 80);
		frame.getContentPane().add(btnLogin);

		Imagen.setBounds(6, 54, 192, 212);
		frame.getContentPane().add(Imagen);

		lblUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblUsuario.setBounds(236, 105, 81, 26);
		frame.getContentPane().add(lblUsuario);

		lblContrasenia.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblContrasenia.setBounds(220, 179, 121, 30);
		frame.getContentPane().add(lblContrasenia);
	}

	/**
	 * ADAPTADORES
	 */
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

	/**
	 * VALIDA QUE EL USUARIO Y LA CONTRASEÃ‘A YA ESTEN REGISTRADOS
	 * 
	 * @return DEVUELVE TRUE SI ES CORRECTO Y FALSE SI NO
	 */
	private boolean validarLogin() {
		String usuario = txtUsuario.getText();
		mecanicoCN.cargarMecanicos();
		if (usuario.isEmpty() || new String(txtContrasenia.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña no pueden estar vacios.");
			return false;
		}

		if (!Constants.CONSTRAINT_CONTRASENIA.matcher(new String(txtContrasenia.getPassword())).matches()) {
			JOptionPane.showMessageDialog(null, "La contraseï¿½a no coincide con el patron necesario");
			return false;
		}
		Usuario aux = new Usuario(usuario, new String(txtContrasenia.getPassword()));
		// System.out.println(listaMecanicos.get(0));
		if (Container.listaMecanicos.contains(aux)) {
			Container.mecanicoActivo = aux;
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "El usuario o la contraseña no son correctos.");
			return false;
		}

	}
}
