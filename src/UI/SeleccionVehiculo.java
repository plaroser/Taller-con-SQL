package UI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import Containers.Container;
import connections.connect;

public class SeleccionVehiculo {

	/**
	 * ATRIBUTOS
	 */
	private JFrame frame;
	private JButton btnCoche;
	private JButton buttonCamion;
	private JButton buttonBicicleta;
	private JButton buttonMoto;

	/**
	 * SET AND GET FRAME
	 * 
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
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

		buttonCamion = new JButton("Cami\u00F3n");

		buttonBicicleta = new JButton("Bicicleta");

		buttonMoto = new JButton("Moto");

	}

	/**
	 * PROPIEDADES DE LOS COMPONENTES
	 */
	private void setComponentProperties() {
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

	/**
	 * ADAPTADORES
	 */
	private void setComponentAdapters() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				try {
					connect.stmt.close();
					connect.con.close();
					System.out.println("Conexion cerrada.\nHasta pronto!!!");
				} catch (Exception e) {
					System.out.println("ERROR al cerrar la conexion.\n" + e.getMessage());
				}

				System.exit(0);
			}
		});
		
		btnCoche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lanzarVehiculo("Coche");
			}
		});

		buttonMoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lanzarVehiculo("Moto");
			}
		});

		buttonCamion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lanzarVehiculo("Camión");
			}
		});

		buttonBicicleta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lanzarVehiculo("Bicicleta");
			}
		});

	}

	/**
	 * SELECCIONA EL TIPO DE VEHICULO
	 * 
	 * @param tipo
	 *            RECOGE EL STRING DE TIPO DE VEHICULO
	 */
	private void lanzarVehiculo(String tipo) {
		Container.tipoVehiculo = tipo;
		Vehiculo Ventana = new Vehiculo();
		Ventana.getFrame().setVisible(true);
		frame.dispose();
	}

}
