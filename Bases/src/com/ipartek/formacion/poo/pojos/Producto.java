package com.ipartek.formacion.poo.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Producto {
	// Constante estática ("de clase")
	public static final String NOMBRE_POR_DEFECTO = "SIN NOMBRE";
	public static final BigDecimal PRECIO_POR_DEFECTO = BigDecimal.ONE;
	
	// Variables de instancia
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private LocalDate caducidad;
	
	// Constructores (de instancia)
	public Producto(Long id, String nombre, BigDecimal precio, LocalDate caducidad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.caducidad = caducidad;
	}
	
	public Producto(Long id, String nombre, LocalDate caducidad) {
		this(id, nombre, PRECIO_POR_DEFECTO, caducidad);
	}
	
	public Producto(String nombre, BigDecimal precio, LocalDate caducidad) {
		this(null, nombre, precio, caducidad);
	}
	
	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, precio, null);
	}
	
	public Producto() {
		this(null, NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, null);
	}
	
	// Setters y Getters (de instancia)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public LocalDate getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
	}
	
	// Métodos estáticos ("de clase")
	public static Producto paqueteDosPorUno(Producto p1, Producto p2) {
		Producto producto = new Producto();
		
		producto.setNombre("2x1: " + p1.getNombre() + " y " + p2.getNombre());
		producto.setPrecio(p1.getPrecio().max(p2.getPrecio()));
		
		LocalDate caducidad1 = p1.getCaducidad();
		LocalDate caducidad2 = p2.getCaducidad();
		
		LocalDate caducidad = caducidad1.compareTo(caducidad2) < 0 ? caducidad1 : caducidad2;
		
		producto.setCaducidad(caducidad);
		
		return producto;
	}
	
	// Métodos de instancia
	public String obtenerFicha() {
		String ficha = 
				"Id:        " + id + 
				"\nNombre:    " + nombre + 
				"\nPrecio:    " + precio + 
				"\nCaducidad: " + caducidad +
				"\n";
		
		return ficha;
	}
	
	public Producto paqueteDosPorUno(Producto producto) {
		return paqueteDosPorUno(this, producto);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", caducidad=" + caducidad + "]";
	}
}
