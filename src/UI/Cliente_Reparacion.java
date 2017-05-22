package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

public class Cliente_Reparacion {

	private JFrame frame;
	private JButton btnReparacion;
	private JButton btnCliente;
	private JButton btnGuardar;
	private JButton btnEditar;
	
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
					Cliente_Reparacion window = new Cliente_Reparacion();
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
	public Cliente_Reparacion() {
		Componentes();
		Cliente();
		Reparar();
	}

	/**
	 * Componentes del Frame
	 */
	private void Componentes() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cliente - Reparacion");
		frame.getContentPane().setLayout(null);
		
		
		
	}
	
	/**
	 * Boton Cliente
	 */
	private void Cliente(){
		btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnCliente.setBounds(546, 92, 135, 78);
		frame.getContentPane().add(btnCliente);
	}
	

	/**
	 * Boton Cliente
	 */
	private void Reparar(){
		btnReparacion = new JButton("Reparar");
		btnReparacion.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnReparacion.setBounds(546, 203, 135, 78);
		frame.getContentPane().add(btnReparacion);
		
		
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnEditar.setBounds(208, 399, 147, 53);
		frame.getContentPane().add(btnEditar);
	}
	
	/**
	 * Boton Guardar
	 */
	private void Guardar(){
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnGuardar.setBounds(31, 399, 147, 53);
		frame.getContentPane().add(btnGuardar);
	}
	
}
