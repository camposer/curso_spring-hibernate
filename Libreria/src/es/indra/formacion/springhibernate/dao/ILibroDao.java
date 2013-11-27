package es.indra.formacion.springhibernate.dao;

import java.util.List;

import es.indra.formacion.springhibernate.model.Libro;

public interface ILibroDao extends IDao<Libro, Integer> {
	public List<String> obtenerAutores();
	public Libro obtenerLibroMasVendido();
	public Object[] obtenerAutorMasVendidoVentas();
	public List<Object[]> obtenerLibrosVendidosPorAnio();
}
