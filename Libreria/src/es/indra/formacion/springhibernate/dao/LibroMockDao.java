package es.indra.formacion.springhibernate.dao;

import java.util.LinkedList;
import java.util.List;

import es.indra.formacion.springhibernate.model.Libro;

public class LibroMockDao implements ILibroDao {
	private List<Libro> libros;
	private int contador;
	
	public LibroMockDao() {
		libros = new LinkedList<Libro>();
		contador = 1;
	}
	
	private int buscarPos(Integer id) {
		int pos = -1;
		
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getId().equals(id)) {
				pos = i;
				break;
			}
		}
		
		return pos;
	}
	
	@Override
	public void agregar(Libro obj) {
		obj.setId(contador++);
		libros.add(obj);

	}

	@Override
	public void modificar(Libro obj) {
		int pos = buscarPos(obj.getId());
		
		if (pos >= 0) 
			libros.set(pos, obj);
	}

	@Override
	public void eliminar(Integer id) {
		int pos = buscarPos(id);
		
		if (pos >= 0) 
			libros.remove(pos);
	}

	@Override
	public List<Libro> obtenerTodos() {
		return libros;
	}

	@Override
	public Libro obtener(Integer id) {
		int pos = buscarPos(id);
		Libro resultado = null;
		
		if (pos >= 0) 
			resultado = libros.get(pos);
		
		return resultado;
	}
	
}
