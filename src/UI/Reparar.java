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
	private JButton btnVolver;
	private JSpinner spinnerFsalida;
	private JSpinner spinnerFEntrada;
	private JTextPane textPane;

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
		frame.setBounds(100, 100, 680, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setBounds(55, 66, 63, 14);
		frame.getContentPane().add(lblMatrcula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(150, 63, 86, 20);
		frame.getContentPane().add(textMatricula);
		textMatricula.setColumns(10);
		
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		lblFechaEntrada.setBounds(55, 115, 86, 14);
		frame.getContentPane().add(lblFechaEntrada);
		
		lblFechaSalida = new JLabel("Fecha Salida:");
		lblFechaSalida.setBounds(55, 164, 86, 14);
		frame.getContentPane().add(lblFechaSalida);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(55, 211, 63, 14);
		frame.getContentPane().add(lblPrecio);
		
		lblMecnico = new JLabel("Mec\u00E1nico:");
		lblMecnico.setBounds(55, 260, 63, 14);
		frame.getContentPane().add(lblMecnico);
		
		lblEstadoDeLa = new JLabel("Estado de la reparacion:");
		lblEstadoDeLa.setBounds(55, 308, 123, 14);
		frame.getContentPane().add(lblEstadoDeLa);
		
		lblNewLabel = new JLabel("Comentarios:");
		lblNewLabel.setBounds(55, 371, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(150, 208, 86, 20);
		frame.getContentPane().add(textPrecio);
		textPrecio.setColumns(10);
		
		textMecanico = new JTextField();
		textMecanico.setBounds(150, 257, 86, 20);
		frame.getContentPane().add(textMecanico);
		textMecanico.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Entregado"}));
		comboBox.setBounds(188, 303, 112, 25);
		frame.getContentPane().add(comboBox);
		
		SpinnerDateModel model = new SpinnerDateModel();
		
		JSpinner spinnerFEntrada = new JSpinner(new SpinnerDateModel(new Date(1483225200872L), null, null, Calendar.DAY_OF_MONTH));
		spinnerFEntrada.setBounds(150, 112, 86, 20);
		frame.getContentPane().add(spinnerFEntrada);
		spinnerFEntrada.setEditor(new JSpinner.DateEditor(spinnerFEntrada,"dd-mm-yyyy"));
	
		
		JSpinner spinnerFsalida = new JSpinner(new SpinnerDateModel(new Date(1483225200378L), null, null, Calendar.DAY_OF_MONTH));
		spinnerFsalida.setBounds(150, 161, 86, 20);
		frame.getContentPane().add(spinnerFsalida);
		spinnerFsalida.setEditor(new JSpinner.DateEditor(spinnerFsalida,"dd-mm-yyyy"));
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardar.setBounds(470, 35, 141, 69);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearText();
			}
		});
		btnLimpiar.setBounds(470, 143, 141, 69);
		frame.getContentPane().add(btnLimpiar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBounds(470, 260, 141, 69);
		frame.getContentPane().add(btnEditar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.setBounds(470, 370, 141, 69);
		frame.getContentPane().add(btnVolver);
		
		textPane = new JTextPane();
		textPane.setBounds(150, 365, 153, 86);
		frame.getContentPane().add(textPane);
		
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vehiculo ventana = new Vehiculo();
				ventana.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
	}
	
	public void clearText(){
		textMatricula.setText("");
		spinnerFEntrada.setValue(01/01/2017);
		spinnerFsalida.setValue(01/01/2017);
		textPrecio.setText("");
		textMecanico.setText("");
		textPane.setText("");
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
