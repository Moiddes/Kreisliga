package simulation;

import java.io.PrintStream;

import manager.*;
import tools.*;

public class Spiel {

	public int halbzeit = 1;
	public int time = 0;
	public int ThisEvent= 0;
	public Team Heimteam;
	public Team Auswaertsteam;
	public Team Angriff;
	public Team Verteidigung;
	private Spieler PassSpieler; 
	private Spieler PassEmpfaenger;
	private Spieler PassGegner;
	private static PrintStream p = System.out;
	static RandomInt r = new RandomInt();

	public void spielsimulation (Team Heimteam, Team Auswaertsteam) {

		p.println(Auswaertsteam.getTeamName());
		p.println(Heimteam.getTeamName());

		this.Heimteam = Heimteam;
		this.Auswaertsteam = Auswaertsteam;

		ThisEvent =0; 
		while (time <45) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch  (ThisEvent){

			// PULLEVENT
			case 0 : 
				ThisEvent = pullEvent();
				time += 2;
				break;

				//LANGER PASS AUF AUSSEN
			case 1 :

				PassSpieler =  Angriff.getPlayerExcept("ST");
				PassEmpfaenger = Angriff.getPlayerFrom ("LM", "RM", "LV", "RV");
				PassGegner = null;
				p.println(PassSpieler.getLastname() + " eröffnet mit einem Pass auf die Außenbahn");
				if (PassEmpfaenger.getPosition() == "LM" || PassEmpfaenger.getPosition() == "LV")
					PassGegner = Verteidigung.getPlayerFrom("RM", "RV");
				else 
					PassGegner = Verteidigung.getPlayerFrom("LM", "LV");

				int Passqualitaet = Pass(PassSpieler);
				if (Passqualitaet == 3) {
					p.println("Ein Wahnsinnspass " + PassGegner.getLastname() + " hat da keine Chance");
					ThisEvent= 2;
					break;
				}
				else if (Passqualitaet == 2) {
					p.println("Der Pass kommt ganz gut");
					ThisEvent = Laufduell(Passqualitaet, PassEmpfaenger, PassGegner);
					break;
				}
				else if (Passqualitaet == 1 ){
					p.println("Das ist ein lausiger Pass!");
					ThisEvent = Laufduell(Passqualitaet, PassEmpfaenger, PassGegner);
					break;
				}
				else
					p.println("Wo wandert der denn hin?");
				ThisEvent = 0;
				break;

				// Spieler mit Ball auf außen
			case 2 : 

				int Schranke = 50 + ( -50 + PassEmpfaenger.getSelbstbewusstsein());
				int roll = r.randomIntegerbetween(0, 100);
				if (roll <= Schranke) {
					p.println("Der Junge zieht nach Innen!");
					ThisEvent = NachInnenZiehen( PassEmpfaenger);

				}
				else {
					p.println("Er nimmt den Ball mit und begibt sich in Flankenposition");
					ThisEvent = Flanke(PassEmpfaenger);
				}


			}	
		}
	}







	private int pullEvent () {
		if (time == 0) {
			p.println("Herzlich Wilkommen, meine Damen und Herren zu der Partie zwischen " + Heimteam.getTeamName() + " und " + Auswaertsteam.getTeamName());
		}
		else{
			p.println("Das Spiel dümpelt vor sich hin");
		}
		int a = r.randomIntegerbetween(0,100);
		if (a < 50) {
			Angriff = Heimteam;
			Verteidigung= Auswaertsteam;
		}
		else {
			Angriff = Auswaertsteam;
			Verteidigung= Heimteam;
		}

		return r.randomIntegerbetween(0,1);


	}


	private int Pass(Spieler PassSpieler) {
		p.println(PassSpieler.getLastname() + " spielt den Pass");
		int Schranke = PassSpieler.getPass();
		int roll = r.randomIntegerbetween(0, 100);
		if (roll <= Schranke) {
			return 1+ roll / (Schranke/3);	
		}
		else return 0;


	}

	private int Laufduell(int Qualitaet, Spieler Empfaenger, Spieler Gegner)	{
		int Schranke = 50 + Qualitaet + Empfaenger.getGeschwindigkeit() + Empfaenger.getStellungsspiel() - Gegner.getGeschwindigkeit() - Gegner.getStellungsspiel();
		int roll =	r.randomIntegerbetween(0, 100);

		if (roll <= Schranke) {
			p.println(Empfaenger.getLastname() + " nimmt den Klasse mit");
			return 2;
		}
		else {
			p.println(Gegner.getLastname() + " ist schneller am Ball und klärt");
			return 0;

		}


	}


	private int NachInnenZiehen(Spieler Angreifer) {
		return 0;
	}

	private int Flanke (Spieler Flankengeber){
		return 0;
	}







	//TODO Events so umschreiben, dass sie mit listen von Spielern arbeiten. Man könnte dann Funktionen schreiben, die zB alle offensiven oder
	//alle linken offensiven Spieler eines Systems zurückgeben, siehe Bsp unten
	private int kopfballduell(Spieler Verteidiger, Spieler Angreifer){
		double Schranke =0.01 * ( 50 + Angreifer.getKopfball() - Verteidiger.getKopfball());

		double roll = Math.random();

		if ( roll <= Schranke) {

			p.println("Er köpft...");
			return 2;
		}
		else {
			p.println("Der Verteidiger klärt...");
			return 0;
		}
	}


	private int kopfball(Spieler Angreifer){
		double Schranke =0.01 * (Angreifer.getKopfball());

		double roll = Math.random();

		if ( roll <= Schranke) {			

			p.println("Der kommt gut");
			return 3;
		}

		else {
			p.println("Der geht in die Karpaten.");
			return 0;
		}
	}
	private int kopfballAufsTor(Spieler Torwart, Spieler Angreifer){
		double Schranke =0.01 * ( 50 + Angreifer.getKopfball() - Torwart.getTorwart());

		double roll = Math.random();

		if ( roll <= Schranke) {
			double latte = Math.random();
			if (latte <= 0.02){
				p.println(" An die Latte! Und der wird nochmal heiß");
				return 4;
			}
			else {

				p.println(" und passt perfekt! Tor!!!!!!");
				return 2;
			}
		}
		else {
			p.println("Der Keeper fischt ihn raus.");
			double haelt = Math.random();
			if (Torwart.getTorwart()/2 <= haelt){
				p.println("Und hält die Murmel fest");
				return 0;
			}
			else if (Torwart.getTorwart() <= haelt) {
				p.println("Und lässt zur Ecke klatschen");
				return 5;
			}
			else {
				p.println("Und er klatscht nach vorne");
				return 4;
			}
		}
	}

	private int Abpraller() {
		// Soll den Wert der Verteidigenden und der Angreifenden Spieler vergleichen, um darauf zu rollen, ob die Verteidiger klären, oder 
		// died Angreifer einen Nachschuss bekommen. Vorerst 50/50
		double nachschuss= Math.random();
		if (nachschuss <= 0.5){
			//hier sollte noch ein offensiver Spieler der angreifenden Mannschaft gepullt werden
			p.println("Direkt vor die Füße von ");
			return 6;
		}
		else {
			p.println("Aber ... kann klären");
			return 0;
		}


	}

	// Methode, die alle offensiven Spieler eines Systems zurückgibt


































	public Spiel() {

	}
}


