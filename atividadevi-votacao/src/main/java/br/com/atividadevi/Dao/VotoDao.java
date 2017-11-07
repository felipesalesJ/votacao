package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import br.com.atividadevi.Modelo.Eleitor;
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
	
	public boolean findVotoEleitor(String cpfEleitor) {
		Query query = em.createQuery("SELECT VT.idvoto "
					+ "FROM Voto VT "
					+ "INNER JOIN VT.eleitor EL "
					+ "INNER JOIN EL.pessoa PE "
					+ "WHERE PE.cpf = :pCPF")
		.setParameter("pCPF", cpfEleitor);
		try{
			Integer resultado = (Integer) query.getSingleResult();		
		}catch(Exception nrex){
			return false;
		}
		return true;
	}
}
