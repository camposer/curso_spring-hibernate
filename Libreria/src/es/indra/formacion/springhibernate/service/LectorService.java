package es.indra.formacion.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.indra.formacion.springhibernate.dao.ILectorDao;
import es.indra.formacion.springhibernate.model.Lector;

@Transactional
public class LectorService implements ILectorService { 
	@Autowired
	private ILectorDao lectorDao;

	@Override
	public List<Lector> obtenerLectores() {
		return lectorDao.obtenerTodos();
	}

	@Override
	public List<Lector> obtenerLectoresMayorEdad() {
		return lectorDao.obtenerLectoresMayorEdad();
	}
	
}
