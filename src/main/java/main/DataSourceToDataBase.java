package main;

import java.util.List;
import java.util.Random;

import dao.CompeticionDAO;
import dao.EquipoDAO;
import dao.JugadorDAO;
import dao.PatrocinadorDAO;
import data_source.CompeticionDS;
import data_source.EntrenadorDS;
import data_source.EquipoDS;
import data_source.JugadorDS;
import data_source.PatrocinadorDS;
import entity.Competicion;
import entity.Entrenador;
import entity.Equipo;
import entity.Jugador;
import entity.Patrocinador;
import jakarta.persistence.EntityManagerFactory;
import utils.JPAUtils;

public class DataSourceToDataBase {
	private static final Random rand = new Random();
	public static void main(String[] args) {
		EntityManagerFactory eMF = JPAUtils.getEntityManagerFactory();
		
		// Saving Teams and only T1 players
		JugadorDAO jugadorDAO = new JugadorDAO(eMF);
		EquipoDAO equipoDAO = new EquipoDAO(eMF);
		PatrocinadorDAO patrocinadorDAO = new PatrocinadorDAO(eMF);
		CompeticionDAO competicionDAO = new CompeticionDAO(eMF);
		//EntrenadorDAO entrenadorDAO = new EntrenadorDAO(eMF);

		int indexPlayers = 0;
		List<Jugador> jugadores = JugadorDS.getJugadores();
		int count = 0;
		int countTeams = 0;
		for (Equipo equipo : EquipoDS.getEquipos()) {
			//Set "Competicion"
			Competicion competicion = CompeticionDS.getCompeticiones().get(0);
			equipo.getCompeticiones().add(competicion);
			competicion.getEquipos().add(equipo);
			// Set "coaches"
			Entrenador coach = EntrenadorDS.getEntrenadores().get(countTeams);
			coach.setEquipo(equipo);
			equipo.setEntrenador(coach);
			//Set "patrocinadores"
			for (Patrocinador patrocinador: PatrocinadorDS.getPatrocinador()) {//TODO: Randomized sponsors
				if (rand.nextBoolean()) {
					equipo.getPatrocinadores().add(patrocinador);
					if (!patrocinador.getEquipos().contains(equipo))
						patrocinador.getEquipos().add(equipo); 
				}
			}
			// Set "players"
			count = 0;
			while (indexPlayers < jugadores.size() && count < equipo.getNumeroJugadores()) {
				Jugador jugador = jugadores.get(indexPlayers);
				jugador.setEquipo(equipo);
				equipo.getJugadores().add(jugador);
				indexPlayers++;
				count++;
			}
			countTeams++;
		}
		
		//Persist Entities
		indexPlayers = 0;
		countTeams = 0;
		for(Patrocinador p: PatrocinadorDS.getPatrocinador())
			patrocinadorDAO.save(p);
		for (Equipo equipo : EquipoDS.getEquipos()) {
			equipoDAO.save(equipo);
			count = 0;
			while (indexPlayers < jugadores.size() && count < equipo.getNumeroJugadores()) {
				jugadorDAO.save(jugadores.get(indexPlayers));
				indexPlayers++;
				count++;
			}
			countTeams++;
		}
		for(Competicion c: CompeticionDS.getCompeticiones()) //Since Comp. is the owner, he owns the reference(FK) to Equipo
			competicionDAO.save(c);								//, He needs Equipo to be persisted first
		
//		int result = 0;
//		for(Equipo e : EquipoDS.getEquipos()) {
//			result += e.getPatrocinadores().size();
//			System.out.println(e.getNombre() + ": Patrocinadores: " + e.getPatrocinadores());
//		}
//		for(Patrocinador p: PatrocinadorDS.getPatrocinador())
//			System.out.println(p.getNombre() + ", Equipos " + p.getEquipos());
//		
//		System.out.println(result);
//		System.out.println("Equipo: " + JugadorDS.getJugadores().get(0).getEquipo().getNombre() + ", "
//				+ EquipoDS.getEquipos().get(0).getJugadores().toString());
//		System.out.println("Entrenador: " + EquipoDS.getEquipos().get(0).getEntrenador().getNombre() +", "
//				+ EntrenadorDS.getEntrenadores().get(0).getEquipo().getNombre());
//		System.out.println("Players added: " + indexPlayers + ", Data Source Size: " + JugadorDS.getJugadores().size());
		JPAUtils.close();
	}
}
