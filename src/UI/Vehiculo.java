package UI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.Collection;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

import Containers.Container;
import connections.clienteCN;
import connections.connect;
import connections.reparacionCN;
import connections.vehiculosCN;

public class Vehiculo {

	private JFrame frame;
	private JButton btnReparacion;
	private JButton btnCliente;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JTextField txtMatricula;
	private JTextField textMarca;
	private JTextField textModelo;
	@SuppressWarnings("unused")
	private JLabel lblMatricula;
	private JSpinner SpinnerCV;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblCombustible;
	private JLabel lblMatricula_1;
	private JTextField textColor;
	private JLabel lblAoMatriculacion;
	private JSpinner spinnerAnioMatricula;
	private Collection<Models.Vehiculo> listaVehiculo;
	private SpinnerNumberModel model1;
	private SpinnerNumberModel model;
	private JLabel lblPuertas;
	private JComboBox<String> comboBoxCombustible;
	private JLabel lblColor;
	private JSpinner spinnerPuertas;
	private JButton buttonLimpiar;
	private JLabel lblCV;
	private JLabel lblTipo;
	private JList<String> listaTipoVehiculo;
	private boolean esNuevo;

	public Collection<Models.Vehiculo> getListaVehiculo() {
		return listaVehiculo;
	}

	public void setListaVehiculo(Collection<Models.Vehiculo> listaVehiculo) {
		this.listaVehiculo = listaVehiculo;
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
	public Vehiculo() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		btnCliente = new JButton("Cliente");
		btnReparacion = new JButton("Reparar");
		btnGuardar = new JButton("Guardar");

		txtMatricula = new JTextField();
		buttonLimpiar = new JButton("Limpiar");

		btnEditar = new JButton("Editar");
		textColor = new JTextField();
		lblMatricula_1 = new JLabel("Matricula:");
		lblMarca = new JLabel("Marca:");
		textMarca = new JTextField();
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblCombustible = new JLabel("Combustible:");
		textModelo = new JTextField();
		lblCV = new JLabel("CV:");
		SpinnerCV = new JSpinner();
		spinnerPuertas = new JSpinner();
		comboBoxCombustible = new JComboBox();
		comboBoxCombustible
				.setModel(new DefaultComboBoxModel(new String[] { "Ninguno", "Diesel", "Gasolina", "Electrico" }));
		listaTipoVehiculo = new JList();
		listaTipoVehiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lblColor = new JLabel("Color");
		lblAoMatriculacion = new JLabel("A\u00F1o Matriculaci\u00F3n:");
		lblPuertas = new JLabel("Puertas:");
		spinnerAnioMatricula = new JSpinner();
		esNuevo = true;
		setComponetProperties();
		setComponentAdapters();
	}

	private void setComponentAdapters() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				try {
					connect.stmt.close();
					connect.con.close();
					System.out.println("Conexion cerrada.\nHasta pronto!!!");
				} catch (Exception e) {
					System.out.println("ERROR al cerrar la conexion.\n" + e.getMessage());
				}

