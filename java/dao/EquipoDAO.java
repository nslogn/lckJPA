package dao;

import entity.Equipo;
import jakarta.persistence.EntityManagerFactory;

public class EquipoDAO extends GenericDAOImpl<Equipo>{

	public EquipoDAO(EntityManagerFactory entityManagerFactory) {
		super(entityManagerFactory);
		// TODO Auto-generated constructor stub
	}

}
