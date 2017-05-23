package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Vehiculo;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

public class PantallaPrincipal {

	private JFrame frame;
	private JButton btnBV;
	private JButton btnNV;
	private Collection<Vehiculo> listaActual;

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
				UI.Vehiculo Ventana = new UI.Vehiculo();
				Ventana.getFrame().setVisible(true);
				frame.dispose();

			}
		});
	}

	private void setComponetProperties() {
		frame.setBounds(100, 100, 519, 232);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pantalla Principal");
		frame.getContentPane().setLayout(null);

		btnBV.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnBV.setBounds(32, 59, 194, 76);
		frame.getContentPane().add(btnBV);

		btnNV.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnNV.setBounds(265, 59, 194, 76);
		frame.getContentPane().add(btnNV);
	}

	/**
	 * Componentes principales
	 */
	private void initialize() {
		frame = new JFrame();
		btnBV = new JButton("Buscar Vehiculo");
		btnNV = new JButton("Nuevo Vehiculo");

	}

}
