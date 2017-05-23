package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Models.Vehiculo;
import res.Constants;

import javax.sound.midi.ControllerEventListener;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

public class BuscarVehiculo {

	private JFrame frame;
	private JTextField txtMatricula;
	private JLabel lblBuscar, lblMatricula;
	JButton btnBuscar;
	private Collection<Vehiculo> listaActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVehiculo window = new BuscarVehiculo(new ArrayList<Vehiculo>() {
					});
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
	public BuscarVehiculo(Collection<Vehiculo> listaActual) {
		this.listaActual=listaActual;
		initialize();
		setComponetProperties();
		setComponentAdapters();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		lblBuscar = new JLabel("Buscar Vehiculo");

		lblMatricula = new JLabel("Matricula");

		txtMatricula = new JTextField();

		btnBuscar = new JButton("Buscar");

	}

	private void setComponetProperties() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblBuscar.setBounds(23, 23, 120, 30);
		frame.getContentPane().add(lblBuscar);

		lblMatricula.setBounds(23, 110, 66, 16);
		frame.getContentPane().add(lblMatricula);

		txtMatricula.setBounds(101, 107, 116, 22);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		btnBuscar.setBounds(101, 156, 116, 48);
		frame.getContentPane().add(btnBuscar);
	}

	private void setComponentAdapters() {
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = txtMatricula.getText();
				if(Constants.REGEX_MATRICULA.matcher(s).matches()){
					//Collection<Vehiculo> lista = UI.Vehiculo.
				}
			}
		});
	}
}
