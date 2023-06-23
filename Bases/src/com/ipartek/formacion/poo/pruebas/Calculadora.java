package com.ipartek.formacion.poo.pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Calculadora {

	private static final String CERO = "0";
	private static final String ERROR = "****ERROR****";
	
	private JFrame frame;
	private JTextField tfDisplay;
	private JPanel pNumeros;
	
	private double op1;
	private String op;
	private double op2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
		
		String[] numeros = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ",", "E" };
		
		JButton boton;
		
		for(String numero: numeros) {
			boton = new JButton(numero);
			pNumeros.add(boton);
			
			// Java8
			boton.addActionListener(
					e -> eventoAPantalla(e));
			
			// Java < 8
//			boton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					eventoAPantalla(e);
//				}
//			});
		}
		
//		for(int num = 0; num <= 9; num++) {
//			boton = new JButton(String.valueOf(num));
//			pNumeros.add(boton);
//		}
	}

	private void eventoAPantalla(ActionEvent e) {
		digitoAPantalla(extraerNumeroDeBoton(extraerBotonDeEvento(e)));
	}

	private void digitoAPantalla(String digito) {
		String texto = tfDisplay.getText();
		
		if(ERROR.equals(texto)) {
			texto = "";
		}
		
		if(CERO.equals(texto) && !",".equals(digito)) {
			texto = "";
		}
		
		escribirPantalla(texto + digito);
	}

	private String extraerNumeroDeBoton(JButton boton) {
		return boton.getText();
	}

	private JButton extraerBotonDeEvento(ActionEvent e) {
		return (JButton) e.getSource();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tfDisplay = new JTextField();
		tfDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(tfDisplay, BorderLayout.NORTH);
		tfDisplay.setColumns(10);
		
		JPanel pOperaciones = new JPanel();
		frame.getContentPane().add(pOperaciones, BorderLayout.EAST);
		pOperaciones.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnSumar = new JButton("+");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = leerPantalla();
				op = "+";
				limpiarPantalla();
			}
		});
		pOperaciones.add(btnSumar);
		
		JButton btnRestar = new JButton("-");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = leerPantalla();
				op = "-";
				limpiarPantalla();
			}
		});
		pOperaciones.add(btnRestar);
		
		JButton btnMultiplicar = new JButton("X");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = leerPantalla();
				op = "*";
				limpiarPantalla();
			}
		});
		pOperaciones.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("/");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op1 = leerPantalla();
				op = "/";
				limpiarPantalla();
			}
		});
		pOperaciones.add(btnDividir);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double res = 0.0;
				
				op2 = leerPantalla();
				
				switch(op) {
				case "+":
					res = op1 + op2;
					break;
				case "-":
					res = op1 - op2;
					break;
				case "*":
					res = op1 * op2;
					break;
				case "/":
					res = op1 / op2;
					break;
				}
				
				escribirPantalla(res);
			}
		});
		pOperaciones.add(btnIgual);
		
		JPanel pCentral = new JPanel();
		frame.getContentPane().add(pCentral, BorderLayout.CENTER);
		pCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel pOperaciones2 = new JPanel();
		pCentral.add(pOperaciones2, BorderLayout.NORTH);
		pOperaciones2.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnAc = new JButton("AC");
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escribirPantalla(CERO);
			}
		});
		pOperaciones2.add(btnAc);
		
		JButton btnMasMenos = new JButton("+/-");
		btnMasMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num = leerPantalla();
				
				num *= -1;
				
				escribirPantalla(num);
			}
		});
		pOperaciones2.add(btnMasMenos);
		
		JButton btnPorcentaje = new JButton("%");
		btnPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num = leerPantalla();
				
				num /= 100;
				
				escribirPantalla(num);
			}
		});
		pOperaciones2.add(btnPorcentaje);
		
		pNumeros = new JPanel();
		pCentral.add(pNumeros, BorderLayout.CENTER);
		pNumeros.setLayout(new GridLayout(4, 3, 0, 0));
	}
	
	private double leerPantalla() {
		String texto = tfDisplay.getText();
		String textoConPuntos = texto.replace(",", ".");
		try {
			return Double.parseDouble(textoConPuntos);
		} catch (NumberFormatException e) {
			escribirPantalla(ERROR);
			throw e;
		}
	}

	private void escribirPantalla(double dato) {
		String texto = String.valueOf(dato);
		String textoConComas = texto.replace(".", ",");
		
		if(textoConComas.endsWith(",0")) {
			textoConComas = textoConComas.replace(",0", "");
		}
		
		escribirPantalla(textoConComas);
	}

	private void escribirPantalla(String texto) {
		tfDisplay.setText(texto);
	}

	private void limpiarPantalla() {
		escribirPantalla("0");
	}

}
