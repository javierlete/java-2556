package com.ipartek.formacion.poo.pojos;

import java.util.ArrayList;

public class Almacen {
	// Variables de instancia
	private Long id;
	private String nombre;
	private Double latitud;
	private Double longitud;
	
	private ArrayList<Producto> productos = new ArrayList<>();	
	
	// Constructores
	public Almacen(Long id, String nombre, Double latitud, Double longitud) {
		setId(id);
		setNombre(nombre);
		setLatitud(latitud);
		setLongitud(longitud);
	}

	// Getters y setters
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

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	// Métodos específicos
	public void meter(Producto producto) {
		if(producto == null) {
			throw new RuntimeException("No se admiten productos nulos");
		}
		
		productos.add(producto);
	}
	
	public Producto sacar(Long id) {
		Producto producto = null;
		
		for(int i = 0; i < productos.size(); i++) {
			if(productos.get(i).getId() == id) {
				producto = productos.get(i);
				productos.remove(i);
				return producto;
			}
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Producto> listado() {
		return (ArrayList<Producto>) productos.clone();
	}
	
	// toString
	@Override
	public String toString() {
		return "Almacen [id=" + id + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

}
