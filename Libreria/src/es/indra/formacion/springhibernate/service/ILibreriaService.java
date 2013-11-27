package es.indra.formacion.springhibernate.service;

import java.util.List;

import es.indra.formacion.springhibernate.model.Libreria;

public interface ILibreriaService {
	public List<Libreria> obtenerLibrerias();
	public Libreria obtenerLibreria(Integer id);
}
