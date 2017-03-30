package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Team {
	private Map<String, Spieler> team = new HashMap<String, Spieler>();
	private List<String> playerNames = new ArrayList<String>();  
	
	public Team() {
		for(int k=0; k <= 15; k++){
			String lastName = this.LastNameGenerator();
			String firstName = this.FirstNameGenerator();
			this.playerNames.add(firstName + lastName);
			this.team.put(firstName + lastName, new Spieler(firstName, lastName));
		}
		
	}
	

	private String FirstNameGenerator(){

		String[] firstName = {"Hans", "Karl", "Heribert", "Dieter", "Timo", "Werner",
							"Sven", "Mario", "Christiano", "Tim", "Julian", "Mats", "Jan", "Johann", "Antoine" };

		Random r = new Random();

		return firstName[r.nextInt(firstName.length)];
		}
	
	private String LastNameGenerator(){

		String[] lastName = { "van Bommel", "Weigl", "Gomez", "Werner", "Schinkel", "Schweiß",
				"Michalke", "Meier", "Kühne", "Djourou", "Bruchhagen", "Neuer", "Müller", "Frei", "Freund" };

		Random r = new Random();

		return lastName[r.nextInt(lastName.length)];
		}


	public Map<String, Spieler> getTeam() {
		return team;
	}

	public List<String> getPlayerNames() {
		return playerNames;
	}
	

}
