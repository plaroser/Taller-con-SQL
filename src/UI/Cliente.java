package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Containers.Container;
import Models.ClienteModels;

import javax.swing.ImageIcon;
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
	private Collection<ClienteModels> listaClientes;
	private ClienteModels cliente1;
	private ClienteModels cliente2;
	private JLabel imagen;

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
		frame.setBounds(100, 100, 599, 293);
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
		imagen = new JLabel(new ImageIcon(this.getClass().getResource("/image/new_add_user_16734.png")));
		setComponentProperties();
		setComponentAdapters();

	}

	/**
	 * Datos Clientes
	 */
	private void setComponentProperties() {

		lblNombre.setBounds(205, 27, 61, 16);
		frame.getContentPane().add(lblNombre);

		textNombre.setBounds(278, 22, 148, 26);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		lblDni.setBounds(205, 108, 61, 16);
		frame.getContentPane().add(lblDni);

		textDni.setBounds(278, 103, 148, 26);
		frame.getContentPane().add(textDni);
		textDni.setColumns(10);

		lblApellidos.setBounds(205, 65, 72, 16);
		frame.getContentPane().add(lblApellidos);

		textApellido.setBounds(278, 60, 148, 26);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);

		lblDireccion.setBounds(205, 149, 72, 16);
		frame.getContentPane().add(lblDireccion);

		textDireccion.setBounds(278, 144, 148, 26);
		frame.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);

		lblTelefono.setBounds(205, 189, 61, 16);
		frame.getContentPane().add(lblTelefono);

		textTelf.setBounds(278, 184, 148, 26);
		frame.getContentPane().add(textTelf);
		textTelf.setColumns(10);

		lblEmail.setBounds(205, 232, 61, 16);
		frame.getContentPane().add(lblEmail);

		textEmail.setBounds(278, 227, 148, 26);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(456, 27, 117, 60);
		frame.getContentPane().add(btnGuardar);

		btnLimpiar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnLimpiar.setBounds(456, 108, 117, 60);
		frame.getContentPane().add(btnLimpiar);

		buttonVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonVolver.setBounds(456, 184, 117, 60);
		frame.getContentPane().add(buttonVolver);
		
		imagen.setBounds(0, 27, 204, 228);
		frame.getContentPane().add(imagen);
	}

	/**
	 * Botones Limpiar y Guardar
	 */
	private void setComponentAdapters() {
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Container.listaClientes.contains(LeerCliente())) {
					JOptionPane.showMessageDialog(null,
							"El cliente ya exixte en la base de datos, se le a�adira el nuevo vehiculo");
					Container.clienteActivo = Container.listaClientes.indexOf(LeerCliente());
					imprimirCliente(Container.listaClientes.get(Container.clienteActivo));
					Container.listaClientes.get(Container.clienteActivo).getListaCoches()
							.add(Container.listaVehiculos.get(Container.vehiculoActivo));
				} else {
					Container.listaClientes.add(LeerCliente());
					Container.clienteActivo = Container.listaClientes.indexOf(LeerCliente());
					if (!Container.listaClientes.get(Container.clienteActivo).getListaCoches()
							.contains(Container.listaVehiculos.get(Container.vehiculoActivo))) {
						Container.listaClientes.get(Container.clienteActivo).getListaCoches()
								.add(Container.listaVehiculos.get(Container.vehiculoActivo));
						JOptionPane.showMessageDialog(null, "Vehiculo a�adido correctamente");

					} else {
						JOptionPane.showMessageDialog(null, "El cliente ya tiene este vehiculo guardado");
					}
					Container.clienteActivo = Container.listaClientes.indexOf(LeerCliente());
					Vehiculo Ventana = new Vehiculo();
					Ventana.getFrame().setVisible(true);
					Ventana.imprimirVehiculoPorIndice(Container.vehiculoActivo);
					Ventana.ModoLeer();
					frame.dispose();
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
			public void mouseClicked(MouseEvent e) {
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
	private void clearTxtField() {
		textNombre.setText("");
		textDni.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textTelf.setText("");
		textEmail.setText("");
	}

	public void imprimirCliente(ClienteModels c) {
		textNombre.setText(c.getNombre());
		textDni.setText(c.getDni());
		textApellido.setText(c.getApellidos());
		textDireccion.setText(c.getDireccion());
		textTelf.setText(c.getTelefono());
		textEmail.setText(c.getEmail());
	}

	/**
	 * Leer Cliente
	 * 
	 * @return
	 */
	private ClienteModels LeerCliente() {
		return new ClienteModels(textNombre.getText(), textDni.getText(), textApellido.getText(),
				textDireccion.getText(), textTelf.getText(), textEmail.getText());

	}
}
