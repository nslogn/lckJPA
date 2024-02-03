package data_source;

import java.util.Arrays;
import java.util.List;

import entity.Entrenador;

public class EntrenadorDS {
	
	private static final List<Entrenador> ENTRENADORES = Arrays.asList(
			new Entrenador("Zefa"), //DPLUSKIA
			new Entrenador("Micro"), //DRX
			new Entrenador("Ryu"), //FEARX
			new Entrenador("Mata"), //Geng G
			new Entrenador("DanDy"), //HWL
			new Entrenador("Hirai"), //KTRolsters
			new Entrenador("cvMax"), //Kwangdong Freecs
			new Entrenador("Irean"), //Nongshim RedForce
			new Entrenador("Edgar"), //OKSavingsBank BRION
			new Entrenador("Kkoma") //SK-T1
			);
	
	public static List<Entrenador> getEntrenadores(){
		return ENTRENADORES;
	}
}
