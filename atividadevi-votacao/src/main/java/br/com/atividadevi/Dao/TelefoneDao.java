package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.atividadevi.Modelo.Telefone;


@Stateless
public class TelefoneDao extends GenericDao<Telefone>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public TelefoneDao() {
		super(Telefone.class);
	}

}
