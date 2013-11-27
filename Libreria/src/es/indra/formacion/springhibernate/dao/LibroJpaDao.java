package es.indra.formacion.springhibernate.dao;

import java.util.List;

import javax.persistence.Query;

import es.indra.formacion.springhibernate.model.Libro;

public class LibroJpaDao extends GenericJpaDao<Libro, Integer> implements ILibroDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> obtenerAutores() {
		String jql = "select distinct(l.autor) from Libro l";
		return entityManager.createQuery(jql).getResultList();
	}

	@Override
	public Libro obtenerLibroMasVendido() {
		String jql = "select l from Libro l where l.id in"
				+ "(select c.libro.id from Compra c "
				+ "group by c.libro.id "
				+ "order by COUNT(c.id) desc)";
		
		Query q = entityManager.createQuery(jql);
		q.setMaxResults(1);
		
		return (Libro) q.getSingleResult();	
	}

	@Override
	public Object[] obtenerAutorMasVendidoVentas() {
		String jql = "select c.libro.autor, COUNT(c.id) AS cuenta from Compra c "
				+ "group by c.libro.autor "
				+ "order by cuenta desc";
		
		Query q = entityManager.createQuery(jql);
		q.setMaxResults(1);
		
		return (Object[]) q.getSingleResult();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> obtenerLibrosVendidosPorAnio() {
		String jql = "select c.libro.id, c.libro.titulo, YEAR(c.fecha) "
				+ "from Compra c "
				+ "group by YEAR(c.fecha), c.libro.id, c.libro.titulo "
				+ "order by YEAR(c.fecha) desc";

		Query q = entityManager.createQuery(jql);
		
		return q.getResultList();	
	}
	
}
