package com.ipartek.formacion.poo.pruebas;

import static com.ipartek.formacion.bibliotecas.Consola.*;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.poo.pojos.Producto;

public class ProductoPrueba {
	// Métodos estáticos ("de clase")
	public static void main(String[] args) {
		Producto manzana = new Producto();

		manzana.setId(5L);
		manzana.setNombre("    Naranja  ");
		manzana.setPrecio(new BigDecimal("1.23"));
		manzana.setCaducidad(LocalDate.of(2025, 1, 2));

		mostrarProducto(manzana);

		Producto manzana2 = new Producto(manzana);
		
		manzana2.setNombre("Manzana2");
		
		mostrarLinea(manzana);
		mostrarLinea(manzana2);
		
		//System.exit(0);
		
		Producto naranja = new Producto(1L, "Naranja", new BigDecimal("2.13"), LocalDate.of(2024, 12, 12));

		mostrarProducto(naranja);

		Producto pack = Producto.paqueteDosPorUno(manzana, naranja);

		mostrarProducto(pack);

		Producto pack2 = naranja.paqueteDosPorUno(manzana);

		mostrarProducto(pack2);

		System.out.println(pack2);

		mostrarLinea(pack2);

		ejemploAlmacen();
	}

	private static void ejemploAlmacen() {
		ArrayList<Producto> almacen = new ArrayList<>();

//		almacen.add(manzana);
//		almacen.add(naranja);
//		almacen.add(pack);
//		almacen.add(pack2);

		boolean seguir;

		do {
			Producto p = pedirProducto();

			almacen.add(p);

			seguir = leerBooleano("¿Otro producto?");
		} while (seguir);

		mostrarLinea("INFORME DE ALMACEN");

		for (Producto producto : almacen) {
			mostrarLinea(producto);
			// mostrarProducto(producto);
		}
	}

	private static Producto pedirProducto() {
		Producto p = new Producto();

		pedirId(p);
		pedirNombre(p);
		pedirPrecio(p);
		pedirCaducidad(p);

		return p;
	}

	private static void pedirId(Producto p) {
		boolean equivocado = true;
		
		do {
			Long id = leerLong("Id");
			
			try {
				p.setId(id);
				equivocado = false;
			} catch (Exception e) {
				mostrarLineaError(e.getMessage());
			}
		} while (equivocado);
	}

	private static void pedirNombre(Producto p) {
		boolean equivocado = true;
		
		do {
			String nombre = leerLinea("Nombre");
			try {
				p.setNombre(nombre);
				equivocado = false;
			} catch (Exception e) {
				mostrarLineaError(e.getMessage());
			}
		} while (equivocado);
	}

	private static void pedirPrecio(Producto p) {
		boolean equivocado = true;
		
		do {
			BigDecimal precio = leerBigDecimal("Precio");
			try {
				p.setPrecio(precio);
				equivocado = false;
			} catch (Exception e) {
				mostrarLineaError(e.getMessage());
			}
		} while (equivocado);
	}

	private static void pedirCaducidad(Producto p) {
		boolean equivocado = true;
		
		do {
			LocalDate caducidad = leerLocalDate("Caducidad");
			try {
				p.setCaducidad(caducidad);
				equivocado = false;
			} catch (Exception e) {
				mostrarLineaError(e.getMessage());
			}
		} while (equivocado);
	}

	private static void mostrarProducto(Producto p) {
		System.out.println(p.obtenerFicha());
	}

}
