package es.indra.formacion.springhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import es.indra.formacion.springhibernate.model.Libro;

public class LibroJpaTransDao implements ILibroDao {
	
	@Autowired
	EntityManager entityManager;

	public void init() {
		
	}
	
	@Override
	public void agregar(Libro obj) {
		entityManager.persist(obj);
	}

	@Override
	public void modificar(Libro obj) {
		entityManager.merge(obj);
	}

	@Override
	public void eliminar(Integer id) {
		Libro t = entityManager.find(Libro.class, id);
		entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> obtenerTodos() {
		return entityManager.createQuery("from " + Libro.class.getSimpleName()).getResultList();
	}

	@Override
	public Libro obtener(Integer id) {
		return entityManager.find(Libro.class, id);
	}

}
