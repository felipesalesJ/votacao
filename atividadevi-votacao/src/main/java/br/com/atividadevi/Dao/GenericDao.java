package br.com.atividadevi.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import javax.ws.rs.Produces;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named("genericDao")
public abstract class GenericDao<T>{
	
	private static final long serialVersionUID = 1L;
	
	
	private Class<T> classe;

	@Inject 
	@PersistenceContext(name = "atividade_vi")
	public EntityManager em;
	
	@Inject
	@Produces
	protected EntityManager getEntityManager(){
		return em;
	}
//	
//	public GenericDao(EntityManager em, Class<T> classe){
//		this.em = em;
//		this.classe = classe;
//	} 

	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	public void rollback(){
		getEntityManager().getTransaction().rollback();
	}
	
	public void create(T t){
		getEntityManager().persist(t);
	}
	
	public void close(){
		getEntityManager().close();
	}
	
	public void update(T t){
		getEntityManager().merge(t);
	}
	
	public void delete(T t){
		getEntityManager().remove(getEntityManager().merge(t));
	}
	
	public void begin(){
		getEntityManager().getTransaction().begin();
	}
	
	public void commit(){
		getEntityManager().getTransaction().commit();
	}
	
	public List<T> readTodos(){
		CriteriaQuery<T>query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		return lista;			
	}
	
	public T buscarPorId(Integer id){
		T instancia = em.find(classe, id);
		return instancia;
	}
}
