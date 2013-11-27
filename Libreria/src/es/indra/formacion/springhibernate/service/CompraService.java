package es.indra.formacion.springhibernate.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import es.indra.formacion.springhibernate.dao.ICompraDao;
import es.indra.formacion.springhibernate.dao.ILectorDao;
import es.indra.formacion.springhibernate.model.Compra;
import es.indra.formacion.springhibernate.model.Lector;
import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;

public class CompraService implements ICompraService { 
	@Autowired
	private ILectorDao lectorDao;
	@Autowired
	private ICompraDao compraDao;
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void comprar(Libro libro, Libreria libreria, Lector lector) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		try {
			// Asignando entityManager para que formen parte de la misma transacción
			lectorDao.setEntityManager(em);
			compraDao.setEntityManager(em);
			
			// Guardando datos del lector
			lectorDao.agregar(lector);
			
			// Guardando datos de la compra
			Compra compra = new Compra();
			compra.setLector(lector);
			compra.setLibreria(libreria);
			compra.setLibro(libro);
			compra.setFecha(new Date());
			compra.setMontante(libro.getPrecio() * 1.3);
			
			compraDao.agregar(compra);
			
			em.getTransaction().commit();
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
		}
		
		
	}

}
