package es.indra.formacion.springhibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericJpaDao<T, K> implements IDao<T, K>  {
	@Autowired
	@PersistenceContext
	EntityManager entityManager;
	
	Class<T> clase;

	@SuppressWarnings("unchecked")
	public GenericJpaDao() {
		this.clase = (Class<T>) ((ParameterizedType) getClass()
                		.getGenericSuperclass()).getActualTypeArguments()[0];
		
	}
	
	@Override
	public void agregar(T obj) {
		entityManager.persist(obj);		
	}

	@Override
	public void modificar(T obj) {
		entityManager.merge(obj);
	}

	@Override
	public void eliminar(K id) {
		T t = entityManager.find(clase, id);
		entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> obtenerTodos() {
		return entityManager.createQuery("from " + clase.getSimpleName()).getResultList();
	}

	@Override
	public T obtener(K id) {
		return entityManager.find(clase, id);
	}
	
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		
	}
}
