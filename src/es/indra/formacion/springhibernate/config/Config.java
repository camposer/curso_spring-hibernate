package es.indra.formacion.springhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.indra.formacion.springhibernate.dao.ILibroDao;
import es.indra.formacion.springhibernate.dao.LibroMockDao;
import es.indra.formacion.springhibernate.gui.Principal;
import es.indra.formacion.springhibernate.service.ILibroService;
import es.indra.formacion.springhibernate.service.LibroService;

@Configuration
public class Config {
	/**
	 * El nombre del método es el id del bean
	 * @return
	 */
	@Bean
	public ILibroDao libroDao() {
		return new LibroMockDao();
	}

	@Bean(initMethod="init")
	public ILibroService libroService() {
		return new LibroService();
	}

	@Bean
	@Scope("prototype")
	public Principal principal() {
		return new Principal();
	}
}
