package Models;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BuscarVehiculo {

	private JFrame frame;

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

	}

	private void setComponetProperties() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setComponentAdapters() {
		// TODO Auto-generated method stub

	}
}
