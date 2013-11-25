package es.indra.formacion.springhibernate.service;

import java.util.Date;
import java.util.List;

import es.indra.formacion.springhibernate.dao.ILibroDao;
import es.indra.formacion.springhibernate.model.Libro;

public class LibroService implements ILibroService { 
	private ILibroDao libroDao;

	public void init() {
		libroDao.agregar(new Libro("Titulo 1", "Autor 1", "Editorial 1", new Date(), Libro.TIPO_TAPA_DURA));
		libroDao.agregar(new Libro("Titulo 2", "Autor 2", "Editorial 2", new Date(), Libro.TIPO_DE_BOLSILLO));
	}
	
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
