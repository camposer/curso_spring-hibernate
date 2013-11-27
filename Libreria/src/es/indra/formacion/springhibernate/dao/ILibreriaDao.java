package es.indra.formacion.springhibernate.dao;

import java.util.List;

import es.indra.formacion.springhibernate.model.Libreria;

public interface ILibreriaDao extends IDao<Libreria, Integer> {
	public List<Libreria> obtenerLibreriasPorLibro(Integer id);
}
