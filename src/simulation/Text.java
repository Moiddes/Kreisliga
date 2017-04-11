package simulation;

import java.util.Random;

import manager.*;

public class Text {
	private String sprache;

	public String getSprache() {
		return sprache;
	}
	public void setSprache(String sprache) {
		this.sprache = sprache;
	}
	
	public String Aussenbahnpass(Spieler spieler){
		String[] string = {	spieler.getNamePosition() + " er�ffnet mit einem Pass auf die Au�enbahn",
							spieler.getNamePosition() + " spielt den Ball auf Au�en"};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String Eroeffnung(String Heimteam, String Auswaertsteam){
		String[] string = {	"Herzlich Wilkommen, meine Damen und Herren zu der Partie zwischen " + Heimteam + " und " + Auswaertsteam,
							"Guten Tag, meine Damen und Herren. Ich begr��e Sie zur Partie zwischen " + Heimteam + " und " + Auswaertsteam};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
}
