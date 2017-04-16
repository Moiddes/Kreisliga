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
	
	public String Eroeffnung(String Heimteam, String Auswaertsteam){
		String[] string = {	"Herzlich Wilkommen, meine Damen und Herren zu der Partie zwischen " + Heimteam + " und " + Auswaertsteam,
							"Guten Tag, meine Damen und Herren. Ich begr��e Sie zur Partie zwischen " + Heimteam + " und " + Auswaertsteam};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String KeinEvent(){
		String[] string = {	"Das Spiel d�mpelt vor sich hin ",
							"Hier passiert nichts. ",
							"Kein Raumgewinn f�r die beiden Teams. ",
							"Noch passiert nichts. ",
							"Zur Zeit ist nicht viel los. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String Minute(int time){
		return (time + " :00 Min - ");
	}
	
	public String Aussenbahnpass(Spieler angreifer){
		String[] string = {	angreifer.getNamePosition() + " er�ffnet mit einem Pass auf die Au�enbahn",
				angreifer.getNamePosition() + " spielt den Ball auf Au�en"};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String PassSehrGut(){
		String[] string = {	"Der Pass kommt genial! ",
							"Ein Wahnsinnspass! ",
							"Genialer Pass! ",
							"Was ein Pass! "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String PassGut(){
		String[] string = {	"Der Pass kommt ganz gut. ",
							"Der Pass ist in Ordung. ",
							"Das sieht gut aus. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String PassSchlecht(){
		String[] string = {	"Das ist ein lausiger Pass! ",
							"Der ist nicht gut... ",
							"Leicht verzogen. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String PassVerfehlt(){
		String[] string = {	"Wo wandert der denn hin? ",
							"Der geht in die Karpaten. ",
							"Vollkommen verzogen und ins Aus. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String FlankenSehrGut(){
		String[] string = {	"Die Flanke kommt genial! ",
							"Eine Wahnsinnsflanke! ",
							"Geniale Flanke! ",
							"Was eine Flanke! "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String FlankenGut(){
		String[] string = {	"Die Flanke kommt ganz gut. ",
							"Die Flanke ist in Ordung. ",
							"Das sieht gut aus. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String FlankenSchlecht(){
		String[] string = {	"Das ist eine lausige Flanke! ",
							"Die ist nicht gut... ",
							"Leicht verzogen. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String FlankenVerfehlt(){
		String[] string = {	"Wo wandert der denn hin? ",
							"Der geht in die Karpaten. ",
							"Vollkommen verzogen und ins Aus. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String GegnerKeineChance(Spieler verteidiger){
		String[] string = {	verteidiger.getNamePosition() + " hat da keine Chance. ",
							verteidiger.getNamePosition() + " sieht keine Schnitte. ",
							verteidiger.getNamePosition() + " kommt da nicht ran. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String LaufduellPositiv(Spieler angreifer){
		String[] string = {	angreifer.getNamePosition() + " nimmt den Klasse mit. ",
							angreifer.getNamePosition() + " erl�uft den Ball. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String LaufduellNegativ(Spieler verteidiger){
		String[] string = {	verteidiger.getNamePosition() + " ist schneller und l�uft den Ball ab. ",
							verteidiger.getNamePosition() + " erl�uft den Ball und der Angriff verpufft. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String NachInnenZiehen(){
		String[] string = {	"Er �berlegt kurz und zieht dann nach Innen. ",
							"Er zieht in vollem Lauf nach Innen. ",
							"Er knickt ab und l�uft parallel zur Grundlinie. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String InFlankenposition(){
		String[] string = {	"Er geht bis zur Grundlinie und bringt sich in Position zum Flanken. ",
							"Er begibt sich in Flankenposition. ",
							"Er setzt zur Flanke an. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String KopfballDuell(Spieler angreifer, Spieler verteidiger){
		String[] string = {	angreifer.getNamePosition() + " und " + verteidiger.getNamePosition() + " steigen zum Kopfball hoch. ",
							angreifer.getNamePosition() + " und " + verteidiger.getNamePosition() + " gehen zum Ball. ",};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String DuellPositiv(Spieler angreifer, Spieler verteidiger){
		String[] string = {	angreifer.getLastname() + " entscheidet das Duell f�r sich. ",
							angreifer.getLastname() + " ist eher am Ball. ",
							angreifer.getLastname() + " l�sst " + verteidiger.getLastname() + " alt aussehen. ",
							"Der Verteidiger hat gegen " + angreifer.getLastname() + " keine Chance! "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String DuellNegativ(Spieler angreifer, Spieler verteidiger){
		String[] string = {	verteidiger.getLastname() + " entscheidet das Duell f�r sich. ",
							verteidiger.getLastname() + " ist eher am Ball. ",
							verteidiger.getLastname() + " l�sst " + angreifer.getLastname() + " alt aussehen. ",
							"Der Angreifer hat gegen " + verteidiger.getLastname() + " keine Chance! "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String BallDaneben(){
		String[] string = {	"Der ist vollkommen verzogen. ",
							"In die Karpaten. ",
							"Meilenweit daneben. "};

		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String TorwartHaelt(Spieler torwart){
		String[] string = {	torwart.getNamePosition() + " fischt den Ball. ",
							torwart.getNamePosition() + " ist schnell genug. ",
							"Der Keeper fischt den Ball. ",
							"Der Keeper ist schnell genug. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String TorwartHaeltFest(){
		String[] string = {	"Und h�lt den Ball fest. ",
							"Und hat ihn sicher. ",
							"Und begr�bt ihn unter sich. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String TorwartZurEcke(){
		String[] string = {	"Und l�sst ihn zur Ecke klatschen. ",
							"Und lenkt ihn ins Toraus. ",
							"Und bef�rdert ihn ins Toraus. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
	public String TorwartAbpraller(){
		String[] string = {	"Und l�sst ihn nach vorne klatschen. ",
							"Und lenkt ihn nach vorne ab. ",
							"Und faustet ihn nach vorne. "};
		
		Random r = new Random();

		return string[r.nextInt(string.length)];
	}
	
}
