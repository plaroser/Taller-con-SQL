package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class Reparar {

	private JFrame frame;
	private JTextField textMatricula;
	private JLabel lblFechaEntrada;
	private JLabel lblFechaSalida;
	private JLabel lblPrecio;
	private JLabel lblMecnico;
	private JLabel lblEstadoDeLa;
	private JLabel lblNewLabel;
	private JTextField textPrecio;
	private JTextField textMecanico;
	private JButton btnEditar;
	private JButton btnLimpiar;
	private JButton btnVolver;
	private JSpinner spinnerFsalida;
	private JSpinner spinnerFEntrada;
	private JTextPane textPane;
	private JLabel lblMatricula;
	private JComboBox comboBox;
	private SpinnerDateModel model;
	private JButton btnGuardar;
	private JButton btnAnterior;
	private JProgressBar progressBar;
	private JButton btnSiguiente;
	private JTextField textTInvertido;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JLabel lblTiempoInvertido;
	private JButton btnIniciarContador;
	private JButton btnDetenerContador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reparar window = new Reparar();
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
	public Reparar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		lblMatricula = new JLabel("Matr\u00EDcula:");
		textMatricula = new JTextField();
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		spinnerFEntrada = new JSpinner(
				new SpinnerDateModel(new Date(1483225200872L), null, null, Calendar.DAY_OF_MONTH));
		lblFechaSalida = new JLabel("Fecha Salida:");
		spinnerFsalida = new JSpinner(
				new SpinnerDateModel(new Date(1483225200378L), null, null, Calendar.DAY_OF_MONTH));
		lblPrecio = new JLabel("Coste piezas:");
		textPrecio = new JTextField();
		lblMecnico = new JLabel("Mec\u00E1nico:");
		textMecanico = new JTextField();
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Pendiente", "Entregado" }));
		btnLimpiar = new JButton();
		lblEstadoDeLa = new JLabel("Estado de la reparacion:");
		lblNewLabel = new JLabel("Comentarios:");
		model = new SpinnerDateModel();
		btnGuardar = new JButton("Guardar");
		btnLimpiar = new JButton("Limpiar");
		btnVolver = new JButton("Volver");
		textPane = new JTextPane();
		btnAnterior = new JButton("Anterior");
		btnEditar = new JButton("Editar");
		progressBar = new JProgressBar();
		btnSiguiente = new JButton("Siguiente");
		textTInvertido = new JTextField();
		JLabel lblTiempoInvertido = new JLabel("Tiempo Invertido:");
		textTotal = new JTextField();
		JButton btnIniciarContador = new JButton("Iniciar Reparacion");
		JButton btnDetenerContador = new JButton("Detener Reparacion");
		lblTotal = new JLabel("TOTAL:");

		setComponentPropierties();
		setComponentAdapters();

	}

	private void setComponentAdapters() {
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearText();
			}
		});

		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vehiculo ventana = new Vehiculo();
				ventana.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModoLectura();
			}
		});
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModoEscritura();
			}
		});
	}

	private void setComponentPropierties() {

		frame.setBounds(100, 100, 732, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblMatricula.setBounds(55, 66, 63, 14);
		frame.getContentPane().add(lblMatricula);

		textMatricula.setBounds(150, 63, 86, 20);
		frame.getContentPane().add(textMatricula);
		textMatricula.setColumns(10);

		lblFechaEntrada.setBounds(55, 164, 86, 14);
		frame.getContentPane().add(lblFechaEntrada);

		lblFechaSalida.setBounds(55, 211, 86, 14);
		frame.getContentPane().add(lblFechaSalida);

		lblPrecio.setBounds(55, 315, 72, 14);
		frame.getContentPane().add(lblPrecio);

		lblMecnico.setBounds(55, 260, 63, 14);
		frame.getContentPane().add(lblMecnico);

		lblEstadoDeLa.setBounds(55, 375, 123, 14);
		frame.getContentPane().add(lblEstadoDeLa);

		lblNewLabel.setBounds(55, 429, 86, 14);
		frame.getContentPane().add(lblNewLabel);

		textPrecio.setBounds(150, 309, 86, 20);
		frame.getContentPane().add(textPrecio);
		textPrecio.setColumns(10);

		textMecanico.setBounds(150, 257, 86, 20);
		frame.getContentPane().add(textMecanico);
		textMecanico.setColumns(10);

		comboBox.setBounds(191, 370, 112, 25);
		frame.getContentPane().add(comboBox);

		spinnerFEntrada.setBounds(150, 161, 86, 20);
		frame.getContentPane().add(spinnerFEntrada);
		spinnerFEntrada.setEditor(new JSpinner.DateEditor(spinnerFEntrada, "dd-mm-yyyy"));

		spinnerFsalida.setBounds(150, 208, 86, 20);
		frame.getContentPane().add(spinnerFsalida);
		spinnerFsalida.setEditor(new JSpinner.DateEditor(spinnerFsalida, "dd-mm-yyyy"));

		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardar.setBounds(519, 35, 141, 69);
		frame.getContentPane().add(btnGuardar);

		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnLimpiar.setBounds(519, 144, 141, 69);
		frame.getContentPane().add(btnLimpiar);

		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBounds(519, 260, 141, 69);
		frame.getContentPane().add(btnEditar);

		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.setBounds(519, 371, 141, 69);
		frame.getContentPane().add(btnVolver);

		textPane.setBounds(150, 429, 153, 86);
		frame.getContentPane().add(textPane);

		btnAnterior.setBounds(55, 13, 97, 25);
		frame.getContentPane().add(btnAnterior);

		progressBar.setBounds(154, 13, 146, 25);
		frame.getContentPane().add(progressBar);

		btnSiguiente.setBounds(305, 13, 97, 25);
		frame.getContentPane().add(btnSiguiente);
		
		
		textTInvertido.setBounds(150, 114, 86, 20);
		frame.getContentPane().add(textTInvertido);
		textTInvertido.setColumns(10);
		
		
		lblTiempoInvertido.setBounds(55, 117, 86, 14);
		frame.getContentPane().add(lblTiempoInvertido);
		
		
		btnIniciarContador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIniciarContador.setBounds(281, 78, 186, 62);
		frame.getContentPane().add(btnIniciarContador);
		
		
		btnDetenerContador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDetenerContador.setBounds(281, 190, 186, 62);
		frame.getContentPane().add(btnDetenerContador);
		
		
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(390, 493, 141, 40);
		frame.getContentPane().add(lblTotal);
		
		
		textTotal.setBounds(519, 503, 135, 25);
		frame.getContentPane().add(textTotal);
		textTotal.setColumns(10);
	}

	public void clearText() {
		textMatricula.setText("");
		spinnerFEntrada.setValue(01 / 01 / 2017);
		spinnerFsalida.setValue(01 / 01 / 2017);
		textPrecio.setText("");
		textMecanico.setText("");
		textPane.setText("");
	}
	
	/**
	 * Metodo para bloquear los datos para editar modificarlos.
	 */
	public void ModoLectura(){
		textMatricula.setEnabled(false);
		spinnerFEntrada.setEnabled(false);
		spinnerFsalida.setEnabled(false);
		textPrecio.setEnabled(false);
		textMecanico.setEnabled(false);
		comboBox.setEnabled(false);
		textPane.setEnabled(false);
		btnLimpiar.setEnabled(false);
		btnVolver.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnAnterior.setEnabled(true);
		btnSiguiente.setEnabled(true);
		progressBar.setEnabled(true);
		btnEditar.setEnabled(true);
	}
	
	/**
	 * Metodo para poder realizar cambios y modificar datos si se desea
	 */
	public void ModoEscritura(){
		textMatricula.setEnabled(true);
		spinnerFEntrada.setEnabled(true);
		spinnerFsalida.setEnabled(true);
		textPrecio.setEnabled(true);
		textMecanico.setEnabled(true);
		comboBox.setEnabled(true);
		textPane.setEnabled(true);
		btnGuardar.setEnabled(true);
		btnLimpiar.setEnabled(true);
		btnVolver.setEnabled(true);
		btnEditar.setEnabled(false);
		btnAnterior.setEnabled(false);
		btnSiguiente.setEnabled(false);
		progressBar.setEnabled(false);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
