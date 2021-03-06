package br.com.atividadevi.Dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class JPAUtil {
		
	@PersistenceUnit(name = "atividadevi-votacao")
	EntityManagerFactory emf ;
		
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em){
		em.close();
	}
}