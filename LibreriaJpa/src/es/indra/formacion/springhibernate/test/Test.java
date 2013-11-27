package es.indra.formacion.springhibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import es.indra.formacion.springhibernate.model.Libro;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJpa");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			// Agregar y Modificar
			Libro l1 = new Libro();
			l1.setTitulo("Titulo nuevorrrr");
			l1.setAutor("Autor nuevo");
			l1.setPrecio(30D);

			em.persist(l1); // INSERT
			
			
			Libro l2 = new Libro();
			l2.setId(800);
			l2.setTitulo("Titulo nuevoaaa");
			l2.setAutor("Autor nuevoaaa");
			l2.setPrecio(30D);

			em.persist(l2); // => Falla porque el objeto no pertenece a la sesión
			
			
			// Agregar
			Libro l3 = new Libro();
			l3.setId(98);
			l3.setTitulo("Titulo nuevoxxx");
			l3.setAutor("Autor nuevo");
			l3.setPrecio(30D);

			Libro l4 = em.merge(l3); // => Si el objeto con el id existe lo actualiza

			// Eliminar?
			// Opción 1
			em.remove(l1); // => Lo remueve porque l1 es Persistent
			
			// Opción 2
			//em.remove(l3); // => Falla! porque l3 es Transient
			em.remove(l4);
			
			// Obtener
			Libro l5 = em.find(Libro.class, 1);
			System.out.println(l5);
			
			// Obtener todos
			System.out.println();
			Query q = em.createNamedQuery("Libro.findAll");
			List<Libro> libros = q.getResultList();
			for (Libro l : libros) {
				System.out.println(l);
			}
			tx.commit();
		} catch(PersistenceException pe) {
			pe.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
	}
}
