package es.indra.formacion.springhibernate.dao;

import java.util.Date;
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
	
	public static void main(String[] args) {
		LibroMockDao lmd = new LibroMockDao();
		// Agregar
		Libro l1 = new Libro("Titulo 1", "Autor 1", "Editorial 1", new Date(), Libro.TIPO_TAPA_DURA);
		lmd.agregar(l1);
		lmd.agregar(new Libro("Titulo 2", "Autor 2", "Editorial 2", new Date(), Libro.TIPO_DE_BOLSILLO));
		System.out.println("\nAgregar");
		System.out.println(lmd.obtenerTodos());
		
		// Modificar
		l1.setTitulo("Libro modificado");
		lmd.modificar(l1);
		System.out.println("\nModificar");
		System.out.println(lmd.obtenerTodos());
		
		// Eliminar
		lmd.eliminar(1);
		System.out.println("\nEliminar");
		System.out.println(lmd.obtenerTodos());
		
		// Obtener uno
		System.out.println("\nObtener");
		System.out.println(lmd.obtener(2));
		
	}

}
