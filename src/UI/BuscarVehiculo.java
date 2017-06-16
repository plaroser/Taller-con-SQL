package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Containers.Container;
import Models.Vehiculo;
import connections.connect;
import connections.vehiculosCN;
import res.Constants;

public class BuscarVehiculo {

	private JFrame frame;
	private JTextField txtMatricula;
	private JLabel lblBuscar, lblMatricula;
	JButton btnBuscar;
	private JButton buttonVolver;
	private JLabel Imagen;

	/**
	 * Create the application.
	 */
	public BuscarVehiculo() {
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
		vehiculosCN.cargarVehiculos();
		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		lblBuscar = new JLabel("Buscar Vehiculo");

		lblMatricula = new JLabel("Matricula");

		txtMatricula = new JTextField();

		btnBuscar = new JButton("Buscar");

		buttonVolver = new JButton("Volver");

		Imagen = new JLabel(new ImageIcon(this.getClass().getResource("/Image/images-2.jpg")));

		// Container.listaVehiculos = new ArrayList<Models.Vehiculo>();

	}

	private void setComponetProperties() {
		frame.setBounds(100, 100, 503, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblBuscar.setBounds(23, 23, 120, 30);
		frame.getContentPane().add(lblBuscar);

		lblMatricula.setBounds(23, 89, 66, 16);
		frame.getContentPane().add(lblMatricula);

		txtMatricula.setBounds(101, 82, 130, 30);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		btnBuscar.setBounds(23, 156, 116, 48);
		frame.getContentPane().add(btnBuscar);

		buttonVolver.setBounds(154, 156, 116, 48);
		frame.getContentPane().add(buttonVolver);

		Imagen.setBounds(299, 23, 192, 212);
		frame.getContentPane().add(Imagen);

	}

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

		btnBuscar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// recoger la matricula de la pantalla y pasarla a mayusculas
				String s = txtMatricula.getText().toUpperCase();
				// Comprobar que la matricula cumple los requisitos de una
				// matricula
				if (Constants.REGEX_MATRICULA.matcher(s).matches()) {
					Models.Vehiculo vehiculoAux = new Vehiculo(s, null, null, 0, null, null, 0, null, null, null);
					// Comprobar que la matricula esta dentro del sistema
					if (Container.listaVehiculos.contains(vehiculoAux)) {
						// Una vez que sabemos que esta en el sistema recorremos
						// la lista y buscamos el vehiculo con dicha matricula
						for (int i = 0; i < Container.listaVehiculos.size(); i++) {
							if (Container.listaVehiculos.get(i).equals(vehiculoAux)) {
								// Container.vehiculoActivo;

								UI.Vehiculo ventana = new UI.Vehiculo();
								Container.vehiculoActivo = i;
								ventana.imprimirVehiculo(Container.listaVehiculos.get(i));
								ventana.ModoLeer();
								ventana.getFrame().setVisible(true);
								frame.dispose();
								break;
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "El vehiculo no esta guardado en el sistema");

					}

				} else {
					JOptionPane.showMessageDialog(null,
							"El formato de la matricula no es correcto\nIntroducir sin guiones ni espacios en blanco.");
				}

			}
		});

		buttonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal Ventana = new PantallaPrincipal();
				Ventana.getFrame().setVisible(true);
				frame.dispose();
			}
		});
	}
}
