package com.ipartek.formacion.poo.pruebas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowBuilderPrueba {

	private JFrame frame;
	private JTextField tfNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderPrueba window = new WindowBuilderPrueba();
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
	public WindowBuilderPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 347, 118);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(6, 11, 50, 16);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(68, 6, 130, 26);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblResultado = new JLabel("Introduce tu nombre para que te salude");
		lblResultado.setBounds(6, 39, 248, 16);
		
		JButton btnSaludar = new JButton("Saludarte");
		btnSaludar.setBounds(210, 6, 102, 29);
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("Hola " + tfNombre.getText());
			}
		});
		frame.getContentPane().add(btnSaludar);
		frame.getContentPane().add(lblResultado);
		
	}

}
