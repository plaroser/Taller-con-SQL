package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vehiculo {

	private JFrame frame;
	private JButton btnReparacion;
	private JButton btnCliente;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JTextField textNombre;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textMatricula;
	private JLabel lblMatricula;
	private JTextField textCV;
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
	private JComboBox comboBoxCombustible;
	private JLabel lblColor;
	private JSpinner spinnerPuertas;
	private JButton buttonLimpiar;
	private JLabel lblCV;
	private Models.Vehiculo vehiculoSeleccionado;
	private JButton btnLeer;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehiculo window = new Vehiculo(new ArrayList<>(), null);
					window.frame.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vehiculo(Collection<Models.Vehiculo> listaVehiculo, Models.Vehiculo v) {
		this.listaVehiculo = listaVehiculo;
		this.vehiculoSeleccionado = v;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		btnCliente = new JButton("Cliente");
		btnReparacion = new JButton("Reparar");
		btnGuardar = new JButton("Guardar");
		textNombre = new JTextField();
		buttonLimpiar = new JButton("Limpiar");
		btnLeer = new JButton("leer");
		btnEditar = new JButton("Editar");
		textColor = new JTextField();
		lblMatricula_1 = new JLabel("Matricula:");
		lblMarca = new JLabel("Marca:");
		textMarca = new JTextField();
		lblModelo = new JLabel("Modelo:");
		textModelo = new JTextField();
		lblCV = new JLabel("CV:");
		textCV = new JTextField();
		spinnerPuertas = new JSpinner();
		comboBoxCombustible = new JComboBox();
		lblColor = new JLabel("Color");
		textMatricula = new JTextField();
		setComponetProperties();
		setComponentAdapters();
	}

	private void setComponentAdapters() {
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente Ventana = new Cliente();
				Ventana.getFrame().setVisible(true);
				frame.dispose();
			}
		});

		buttonLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTxtField();
			}
		});
		
		
		btnLeer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModoLeer();
			}
		});
		
	}

	private void setComponetProperties() {
		frame.setBounds(100, 100, 555, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vehiculo");
		frame.getContentPane().setLayout(null);

		lblMatricula_1.setBounds(31, 29, 79, 16);
		frame.getContentPane().add(lblMatricula_1);

		textNombre.setBounds(154, 24, 171, 26);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

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

		textCV.setBounds(154, 136, 171, 26);
		frame.getContentPane().add(textCV);
		textCV.setColumns(10);

		lblPuertas = new JLabel("Puertas:");
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

		lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(23, 258, 87, 16);
		frame.getContentPane().add(lblCombustible);

		comboBoxCombustible.setBounds(154, 254, 171, 27);
		frame.getContentPane().add(comboBoxCombustible);
		comboBoxCombustible.addItem("Diesel");
		comboBoxCombustible.addItem("Gasolina");
		comboBoxCombustible.addItem("Electrico");

		lblAoMatriculacion = new JLabel("Año Matriculacion:");
		lblAoMatriculacion.setBounds(23, 303, 118, 16);
		frame.getContentPane().add(lblAoMatriculacion);

		spinnerAnioMatricula = new JSpinner();
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
		btnCliente.setBounds(398, 66, 135, 78);
		frame.getContentPane().add(btnCliente);

		btnReparacion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnReparacion.setBounds(398, 196, 135, 78);
		frame.getContentPane().add(btnReparacion);

		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(31, 396, 135, 53);
		frame.getContentPane().add(btnGuardar);

		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnEditar.setBounds(214, 396, 135, 53);
		frame.getContentPane().add(btnEditar);

		buttonLimpiar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonLimpiar.setBounds(398, 396, 135, 53);
		frame.getContentPane().add(buttonLimpiar);
		
		btnLeer.setFont(new Font("Lucida Grande", Font.PLAIN, 19));	
		btnLeer.setBounds(53, 345, 97, 25);
		frame.getContentPane().add(btnLeer);
	}

	/**
	 * Algo
	 */
	public void clearTxtField() {
		textNombre.setText("");
		textMarca.setText("");
		textModelo.setText("");
		textMatricula.setText("");
		textCV.setText("");
		spinnerPuertas.setValue(0);
		textColor.setText("");
		comboBoxCombustible.setSelectedItem("Diesel");
		spinnerAnioMatricula.setValue(1950);
	}
	public void ModoLeer() {
		textNombre.setEnabled(false);
		textMarca.setEnabled(false);
		textModelo.setEnabled(false);
		textMatricula.setEnabled(false);
		textCV.setEnabled(false);
		spinnerPuertas.setEnabled(false);
		textColor.setEnabled(false);
		comboBoxCombustible.setEnabled(false);
		spinnerAnioMatricula.setEnabled(false);
	}
	
}
