package UI;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Containers.Container;
import Models.Reparar;
import Models.Vehiculo;
import res.Constants;

import javax.swing.ImageIcon;
import javax.swing.JButton;


import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Collection;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BuscarVehiculo {

	private JFrame frame;
	private JTextField txtMatricula;
	private JLabel lblBuscar, lblMatricula;
	JButton btnBuscar;
	private JButton buttonVolver;
	private JLabel Imagen;
	private Collection<Vehiculo> listaActual;

	


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
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		

		lblBuscar = new JLabel("Buscar Vehiculo");

		lblMatricula = new JLabel("Matricula");

		txtMatricula = new JTextField();

		btnBuscar = new JButton("Buscar");
		
		buttonVolver = new JButton("Volver");
		
		Imagen = new JLabel(new ImageIcon("/Users/Alfonso/Downloads/images-2.jpg"));


		// Container.listaVehiculos = new ArrayList<Models.Vehiculo>();
		// Vehiculos de demo
		Container.listaVehiculos.add(new Vehiculo("1111AAA", "Renault", "Megane", (byte) 3, "Verde",
				LocalDate.of(2015, 3, 2), 120, "Diesel"));
		Container.listaVehiculos.get(0).getListaREparaciones().add(new Reparar(LocalDate.now(), null, 0.0f, Container.usuarioActivo, "Roto", null));
		Container.listaVehiculos.add(
				new Vehiculo("2222BBB", "Audi", "A3", (byte) 3, "Blanco", LocalDate.of(2015, 3, 2), 140, "Diesel"));
		Container.listaVehiculos
				.add(new Vehiculo("3333CCC", "BMW", "335", (byte) 2, "Gris", LocalDate.of(2015, 3, 2), 120, "Diesel"));
		Container.listaVehiculos.add(
				new Vehiculo("4444DDD", "Mercedes", "350", (byte) 2, "Negro", LocalDate.of(2015, 3, 2), 120, "Diesel"));
		listaActual = Container.listaVehiculos;
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
		btnBuscar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// recoger la matricula de la pantalla y pasarla a mayusculas
				String s = txtMatricula.getText().toUpperCase();
				// Comprobar que la matricula cumple los requisitos de una
				// matricula
				if (Constants.REGEX_MATRICULA.matcher(s).matches()) {
					Models.Vehiculo vehiculoAux = new Vehiculo(s, null, null, 0, null, null, 0, null);
					// Comprobar que la matricula esta dentro del sistema
					if (listaActual.contains(vehiculoAux)) {
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
		
		buttonVolver.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal Ventana = new PantallaPrincipal();
				Ventana.getFrame().setVisible(true);
				frame.dispose();
			}
		});
	}
}
