package br.com.atividadevi.Dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadevi-votacao");
		
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em){
		em.close();
	}
}