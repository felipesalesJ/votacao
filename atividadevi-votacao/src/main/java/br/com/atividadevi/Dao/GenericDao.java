package br.com.atividadevi.Dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

@Named("genericDao")
public abstract class GenericDao<T>{
	
	private Class<T> classe;
 
	@Inject
	public EntityManager em;
	
	public Session getSession(){
		return (Session)em.getDelegate();
		
	}
	protected EntityManager getEntityManager(){
		return em;
	}
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	public void rollback(){
		getEntityManager().getTransaction().rollback();
	}
	
	public void create(T t){
		getSession().save(t);
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
