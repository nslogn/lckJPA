package data_source;

import java.util.Arrays;
import java.util.List;

import entity.Equipo;

public class EquipoDS {
	private static final List<Equipo> EQUIPOS = Arrays.asList(
			new Equipo("Dplus KIA", 0, 5), 
			new Equipo("DRX", 0, 5), 
			new Equipo("FearX", 0, 6),
			new Equipo("Gen.G", 0, 5), 
			new Equipo("Hanwha Life", 0, 5), 
			new Equipo("KT Rolster", 0, 5),
			new Equipo("Kwangdong Freecs", 0, 6),
			new Equipo("NS RedForce", 0, 6), 
			new Equipo("OK BRION", 0, 5),
			new Equipo("T1", 0, 5)
			);

	public static List<Equipo> getEquipos() {
		return EQUIPOS;
	}
}
