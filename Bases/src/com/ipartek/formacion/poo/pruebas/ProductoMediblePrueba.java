package com.ipartek.formacion.poo.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.poo.pojos.Almacen;
import com.ipartek.formacion.poo.pojos.Producto;
import com.ipartek.formacion.poo.pojos.ProductoMedible;

public class ProductoMediblePrueba {
	public static void main(String[] args) {
		ProductoMedible pm = new ProductoMedible();

		System.out.println(pm);
		
		pm.setId(1L);
		pm.setNombre("Prueba");
		pm.setPrecio(new BigDecimal("123"));
		pm.setCaducidad(null);
		
		pm.setAlto(1.0);
		pm.setAncho(2.0);
		pm.setProfundidad(3.0);
		
		System.out.println(pm);
		
		System.out.println(pm.obtenerFicha());
		
		Producto pack = ProductoMedible.paqueteDosPorUno(pm, new Producto());
		
		System.out.println(pack);
		
		Almacen almacen = new Almacen(1L, "Bilbao", 42.2, -2.9);
		
		almacen.meter(pack);
		almacen.meter(pm);
		
		System.out.println("LISTADO");
		
		for(Producto p: almacen.listado()) {
			System.out.println(p.obtenerFicha());
			
			if(p instanceof ProductoMedible) {
				ProductoMedible prodMed = (ProductoMedible) p;
				
				System.out.println("Area: " + prodMed.getAlto() * prodMed.getAncho() * prodMed.getProfundidad());
			}
		}
		
		ProductoMedible pm1 = new ProductoMedible();
		
		pm1.setAlto(1.0);
		pm1.setAncho(2.0);
		pm1.setProfundidad(3.0);

		System.out.println("Antes: " + pm1);
		
		Producto producto = pm1; // Generalización
		
		// > Java 8
		if(producto instanceof ProductoMedible pm2) {
			System.out.println("Después: " + pm2);
		}
		
		Producto p = new Producto();
		
		if(p instanceof ProductoMedible) {
			ProductoMedible pm3 = (ProductoMedible) p;
			System.out.println(pm3);
		} else {
			System.err.println("No se puede utilizar como producto medible");
		}
		
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		System.out.println(p1.getClass().getName() + "@" + Integer.toHexString(p1.hashCode()));
	}
}
