package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Cliente {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textDni;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textTelf;
	private JTextField textEmail;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JLabel lblNombre;
	private JLabel lblDni;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblEmail;

	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
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
	public Cliente() {
		initialize();
		setComponentProperties();
		Botones();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cliente");
		frame.getContentPane().setLayout(null);
		
		
		
	}
	
	/**
	 * Datos Clientes
	 */
	private void setComponentProperties(){

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(35, 27, 61, 16);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(108, 22, 148, 26);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(35, 108, 61, 16);
		frame.getContentPane().add(lblDni);
		
		textDni = new JTextField();
		textDni.setBounds(108, 103, 148, 26);
		frame.getContentPane().add(textDni);
		textDni.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(35, 65, 72, 16);
		frame.getContentPane().add(lblApellidos);
		
		textApellido = new JTextField();
		textApellido.setBounds(108, 60, 148, 26);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(35, 149, 72, 16);
		frame.getContentPane().add(lblDireccion);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(108, 144, 148, 26);
		frame.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(35, 189, 61, 16);
		frame.getContentPane().add(lblTelefono);
		
		textTelf = new JTextField();
		textTelf.setBounds(108, 184, 148, 26);
		frame.getContentPane().add(textTelf);
		textTelf.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(35, 232, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(108, 227, 148, 26);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
	}
	
	/**
	 * Botones Limpiar y Guardar
	 */
	private void Botones(){
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(305, 29, 117, 60);
		frame.getContentPane().add(btnGuardar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnLimpiar.setBounds(305, 150, 117, 60);
		frame.getContentPane().add(btnLimpiar);
	}
}
