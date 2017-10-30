package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	public Integer findEleitor(String cpf) {
		Query query = em.createQuery("SELECT EL.eleitorId "
					+ "FROM Eleitor EL "
					+ "INNER JOIN EL.pessoa PE "
					+ "WHERE PE.cpf = :pCPF")
		.setParameter("pCPF", cpf);
		Integer resultado = (Integer) query.getSingleResult();
		return resultado;
	}
}
