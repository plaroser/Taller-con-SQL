package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Containers.Container;
import Models.Vehiculo;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class PantallaPrincipal {

	private JFrame frame;
	private JButton btnBV;
	private JButton btnNV;
	private JButton btnCS;
	private Collection<Models.Vehiculo> listaVehiculo;

	// FD
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
					PantallaPrincipal window = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		initialize();
		setComponetProperties();
		setComponentAdapters();
	}

	private void setComponentAdapters() {
		btnNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Container.vehiculoActivo = -1;
				UI.SeleccionVehiculo Ventana = new UI.SeleccionVehiculo();
				Ventana.getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});

		btnBV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuscarVehiculo ventana = new BuscarVehiculo();
				ventana.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});

		btnCS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login ventana = new Login();
				ventana.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
	}

	private void setComponetProperties() {
		frame.setBounds(100, 100, 519, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pantalla Principal");
		frame.getContentPane().setLayout(null);

		btnBV.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnBV.setBounds(32, 59, 194, 76);
		frame.getContentPane().add(btnBV);

		btnNV.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnNV.setBounds(258, 59, 194, 76);
		frame.getContentPane().add(btnNV);

		btnCS.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnCS.setBounds(149, 147, 194, 76);
		frame.getContentPane().add(btnCS);

	}

	/**
	 * Componentes principales
	 */
	private void initialize() {
		Container.listaVehiculos = new ArrayList<>();
		listaVehiculo = Container.listaVehiculos;
		frame = new JFrame();
		btnBV = new JButton("Buscar Vehiculo");
		btnNV = new JButton("Nuevo Vehiculo");
		btnCS = new JButton("Cerrar Sesion");
		Container.listaClientes = new ArrayList<>();

	}

}
