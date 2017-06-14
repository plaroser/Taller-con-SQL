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
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDateTime;
import org.omg.CORBA.TRANSACTION_UNAVAILABLE;

import Containers.Container;
import Models.Usuario;

import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class Reparar {

	private JFrame frame;
	private JLabel lblFechaEntrada;
	private JLabel lblFechaSalida;
	private JLabel lblPrecio;
	private JLabel lblMecnico;
	private JLabel lblEstadoDeLa;
	private JLabel lblNewLabel;
	private JTextField textPrecio;
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
		frame = new JFrame();
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		textFEntrada = new JTextField();
		lblFechaSalida = new JLabel("Fecha Salida:");
		textFsalida = new JTextField();
		lblPrecio = new JLabel("Coste piezas:");
		textPrecio = new JTextField();
		lblMecnico = new JLabel("Mec\u00E1nico:");
		textMecanico = new JTextField();
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
		lblTiempoInvertido = new JLabel("Tiempo Invertido:");
		textTotal = new JTextField();
		btnIniciar = new JButton("Iniciar Reparacion");
		btnFinalizar = new JButton("Finalizar Reparacion");
		lblTotal = new JLabel("TOTAL:");
		btnNuevaReparacion = new JButton("Nueva Reparacion");

		setComponentPropierties();
		setComponentAdapters();

	}

	private void setComponentAdapters() {
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
				ventana.getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editable(false);
				if (Container.reparacionActiva == -1) {
					Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones().add(leerReparacion());
					Container.reparacionActiva = Container.listaVehiculos.get(Container.vehiculoActivo)
							.getListaREparaciones().indexOf(leerReparacion());
				} else {
					Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones()
							.add(Container.reparacionActiva, leerReparacion());
					Container.reparacionActiva = Container.listaVehiculos.get(Container.vehiculoActivo)
							.getListaREparaciones().indexOf(leerReparacion());
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

				int SiguienteIndice = Container.reparacionActiva + 1;
				if (SiguienteIndice < Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones()
						.size())
					imprimirReparacion(Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones()
							.get(SiguienteIndice));
			}
		});

		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int AnteriorIndice = Container.reparacionActiva - 1;
				if (AnteriorIndice >= 0)
					imprimirReparacion(Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones()
							.get(AnteriorIndice));
			}
		});

		btnNuevaReparacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearText();
				Container.reparacionActiva = -1;
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

		lblPrecio.setBounds(55, 315, 72, 14);
		frame.getContentPane().add(lblPrecio);

		lblMecnico.setBounds(55, 260, 63, 14);
		frame.getContentPane().add(lblMecnico);

		lblEstadoDeLa.setBounds(55, 375, 123, 14);
		frame.getContentPane().add(lblEstadoDeLa);

		lblNewLabel.setBounds(55, 429, 86, 14);
		frame.getContentPane().add(lblNewLabel);

		textPrecio.setBounds(150, 309, 86, 20);
		frame.getContentPane().add(textPrecio);
		textPrecio.setColumns(10);

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

	public void clearText() {
		textFEntrada.setText("");
		textFsalida.setText("");
		textPrecio.setText("");
		textComentarios.setText("");
	}

	public void nuevaReparacion() {

	}

	/**
	 * Metodo para bloquear los datos para editar modificarlos.
	 */
	public void editable(boolean activo) {
		textFEntrada.setEnabled(activo);
		textFsalida.setEnabled(activo);
		textPrecio.setEnabled(activo);
		textMecanico.setEnabled(activo);
		comboBox.setEnabled(activo);
		textComentarios.setEnabled(activo);
		btnLimpiar.setEnabled(activo);
		btnGuardar.setEnabled(activo);
		btnAnterior.setEnabled(!activo);
		btnSiguiente.setEnabled(!activo);
		progressBar.setEnabled(!activo);
		btnEditar.setEnabled(!activo);
		textTInvertido.setEnabled(activo);
	}

	public void imprimirLista() {
		if (Container.listaReparaciones.size() > 0) {
			imprimirReparacion(Container.listaReparaciones.get(0));
			progressBar.setMaximum(Container.listaReparaciones.size());
			progressBar.setValue(1);
			Container.reparacionActiva = 0;
			editable(false);
		} else {
			editable(true);
		}
	}

	public void imprimirReparacion(Models.Reparar r, int indice) {
		imprimirReparacion(r);
		progressBar.setValue(indice + 1);
	}

	public void imprimirReparacion(Models.Reparar r) {

		textPrecio.setText(String.valueOf(r.getPrecio()));
		textMecanico.setText(r.getMecanico());
		comboBox.setSelectedItem(r.getEstado());
		textComentarios.setText(r.getComentario());
		Container.reparacionActiva = Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones()
				.indexOf(r);
		iterador = Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones().listIterator();
		progressBar
				.setValue(Container.listaVehiculos.get(Container.vehiculoActivo).getListaREparaciones().indexOf(r) + 1);
		LocalDateTime inicio = r.getFecha_Entrada();
		LocalDateTime fin = r.getFecha_Salida();

		Duration duration = new Duration(inicio.toDateTime(), fin.toDateTime());
		textTInvertido.setText(duration.toString());
		textPrecio.setText("");
		textTotal.setText("");
	}

	public Models.Reparar leerReparacion() {

		// spinnerFEntrada.setValue(r.getFecha_Entrada().toString());
		// spinnerFsalida.setValue(r.getFecha_Salida().toString());
		float precio = Float.parseFloat(textPrecio.getText());
		String mecanico = Container.usuarioActivo.getUsuario();
		String estado = (String) comboBox.getSelectedItem();
		String comentarios = textComentarios.getText();
		return new Models.Reparar(null, null, precio, mecanico, estado, comentarios, comentarios, comentarios);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
