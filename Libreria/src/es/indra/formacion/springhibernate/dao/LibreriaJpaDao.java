package es.indra.formacion.springhibernate.dao;

import java.util.List;

import javax.persistence.Query;

import es.indra.formacion.springhibernate.model.Libreria;

public class LibreriaJpaDao extends GenericJpaDao<Libreria, Integer> implements ILibreriaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Libreria> obtenerLibreriasPorLibro(Integer id) {
		String jql = "select libr from Libreria libr join libr.ofreces o where o.libro.id = :id";
		Query q = entityManager.createQuery(jql);
		q.setParameter("id", id);
		
		return q.getResultList();
	}
	
}
