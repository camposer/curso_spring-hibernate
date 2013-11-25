package es.indra.formacion.springhibernate.service;

import java.util.List;

import es.indra.formacion.springhibernate.model.Libro;

public interface ILibroService {
	public void agregarLibro(Libro libro);
	public void modificarLibro(Libro libro);
	public void eliminarLibro(Integer id);
	public List<Libro> obtenerLibros();
	public Libro obtenerLibro(Integer id);
}
