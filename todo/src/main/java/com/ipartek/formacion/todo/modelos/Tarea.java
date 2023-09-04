package com.ipartek.formacion.todo.modelos;

import java.util.Objects;

public class Tarea {
	private Long id;
	private String texto;
	private boolean terminada;
	
	public Tarea(Long id, String texto, boolean terminada) {
		super();
		this.id = id;
		this.texto = texto;
		this.terminada = terminada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, terminada, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		return Objects.equals(id, other.id) && terminada == other.terminada && Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", texto=" + texto + ", terminada=" + terminada + "]";
	}
	
	
}
