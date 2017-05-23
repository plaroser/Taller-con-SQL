package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPrincipal {

	private JFrame frame;
	private JButton btnBV;
	private JButton btnNV;

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
		Componentes();
		BV();
		NV();
	}

	/**
	 * Componentes principales
	 */
	private void Componentes() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 232);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pantalla Principal");
		frame.getContentPane().setLayout(null);
		
		
	}
	
	/**
	 * Boton Buscar Vehiculo
	 */
	
	private void BV(){
		btnBV = new JButton("Buscar Vehiculo");
		btnBV.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnBV.setBounds(32, 59, 194, 76);
		frame.getContentPane().add(btnBV);
	}
	
	/**
	 * Boton Nuevo Vehiculo
	 */
	
	private void NV(){
		btnNV = new JButton("Nuevo Vehiculo");
		btnNV.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnNV.setBounds(265, 59, 194, 76);
		frame.getContentPane().add(btnNV);
		btnNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
					Vehiculo Ventana = new Vehiculo();
					Ventana.getFrame().setVisible(true);
					frame.dispose();
			
				
			}
		});
	}
}
