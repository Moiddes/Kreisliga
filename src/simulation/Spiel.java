package simulation;
import manager.*;

public class Spiel {


	public static int time = 0;
	public static void main(String[] args) {
		



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
		System.out.println(" und passt perfekt! Tor!!!!!!");
		return 2;
	}
	else {
		System.out.println("Der geht in die Karpaten.");
		return 3;
	}
}

}
