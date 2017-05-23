package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuscarVehiculo {

	private JFrame frame;
	private JTextField txtMatricula;
	private JLabel lblBuscar, lblMatricula;
	JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVehiculo window = new BuscarVehiculo();
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
	public BuscarVehiculo() {
		initialize();
		setComponetProperties();
		setComponentAdapters();
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
			}
		});
	}
}
