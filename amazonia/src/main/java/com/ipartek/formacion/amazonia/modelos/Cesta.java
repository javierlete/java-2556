package com.ipartek.formacion.amazonia.modelos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cesta {
	private List<Articulo> articulos = new ArrayList<>();

	public void agregarArticulo(Articulo articulo) {
		if(articulos.stream().anyMatch(a -> a.getId() == articulo.getId())) {
			agregarCantidad(articulo.getId(), articulo.getCantidad());
		} else {
			articulos.add(articulo);
		}
	}

	public void eliminarArticulo(Long id) {
		articulos.removeIf(a -> a.getId() == id);
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public BigDecimal getTotal() {
//		BigDecimal total = BigDecimal.ZERO;
//		
//		for(Articulo a: articulos) {
//			total = total.add(a.getTotal());
//		}
//		
//		return total;

		return articulos.stream().map(a -> a.getTotal()).reduce(BigDecimal.ZERO,
				(acumulado, subtotal) -> subtotal.add(acumulado));
	}

	public void agregarCantidad(Long id, Integer cantidad) {
		Optional<Articulo> articulo = articulos.stream().filter(a -> a.getId() == id).findFirst();

		if (articulo.isPresent()) {
			articulo.get().setCantidad(cantidad + articulo.get().getCantidad());
		}
	}

	public void cambiarCantidad(Long id, Integer cantidad) {
		Optional<Articulo> articulo = articulos.stream().filter(a -> a.getId() == id).findFirst();

		Articulo a = articulo.orElse(null);
		
		if (a != null) {
			a.setCantidad(cantidad);
		}
	}
	
	public Integer getCantidadArticulos() {
		return articulos.size();
	}
}
