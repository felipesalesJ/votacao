package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Eleitor;

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
	
	public Integer findVoto(Object candidato) {
		Query query = em.createQuery("SELECT VT.idvoto "
					+ "FROM Voto VT "
					+ "WHERE VT.eleitor = :idEl")
		.setParameter("idEl", candidato);
		Integer resultado = (Integer) query.getSingleResult();
		return resultado;
	}

}