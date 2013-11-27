package es.indra.formacion.springhibernate.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang.time.DateUtils;

import es.indra.formacion.springhibernate.model.Lector;

public class LectorJpaDao extends GenericJpaDao<Lector, Integer> implements ILectorDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Lector> obtenerLectoresMayorEdad() {
		Date fecha = DateUtils.addYears(new Date(), -18);
		
		String jql = "from Lector l WHERE l.fechaNacimiento <= :fecha";
		Query q = entityManager.createQuery(jql);
		q.setParameter("fecha", fecha);
		
		return q.getResultList();
	}
	
}
