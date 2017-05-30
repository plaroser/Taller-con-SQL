package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Containers.Container;
import Models.ClienteModels;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

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
	private JButton buttonVolver;
	private Collection <ClienteModels> listaClientes;

	
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
		listaClientes = new ArrayList<Models.ClienteModels>();
		lblNombre = new JLabel("Nombre:");
		textNombre = new JTextField();
		lblDni = new JLabel("DNI:");
		textDni = new JTextField();
		lblApellidos = new JLabel("Apellidos:");
		textApellido = new JTextField();
		lblDireccion = new JLabel("Direccion:");
		textDireccion = new JTextField();
		lblTelefono = new JLabel("Telefono:");
		textTelf = new JTextField();
		lblEmail = new JLabel("Email:");
		textEmail = new JTextField();
		btnGuardar = new JButton("Guardar");
		btnLimpiar = new JButton("Limpiar");
		buttonVolver = new JButton("Volver");
		setComponentProperties();
		setComponentAdapters();
		
	}
	
	/**
	 * Datos Clientes
	 */
	private void setComponentProperties(){

		lblNombre.setBounds(35, 27, 61, 16);
		frame.getContentPane().add(lblNombre);
		
		
		textNombre.setBounds(108, 22, 148, 26);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		
		lblDni.setBounds(35, 108, 61, 16);
		frame.getContentPane().add(lblDni);
		
		
		textDni.setBounds(108, 103, 148, 26);
		frame.getContentPane().add(textDni);
		textDni.setColumns(10);
		
		
		lblApellidos.setBounds(35, 65, 72, 16);
		frame.getContentPane().add(lblApellidos);
		
		
		textApellido.setBounds(108, 60, 148, 26);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		
		lblDireccion.setBounds(35, 149, 72, 16);
		frame.getContentPane().add(lblDireccion);
		
		
		textDireccion.setBounds(108, 144, 148, 26);
		frame.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		
		lblTelefono.setBounds(35, 189, 61, 16);
		frame.getContentPane().add(lblTelefono);
		
		
		textTelf.setBounds(108, 184, 148, 26);
		frame.getContentPane().add(textTelf);
		textTelf.setColumns(10);
		
		
		lblEmail.setBounds(35, 232, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		textEmail.setBounds(108, 227, 148, 26);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(305, 29, 117, 60);
		frame.getContentPane().add(btnGuardar);
		
		btnLimpiar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnLimpiar.setBounds(305, 108, 117, 60);
		frame.getContentPane().add(btnLimpiar);
		
		buttonVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonVolver.setBounds(305, 184, 117, 60);
		frame.getContentPane().add(buttonVolver);
	}
	
	/**
	 * Botones Limpiar y Guardar
	 */
	private void setComponentAdapters(){
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
					 ClienteModels cliente1 = new ClienteModels(textNombre.getText(),textDni.getText(),textApellido.getText(),textDireccion.getText(),textTelf.getText(),textEmail.getText());
					 listaClientes.add(cliente1);
					 if (listaClientes.add(cliente1)){
						 JOptionPane.showMessageDialog(null, "Ha sido añadido correctamente");
					 }
					 else if(listaClientes.contains(cliente1)){
						 JOptionPane.showMessageDialog(null, "Este cliente ya ha sido registrado anteriormente");
					 }
					 else{
						 JOptionPane.showMessageDialog(null, "No ha sido añadido correctamente");
					 }
			}
		});
		
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTxtField();
			}
		});
		
		buttonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
					Vehiculo Ventana = new Vehiculo();
					Ventana.getFrame().setVisible(true);
					Ventana.imprimirVehiculoPorIndice(Container.vehiculoActivo);
					Ventana.ModoLeer();
					frame.dispose();
			}
		});
	}
	
	/**
	 * Metodo para limpiar
	 */
	private void clearTxtField(){
		textNombre.setText("");
		textDni.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textTelf.setText("");
		textEmail.setText("");		
	}
}
