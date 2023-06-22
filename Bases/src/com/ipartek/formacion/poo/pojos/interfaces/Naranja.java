package com.ipartek.formacion.poo.pojos.interfaces;

public class Naranja extends Fruto implements Rodable, Comestible {
	private boolean rodado = false;
	
	@Override
	public void comer() {
		if(rodado) {
			System.out.println("Puagh, que asco...");
		} else {
			System.out.println("Ñam, que rica");
		}
	}

	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		rodado = true;
	}

}