				System.exit(0);
			}
		});

		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente Ventana = new Cliente();
				Ventana.getFrame().setVisible(true);
				Models.Vehiculo vehiculoAux = Container.listaVehiculos
						.get(Container.listaVehiculos.indexOf(leerVehiculo()));
				if (vehiculoAux.getDniDuenio() != null) {
					Ventana.imprimirCliente(clienteCN.getCliente(vehiculoAux.getDniDuenio()));
					Ventana.setEsNuevo(false);
					Ventana.modoEditable(false);
					Ventana.setEsNuevo(false);
				} else {
					Ventana.setEsNuevo(true);

					Ventana.modoEditable(true);
					Ventana.clearTxtField();
					Ventana.setEsNuevo(true);
				}
				Ventana.vehiculoAux = vehiculoAux;
				frame.dispose();
			}
		});
		btnReparacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnReparacion.isEnabled()) {
					Reparar Ventana = new Reparar();
					clienteCN.cargarClientes();
					reparacionCN.cargarReparacionesVehiculo(
							Container.listaVehiculos.get(Containers.Container.vehiculoActivo));
					Container.vehiculoActivo = Container.listaVehiculos.indexOf(leerVehiculo());
					Ventana.getFrame().setVisible(true);
					Ventana.imprimirLista();
					Ventana.editable(false);
					frame.dispose();
				}
			}
		});

		buttonLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTxtField();
			}
		});
		btnEditar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				esNuevo = false;
				ModoEditar();
				txtMatricula.setEditable(false);
			}
		});

		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnGuardar.isEnabled()) {
					if (esNuevo) {
						vehiculosCN.insertarVehiculo(leerVehiculo());
						vehiculosCN.cargarVehiculos();

						Container.vehiculoActivo = Container.listaVehiculos.indexOf(leerVehiculo());
					} else {
						vehiculosCN.actualizarVehiculo(leerVehiculo());
						vehiculosCN.cargarVehiculos();
						imprimirVehiculo(
								Container.listaVehiculos.get(Container.listaVehiculos.indexOf(leerVehiculo())));
						esNuevo = true;
					}
					ModoLeer();
				}
			}
		});

	}

	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void setComponetProperties() {
		frame.setBounds(100, 100, 555, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vehiculo");
		frame.getContentPane().setLayout(null);

		lblMatricula_1.setBounds(31, 29, 79, 16);
		frame.getContentPane().add(lblMatricula_1);

		txtMatricula.setBounds(154, 24, 171, 26);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		lblMarca.setBounds(31, 66, 61, 16);
		frame.getContentPane().add(lblMarca);

		textMarca.setBounds(154, 61, 171, 26);
		frame.getContentPane().add(textMarca);
		textMarca.setColumns(10);

		lblModelo.setBounds(31, 104, 61, 16);
		frame.getContentPane().add(lblModelo);

		textModelo.setBounds(154, 99, 171, 26);
		frame.getContentPane().add(textModelo);
		textModelo.setColumns(10);

		lblCV.setBounds(31, 141, 71, 16);
		frame.getContentPane().add(lblCV);

		SpinnerCV.setBounds(154, 136, 171, 26);
		frame.getContentPane().add(SpinnerCV);
		model = new SpinnerNumberModel(new Integer(0), // Dato visualizado al
				// inicio en el spinner
				new Integer(0), // Límite inferior
				new Integer(1000), // Límite superior
				new Integer(1)); // incremento-decremento
		SpinnerCV.setModel(model);

		lblPuertas.setBounds(31, 182, 61, 16);
		frame.getContentPane().add(lblPuertas);

		spinnerPuertas.setBounds(154, 177, 79, 26);
		frame.getContentPane().add(spinnerPuertas);
		model = new SpinnerNumberModel(new Integer(0), // Dato visualizado al
														// inicio en el spinner
				new Integer(0), // Límite inferior
				new Integer(10), // Límite superior
				new Integer(1)); // incremento-decremento
		spinnerPuertas.setModel(model);

		lblColor.setBounds(31, 217, 61, 16);
		frame.getContentPane().add(lblColor);

		textColor.setBounds(154, 215, 171, 26);
		frame.getContentPane().add(textColor);
		textColor.setColumns(10);

		lblCombustible.setBounds(23, 258, 87, 16);
		frame.getContentPane().add(lblCombustible);

		comboBoxCombustible.setBounds(154, 254, 171, 27);
		frame.getContentPane().add(comboBoxCombustible);
		comboBoxCombustible.addItem("Diesel");
		comboBoxCombustible.addItem("Gasolina");
		comboBoxCombustible.addItem("Electrico");

		lblTipo.setBounds(369, 66, 30, 16);
		frame.getContentPane().add(lblTipo);

		listaTipoVehiculo.setBounds(411, 42, 79, 78);
		frame.getContentPane().add(listaTipoVehiculo);

		lblAoMatriculacion.setBounds(23, 303, 118, 16);
		frame.getContentPane().add(lblAoMatriculacion);

		spinnerAnioMatricula.setBounds(154, 298, 79, 26);
		frame.getContentPane().add(spinnerAnioMatricula);
		model1 = new SpinnerNumberModel(new Integer(1950), // Dato visualizado
															// al inicio en el
															// spinner
				new Integer(1950), // Límite inferior
				new Integer(2017), // Límite superior
				new Integer(1)); // incremento-decremento
		spinnerAnioMatricula.setModel(model1);

		btnCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnCliente.setBounds(398, 163, 135, 78);
		frame.getContentPane().add(btnCliente);

		btnReparacion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnReparacion.setBounds(398, 269, 135, 78);
		frame.getContentPane().add(btnReparacion);

		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(23, 396, 112, 53);
		frame.getContentPane().add(btnGuardar);

		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnEditar.setBounds(154, 396, 112, 53);
		frame.getContentPane().add(btnEditar);

		buttonLimpiar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonLimpiar.setBounds(287, 396, 112, 53);
		frame.getContentPane().add(buttonLimpiar);

		listaTipoVehiculo.setModel(new AbstractListModel() {
			String[] values = new String[] { "Coche", "Moto", "Cami\u00F3n", "Bicicleta" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		JButton btnVolver = new JButton("volver");
		btnVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal Ventana = new PantallaPrincipal();
				Ventana.getFrame().setVisible(true);
				Container.clienteActivo = -1;
				frame.dispose();
			}
		});
		btnVolver.setBounds(411, 399, 118, 53);
		frame.getContentPane().add(btnVolver);

		selecciontipo();

	}

	/**
	 * Seleccion del tipo de vehiculo En container tenemos guardado un string y
	 * lo comparamos con los datos guardados en la jlist devuelve un indice para
	 * seleccionar automaticamente el tipo en la lista y no se puede modificar
	 * 
	 */
	public void selecciontipo() {
		int index = 0;
		if (Container.tipoVehiculo == "Coche") {
			index = 0;
		} else if (Container.tipoVehiculo == "Moto") {
			index = 1;
		} else if (Container.tipoVehiculo == "Cami\u00C3\u00B3n") {
			index = 2;
		} else if (Container.tipoVehiculo == "Bicicleta") {
			index = 3;
		}
		listaTipoVehiculo.setSelectedIndex(index);
		listaTipoVehiculo.setEnabled(false);
	}

	/**
	 * Metodo para limpiar las celdas de datos
	 */
	public void clearTxtField() {
		txtMatricula.setText("");
		textMarca.setText("");
		textModelo.setText("");
		SpinnerCV.setValue(0);
		spinnerPuertas.setValue(0);
		textColor.setText("");
		comboBoxCombustible.setSelectedItem("Diesel");
		spinnerAnioMatricula.setValue(1950);
	}

	/**
	 * Metodo para evitar la modficacion de los datos. Modo lectura
	 */
	public void ModoLeer() {
		txtMatricula.setEnabled(false);
		textMarca.setEnabled(false);
		textModelo.setEnabled(false);
		SpinnerCV.setEnabled(false);
		spinnerPuertas.setEnabled(false);
		textColor.setEnabled(false);
		comboBoxCombustible.setEnabled(false);
		spinnerAnioMatricula.setEnabled(false);
		buttonLimpiar.setEnabled(false);
		btnGuardar.setEnabled(false);
		listaTipoVehiculo.setEnabled(false);
	}

	/**
	 * Metodo para modificar los datos. Modo Escritura
	 */
	public void ModoEditar() {
		txtMatricula.setEnabled(true);
		textMarca.setEnabled(true);
		textModelo.setEnabled(true);
		SpinnerCV.setEnabled(true);
		spinnerPuertas.setEnabled(true);
		textColor.setEnabled(true);
		comboBoxCombustible.setEnabled(true);
		spinnerAnioMatricula.setEnabled(true);
		buttonLimpiar.setEnabled(true);
		btnGuardar.setEnabled(true);
		listaTipoVehiculo.setEnabled(true);
	}

	/**
	 * Metodo para imprimir el vehiculo Devuelve los datos del vehiculo
	 * 
	 * @param v
	 *            Vehiculo a mostrar
	 */
	public void imprimirVehiculo(Models.Vehiculo v) {
		txtMatricula.setText(v.getMatricula());
		textMarca.setText(v.getMarca());
		textModelo.setText(v.getModelo());
		SpinnerCV.setValue(v.getCV());
		spinnerPuertas.setValue(v.getPuertas());
		textColor.setText(v.getColor());
		comboBoxCombustible.setSelectedItem(v.getCombustible());
		spinnerAnioMatricula.setValue(v.getAnioMatriculacion().getYear());
		listaTipoVehiculo.setSelectedValue(v.getTipovheiculo(), false);
	}

	public void imprimirVehiculoPorIndice(int Indice) {
		if (Indice != -1)
			imprimirVehiculo(Container.listaVehiculos.get(Indice));
		else
			clearTxtField();
	}

	/**
	 * Metodo para leer y guardar los datos Almacena los datos introducidos en
	 * los campos de la pantalla en variable que se utilizan para crear un nuevo
	 * vehiculo
	 * 
	 * @return EL vehiculo generado
	 */
	public Models.Vehiculo leerVehiculo() {
		String Matricula = txtMatricula.getText().toUpperCase();
		String Marca = textMarca.getText().toUpperCase();
		String Modelo = textModelo.getText().toUpperCase();
		int CV = (int) SpinnerCV.getValue();
		int Puertas = (int) spinnerPuertas.getValue();
		String Color = textColor.getText().toUpperCase();
		String Combustible = (String) comboBoxCombustible.getSelectedItem();
		int AnioMatricula = (int) spinnerAnioMatricula.getValue();
		String tipoVhe = (String) listaTipoVehiculo.getSelectedValue();
		return new Models.Vehiculo(Matricula, Marca, Modelo, Puertas, Color, LocalDate.of(AnioMatricula, 1, 1), CV,
				Combustible, tipoVhe, null);
	}
}
