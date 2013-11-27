package es.indra.formacion.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.indra.formacion.springhibernate.dao.ILibreriaDao;
import es.indra.formacion.springhibernate.dao.ILibroDao;
import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;

public class LibroService implements ILibroService { 
	@Autowired
	private ILibroDao libroDao;
	@Autowired
	private ILibreriaDao libreriaDao;
	
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

	@Override
	public List<Libreria> obtenerLibreriasPorLibro(Integer id) {
		return libreriaDao.obtenerLibreriasPorLibro(id);
	}

	@Override
	public List<String> obtenerAutores() {
		return libroDao.obtenerAutores();
	}

	@Override
	public Libro obtenerLibroMasVendido() {
		return libroDao.obtenerLibroMasVendido();
	}

	@Override
	public Object[] obtenerAutorMasVendidoVentas() {
		return libroDao.obtenerAutorMasVendidoVentas();
	}

	@Override
	public List<Object[]> obtenerLibrosVendidosPorAnio() {
		return libroDao.obtenerLibrosVendidosPorAnio();
	}
}
