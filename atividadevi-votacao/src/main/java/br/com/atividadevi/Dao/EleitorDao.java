package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

	public Eleitor findVoto(Object eleitor) {
		Query query = em.createQuery("SELECT VT.idvoto "
					+ "FROM Voto VT "
					+ "WHERE VT.eleitor = :idEl")
		.setParameter("idEl", eleitor);
		Eleitor resultado = (Eleitor) query.getSingleResult();
		return resultado;
	}

	public Eleitor findEleitor(Object eleitor) {
		Query query = em.createQuery("SELECT EL.eleitorId "
					+ "FROM Eleitor EL "
					+ "INNER JOIN Pessoa PE "
					+ "ON PE.idpessoa = EL.pessoa "
					+ "WHERE EL.eleitorId = :idEl")
		.setParameter("idEl", eleitor);
		Eleitor resultado = (Eleitor) query.getSingleResult();
		return resultado;
	}
}
