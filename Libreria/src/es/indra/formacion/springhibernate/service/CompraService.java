package es.indra.formacion.springhibernate.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.indra.formacion.springhibernate.dao.ICompraDao;
import es.indra.formacion.springhibernate.dao.ILectorDao;
import es.indra.formacion.springhibernate.model.Compra;
import es.indra.formacion.springhibernate.model.Lector;
import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;

@Transactional
public class CompraService implements ICompraService {
	@Autowired
	private ILectorDao lectorDao;
	@Autowired
	private ICompraDao compraDao;

	@Override
	public void comprar(Libro libro, Libreria libreria, Lector lector) {
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
	}

}
