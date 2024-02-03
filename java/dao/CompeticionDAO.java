package dao;

import entity.Competicion;
import jakarta.persistence.EntityManagerFactory;

public class CompeticionDAO extends GenericDAOImpl<Competicion>{

	public CompeticionDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}
	
}
