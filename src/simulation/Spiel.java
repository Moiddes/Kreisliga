package simulation;
import java.util.List;
import java.util.Random;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import manager.*;
import tools.*;

public class Spiel {

	public static int halbzeit = 1;
	public static int time = 0;
	public static int ThisEvent= 0;
	public static Team HeimTeam;
	public static Team Auswärtsteam;
	
	private static PrintStream p = System.out;
	static RandomInt r = new RandomInt();
	
	public static void main(String[] args) {

		HeimTeam = new Team("Sc Hille");
		Auswärtsteam = new Team(); //TODO macht ein 'ä' im Code nicht Probleme?
		p.println(Auswärtsteam.getTeamName());
		
// Position doch nicht als enum, wahrscheinlich mehr vorteile es als string zu speichern	
//		Position[] spielSystemHeim = new Position[]{Position.TW, LI, MD, MD, DM, DM, LM, RM, ZM, ST, ST}; 

		System.out.println(HeimTeam.getPlayerNames());
		String player = HeimTeam.getPlayerNames().get(0);
		System.out.println(player);
		System.out.println(HeimTeam.getTeam().get(player).getAggresivitat());
		
		HeimTeam.addSpieler(new Spieler("Hans", "Sarpei"));
		System.out.println(HeimTeam.getPlayerNames());
		System.out.println(HeimTeam.getTeam().get("HansSarpei").getAggresivitat());
		HeimTeam.removeSpieler("HansSarpei");
		System.out.println(HeimTeam.getPlayerNames());
		HeimTeam.removeSpieler("HansSarpei");

		//		while (time <45) {
		//			ThisEvent = r.randomIntegerbetween(0,  10);
		//			switch  (ThisEvent){
		//			
		//			case 0 : ThisEvent = pullEvent();
		//			break;
		//
		//			case 1 : ThisEvent = kopfballduell();
		//			break;
		//			
		//			}
		//		}


	}





	static int pullEvent () {
		if (time == 0) {
			System.out.println("Herzlich Wilkommen, meine Damen und Herren zu der Partie zwischen" + HeimTeam.getTeamName() + "und" + Auswärtsteam.getTeamName());
		}
		System.out.println("Das Spiel dümpelt vor sich hin");
		return r.randomIntegerbetween(0,10);


	}
	
	//TODO Events so umschreiben, dass sie mit listen von Spielern arbeiten. Man könnte dann Funktionen schreiben, die zB alle offensiven oder
	//alle linken offensiven Spieler eines Systems zurückgeben, siehe Bsp unten
	static int kopfballduell(Spieler Verteidiger, Spieler Angreifer){
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


	static int kopfball(Spieler Angreifer){
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
	static int kopfballAufsTor(Spieler Torwart, Spieler Angreifer){
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

	static int Abpraller() {
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



}
