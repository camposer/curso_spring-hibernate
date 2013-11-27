package es.indra.formacion.springhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IDao<T, K> {
	public void agregar(T obj);
	public void modificar(T obj);
	public void eliminar(K id);
	public List<T> obtenerTodos();
	public T obtener(K id);
	public void setEntityManager(EntityManager em);
}
