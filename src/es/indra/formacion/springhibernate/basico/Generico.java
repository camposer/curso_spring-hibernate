package es.indra.formacion.springhibernate.basico;

import java.util.ArrayList;
import java.util.List;

public class Generico {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("Hola");
		A<String> a = new A<String>();
		List<? extends String> lista1 = new ArrayList<String>();
		a.setMensaje("Hola");
		
		System.out.println(a.getMensaje());
		
		for (String obj : lista) {
			if (obj instanceof String) 
				System.out.println("String: " + obj);

		}
	}
}

class A<HOLA> {
	HOLA mensaje;

	public HOLA getMensaje() {
		return mensaje;
	}

	public void setMensaje(HOLA mensaje) {
		this.mensaje = mensaje;
	}
}
