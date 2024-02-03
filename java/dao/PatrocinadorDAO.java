package dao;

import entity.Patrocinador;
import jakarta.persistence.EntityManagerFactory;

public class PatrocinadorDAO extends GenericDAOImpl<Patrocinador>{

	public PatrocinadorDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
