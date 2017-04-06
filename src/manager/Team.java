package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Team {

	private Map<String, Spieler> team = new HashMap<String, Spieler>();  
	private String teamName;
	private Taktik taktik = new Taktik();

	public Team(String name) {
		this.setTeamName(name);
		this.taktik.setrandomFormation();
		for(String position : this.taktik.getSpielertypen()){
			String lastName = this.LastNameGenerator();
			String firstName = this.FirstNameGenerator();
			this.team.put(firstName + " " + lastName, new Spieler(firstName, lastName, position));			
		}

	}

	public Team() {
		this.setTeamName(this.TeamNameGenerator());
		this.taktik.setrandomFormation();
		for(String position : this.taktik.getSpielertypen()){
			String lastName = this.LastNameGenerator();
			String firstName = this.FirstNameGenerator();
			this.team.put(firstName + " " + lastName, new Spieler(firstName, lastName, position));			
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

		String[] firstPart = { "SC", "FSV", "FC", "Real", "Atletico", "Türk SV", "Rasenball Sport",
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;

	}
	
	public List<String> getplayerList(){
		List<String> playerList = new ArrayList<String>(this.team.keySet());
		return playerList;
	}


	public void addSpieler(Spieler spieler){
		this.team.put(spieler.getFirstname() + " " + spieler.getLastname(), spieler);	
	}

	public void removeSpieler(String firstName, String lastName){
		if(this.team.containsKey(firstName + " " + lastName)){
			this.team.remove(firstName + " " + lastName);
			}
		else{
			//TODO throw exception
		}
	}
	
//	public Spieler getPlayerExcept(String... strings){
//		return 
//	}
//	
//	public Spieler getPlayerFrom(String... strings){
//		
//	}
}
