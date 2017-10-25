package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.atividadevi.Modelo.Endereco;

@Stateless
public class EnderecoDao extends GenericDao<Endereco>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager(){
		return em;
	}
	public EnderecoDao() {
		super(Endereco.class);
	}

}
