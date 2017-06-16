package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDateTime;
import org.omg.CORBA.TRANSACTION_UNAVAILABLE;

import Containers.Container;
import Models.Usuario;
import connections.reparacionCN;

import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class Reparar {

	private JFrame frame;
	private JLabel lblFechaEntrada;
	private JLabel lblFechaSalida;
	private JLabel lblPiezas;
	private JLabel lblMecnico;
	private JLabel lblEstadoDeLa;
	private JLabel lblNewLabel;
	private JTextField textPiezas;
	private JTextField textMecanico;
	private JButton btnEditar;
	private JButton btnLimpiar;
	private JButton btnVolver;
	private JTextField textFsalida;
	private JTextField textFEntrada;
	private JTextPane textComentarios;
	private JComboBox comboBox;
	private SpinnerDateModel model;
	private JButton btnGuardar;
	private JButton btnAnterior;
	private JProgressBar progressBar;
	private JButton btnSiguiente;
	private JTextField textTInvertido;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JLabel lblTiempoInvertido;
	private JButton btnIniciar;
	private JButton btnFinalizar;

	private ListIterator<Models.Reparar> iterador;
	private ImageIcon imagen;
	private ImageIcon imagen1;
	private JButton btnNuevaReparacion;
	private boolean esNueva;

	private Models.Vehiculo vehiculoActivo;

	public Models.Vehiculo getVehiculoActivo() {
		return vehiculoActivo;
	}

	public void setVehiculoActivo(Models.Vehiculo vehiculoActivo) {
		this.vehiculoActivo = vehiculoActivo;
	}

	/**
	 * Create the application.
	 */
	public Reparar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		esNueva = false;
		frame = new JFrame();
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		textFEntrada = new JTextField();
		textFEntrada.setEditable(false);
		lblFechaSalida = new JLabel("Fecha Salida:");
		textFsalida = new JTextField();
		textFsalida.setEditable(false);
		lblPiezas = new JLabel("Piezas:");
		textPiezas = new JTextField();
		lblMecnico = new JLabel("Mec\u00E1nico:");
		textMecanico = new JTextField();
		textMecanico.setEditable(false);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Pendiente", "Entregado" }));
		btnLimpiar = new JButton();
		lblEstadoDeLa = new JLabel("Estado de la reparacion:");
		lblNewLabel = new JLabel("Comentarios:");
		model = new SpinnerDateModel();
		btnGuardar = new JButton("Guardar");
		btnLimpiar = new JButton("Limpiar");
		btnVolver = new JButton("Volver");
		textComentarios = new JTextPane();
		imagen = new ImageIcon(this.getClass().getResource("/Image/left.png"));
		btnAnterior = new JButton(imagen);
		btnEditar = new JButton("Editar");
		progressBar = new JProgressBar();
		imagen1 = new ImageIcon(this.getClass().getResource("/Image/right.png"));
		btnSiguiente = new JButton(imagen1);
		textTInvertido = new JTextField();
		textTInvertido.setEditable(false);
		lblTiempoInvertido = new JLabel("Tiempo Invertido:");
		textTotal = new JTextField();
		textTotal.setEditable(false);
		btnIniciar = new JButton("Iniciar Reparacion");

		btnFinalizar = new JButton("Finalizar Reparacion");
		lblTotal = new JLabel("TOTAL:");
		btnNuevaReparacion = new JButton("Nueva Reparacion");
		vehiculoActivo = Container.listaVehiculos.get(Container.vehiculoActivo);
		setComponentPropierties();
		setComponentAdapters();

	}

	private void setComponentAdapters() {
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnIniciar.isEnabled()) {
					// Establecer fecha de entrada
					Container.listaReparaciones.get(Container.reparacionActiva).setFecha_Entrada(new LocalDateTime());
					;
					reparacionCN.actualizarReparacion(Container.listaReparaciones.get(Container.reparacionActiva));
					reparacionCN.cargarReparacionesVehiculo(vehiculoActivo);
					imprimirLista();
				}
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnLimpiar.isEnabled())
					clearText();
			}
		});

		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vehiculo ventana = new Vehiculo();
				Container.listaReparaciones = new ArrayList<>();
				ventana.getFrame().setVisible(true);
				ventana.imprimirVehiculo(Container.listaVehiculos.get(Container.vehiculoActivo));
				ventana.ModoLeer();
				frame.setVisible(false);
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editable(false);
				if (!esNueva) {
					if (Container.reparacionActiva == -1) {
						Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones()
								.add(leerReparacion());
						Container.reparacionActiva = Container.listaVehiculos.get(Container.vehiculoActivo)
								.getListaREparaciones().indexOf(leerReparacion());
					} else {
						// connections.connect.actualizarReparacion(leerReparacion());
						reparacionCN.cargarReparacionesVehiculo(vehiculoActivo);
						imprimirLista();
					}
				} else {
					reparacionCN.insertarReparacion(leerReparacion());
					reparacionCN.cargarReparacionesVehiculo(vehiculoActivo);
					editable(false);
					esNueva = false;

				}
			}
		});

		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editable(true);
			}
		});

		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnSiguiente.isEnabled()) {
					imprimirReparacion(Container.listaReparaciones.get(++Container.reparacionActiva));
					btnSiguiente.setEnabled(
							Container.reparacionActiva < (Containers.Container.listaReparaciones.size() - 1));
					btnAnterior.setEnabled(true);
				}
			}
		});

		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnAnterior.isEnabled()) {
					imprimirReparacion(Container.listaReparaciones.get(--Container.reparacionActiva));
					btnAnterior.setEnabled(Container.reparacionActiva > 0);
					btnSiguiente.setEnabled(true);
				}
			}
		});

		btnNuevaReparacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearText();
				textMecanico.setText(Container.mecanicoActivo.getUsuario());
				esNueva = true;
				editable(true);
			}
		});
	}

	private void setComponentPropierties() {

		frame.setBounds(100, 100, 732, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblFechaEntrada.setBounds(55, 164, 86, 14);
		frame.getContentPane().add(lblFechaEntrada);

		lblFechaSalida.setBounds(55, 211, 86, 14);
		frame.getContentPane().add(lblFechaSalida);

		lblPiezas.setBounds(55, 315, 72, 14);
		frame.getContentPane().add(lblPiezas);

		lblMecnico.setBounds(55, 260, 63, 14);
		frame.getContentPane().add(lblMecnico);

		lblEstadoDeLa.setBounds(55, 375, 123, 14);
		frame.getContentPane().add(lblEstadoDeLa);

		lblNewLabel.setBounds(55, 429, 86, 14);
		frame.getContentPane().add(lblNewLabel);

		textPiezas.setBounds(150, 309, 86, 53);
		frame.getContentPane().add(textPiezas);
		textPiezas.setColumns(10);

		textMecanico.setBounds(150, 257, 86, 20);
		frame.getContentPane().add(textMecanico);
		textMecanico.setColumns(10);

		comboBox.setBounds(191, 370, 112, 25);
		frame.getContentPane().add(comboBox);

		textFEntrada.setBounds(150, 161, 86, 20);
		frame.getContentPane().add(textFEntrada);

		textFsalida.setBounds(150, 208, 86, 20);
		frame.getContentPane().add(textFsalida);

		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardar.setBounds(519, 35, 141, 69);
		frame.getContentPane().add(btnGuardar);

		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnLimpiar.setBounds(519, 144, 141, 69);
		frame.getContentPane().add(btnLimpiar);

		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBounds(519, 260, 141, 69);
		frame.getContentPane().add(btnEditar);

		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.setBounds(519, 371, 141, 69);
		frame.getContentPane().add(btnVolver);

		textComentarios.setBounds(150, 429, 153, 86);
		frame.getContentPane().add(textComentarios);

		btnAnterior.setBounds(55, 6, 97, 40);
		frame.getContentPane().add(btnAnterior);

		progressBar.setBounds(154, 6, 146, 40);
		frame.getContentPane().add(progressBar);

		btnSiguiente.setBounds(305, 6, 97, 40);
		frame.getContentPane().add(btnSiguiente);

		textTInvertido.setBounds(150, 114, 86, 20);
		frame.getContentPane().add(textTInvertido);
		textTInvertido.setColumns(10);

		lblTiempoInvertido.setBounds(55, 117, 86, 14);
		frame.getContentPane().add(lblTiempoInvertido);

		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIniciar.setBounds(281, 78, 186, 62);
		frame.getContentPane().add(btnIniciar);

		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFinalizar.setBounds(281, 148, 186, 62);
		frame.getContentPane().add(btnFinalizar);

		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(390, 493, 141, 40);
		frame.getContentPane().add(lblTotal);

		textTotal.setBounds(519, 503, 135, 25);
		frame.getContentPane().add(textTotal);
		textTotal.setColumns(10);

		btnNuevaReparacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNuevaReparacion.setBounds(281, 223, 186, 62);
		btnNuevaReparacion.setBounds(281, 260, 186, 53);
		frame.getContentPane().add(btnNuevaReparacion);
	}

	/**
	 * Limpia el texto d ela pantalla
	 */
	public void clearText() {
		textFEntrada.setText("");
		textFsalida.setText("");
		textPiezas.setText("");
		textComentarios.setText("");
	}

	public void nuevaReparacion() {

	}

	/**
	 * Metodo para bloquear los datos para editar modificarlos.
	 */
	public void editable(boolean activo) {
		textPiezas.setEnabled(activo);
		textMecanico.setEnabled(activo);
		comboBox.setEnabled(activo);
		textComentarios.setEnabled(activo);
		btnLimpiar.setEnabled(activo);
		btnGuardar.setEnabled(activo);
		btnAnterior.setEnabled(false);
		if (!activo)
			btnSiguiente.setEnabled(Container.listaReparaciones.size() > 1);
		else
			btnSiguiente.setEnabled(false);
		progressBar.setEnabled(!activo);
		btnEditar.setEnabled(!activo);
	}

	/**
	 * Imprime una lista de reparaciones en la pantalla para navegar entre ellas
	 */
	public void imprimirLista() {
		if (Container.listaReparaciones.size() > 0) {
			imprimirReparacion(Container.listaReparaciones.get(0));
			progressBar.setMaximum(Container.listaReparaciones.size() - 1);
			progressBar.setValue(0);
			Container.reparacionActiva = 0;
			editable(false);
		} else {
			editable(true);
		}
	}

	/**
	 * Imprime una reparacion en la pantalla y establece el valor de la variable
	 * de progreso segun su indice
	 * 
	 * @param r
	 *            reparacion a mostrar
	 * @param indice
	 *            Indice a mostrar
	 */
	public void imprimirReparacion(Models.Reparar r, int indice) {
		imprimirReparacion(r);
		progressBar.setValue(indice + 1);
	}

	/**
	 * Imprime una reparacion por pantalla
	 * 
	 * @param r
	 *            Reparacion a mostrar
	 */
	public void imprimirReparacion(Models.Reparar r) {
		progressBar.setValue(Container.reparacionActiva);
		textMecanico.setText(r.getMecanico());
		comboBox.setSelectedItem(r.getEstado());
		textComentarios.setText(r.getComentario());
		if (r.getFecha_Entrada() != null) {
			if (r.getFecha_Entrada() != null && r.getFecha_Salida() != null) {
				LocalDateTime inicio = r.getFecha_Entrada();
				LocalDateTime fin = r.getFecha_Salida();

				Duration duration = new Duration(inicio.toDateTime(), fin.toDateTime());
				textTInvertido.setText(duration.toString());
				textTInvertido.setText(duration.toString());
				textFEntrada.setText(r.getFecha_Entrada().toString());
				textFsalida.setText(r.getFecha_Salida().toString());
			} else {
				textFEntrada.setText(r.getFecha_Entrada().toString());
				textFsalida.setText("---");
				textTInvertido.setText("---");
			}
		}

		textMecanico.setText(r.getMecanico());
		textPiezas.setText(r.getPiezas());
		comboBox.setSelectedItem(r.getEstado());
		textComentarios.setText(r.getComentario());
		textTotal.setText(String.valueOf(r.getPrecio()));
		btnIniciar.setEnabled(r.getFecha_Entrada() == null);
		btnFinalizar.setEnabled(r.getFecha_Salida() == null && !btnIniciar.isEnabled());

	}

	/**
	 * Crea una reparaciona partir de los datos que se introducen en la pantalla
	 * 
	 * @return reparacion creada
	 */
	public Models.Reparar leerReparacion() {
		float precio;
		try {
			precio = Float.parseFloat(textTotal.getText());
		} catch (Exception e) {
			precio = 0.0f;
		}
		String mecanico = Container.mecanicoActivo.getUsuario();
		String estado = (String) comboBox.getSelectedItem();
		String comentarios = textComentarios.getText();
		String piezas = textPiezas.getText();
		return new Models.Reparar(null, null, precio, piezas, Container.mecanicoActivo.getUsuario(), estado,
				comentarios, Container.listaVehiculos.get(Container.vehiculoActivo).getMatricula());
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
