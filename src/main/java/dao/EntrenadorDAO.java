package dao;

import entity.Entrenador;
import jakarta.persistence.EntityManagerFactory;

public class EntrenadorDAO extends GenericDAOImpl<Entrenador> {

	public EntrenadorDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);

	}

}
