package es.indra.formacion.springhibernate.service;

import java.util.List;

import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;

public interface ILibroService {
	public void agregarLibro(Libro libro);
	public void modificarLibro(Libro libro);
	public void eliminarLibro(Integer id);
	public List<Libro> obtenerLibros();
	public Libro obtenerLibro(Integer id);
	public List<Libreria> obtenerLibreriasPorLibro(Integer id);
	public List<String> obtenerAutores();
	public Libro obtenerLibroMasVendido();
	public Object[] obtenerAutorMasVendidoVentas();
	public List<Object[]> obtenerLibrosVendidosPorAnio();
}
