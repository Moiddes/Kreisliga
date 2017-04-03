package simulation;
import java.util.Random;

import manager.*;

public class Spiel {

	public static int halbzeit = 1;
	public static int time = 0;
	public static int ThisEvent= 0;
	public static Team HeimTeam;
	public static Team Auswärtsteam;
	public static void main(String[] args) {

		HeimTeam = new Team("ScHille");
		Auswärtsteam = new Team("Real Madrid");
		
		
		System.out.println(HeimTeam.getPlayerNames());
		String player = HeimTeam.getPlayerNames().get(0);
		System.out.println(player);
		System.out.println(HeimTeam.getTeam().get(player).getAggresivitat());
		while (time <45) {
			ThisEvent = randomIntegerbetween(0,  10);
			switch  (ThisEvent){
			
			case 0 : ThisEvent = pullEvent();
			break;

			case 1 : ThisEvent = kopfballduell();
			break;
			
			}
		}


	}





	static int pullEvent () {
		if (time == 0) {
			System.out.println("Herzlich Wilkommen, meine Damen und Herren zu der Partie zwischen" + HeimTeam.getTeamName() + "und" + Auswärtsteam.getTeamName());
		}
		System.out.println("Das Spiel dümpelt vor sich hin");
		return randomIntegerbetween(0,10);
				
		
	}

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




	//sollte irgendwann evtl in eine eigene Klasse
	private static int randomIntegerbetween(int Low, int High){
		Random r = new Random();
		int Result = r.nextInt(High+1-Low) + Low;
		return Result;
	}


}
