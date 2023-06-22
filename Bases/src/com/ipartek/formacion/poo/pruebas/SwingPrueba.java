package com.ipartek.formacion.poo.pruebas;

import java.awt.Container;

import java.awt.*;
import javax.swing.*;

public class SwingPrueba {

	public static void main(String[] args) {
		JFrame jf = new JFrame("Ejemplo de Swing");
		Container c = jf.getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel jl = new JLabel("Dime tu nombre");
		c.add(jl);

		JTextField tf = new JTextField(10);
		c.add(tf);
		
		JButton b = new JButton("Saludar");
		c.add(b);
		
		JLabel saludo = new JLabel("Introduce tu nombre para que te salude");
		c.add(saludo);
		
		b.addActionListener(e -> saludo.setText("Hola " + tf.getText()));
		
		jf.setBounds(100, 100, 300, 200);
		jf.setVisible(true);
	}

}
