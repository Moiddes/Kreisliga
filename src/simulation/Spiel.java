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
	
	private Spieler SpielerMitBall;
	private Spieler SpielerMitBallVorher;
	private Spieler GegnerVorher;
	private int Passqualitaet;
	private int Flankenqualitaet;
	
	private int HeimteamTore;
	private int AuswaertsteamTore;
	private static PrintStream p = System.out;
	static RandomInt r = new RandomInt();
	private Text text = new Text();

	public void spielsimulation (Team Heimteam, Team Auswaertsteam) {

		p.println(Auswaertsteam.getTeamName());
		p.println(Heimteam.getTeamName());

		this.Heimteam = Heimteam;
		this.Auswaertsteam = Auswaertsteam;

		ThisEvent =0; 
		while (time <= 90) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (time == 45){
				p.println("ZWEITE HALBZEIT");
			}
			switch  (ThisEvent){
		
			case 0 : // PULLEVENT
				ThisEvent = pullEvent();
				time += 1;
				break;

			case 1 : //LANGER PASS AUF AUSSEN 
				ThisEvent = AussenbahnPass();
				break;
				
			case 2 : // Spieler mit Ball auf außen
				ThisEvent = SpielerAufAussen();
				break;

			case 3: //Spieler zieht nach innen
				ThisEvent = NachInnenZiehen();
				break;
			case 4: //Spieler flankt
				ThisEvent = Flanken();
				break;
			case 5: //Laufduell auf Außen
				ThisEvent = LaufduellaufAussen();
				break;
				
			case 6: //Fernschuss Sechzehner
				ThisEvent = Fernschuss(16);
			case 7: //Quer legen
				
			case 8: //Kopfball aufs Tor
				ThisEvent = kopfball();
				break;
			case 9: //Kopfballduell
				ThisEvent = kopfballduell();
				break;
			case 10: //Abpraller
				
			case 100: // TOOOOR
				ThisEvent = Tor();
				break;
				
			default: 
				ThisEvent = 0;
				break;
			}	
		}
		p.println("ENDERGEBNIS: " + HeimteamTore + " : " + AuswaertsteamTore);
	}

	//case 0
	private int pullEvent () {
		// alle Spieler wieder für Aktionen freigeben
		for (Spieler spieler : Heimteam.getTeam().values()){
			spieler.setBusy(false);
		}
		for (Spieler spieler : Auswaertsteam.getTeam().values()){
			spieler.setBusy(false);
		}
		// alle Zuweisungen wieder aufheben
		SpielerMitBall = null;
		SpielerMitBallVorher = null;
		GegnerVorher = null;
		
		if (time == 0) {
			p.println(text.Eroeffnung(Heimteam.getTeamName(), Auswaertsteam.getTeamName()));
		}
		else{
			p.println(text.KeinEvent());
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

	//case 1
	private int AussenbahnPass(){
		Spieler PassSpieler =  Angriff.getPlayerExcept("ST");
		PassSpieler.setBusy(true);
		p.println(text.Aussenbahnpass(PassSpieler));
		Passqualitaet = PassQualitaet(PassSpieler);

		if (Passqualitaet == 100) {
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = PassSpieler;
			SpielerMitBall = Angriff.getPlayerFrom("LM", "LV", "RM", "RV");
			return 2; //Spieler auf Außen 
		}
		else if (Passqualitaet > 0 && Passqualitaet < 100) {
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = SpielerMitBall;
			SpielerMitBall = Angriff.getPlayerFrom("LM", "LV", "RM", "RV");
			return 5; //Laufduell auf Aussen
		}
		else{
			return 0;
		}
	}
	
	//case 2
	private int SpielerAufAussen(){
		Spieler ZweikampfGegner = null;
		if (SpielerMitBall.getPosition() == "LM" || SpielerMitBall.getPosition() == "LV"){
			ZweikampfGegner = Verteidigung.getPlayerFrom("RV", "DM", "IV");
		}
		else{
			ZweikampfGegner = Verteidigung.getPlayerFrom("LV", "DM", "IV");
		}
		p.println(SpielerMitBall.getNamePosition() + " hat den Ball auf Außen. ");
		int Schranke = ZweikampfGegner.getStellungsspiel();
		int roll = r.randomInteger();
		if (roll <= Schranke) {
			p.println("Er wird von " + ZweikampfGegner.getNamePosition() + " gestellt.");
			if (Dribbling(SpielerMitBall, ZweikampfGegner)){
				if (GegnerVorher != null){
					GegnerVorher.setBusy(false);
				}
				GegnerVorher = ZweikampfGegner;
				//zieht nach innen oder flanke 
				Schranke = SpielerMitBall.getSelbstbewusstsein();
				roll = r.randomInteger();
				if (roll <= Schranke) {
					return 3; //zieht nach innen
				}
				else return 4; //Flanke
			}
			else return 0;
		}
		else {
			p.println("Es ist niemand da um ihn zu stellen. ");
			//zieht nach innen oder flanke 
			Schranke = SpielerMitBall.getSelbstbewusstsein();
			roll = r.randomInteger();
			if (roll <= Schranke) {
				return 3; //zieht nach innen
			}
			else return 4; //Flanke
		}
	}
	
	//case 3
	private int NachInnenZiehen() {
		p.println("Er zieht nach Innen ");
		int Schranke = SpielerMitBall.getSelbstbewusstsein();
		int roll = r.randomInteger();
		if (roll == 100){
			p.println("und verstolpet den Ball... ");
			return 0;
		}
		else if (roll <= Schranke) {
			return 6; //Fernschuss
		}
		else return 7; //Quer legen
	}
	
	//case 4
	private int Flanken(){
		p.println(SpielerMitBall.getNamePosition() + " setzt zur Flanke an.");
		Flankenqualitaet = FlankenQualitaet(SpielerMitBall);
		
		if (Flankenqualitaet == 100) {
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = SpielerMitBall;
			SpielerMitBall = Angriff.getPlayerFrom("OM", "ZM", "ST");
			return 8; //Kopfball
		}
		else if (Flankenqualitaet > 0 && Flankenqualitaet < 100) {
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = SpielerMitBall;
			SpielerMitBall = Angriff.getPlayerFrom("OM", "ZM", "ST");
			return 9; //Kopfballduell
		}
		else{
			return 0;
		}
	}
	//case 5
	private int LaufduellaufAussen(){
		Spieler PassEmpfaenger = Angriff.getPlayerFrom("LM", "LV", "RM", "RV");
		PassEmpfaenger.setBusy(true);
		Spieler PassGegner = null;
		if (PassEmpfaenger.getPosition() == "LM" || PassEmpfaenger.getPosition() == "LV"){
			PassGegner = Verteidigung.getPlayerFrom("RV", "RM");
		}
		else{
			PassGegner = Verteidigung.getPlayerFrom("LV", "LM");
		}
		PassGegner.setBusy(true);
		int Schranke = Passqualitaet + PassEmpfaenger.getGeschwindigkeit() + PassEmpfaenger.getStellungsspiel() - PassGegner.getGeschwindigkeit() - PassGegner.getStellungsspiel();
		int roll =	r.randomInteger();

		if (roll <= Schranke) {
			p.println(text.LaufduellPositiv(PassEmpfaenger));
			if (GegnerVorher != null){
				GegnerVorher.setBusy(false);
			}
			GegnerVorher = PassGegner;
			SpielerMitBall = PassEmpfaenger;
			return 2; //AufAussen
		}
		else {
			p.println(text.LaufduellNegativ(PassGegner));
			return 0; //pullEvent

		}
	}
	
	//case 6
	private int Fernschuss(int Abstand){
		p.println(SpielerMitBall.getNamePosition() + " setzt zum Schuss an.");
		int Schranke = SpielerMitBall.getSchuss();
		int roll = r.randomInteger();
		if (roll <= Schranke){
			p.println("Der geht Richtung Tor. ");
			if (!Block()){
				Spieler torwart = Verteidigung.getPlayerFrom("TW");
				Schranke = 50 - Abstand + SpielerMitBall.getSchuss() - torwart.getTorwart();
				return BallAufsTor(Schranke);
			}
			else{
				return 0;
			}
		}
		else{
			p.println(text.BallDaneben());
			return 0;
		}
		
	}
	

	//case 8
	private int kopfball(){
		int Schranke = SpielerMitBall.getKopfball();
		int roll = r.randomInteger();

		if ( roll <= Schranke) {			
			p.println("Der kommt gut ");
			Spieler torwart = Verteidigung.getPlayerFrom("TW");
			Schranke = 50 + SpielerMitBall.getKopfball() - torwart.getTorwart();
			return BallAufsTor(Schranke);
		}
		else {
			p.println("Meilenweit daneben. ");
			return 0;
		}
	}
	
	//case 9
	private int kopfballduell(){
		Spieler angreifer = Angriff.getPlayerFrom("ST", "OM", "ZM");
		Spieler verteidiger = Verteidigung.getPlayerFrom("LI", "IV", "MD");
		int Schranke = 50 + angreifer.getKopfball() - verteidiger.getKopfball();
		int roll = r.randomInteger();

		if ( roll <= Schranke) {
			p.println(text.KopfballDuell(angreifer, verteidiger) + text.DuellPositiv(angreifer, verteidiger));
			return 8;
		}
		else {
			p.println(text.KopfballDuell(angreifer, verteidiger) + text.DuellNegativ(angreifer, verteidiger));
			return 0;
		}
	}
	
	//case 10
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
	
	//case 11
	
	//Case 100
	private int Tor(){
		p.println("Was für eine Bude für " + Angriff.getTeamName());
		if (Angriff == Heimteam){
			HeimteamTore += 1;
		}
		else{
			AuswaertsteamTore += 1;
		}
		return 0;
	}
		
	private int PassQualitaet(Spieler spieler) {
		int Schranke = spieler.getPass();
		int roll = r.randomInteger();
		if (roll <= Schranke/3) {
			p.println(text.PassSehrGut());
			return 100;	
		}
		else if(roll <= 2*Schranke/3 && roll > Schranke/3){
			p.println(text.PassGut());
			return 50;
		}
		else if(roll <= Schranke && roll > Schranke/3){
			p.println(text.PassSchlecht());
			return 25;
		}
		else{
			p.println(text.PassVerfehlt());
			return 0;
		}
	}
	
	private int FlankenQualitaet(Spieler spieler) {
		int Schranke = spieler.getFlanken();
		int roll = r.randomInteger();
		if (roll <= Schranke/3) {
			p.println(text.FlankenSehrGut());
			return 100;	
		}
		else if(roll <= 2*Schranke/3 && roll > Schranke/3){
			p.println(text.FlankenGut());
			return 50;
		}
		else if(roll <= Schranke && roll > Schranke/3){
			p.println(text.FlankenSchlecht());
			return 25;
		}
		else{
			p.println(text.FlankenVerfehlt());
			return 0;
		}
	}
	
	private boolean Dribbling(Spieler angreifer, Spieler verteidiger){
		p.print("Er setzt zum Dribbling an... ");
		int schranke = 50 + angreifer.getDribbling() - verteidiger.getZweikampf();
		int roll = r.randomInteger();
		if (roll <= schranke){
			p.println("und lässt " + verteidiger.getNamePosition() + " stehen. ");
			if (GegnerVorher != null){
				GegnerVorher.setBusy(false);
			}
			GegnerVorher = verteidiger;
			return true;
		}
		else{
			p.println("aber scheitert an " + verteidiger.getNamePosition());
			return false;
		}
	}
	
	private boolean Block(){
		Spieler block = Verteidigung.getPlayerFrom("IV", "LI", "MD", "DM");
		int Schranke = 50 + SpielerMitBall.getSchuss() - block.getStellungsspiel();
		int roll = r.randomInteger();
		if (roll <= Schranke){
			p.println("Durch alle hindurch. ");
			return false;
		}
		else{
			p.println("Und wird geblockt. ");
			return true;
		}
	}
	
	private int torwartHaelt(Spieler torwart){
		p.println(text.TorwartHaelt(torwart));
		int haelt = r.randomInteger();
		if (torwart.getTorwart()/2 <= haelt){
			p.println(text.TorwartHaeltFest());
			return 0;
		}
		else if (torwart.getTorwart() <= haelt) {
			p.println(text.TorwartZurEcke());
			return 11; //Ecke
		}
		else {
			p.println(text.TorwartAbpraller());
			return 10; //Abpraller
		}
	}
	
	private int BallAufsTor(int Schranke){
		Spieler torwart = Verteidigung.getPlayerFrom("TW");
		int roll = r.randomInteger();

		if ( roll <= Schranke) {
			int latte = r.randomInteger();
			if (latte <= 1){
				p.println("An die Latte! Und der wird nochmal heiß");
				return 10; //Abpraller
			}
			else {
				p.println("Und passt perfekt! TOR!!!!!!");
				return 100; //Tor verarbeiten je nach Ergebniss etc.
			}
		}
		else {
			return torwartHaelt(torwart);
		}
	}

	public Spiel() {

	}

	public int getHeimteamTore() {
		return HeimteamTore;
	}

	public int getAuswaertsteamTore() {
		return AuswaertsteamTore;
	}
	
}


