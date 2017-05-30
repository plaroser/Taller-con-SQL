package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Containers.Container;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.spi.TimeZoneNameProvider;

public class SeleccionVehiculo {

	private JFrame frame;
	private JButton btnCoche;
	private JButton buttonCamion;
	private JButton buttonBicicleta;
	private JButton buttonMoto;

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
		setComponentAdapters();
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
	private void setComponentAdapters() {
		btnCoche.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseClicked(MouseEvent e) {
					lanzarVehiculo("Coche");	
			}
		});
		
		buttonMoto.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseClicked(MouseEvent e) {
					lanzarVehiculo("Moto");	
			}
		});
		
		buttonCamion.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseClicked(MouseEvent e) {
					lanzarVehiculo("Camión");	
			}
		});
		
		buttonBicicleta.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseClicked(MouseEvent e) {
					lanzarVehiculo("Bicicleta");	
			}
		});
		
	}
	
	private void lanzarVehiculo(String tipo){
		Container.tipoVehiculo = tipo;
		Vehiculo Ventana = new Vehiculo();
		Ventana.getFrame().setVisible(true);
		frame.dispose();
	}

	
}

