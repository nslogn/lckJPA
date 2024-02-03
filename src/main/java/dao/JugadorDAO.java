package dao;

import entity.Jugador;
import jakarta.persistence.EntityManagerFactory;

public class JugadorDAO extends GenericDAOImpl<Jugador>{

	public JugadorDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
