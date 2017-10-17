package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Pessoa;

@Stateless
public class CandidatoDao extends GenericDao<Candidato>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public CandidatoDao(){
		super(Candidato.class);
	}
	
}
