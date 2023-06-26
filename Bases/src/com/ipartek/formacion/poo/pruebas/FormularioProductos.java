package com.ipartek.formacion.poo.pruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.poo.pojos.Almacen;
import com.ipartek.formacion.poo.pojos.Producto;

public class FormularioProductos {

	// https://chuidiang.org/index.php?title=JTable
	
	private Almacen almacen = new Almacen(1L, "Bilbao", 42.0, 2.0);
	private DefaultTableModel modelo;

	private JFrame frame;
	private JTable tabla;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTextField tfCaducidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioProductos window = new FormularioProductos();
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
	public FormularioProductos() {

		for (int i = 1; i <= 10; i++) {
			Long id = (long) i;
			String nombre = "Producto " + i;
			BigDecimal precio = new BigDecimal(i + "0");
			LocalDate caducidad = LocalDate.of(2024 + i, i, i * 2);

			Producto producto = new Producto(id, nombre, precio, caducidad);

			almacen.meter(producto);
		}

		initialize();

		modelo = (DefaultTableModel) tabla.getModel();

		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		modelo.addColumn("Caducidad");

		rellenarTabla();

		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.rowAtPoint(e.getPoint());
				// int columna = tabla.columnAtPoint(e.getPoint());
				// if ((fila > -1) && (columna > -1))
				// System.out.println(modelo.getValueAt(fila, columna));

				if (fila > -1) {
					Long id = (Long) modelo.getValueAt(fila, 0);
					Producto producto = almacen.verPorId(id);

					productoAFormulario(producto);
				}
			}
		});

//		Object[] fila = new Object[4];
//		fila[0] = "1";
//		fila[1] = "Producto1";
//		fila[2] = "1234,12";
//		fila[3] = "2024-01-02";
//		modelo.addRow(fila); // Añade una fila al final
		// modelo.setValueAt ("nuevo valor", 0, 1); // Cambia el valor de la fila 1,
		// columna 2.
		// modelo.removeRow (0); // Borra la primera fila
	}

	private void rellenarTabla() {
		modelo.setRowCount(0);
		
		Object[] fila;
		for (Producto producto : almacen.listado()) {
			fila = new Object[4];

			fila[0] = producto.getId();
			fila[1] = producto.getNombre();
			fila[2] = producto.getPrecio();
			fila[3] = producto.getCaducidad();

			modelo.addRow(fila);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pFormulario = new JPanel();
		frame.getContentPane().add(pFormulario, BorderLayout.SOUTH);
		GridBagLayout gbl_pFormulario = new GridBagLayout();
		gbl_pFormulario.columnWidths = new int[] { 0, 0, 0 };
		gbl_pFormulario.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_pFormulario.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_pFormulario.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pFormulario.setLayout(gbl_pFormulario);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		pFormulario.add(lblId, gbc_lblId);

		tfId = new JTextField();
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.insets = new Insets(0, 0, 5, 0);
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.gridx = 1;
		gbc_tfId.gridy = 0;
		pFormulario.add(tfId, gbc_tfId);
		tfId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		pFormulario.add(lblNombre, gbc_lblNombre);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 1;
		pFormulario.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 2;
		pFormulario.add(lblPrecio, gbc_lblPrecio);

		tfPrecio = new JTextField();
		GridBagConstraints gbc_tfPrecio = new GridBagConstraints();
		gbc_tfPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrecio.gridx = 1;
		gbc_tfPrecio.gridy = 2;
		pFormulario.add(tfPrecio, gbc_tfPrecio);
		tfPrecio.setColumns(10);

		JLabel lblCaducidad = new JLabel("Caducidad");
		GridBagConstraints gbc_lblCaducidad = new GridBagConstraints();
		gbc_lblCaducidad.anchor = GridBagConstraints.EAST;
		gbc_lblCaducidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaducidad.gridx = 0;
		gbc_lblCaducidad.gridy = 3;
		pFormulario.add(lblCaducidad, gbc_lblCaducidad);

		tfCaducidad = new JTextField();
		GridBagConstraints gbc_tfCaducidad = new GridBagConstraints();
		gbc_tfCaducidad.insets = new Insets(0, 0, 5, 0);
		gbc_tfCaducidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCaducidad.gridx = 1;
		gbc_tfCaducidad.gridy = 3;
		pFormulario.add(tfCaducidad, gbc_tfCaducidad);
		tfCaducidad.setColumns(10);

		JPanel pBotonera = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pBotonera.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_pBotonera = new GridBagConstraints();
		gbc_pBotonera.fill = GridBagConstraints.BOTH;
		gbc_pBotonera.gridx = 1;
		gbc_pBotonera.gridy = 4;
		pFormulario.add(pBotonera, gbc_pBotonera);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Producto producto = formularioAProducto();
					
					almacen.meter(producto);
					
					rellenarTabla();
					
					limpiarFormulario();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No se ha podido hacer la operación", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pBotonera.add(btnInsertar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Producto producto = formularioAProducto();
					
					almacen.cambiar(producto);
					
					rellenarTabla();
					
					limpiarFormulario();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No se ha podido hacer la operación", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pBotonera.add(btnModificar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Producto producto = formularioAProducto();
					
					almacen.sacar(producto.getId());
					
					rellenarTabla();
					
					limpiarFormulario();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No se ha podido hacer la operación", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pBotonera.add(btnBorrar);

		tabla = new JTable();
		// frame.getContentPane().add(tabla, BorderLayout.CENTER);
		// scrollPane.add(tabla);
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	private Producto formularioAProducto() {
		Producto producto = new Producto();
		
		producto.setId(Long.parseLong(tfId.getText()));
		producto.setNombre(tfNombre.getText());
		producto.setPrecio(new BigDecimal(tfPrecio.getText()));
		producto.setCaducidad(LocalDate.parse(tfCaducidad.getText()));
		
		return producto;
	}
	
	private void productoAFormulario(Producto producto) {
		tfId.setText(producto.getId().toString());
		tfNombre.setText(producto.getNombre());
		tfPrecio.setText(producto.getPrecio().toString());
		tfCaducidad.setText(producto.getCaducidad().toString());
	}

	private void limpiarFormulario() {
		tfId.setText("");
		tfNombre.setText("");
		tfPrecio.setText("");
		tfCaducidad.setText("");
	}
}
