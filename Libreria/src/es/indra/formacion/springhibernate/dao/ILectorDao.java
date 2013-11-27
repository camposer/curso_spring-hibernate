package es.indra.formacion.springhibernate.dao;

import java.util.List;

import es.indra.formacion.springhibernate.model.Lector;

public interface ILectorDao extends IDao<Lector, Integer> {
	public List<Lector> obtenerLectoresMayorEdad();
}
