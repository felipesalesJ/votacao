package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	public Voto findVoto(Integer eleitor) {
		Query query = em.createQuery("SELECT VT.idvoto "
					+ "FROM Voto VT "
					+ "WHERE VT.eleitor = :idEl")
		.setParameter("idEl", eleitor);
		Voto resultado = (Voto) query.getSingleResult();
		return resultado;
	}
}
