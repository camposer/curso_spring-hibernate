package es.indra.formacion.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.indra.formacion.springhibernate.dao.ILibroDao;
import es.indra.formacion.springhibernate.model.Libro;

@Transactional
public class LibroTransService implements ILibroService { 
	@Autowired
	private ILibroDao libroDao;

	@Override
	public void agregarLibro(Libro libro) {
		// TODO: Agregar lógica de negocios
		libroDao.agregar(libro);
	}

	@Override
	public void modificarLibro(Libro libro) {
		// TODO: Agregar lógica de negocios
		libroDao.modificar(libro);
	}

	@Override
	public void eliminarLibro(Integer id) {
		// TODO: Agregar lógica de negocios
		libroDao.eliminar(id);
	}

	@Override
	public List<Libro> obtenerLibros() {
		// TODO: Agregar lógica de negocios
		return libroDao.obtenerTodos();
	}

	@Override
	public Libro obtenerLibro(Integer id) {
		// TODO: Agregar lógica de negocios
		return libroDao.obtener(id);
	}

	public void setLibroDao(ILibroDao libroDao) {
		this.libroDao = libroDao;
	}
}
