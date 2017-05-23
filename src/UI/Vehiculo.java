package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
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
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblCombustible;
	private JLabel lblMatricula_1;
	private JTextField textField;
	private DefaultListModel lista;
	private JLabel lblAoMatriculacion;
	private JSpinner spinnerAnioMatricula;
	
	
		
	
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
		frame.setTitle("Cliente - Reparacion");
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
		btnEditar.setBounds(222, 396, 135, 53);
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
		
		lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(31, 141, 71, 16);
		frame.getContentPane().add(lblMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(154, 136, 171, 26);
		frame.getContentPane().add(textMatricula);
		textMatricula.setColumns(10);
		
		JLabel lblPuertas = new JLabel("Puertas:");
		lblPuertas.setBounds(31, 182, 61, 16);
		frame.getContentPane().add(lblPuertas);
		
		JSpinner spinnerPuertas = new JSpinner();
		spinnerPuertas.setBounds(154, 177, 79, 26);
		frame.getContentPane().add(spinnerPuertas);
		
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(31, 217, 61, 16);
		frame.getContentPane().add(lblColor);
		
		textField = new JTextField();
		textField.setBounds(154, 215, 171, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(23, 258, 87, 16);
		frame.getContentPane().add(lblCombustible);
		
		JComboBox comboBoxCombustible = new JComboBox();
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
		SpinnerDateModel model1 = new SpinnerDateModel();
		spinnerAnioMatricula = new JSpinner(model1);
		spinnerAnioMatricula.setEditor(new JSpinner.DateEditor(spinnerAnioMatricula,"yyyy"));
		
		

	}
}