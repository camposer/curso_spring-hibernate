package es.indra.formacion.springhibernate.service;

import es.indra.formacion.springhibernate.model.Lector;
import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;

public interface ICompraService {
	public void comprar(Libro libro, Libreria libreria, Lector lector);
}
