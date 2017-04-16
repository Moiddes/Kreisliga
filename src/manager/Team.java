package manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Team {

	private Map<String, Spieler> team = new HashMap<String, Spieler>();  
	private String teamName;
//	private String teamArtikel; //TODO Artikel in Fällen definieren für die Ausgabe; evtl. über Geschlecht lösen
	private Taktik taktik = new Taktik();
	public static int teamCount = 0;
	
	public Team() {
		teamCount++;
		this.setTeamName(this.TeamNameGenerator());
		this.taktik.setrandomFormation();
		int i = 0;
		while(i < this.taktik.getSpielertypen().size()){
			String position = this.taktik.getSpielertypen().get(i);
			String lastName = this.LastNameGenerator();
			String firstName = this.FirstNameGenerator();
			if(!this.team.containsKey(firstName + " " + lastName)){
				this.team.put(firstName + " " + lastName, new Spieler(firstName, lastName, position));
				i++;
			}
		}
		autoAufstellung();
	}
	
	public Team(String name) {
		teamCount++;
		this.setTeamName(name);
		this.taktik.setrandomFormation();
		int i = 0;
		while(i < this.taktik.getSpielertypen().size()){
			String position = this.taktik.getSpielertypen().get(i);
			String lastName = this.LastNameGenerator();
			String firstName = this.FirstNameGenerator();
			if(!this.team.containsKey(firstName + " " + lastName)){
				this.team.put(firstName + " " + lastName, new Spieler(firstName, lastName, position));
				i++;
			}

		}
		autoAufstellung();
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

		String[] firstPart = { "SC", "FSV", "FC", "Real", "Atletico", "Türk SV", "Rasenballsport", "SG",
				"Sportfreunde", "TSG", "1. FC", "Eintracht", "VfL", "Borussia", "SV", "1. FSV", "Borussia" };

		String[] lastPart = { "Hille", "Eckernförde", "Päppinghausen", "Wattenscheid", "Bochum", "Herne",
				"Hartum", "Holzhausen II", "Südhemmern", "Nordhemmern", "Oberlübbe", "Unterlübbe", "Rothenuffeln", "Dützen", "Hahlen" };
		Random r = new Random();

		return firstPart[r.nextInt(firstPart.length)]
				+ " "
				+ lastPart[r.nextInt(lastPart.length)];
	}
	
//	private String TeamArtikel(){
//		String artikel;
//		String[] anfaenge = { "SC", "FSV", "FC", "Real", "Atletico", "Türk SV", "Rasenball Sport",
//				"Sportfreunde", "TSG", "1. FC", "Eintracht", "VfL", "Borussia", "SV", "1. FSV", "Borussia" };
//		for (String )
//		return artikel;
//	}


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
		this.team.put(spieler.getName(), spieler);	
	}

	public void removeSpieler(String firstName, String lastName){
		if(this.team.containsKey(firstName + " " + lastName)){
			this.team.remove(firstName + " " + lastName);
		}
		else{
			//TODO throw exception
		}
	}

	public void autoAufstellung(){
		int i = 0;
		for(String position : this.taktik.getSpielertypen()){
			i++;
			if(i<=16){
				float best = 0;
				String bestSpieler = null;
				for (Map.Entry<String, Spieler> entry : team.entrySet()) {
					if(entry.getValue().getPositionValue(position) > best && entry.getValue().getPosition() == "RES"){
						bestSpieler = entry.getKey();
						best = entry.getValue().getPositionValue(position);
					}    
				}
				if(i<=11){
					team.get(bestSpieler).setPosition(position);
				}
				else if(i>11 && i<=16){
					team.get(bestSpieler).setPosition("AUSW");
				}
			}
		}
	}

	public Spieler getPlayerExcept(String... strings){
		List<String> positions = new ArrayList<String>(Arrays.asList("TW", "LI", "IV", "MD", "LV", "RV", "DM", "LM", "ZM", "OM", "RM", "ST"));
		for(int i = 0; i < strings.length; i++){
			positions.remove(strings[i]);
		}
		List<Spieler> possiblePlayers = new ArrayList<Spieler>();
		for(String position : positions){
			for (Spieler value : team.values()) {
				if(value.getPosition() == position && !value.isBusy()){
					possiblePlayers.add(value);
				}    
			}
		}
		Random r = new Random();
		return possiblePlayers.get(r.nextInt(possiblePlayers.size()));		
	}

	public Spieler getPlayerFrom(String... strings){
		List<String> positions = new ArrayList<String>();
		for(int i = 0; i < strings.length; i++){
			positions.add(strings[i]);
		}
		List<Spieler> possiblePlayers = new ArrayList<Spieler>();
		for(String position : positions){
			for (Spieler value : team.values()) {
				if(value.getPosition() == position && !value.isBusy()){
					possiblePlayers.add(value);
				}    
			}
		}
		Random r = new Random();
		return possiblePlayers.get(r.nextInt(possiblePlayers.size()));	
	}
	
	public float getTeamInitiative(){
		float morale = 0;
		float strength = 0;
		for (Spieler value : team.values()) {
			if(value.getPosition() != "AUSW" && value.getPosition() != "RES"){
				morale += value.getMoral();
				strength += value.getPositionValue(value.getPosition());
			}
		}
		return morale + strength; //TODO evtl die beiden Dinge noch gewichten
	}	
}
