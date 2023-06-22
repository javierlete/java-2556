package com.ipartek.formacion.poo.pruebas;

import java.util.*;

import com.ipartek.formacion.poo.pojos.interfaces.Balon;
import com.ipartek.formacion.poo.pojos.interfaces.Comestible;
import com.ipartek.formacion.poo.pojos.interfaces.Naranja;
import com.ipartek.formacion.poo.pojos.interfaces.Rodable;

public class InterfacesPrueba {
	public static void main(String[] args) {
		List<Rodable> rodables = new ArrayList<>();
		
		rodables.add(new Balon());
		rodables.add(new Naranja());
		
		for(Rodable r: rodables) {
			if(r instanceof Comestible c) {
				c.comer();
			}
			
			r.rodar();

			if(r instanceof Comestible c) {
				c.comer();
			}
		}
	}
}
