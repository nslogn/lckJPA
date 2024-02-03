package data_source;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import entity.Competicion;

public class CompeticionDS {
	private static final List<Competicion> COMPETICION = Arrays.asList(
			new Competicion("LCK", LocalDate.of(2024, 1, 17), 9, 10),
			new Competicion("PLayoffs", LocalDate.of(2024, 3, 24), 4, 6)
			);

	public static List<Competicion> getCompeticiones() {
		return COMPETICION;
	}
}
