package com.ipartek.formacion.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setCaducidad(caducidad);
	}
	
	// Constructor de copia
	public Producto(Producto producto) {
		this(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getCaducidad());

//		this.id = producto.getId();
//		this.nombre = producto.getNombre();
//		this.precio = producto.getPrecio();
//		this.caducidad = producto.getCaducidad();
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
		if(id != null && id < 0) {
			throw new RuntimeException("No se admiten valores negativos para el id");
		}
		
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres sin rellenar");
		}
		this.nombre = nombre.trim();
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			throw new RuntimeException("El precio es obligatorio y debe ser positivo");
		}
		this.precio = precio;
	}
	public LocalDate getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(LocalDate caducidad) {
		if(caducidad != null && caducidad.compareTo(LocalDate.now()) <= 0) {
			throw new RuntimeException("La caducidad debe ser en el futuro");
		}
		this.caducidad = caducidad;
	}
	
	// Métodos estáticos ("de clase")
	public static Producto paqueteDosPorUno(Producto p1, Producto p2) {
		Producto producto = new Producto();
		
		producto.setNombre("2x1: " + p1.getNombre() + " y " + p2.getNombre());
		producto.setPrecio(p1.getPrecio().max(p2.getPrecio()));
		
		LocalDate caducidad1 = p1.getCaducidad();
		LocalDate caducidad2 = p2.getCaducidad();
		
		LocalDate caducidad;
		
		if(caducidad1 == null) {
			caducidad = caducidad2;
		} else if(caducidad2 == null) {
			caducidad = caducidad1;
		} else {
			caducidad = caducidad1.compareTo(caducidad2) < 0 ? caducidad1 : caducidad2;
		}
		
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
	public int hashCode() {
		return Objects.hash(caducidad, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(caducidad, other.caducidad) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", caducidad=" + caducidad + "]";
	}
}
