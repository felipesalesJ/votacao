package br.com.atividadevi.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.com.atividadevi.Modelo.Pessoa;

@Stateless
public class PessoaDao extends GenericDao<Pessoa>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public PessoaDao(){
		super(Pessoa.class);
	}

//	public boolean verifyPessoa(Pessoa pessoa) {
//		TypedQuery<Pessoa> query = em.createQuery("SELECT PE FORM Pessoa WHERE PE.cpf = :pCPF AND PE.datanascimento = :pDATANASCIMENTO", Pessoa.class);
//		query.setParameter("pCPF", pessoa.getCpf());
//		query.setParameter(":DATANACIMENTO", pessoa.getDatanascimento());
//		try{
//			Pessoa resultado = query.getSingleResult();			
//		}catch(NoResultException nrex){
//			return false;
//		}catch(Exception e){
//			System.out.println("Erro aleatório");
//		}
//		return true;
//	}

//	public boolean verifyEleitor(Pessoa pessoa) {
//		TypedQuery<Pessoa> query = em.createQuery("SELECT PE "
//				+ "FROM Pessoa PE "
//				+ "INNER JOIN Eleitor EL ON EL.pessoa = PE.idPessoa "
//				+ "WHERE PE.cpf = PE.CPF = :pCPF AND PE.datanascimento = :pDATANASCIMENTO", Pessoa.class);
//		query.setParameter("pCPF", pessoa.getCpf());
//		query.setParameter(":DATANACIMENTO", pessoa.getDatanascimento());
//		//		query.setMaxResults(1);
//		try{
//			Pessoa resultado = query.getSingleResult();		
//		}catch(NoResultException nrex){
//			return false;
//		}catch(Exception e){
//			System.out.println("Erro aleatório");
//		}
//		return true;
//	}	
	
	public boolean verifyEleitor(Pessoa pessoa) {
		Query query  = em.createQuery("SELECT PE FROM Pessoa PE WHERE PE.cpf = :pCPF AND PE.datanascimento = :pDATANASCIMENTO")
			.setParameter("pCPF", pessoa.getCpf())
			.setParameter("pDATANASCIMENTO", pessoa.getDatanascimento());
//		if(query != null){
//			return true;
//		}
//		return false;
		try{
			Object resultado = query.getSingleResult();		
		}catch(NoResultException nrex){
			return false;
		}catch(Exception e){
			System.out.println("Erro aleatório");
		}
		return true;
	}	
}
