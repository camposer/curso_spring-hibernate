package es.indra.formacion.springhibernate.dao;

import es.indra.formacion.springhibernate.model.Compra;

public class CompraJpaDao extends GenericJpaDao<Compra, Integer> implements ICompraDao {

	public CompraJpaDao() {
		super();
	}
	
	public CompraJpaDao(boolean autoCommit) {
		super(autoCommit);
	}
	
}
