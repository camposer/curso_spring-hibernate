package es.indra.formacion.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.indra.formacion.springhibernate.dao.ILibreriaDao;
import es.indra.formacion.springhibernate.model.Libreria;

public class LibreriaService implements ILibreriaService { 
	@Autowired
	private ILibreriaDao libreriaDao;
	
	@Override
	public List<Libreria> obtenerLibrerias() {
		return libreriaDao.obtenerTodos();
	}

	@Override
	public Libreria obtenerLibreria(Integer id) {
		return libreriaDao.obtener(id);
	}
	
}