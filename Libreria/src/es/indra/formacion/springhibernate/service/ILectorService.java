package es.indra.formacion.springhibernate.service;

import java.util.List;

import es.indra.formacion.springhibernate.model.Lector;

public interface ILectorService {
	public List<Lector> obtenerLectores();
	public List<Lector> obtenerLectoresMayorEdad();
}
