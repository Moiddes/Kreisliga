package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Team {

	private Map<String, Spieler> team = new HashMap<String, Spieler>();
	private List<String> playerNames = new ArrayList<String>();  
	private String teamName;

	public Team(String name) {
		this.setTeamName(name);
		for(int k=0; k <= 15; k++){
			String lastName = this.LastNameGenerator();
			String firstName = this.FirstNameGenerator();
			this.playerNames.add(firstName + lastName);
			this.team.put(firstName + lastName, new Spieler(firstName, lastName));			
		}

	}

	public Team() {
		this.setTeamName(this.TeamNameGenerator());
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

	private String TeamNameGenerator(){

		String[] firstPart = { "SC", "FSV", "FC", "Real", "Atletico", "Türk SV",
				"Sportfreunde", "TSG", "1. FC", "Eintracht", "VfL", "Borussia", "SV", "1. FSV", "Borussia" };

		String[] lastPart = { "Hille", "Eckernförde", "Päppinghause", "Wattenscheid", "Bochum", "Herne",
				"Hartum", "Holzhausen II", "Südhemmern", "Nordhemmern", "Oberlübbe", "Unterlübbe", "Rothenuffeln", "Dützen", "Hahlen" };
		Random r = new Random();

		return firstPart[r.nextInt(firstPart.length)]
				+ " "
				+ lastPart[r.nextInt(lastPart.length)];
	}	


	public Map<String, Spieler> getTeam() {
		return team;
	}

	public List<String> getPlayerNames() {
		return playerNames;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;

	}


	public void addSpieler(Spieler spieler){
		this.playerNames.add(spieler.getFirstname() + spieler.getLastname());
		this.team.put(spieler.getFirstname() + spieler.getLastname(), spieler);	
	}

	public void removeSpieler(String firstNameLastName){
		if(this.team.containsKey(firstNameLastName)){
			this.playerNames.remove(firstNameLastName);
			this.team.remove(firstNameLastName);
		}
		else{
			System.out.printf("Kein Spieler namens %s im Team", firstNameLastName);
		}

	}
}
