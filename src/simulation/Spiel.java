package simulation;
import java.util.List;
import java.util.Random;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import manager.*;
import tools.*;

public class Spiel {

	public  int halbzeit = 1;
	public int time = 0;
	public int ThisEvent= 0;
	public Team Heimteam;
	public Team Auswaertsteam;
	public Team Angriff;
	public Team Verteidigung;

	private static PrintStream p = System.out;
	static RandomInt r = new RandomInt();

	public  void spielsimulation (Team Heimteam, Team Auswaertsteam) {

				p.println(Auswaertsteam.getTeamName());

		// Position doch nicht als enum, wahrscheinlich mehr vorteile es als string zu speichern	
		//		Position[] spielSystemHeim = new Position[]{Position.TW, LI, MD, MD, DM, DM, LM, RM, ZM, ST, ST}; 

		System.out.println(Heimteam.getPlayerNames());
		String player = Heimteam.getPlayerNames().get(0);
		System.out.println(player);
		System.out.println(Heimteam.getTeam().get(player).getAggresivitat());

		Heimteam.addSpieler(new Spieler("Hans", "Sarpei"));
		System.out.println(Heimteam.getPlayerNames());
		System.out.println(Heimteam.getTeam().get("HansSarpei").getAggresivitat());
		Heimteam.removeSpieler("HansSarpei");
		System.out.println(Heimteam.getPlayerNames());
		Heimteam.removeSpieler("HansSarpei");
		ThisEvent =0; 
		while (time <45) {


			switch  (ThisEvent){

			case 0 : 
				ThisEvent = pullEvent();
				time += 2;
				break;

			case 1 :
				

//				ThisEvent = kopfballduell();
//				break;

			}
		}


	}





	private int pullEvent () {
		if (time == 0) {
			System.out.println("Herzlich Wilkommen, meine Damen und Herren zu der Partie zwischen" + Heimteam.getTeamName() + "und" + Auswaertsteam.getTeamName());
		}
		System.out.println("Das Spiel dümpelt vor sich hin");
		int a = r.randomIntegerbetween(0,100);
		if (a < 50) {
			Angriff = Heimteam;
			Verteidigung= Auswaertsteam;
		}
		
		return r.randomIntegerbetween(0,10);


	}

	//TODO Events so umschreiben, dass sie mit listen von Spielern arbeiten. Man könnte dann Funktionen schreiben, die zB alle offensiven oder
	//alle linken offensiven Spieler eines Systems zurückgeben, siehe Bsp unten
	private int kopfballduell(Spieler Verteidiger, Spieler Angreifer){
		double Schranke =0.01 * ( 50 + Angreifer.getKopfball() - Verteidiger.getKopfball());

		double rnd = Math.random();

		if ( rnd <= Schranke) {

			System.out.println("Er köpft...");
			return 2;
		}
		else {
			System.out.println("Der Verteidiger klärt...");
			return 0;
		}
	}


	private int kopfball(Spieler Angreifer){
		double Schranke =0.01 * (Angreifer.getKopfball());

		double rnd = Math.random();

		if ( rnd <= Schranke) {			

			System.out.println("Der kommt gut");
			return 3;
		}

		else {
			System.out.println("Der geht in die Karpaten.");
			return 0;
		}
	}
	private int kopfballAufsTor(Spieler Torwart, Spieler Angreifer){
		double Schranke =0.01 * ( 50 + Angreifer.getKopfball() - Torwart.getTorwart());

		double rnd = Math.random();

		if ( rnd <= Schranke) {
			double latte = Math.random();
			if (latte <= 0.02){
				System.out.println(" An die Latte! Und der wird nochmal heiß");
				return 4;
			}
			else {

				System.out.println(" und passt perfekt! Tor!!!!!!");
				return 2;
			}
		}
		else {
			System.out.println("Der Keeper fischt ihn raus.");
			double haelt = Math.random();
			if (Torwart.getTorwart()/2 <= haelt){
				System.out.println("Und hält die Murmel fest");
				return 0;
			}
			else if (Torwart.getTorwart() <= haelt) {
				System.out.println("Und lässt zur Ecke klatschen");
				return 5;
			}
			else {
				System.out.println("Und er klatscht nach vorne");
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
			System.out.println("Direkt vor die Füße von ");
			return 6;
		}
		else {
			System.out.println("Aber ... kann klären");
			return 0;
		}


	}

	// Methode, die alle offensiven Spieler eines Systems zurückgibt


public Spiel() {
	
}
}
		

