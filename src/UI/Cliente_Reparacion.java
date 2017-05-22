package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cliente_Reparacion {

	private JFrame frame;
	private JButton btnReparacion;
	private JButton btnCliente;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDNI;
	private JTextField textVehiculo;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textMatricula;
	
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
					Cliente_Reparacion window = new Cliente_Reparacion();
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
	public Cliente_Reparacion() {
		Componentes();
		Cliente();
		Reparar();
		Guardar();
		Editar();
	}

	/**
	 * Componentes del Frame
	 */
	private void Componentes() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cliente - Reparacion");
		frame.getContentPane().setLayout(null);
		
		
		
	}
	
	/**
	 * Boton Cliente
	 */
	private void Cliente(){
		btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnCliente.setBounds(323, 61, 135, 78);
		frame.getContentPane().add(btnCliente);
	}
	

	/**
	 * Boton Cliente
	 */
	private void Reparar(){
		btnReparacion = new JButton("Reparar");
		btnReparacion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnReparacion.setBounds(323, 196, 135, 78);
		frame.getContentPane().add(btnReparacion);

		
	}
	
	/**
	 * Boton Guardar
	 */
	private void Guardar(){
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(217, 338, 135, 53);
		frame.getContentPane().add(btnGuardar);
	}
	
	/**
	 * Boton Editar
	 */
	private void Editar(){
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnEditar.setBounds(31, 338, 135, 53);
		frame.getContentPane().add(btnEditar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 29, 61, 16);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(104, 24, 130, 26);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(31, 67, 71, 16);
		frame.getContentPane().add(lblApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(31, 107, 61, 16);
		frame.getContentPane().add(lblDni);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(104, 62, 130, 26);
		frame.getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setBounds(104, 102, 130, 26);
		frame.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		JLabel lblVehiculo = new JLabel("Vehiculo:");
		lblVehiculo.setBounds(31, 153, 61, 16);
		frame.getContentPane().add(lblVehiculo);
		
		textVehiculo = new JTextField();
		textVehiculo.setBounds(104, 148, 130, 26);
		frame.getContentPane().add(textVehiculo);
		textVehiculo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(31, 201, 61, 16);
		frame.getContentPane().add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(104, 196, 130, 26);
		frame.getContentPane().add(textMarca);
		textMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(31, 249, 61, 16);
		frame.getContentPane().add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setBounds(104, 244, 130, 26);
		frame.getContentPane().add(textModelo);
		textModelo.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(31, 297, 71, 16);
		frame.getContentPane().add(lblMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(104, 292, 130, 26);
		frame.getContentPane().add(textMatricula);
		textMatricula.setColumns(10);
	}
}
