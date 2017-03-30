package manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Team {
	
	public Team() {
//		Map<String, Spieler> Team = new HashMap<String, Spieler>();
//		
//		Team.put("Fido", new Dog("Fido"));
		System.out.print(this.NameGenerator());
	}
	

	private String NameGenerator(){

		String[] firstName = {"Hans", "Karl", "Heribert", "Dieter", "Timo", "Werner",
							"Sven", "Mario", "Christiano", "Tim", "Julian", "Mats", "Jan", "Johann", "Antoine" };
		String[] lastName = { "vanBommel", "Weigl", "Gomez", "Werner", "Schinkel", "Schweiß",
				"Michalke", "Meier", "Kühne", "Djourou", "Bruchhagen", "Neuer", "Müller", "Frei", "Freund" };

		Random r = new Random();

		return firstName[r.nextInt(firstName.length)] + 
					lastName[r.nextInt(lastName.length)];

		}
}
