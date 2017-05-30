package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

public class SeleccionVehiculo {

	private JFrame frame;
	private JButton btnCoche;
	private JButton buttonCamion;
	private JButton buttonBicicleta;
	private JButton buttonMoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionVehiculo window = new SeleccionVehiculo();
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
	public SeleccionVehiculo() {
		initialize();
		setComponentProperties();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		btnCoche = new JButton("Coche");
		
		
		buttonCamion = new JButton("Camión");
		
		buttonBicicleta = new JButton("Bicicleta");
		
		
		buttonMoto = new JButton("Moto");
		
	}

	private void setComponentProperties(){
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCoche.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnCoche.setBounds(23, 27, 171, 78);
		frame.getContentPane().add(btnCoche);
		
		buttonCamion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonCamion.setBounds(23, 153, 171, 78);
		frame.getContentPane().add(buttonCamion);
		
		buttonBicicleta.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonBicicleta.setBounds(248, 153, 171, 78);
		frame.getContentPane().add(buttonBicicleta);
		
		buttonMoto.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		buttonMoto.setBounds(248, 27, 171, 78);
		frame.getContentPane().add(buttonMoto);
		
	}
}

