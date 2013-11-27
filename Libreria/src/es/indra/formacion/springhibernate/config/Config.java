package es.indra.formacion.springhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.indra.formacion.springhibernate.dao.CompraJpaDao;
import es.indra.formacion.springhibernate.dao.ICompraDao;
import es.indra.formacion.springhibernate.dao.ILectorDao;
import es.indra.formacion.springhibernate.dao.ILibreriaDao;
import es.indra.formacion.springhibernate.dao.ILibroDao;
import es.indra.formacion.springhibernate.dao.LectorJpaDao;
import es.indra.formacion.springhibernate.dao.LibreriaJpaDao;
import es.indra.formacion.springhibernate.dao.LibroJpaDao;
import es.indra.formacion.springhibernate.gui.Principal;
import es.indra.formacion.springhibernate.service.CompraService;
import es.indra.formacion.springhibernate.service.ICompraService;
import es.indra.formacion.springhibernate.service.ILectorService;
import es.indra.formacion.springhibernate.service.ILibreriaService;
import es.indra.formacion.springhibernate.service.ILibroService;
import es.indra.formacion.springhibernate.service.LectorService;
import es.indra.formacion.springhibernate.service.LibreriaService;
import es.indra.formacion.springhibernate.service.LibroService;

@Configuration
public class Config {
	@Bean
	public ILibroDao libroDao() {
		return new LibroJpaDao();
	}

	@Bean
	public ILibreriaDao libreriaDao() {
		return new LibreriaJpaDao();
	}

	@Bean
	public ILectorDao lectorDao() {
		return new LectorJpaDao();
	}

	@Bean
	public ICompraDao compraDao() {
		return new CompraJpaDao();
	}

	@Bean
	public ILibroService libroService() {
		return new LibroService();
	}

	@Bean
	public ILibreriaService libreriaService() {
		return new LibreriaService();
	}

	@Bean
	public ILectorService lectorService() {
		return new LectorService();
	}

	@Bean
	public ICompraService compraService() {
		return new CompraService();
	}

	@Bean
	@Scope("prototype")
	public Principal principal() {
		return new Principal();
	}
}
