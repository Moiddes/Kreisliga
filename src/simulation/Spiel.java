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
	private double Passqualitaet;
	private double Flankenqualitaet;
	
	private int HeimteamTore;
	private int AuswaertsteamTore;
	private static PrintStream p = System.out;
	private RandomInt r = new RandomInt();
	private Text text = new Text();
	private Vergleich v = new Vergleich();

	public void spielsimulation (Team Heimteam, Team Auswaertsteam) {
		//Alle returns für die Events sind int
		//Alle nicht-Event returns sind double, damit man Events verschieben kann
		//(einfach alle returns entsprechend ändern)
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
				ThisEvent = 0;
			}
			switch  (ThisEvent){
		
			case 0 : // PULLEVENT
				ThisEvent = pullEvent();
				time += 1;
				break;

			case 1 : //LANGER PASS AUF AUSSEN 
				ThisEvent = AussenbahnPass();
				break;
			case 2: //Doppelpass über die Mittellinie
			
			case 3: //Dribbling über die Mittellinie
				
			case 4: //Pass an den Sechzehner
				
			case 5: //Hoher Ball in den Sechzehner
			
			case 6: //Balleroberung durch Pressing
				
			case 7: //

				
			case 11 : // Spieler mit Ball auf außen
				ThisEvent = SpielerAufAussen();
				break;
			case 12: //Abpraller
				
			case 13: //Spieler zieht nach innen
				ThisEvent = NachInnenZiehen();
				break;
			case 14: //Spieler flankt
				ThisEvent = Flanken();
				break;
			case 15: //Laufduell auf Außen
				ThisEvent = LaufduellaufAussen();
				break;
			case 16: //Fernschuss Sechzehner
				ThisEvent = Schuss(16);
				break;
			case 17: //Quer legen
			case 18: //Kopfball aufs Tor
				ThisEvent = kopfball();
				break;
			case 19: //Kopfballduell
				ThisEvent = kopfballduell();
				break;
			case 20: //Ecke
				
			case 70: //Abseits, ab hier aufsteigend die "Schiri Events"
			case 80: //Konter - Event, dass den Angriff umkehrt
			case 90: //Verzweifelungsschuss - Event bei kleiner Moral
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
			p.println(text.Minute(time) + text.Eroeffnung(Heimteam.getTeamName(), Auswaertsteam.getTeamName()));
		}
		else{
			p.println(text.Minute(time) + text.KeinEvent());
		}
		int nextEvent = r.randomIntegerbetween(0, 1);
		if(nextEvent != 0){
			int Schranke = (int) (100 * (Heimteam.getTeamInitiative()/(Heimteam.getTeamInitiative() + Auswaertsteam.getTeamInitiative())));
			int roll = r.randomInteger();
			if (roll < Schranke) {
				Angriff = Heimteam;
				Verteidigung= Auswaertsteam;
			}
			else {
				Angriff = Auswaertsteam;
				Verteidigung= Heimteam;
			}
			p.println(text.Minute(time) + Angriff.getTeamName() + " im Angriff");
		}
		return nextEvent;
	}

	//case 1
	private int AussenbahnPass(){
		Spieler PassSpieler =  Angriff.getPlayerExcept("ST");
		PassSpieler.setBusy(true);
		p.println(text.Minute(time) + text.Aussenbahnpass(PassSpieler));
		Passqualitaet = PassQualitaet(PassSpieler);

		if (Passqualitaet == 100.0) {
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = PassSpieler;
			SpielerMitBall = Angriff.getPlayerFrom("LM", "LV", "RM", "RV");
			return 11; //Spieler auf Außen 
		}
		else if (Passqualitaet == 10.0 || Passqualitaet == -10.0) {
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = SpielerMitBall;
			SpielerMitBall = Angriff.getPlayerFrom("LM", "LV", "RM", "RV");
			return 15; //Laufduell auf Aussen
		}
		else{
			return 0;
		}
	}
	
	//case 2
	
	//case 11
	private int SpielerAufAussen(){
		Spieler ZweikampfGegner = null;
		if (SpielerMitBall.getPosition() == "LM" || SpielerMitBall.getPosition() == "LV"){
			ZweikampfGegner = Verteidigung.getPlayerFrom("RV", "DM", "IV");
		}
		else{
			ZweikampfGegner = Verteidigung.getPlayerFrom("LV", "DM", "IV");
		}
		p.println(text.Minute(time) + SpielerMitBall.getNamePosition() + " hat den Ball auf Außen. ");
		int Schranke = ZweikampfGegner.getStellungsspiel();
		int roll = r.randomInteger();
		if (roll <= Schranke) {
			p.println(text.Minute(time) + "Er wird von " + ZweikampfGegner.getNamePosition() + " gestellt.");
			if (Dribbling(SpielerMitBall, ZweikampfGegner)){
				if (GegnerVorher != null){
					GegnerVorher.setBusy(false);
				}
				GegnerVorher = ZweikampfGegner;
				//zieht nach innen oder flanke 
				Schranke = SpielerMitBall.getSelbstbewusstsein();
				roll = r.randomInteger();
				if (roll <= Schranke) {
					return 13; //zieht nach innen
				}
				else return 14; //Flanke
			}
			else return 0;
		}
		else {
			p.println(text.Minute(time) + "Es ist niemand da um ihn zu stellen. ");
			//zieht nach innen oder flanke 
			Schranke = SpielerMitBall.getSelbstbewusstsein();
			roll = r.randomInteger();
			if (roll <= Schranke) {
				return 13; //zieht nach innen
			}
			else return 14; //Flanke
		}
	}
	
	//case 12
	private int Abpraller() {
		// Soll den Wert der Verteidigenden und der Angreifenden Spieler vergleichen, um darauf zu rollen, ob die Verteidiger klären, oder 
		// died Angreifer einen Nachschuss bekommen. Vorerst 50/50
		double nachschuss= Math.random();
		if (nachschuss <= 0.5){
			//hier sollte noch ein offensiver Spieler der angreifenden Mannschaft gepullt werden
			p.println(text.Minute(time) + "Direkt vor die Füße von ");
			return 16; //Fernschuss Sechzehner
		}
		else {
			p.println(text.Minute(time) + "Aber ... kann klären");
			return 0;
		}
	}
	
	//case 13
	private int NachInnenZiehen() {
		p.println(text.Minute(time) + "Er zieht nach Innen ");
		int Schranke = SpielerMitBall.getSelbstbewusstsein();
		int roll = r.randomInteger();
		if (roll == 100){
			p.println(text.Minute(time) + "und verstolpet den Ball... ");
			return 0;
		}
		else if (roll <= Schranke) {
			return 16; //Fernschuss
		}
		else return 17; //Quer legen
	}
	
	//case 14
	private int Flanken(){
		p.println(text.Minute(time) + SpielerMitBall.getNamePosition() + " setzt zur Flanke an.");
		Flankenqualitaet = FlankenQualitaet(SpielerMitBall);
		
		if (Flankenqualitaet == 100.0) {
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = SpielerMitBall;
			SpielerMitBall = Angriff.getPlayerFrom("OM", "ZM", "ST");
			return 18; //Kopfball
		}
		else if (Flankenqualitaet == 10.0 || Flankenqualitaet == -10.0) {
			return 19; //Kopfballduell
		}
		else{
			return 0;
		}
	}
	//case 15
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
		int Schranke = (int) (Passqualitaet) + v.RationX(PassEmpfaenger.getGeschwindigkeit() + PassEmpfaenger.getStellungsspiel(), PassGegner.getGeschwindigkeit() + PassGegner.getStellungsspiel());
		int roll =	r.randomInteger();

		if (roll <= Schranke) {
			p.println(text.Minute(time) + text.LaufduellPositiv(PassEmpfaenger));
			if (GegnerVorher != null){
				GegnerVorher.setBusy(false);
			}
			GegnerVorher = PassGegner;
			SpielerMitBall = PassEmpfaenger;
			return 11; //AufAussen
		}
		else {
			p.println(text.Minute(time) + text.LaufduellNegativ(PassGegner));
			return 0; //pullEvent

		}
	}
	
	//case 16
	private int Schuss(int Abstand){
		p.println(text.Minute(time) + SpielerMitBall.getNamePosition() + " setzt aus " + Abstand + " Metern zum Schuss an");
		int Schranke = SpielerMitBall.getSchuss();
		int roll = r.randomInteger();
		if (roll <= Schranke){
			p.println(text.Minute(time) + "Der geht Richtung Tor. ");
			if (!Block()){
				Spieler torwart = Verteidigung.getPlayerFrom("TW");
				Schranke = v.RationX(SpielerMitBall.getSchuss(), torwart.getTorwart()) - (Abstand - 10);
				return BallAufsTor(Schranke);
			}
			else{
				return 0;
			}
		}
		else{
			p.println(text.Minute(time) + text.BallDaneben());
			return 0;
		}
		
	}
	
	//case 18
	private int kopfball(){
		int Schranke = SpielerMitBall.getKopfball();
		int roll = r.randomInteger();

		if ( roll <= Schranke) {			
			p.println(text.Minute(time) + "Der kommt gut ");
			Spieler torwart = Verteidigung.getPlayerFrom("TW");
			Schranke = v.RationX(SpielerMitBall.getKopfball(), torwart.getTorwart());
			return BallAufsTor(Schranke);
		}
		else {
			p.println(text.Minute(time) + "Meilenweit daneben. ");
			return 0;
		}
	}
	
	//case 19
	private int kopfballduell(){
		Spieler angreifer = Angriff.getPlayerFrom("ST", "OM", "ZM");
		Spieler verteidiger = Verteidigung.getPlayerFrom("LI", "IV", "MD");
		int Schranke = (int)(Flankenqualitaet) + v.RationX(angreifer.getKopfball(), verteidiger.getKopfball());
		int roll = r.randomInteger();

		if ( roll <= Schranke) {
			p.println(text.Minute(time) + text.KopfballDuell(angreifer, verteidiger) + text.DuellPositiv(angreifer, verteidiger));
			if (SpielerMitBallVorher != null){
				SpielerMitBallVorher.setBusy(false);
			}
			SpielerMitBallVorher = SpielerMitBall;
			SpielerMitBall = angreifer;
			return 18; //Kopfball
		}
		else {
			p.println(text.Minute(time) + text.KopfballDuell(angreifer, verteidiger) + text.DuellNegativ(angreifer, verteidiger));
			return 0;
		}
	}
	
	//Case 100
	private int Tor(){
		p.println(text.Minute(time) + "Was für eine Bude für " + Angriff.getTeamName());
		if (Angriff == Heimteam){
			HeimteamTore += 1;
		}
		else{
			AuswaertsteamTore += 1;
		}
		return 0;
	}
		
	private double PassQualitaet(Spieler spieler) {
		int Schranke = spieler.getPass();
		int roll = r.randomInteger();
		if (roll <= Schranke/3) {
			p.println(text.Minute(time) + text.PassSehrGut());
			return 100.0;	
		}
		else if(roll <= 2*Schranke/3 && roll > Schranke/3){
			p.println(text.Minute(time) + text.PassGut());
			return 10.0;
		}
		else if(roll <= Schranke && roll > 2*Schranke/3){
			p.println(text.Minute(time) + text.PassSchlecht());
			return -10.0;
		}
		else{
			p.println(text.Minute(time) + text.PassVerfehlt());
			return -100.0;
		}
	}
	
	private double FlankenQualitaet(Spieler spieler) {
		int Schranke = spieler.getFlanken();
		int roll = r.randomInteger();
		if (roll <= Schranke/3) {
			p.println(text.Minute(time) + text.FlankenSehrGut());
			return 100.0;	
		}
		else if(roll <= 2*Schranke/3 && roll > Schranke/3){
			p.println(text.Minute(time) + text.FlankenGut());
			return 10.0;
		}
		else if(roll <= Schranke && roll > Schranke/3){
			p.println(text.Minute(time) + text.FlankenSchlecht());
			return -10.0;
		}
		else{
			p.println(text.Minute(time) + text.FlankenVerfehlt());
			return -100;
		}
	}
	
	private boolean Dribbling(Spieler angreifer, Spieler verteidiger){
		p.print("Er setzt zum Dribbling an... ");
		int schranke = 50 + angreifer.getDribbling() - verteidiger.getZweikampf();
		int roll = r.randomInteger();
		if (roll <= schranke){
			p.println(text.Minute(time) + "und lässt " + verteidiger.getNamePosition() + " stehen. ");
			if (GegnerVorher != null){
				GegnerVorher.setBusy(false);
			}
			GegnerVorher = verteidiger;
			return true;
		}
		else{
			p.println(text.Minute(time) + "aber scheitert an " + verteidiger.getNamePosition());
			return false;
		}
	}
	
	private boolean Block(){
		Spieler block = Verteidigung.getPlayerFrom("IV", "LI", "MD", "DM");
		int Schranke = 50 + SpielerMitBall.getSchuss() - block.getStellungsspiel();
		int roll = r.randomInteger();
		if (roll <= Schranke){
			p.println(text.Minute(time) + "Durch alle hindurch. ");
			return false;
		}
		else{
			p.println(text.Minute(time) + "Und wird geblockt. ");
			return true;
		}
	}
	
	private int torwartHaelt(Spieler torwart){
		p.println(text.Minute(time) + text.TorwartHaelt(torwart));
		int haelt = r.randomInteger();
		if (torwart.getTorwart()/2 <= haelt){
			p.println(text.Minute(time) + text.TorwartHaeltFest());
			return 0;
		}
		else if (torwart.getTorwart() <= haelt) {
			p.println(text.Minute(time) + text.TorwartZurEcke());
			return 20; //Ecke
		}
		else {
			p.println(text.Minute(time) + text.TorwartAbpraller());
			return 10; //Abpraller
		}
	}
	
	private int BallAufsTor(int Schranke){
		Spieler torwart = Verteidigung.getPlayerFrom("TW");
		int roll = r.randomInteger();

		if ( roll <= Schranke) {
			int latte = r.randomInteger();
			if (latte <= 1){
				p.println(text.Minute(time) + "An die Latte! Und der wird nochmal heiß");
				return 10; //Abpraller
			}
			else {
				p.println(text.Minute(time) + "Und passt perfekt! TOR!!!!!!");
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


