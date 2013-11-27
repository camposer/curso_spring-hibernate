package es.indra.formacion.springhibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericJpaDao<T, K> implements IDao<T, K>  {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	boolean autoCommit = true;
	Class<T> clase;

	@SuppressWarnings("unchecked")
	public GenericJpaDao(boolean autoCommit) {
		this.clase = (Class<T>) ((ParameterizedType) getClass()
                		.getGenericSuperclass()).getActualTypeArguments()[0];
		
		this.autoCommit = autoCommit;
	}
	
	public GenericJpaDao() {
		this(true);
	}

	public void init() {
		if (autoCommit) {
			this.entityManager = entityManagerFactory.createEntityManager();
			this.entityTransaction = this.entityManager.getTransaction();
		}
	}
	
	@Override
	public void agregar(T obj) {
		if (autoCommit)
			entityTransaction.begin();
		
		entityManager.persist(obj);
		
		if (autoCommit)
			entityTransaction.commit();
	}

	@Override
	public void modificar(T obj) {
		if (autoCommit)
			entityTransaction.begin();
		
		entityManager.merge(obj);
		
		if (autoCommit)
			entityTransaction.commit();
	}

	@Override
	public void eliminar(K id) {
		if (autoCommit)
			entityTransaction.begin();
		
		T t = entityManager.find(clase, id);
		entityManager.remove(t);
		
		if (autoCommit)
			entityTransaction.commit();
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
