package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.atividadevi.Modelo.Eleitor;

@Stateless
public class EleitorDao extends GenericDao<Eleitor>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public EleitorDao() {
		super(Eleitor.class);
	}

}
