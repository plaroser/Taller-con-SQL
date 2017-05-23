package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private Collection <Vehiculo>listaVehiculo;
	private SpinnerNumberModel model1;
	private SpinnerNumberModel model;
	private JLabel lblPuertas;
	private JComboBox comboBoxCombustible;
	private JLabel lblColor;
	private JSpinner spinnerPuertas;
	private JButton buttonLimpiar;
	private JLabel lblCV;
	
	
	

	public Collection<Vehiculo> getListaVehiculo() {
		return listaVehiculo;
	}

	public void setListaVehiculo(Collection<Vehiculo> listaVehiculo) {
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
					Vehiculo window = new Vehiculo();
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
	public Vehiculo() {
		Componentes();
		Cliente();
		Reparar();
		Guardar();
		Editar();
		setComponentProperties();
	}

	/**
	 * Componentes del Frame
	 */
	private void Componentes() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vehiculo");
		frame.getContentPane().setLayout(null);
		
		
		
	}
	
	/**
	 * Boton Cliente
	 */
	private void Cliente(){
		btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnCliente.setBounds(398, 66, 135, 78);
		frame.getContentPane().add(btnCliente);
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
					Cliente Ventana = new Cliente();
					Ventana.getFrame().setVisible(true);
					frame.dispose();
			
				
			}
		});
	}
	

	/**
	 * Boton Cliente
	 */
	private void Reparar(){
		btnReparacion = new JButton("Reparar");
		btnReparacion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnReparacion.setBounds(398, 196, 135, 78);
		frame.getContentPane().add(btnReparacion);

		
	}
	
	/**
	 * Boton Guardar
	 */
	private void Guardar(){
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(31, 396, 135, 53);
		frame.getContentPane().add(btnGuardar);
	}
	
	/**
	 * Boton Editar
	 */
	private void Editar(){
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnEditar.setBounds(214, 396, 135, 53);
		frame.getContentPane().add(btnEditar);
		
	}
	
	/**
	 * Datos usuario
	 */
	private void setComponentProperties(){
		lblMatricula_1 = new JLabel("Matricula:");
		lblMatricula_1.setBounds(31, 29, 79, 16);                 
		frame.getContentPane().add(lblMatricula_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(154, 24, 171, 26);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(31, 66, 61, 16);
		frame.getContentPane().add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(154, 61, 171, 26);
		frame.getContentPane().add(textMarca);
		textMarca.setColumns(10);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(31, 104, 61, 16);
		frame.getContentPane().add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setBounds(154, 99, 171, 26);
		frame.getContentPane().add(textModelo);
		textModelo.setColumns(10);
		
		lblCV = new JLabel("CV:");
		lblCV.setBounds(31, 141, 71, 16);
		frame.getContentPane().add(lblCV);
		
		textCV = new JTextField();
		textCV.setBounds(154, 136, 171, 26);
		frame.getContentPane().add(textCV);
		textCV.setColumns(10);
		
		lblPuertas = new JLabel("Puertas:");
		lblPuertas.setBounds(31, 182, 61, 16);
		frame.getContentPane().add(lblPuertas);
		
		spinnerPuertas = new JSpinner();
		spinnerPuertas.setBounds(154, 177, 79, 26);
		frame.getContentPane().add(spinnerPuertas);
		model = new SpinnerNumberModel(
				new Integer(0), // Dato visualizado al inicio en el spinner 
				new Integer(0), // Límite inferior 
				new Integer(10), // Límite superior 
				new Integer(1)); // incremento-decremento 
		spinnerPuertas.setModel(model);
		
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(31, 217, 61, 16);
		frame.getContentPane().add(lblColor);
		
		textColor = new JTextField();
		textColor.setBounds(154, 215, 171, 26);
		frame.getContentPane().add(textColor);
		textColor.setColumns(10);
		
		lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(23, 258, 87, 16);
		frame.getContentPane().add(lblCombustible);
		
		comboBoxCombustible = new JComboBox();
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
		model1 = new SpinnerNumberModel(
				new Integer(1950), // Dato visualizado al inicio en el spinner 
				new Integer(1950), // Límite inferior 
				new Integer(2017), // Límite superior 
				new Integer(1)); // incremento-decremento 
		spinnerAnioMatricula.setModel(model1);
		
		buttonLimpiar = new JButton("Limpiar");
		buttonLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTxtField();
			}
		});
		buttonLimpiar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonLimpiar.setBounds(398, 396, 135, 53);
		frame.getContentPane().add(buttonLimpiar);

	}
	public void clearTxtField(){
			textNombre.setText("");
			textMarca.setText("");
			textModelo.setText("");
			textMatricula.setText("");
			textMatricula.setText("");
			spinnerPuertas.setValue(0);
			textColor.setText("");
			comboBoxCombustible.setSelectedItem("Diesel");
			spinnerAnioMatricula.setValue(1950);
		}
}
