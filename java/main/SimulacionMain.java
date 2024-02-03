package main;


import jakarta.persistence.EntityManagerFactory;
import utils.JPAUtils;

public class SimulacionMain {
	public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = JPAUtils.getEntityManagerFactory();
        
        
        JPAUtils.close();
	}
}
