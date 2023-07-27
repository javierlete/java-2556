package com.ipartek.formacion.amazonia.modelos;

import java.math.BigDecimal;
import java.util.Objects;

public class Articulo {
	private Long id;
	private String descripcion;
	private Integer estrellas;
	private BigDecimal precio;
	private Integer cantidad;

	
	public Articulo(Long id, String descripcion, Integer estrellas, BigDecimal precio, Integer cantidad) {
		this.id = id;
		this.descripcion = descripcion;
		this.estrellas = estrellas;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Articulo(Long id, String descripcion, Integer estrellas, BigDecimal precio) {
		this(id, descripcion, estrellas, precio, null);
	}

	public Articulo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descripcion, estrellas, id, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(estrellas, other.estrellas) && Objects.equals(id, other.id)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", descripcion=" + descripcion + ", estrellas=" + estrellas + ", precio=" + precio
				+ ", cantidad=" + cantidad + "]";
	}
}
