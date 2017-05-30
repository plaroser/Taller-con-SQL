package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.Spring;

import Containers.Container;

import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class Vehiculo {

	private JFrame frame;
	private JButton btnReparacion;
	private JButton btnCliente;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JTextField txtMatricula;
	private JTextField textMarca;
	private JTextField textModelo;
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
	private JComboBox comboBoxCombustible;
	private JLabel lblColor;
	private JSpinner spinnerPuertas;
	private JButton buttonLimpiar;
	private JLabel lblCV;
	private Models.Vehiculo vehiculoSeleccionado;
	private JLabel lblTipo;
	private JList listaTipoVehiculo;
	private JButton btnNewButton ;

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

	private void initialize() {
		frame = new JFrame();
		btnCliente = new JButton("Cliente");
		btnReparacion = new JButton("Reparar");
		btnGuardar = new JButton("Guardar");

		txtMatricula = new JTextField();
		buttonLimpiar = new JButton("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton = new JButton("Volver a Principal");
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
		comboBoxCombustible.setModel(new DefaultComboBoxModel(new String[] {"Ninguno", "Diesel", "Gasolina", "Electrico"}));
		listaTipoVehiculo = new JList();
		listaTipoVehiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lblColor = new JLabel("Color");
		lblAoMatriculacion = new JLabel("Año Matriculacion:");
		lblPuertas = new JLabel("Puertas:");
		spinnerAnioMatricula = new JSpinner();
		
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
		btnReparacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reparar Ventana = new Reparar();
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
		btnEditar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ModoEditar();
			}
		});

		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnGuardar.isEnabled()) {
					Models.Vehiculo aux = leerVehiculo();
					Container.listaVehiculos.add(aux);
					ModoLeer();
					Container.vehiculoActivo = Container.listaVehiculos.size() - 1;
				}
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
					PantallaPrincipal Ventana = new PantallaPrincipal();
					Ventana.getFrame().setVisible(true);					
					frame.dispose();
			}
		});

	}

	private void setComponetProperties() {
		frame.setBounds(100, 100, 706, 597);
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

		lblTipo.setBounds(463, 61, 30, 16);
		frame.getContentPane().add(lblTipo);
		
		listaTipoVehiculo.setBounds(516, 28, 104, 78);
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
		btnCliente.setBounds(516, 136, 155, 78);
		frame.getContentPane().add(btnCliente);

		btnReparacion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnReparacion.setBounds(516, 241, 155, 78);
		frame.getContentPane().add(btnReparacion);

		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(31, 369, 171, 73);
		frame.getContentPane().add(btnGuardar);

		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnEditar.setBounds(262, 369, 151, 73);
		frame.getContentPane().add(btnEditar);

		buttonLimpiar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonLimpiar.setBounds(471, 370, 158, 71);
		frame.getContentPane().add(buttonLimpiar);
		
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnNewButton.setBounds(233, 464, 223, 73);
		frame.getContentPane().add(btnNewButton);
		
		
		listaTipoVehiculo.setModel(new AbstractListModel() {
			String[] values = new String[] {"Coche", "Moto", "Cami\u00C3\u00B3n", "Bicicleta"};
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				
				return values[index];
			}
			
		});
		
		
		
		

		selecciontipo();
		
		

	}

	/**
	 * Algo
	 */
	public void selecciontipo(){
		int index =0;
		if(Container.tipoVehiculo=="Coche"){
				index=0;
		}else if(Container.tipoVehiculo=="Moto"){
			index=1;
		}else if(Container.tipoVehiculo=="Cami\u00C3\u00B3n"){
			index=2;
		}else if(Container.tipoVehiculo=="Bicicleta"){
			index=3;
		}
		listaTipoVehiculo.setSelectedIndex(index);
		listaTipoVehiculo.setEnabled(false);
	}
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

	public void imprimirVehiculo(Models.Vehiculo v) {
		txtMatricula.setText(v.getMatricula());
		textMarca.setText(v.getMarca());
		textModelo.setText(v.getModelo());
		SpinnerCV.setValue(v.getCV());
		spinnerPuertas.setValue(v.getPuertas());
		textColor.setText(v.getColor());
		comboBoxCombustible.setSelectedItem("Diesel");
		spinnerAnioMatricula.setValue(v.getAnioMatriculacion().getYear());
		
	}

	public void imprimirVehiculoPorIndice(int Indice) {
		if (Indice != -1)
			imprimirVehiculo(Container.listaVehiculos.get(Indice));
		else
			clearTxtField();
	}
	
	public Models.Vehiculo leerVehiculo() {
		String Matricula = txtMatricula.getText().toUpperCase();
		String Marca = textMarca.getText().toUpperCase();
		String Modelo = textModelo.getText().toUpperCase();
		int CV = (int) SpinnerCV.getValue();
		int Puertas = (int) spinnerPuertas.getValue();
		String Color = textColor.getText().toUpperCase();
		String Combustible = (String) comboBoxCombustible.getSelectedItem();
		int AnioMatricula = (int) spinnerAnioMatricula.getValue();
		String tipoVhe=(String) listaTipoVehiculo.getSelectedValue();
		return new Models.Vehiculo(Matricula, Marca, Modelo, Puertas, Color, LocalDate.of(AnioMatricula, 1, 1), CV,
				Combustible,tipoVhe);
	}
}
