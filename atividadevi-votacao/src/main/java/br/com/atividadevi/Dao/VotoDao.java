package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.atividadevi.Modelo.Voto;

@Stateless
public class VotoDao extends GenericDao<Voto>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public VotoDao() {
		super(Voto.class);
	}

}
