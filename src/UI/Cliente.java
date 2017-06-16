package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ActionMapUIResource;

import Containers.Container;
import Models.ClienteModels;
import connections.clienteCN;
import connections.connect;
import connections.vehiculosCN;

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
	private JLabel imagen;
	private JButton btnEditar;
	private boolean esNuevo;
	public Models.Vehiculo vehiculoAux;

	public boolean isEsNuevo() {
		return esNuevo;
	}

	public void setEsNuevo(boolean esNuevo) {
		this.esNuevo = esNuevo;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
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
		esNuevo = true;
		vehiculoAux = null;
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cliente");
		frame.getContentPane().setLayout(null);
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
		btnEditar = new JButton("Editar");

		imagen = new JLabel(new ImageIcon(this.getClass().getResource("/Image/new_add_user_16734.png")));
		clienteCN.cargarClientes();
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

		btnEditar.setBounds(456, 257, 117, 59);
		frame.getContentPane().add(btnEditar);
	}

	/**
	 * Botones Limpiar y Guardar
	 */
	private void setComponentAdapters() {
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnGuardar.isEnabled()) {
					clienteCN.cargarClientes();
					esNuevo = !Container.listaClientes.contains(LeerCliente());
					if (!esNuevo) {

						clienteCN.actualizarCliente(LeerCliente());

						// Si la lista de clientes contiene el cliente
					} else {

						clienteCN.insertarCliente(LeerCliente());

					}
					esNuevo = false;

					vehiculosCN.asignarDuenio(LeerCliente(), Container.listaVehiculos.get(Container.vehiculoActivo));
					clienteCN.cargarClientes();
					imprimirCliente(clienteCN.getCliente(LeerCliente().getDni()));
					modoEditable(false);
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
				vehiculosCN.cargarVehiculos();
				Ventana.imprimirVehiculoPorIndice(Container.vehiculoActivo);

				Container.vehiculoActivo = Container.listaVehiculos.indexOf(vehiculoAux);
				Ventana.ModoLeer();
				frame.dispose();
			}
		});

		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnEditar.isEnabled()) {
					modoEditable(true);
					esNuevo = false;
					textDni.setEditable(false);
				}
			}
		});
	}

	/**
	 * Metodo para limpiar
	 */
	public void clearTxtField() {
		textNombre.setText("");
		textDni.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textTelf.setText("");
		textEmail.setText("");
	}

	/**
	 * Activa la pantalla para editar o leer
	 * 
	 * @param activo
	 *            indica si se quiere leer o escribir
	 */
	public void modoEditable(Boolean activo) {
		textNombre.setEnabled(activo);
		textDni.setEnabled(activo);
		textApellido.setEnabled(activo);
		textDireccion.setEnabled(activo);
		textTelf.setEnabled(activo);
		textEmail.setEnabled(activo);
		btnGuardar.setEnabled(activo);
		btnLimpiar.setEnabled(activo);
		btnEditar.setEnabled(!activo);
	}

	/**
	 * Muestra un cliente por pantalla
	 * 
	 * @param c
	 *            Cliente a mostrar
	 */
	public void imprimirCliente(ClienteModels c) {
		textNombre.setText(c.getNombre());
		textDni.setText(c.getDni());
		textApellido.setText(c.getApellidos());
		textDireccion.setText(c.getDireccion());
		textTelf.setText(c.getTelefono());
		textEmail.setText(c.getEmail());
	}

	/**
	 * Recoge los datos de un cliente de la pantalla y genera un cliente
	 * 
	 * @return cliente creado a partir de los datos de la pantalla
	 */
	private ClienteModels LeerCliente() {
		return new ClienteModels(textNombre.getText().toUpperCase(), textDni.getText().toUpperCase(),
				textApellido.getText().toUpperCase(), textDireccion.getText().toUpperCase(),
				textTelf.getText().toUpperCase(), textEmail.getText().toUpperCase());

	}
}
