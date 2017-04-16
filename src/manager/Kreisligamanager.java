package manager;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Map;

import simulation.*;
import tools.*;


public class Kreisligamanager {

	private static PrintStream p = System.out;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Spiel test = new Spiel();
		int Heimtore = 0;
		int Auswaertstore = 0;
//		test.spielsimulation(Heimteam, Auswaertsteam);
//		Auswaertstore += test.getAuswaertsteamTore();
//		Heimtore += test.getHeimteamTore();
//		test.spielsimulation(Heimteam, Auswaertsteam);
//		Auswaertstore += test.getAuswaertsteamTore();
//		Heimtore += test.getHeimteamTore();
		
		for (int i = 0; i < 1; i++){
			Spiel test = new Spiel();
			Team Heimteam = new Team("SC Hille");
			Team Auswaertsteam = new Team();
			test.spielsimulation(Heimteam, Auswaertsteam);
			Auswaertstore += test.getAuswaertsteamTore();
			Heimtore += test.getHeimteamTore();
		}
		p.println("GESAMT: " + Heimtore + " : " + Auswaertstore);




		//			RandomInt r = new RandomInt();
		//			p.println(r.randomIntegerbetween(1, 2));

		//			p.println(Heimteam.getPlayerFrom("ST").getGeburtstag().get(GregorianCalendar.DATE) + "." +  Heimteam.getPlayerFrom("ST").getGeburtstag().get(GregorianCalendar.MONTH) + "." +  Heimteam.getPlayerFrom("ST").getGeburtstag().get(GregorianCalendar.YEAR));
		//			p.println(Heimteam.getPlayerFrom("ST").getAlter());


		//		ManagerGUI gui = new ManagerGUI();

		//		ManagerGUI.startManagerGUI();

		//
		//		for(Spieler spieler : Heimteam.getTeam().values()){
		//			p.printf("%s (%s)%n", spieler.getName(), spieler.getPosition());
		//		}
		//		p.println(" ");
		//		for(int i = 0; i<10; i++){
		//			Spieler spieler = Heimteam.getPlayerExcept("TW", "ST", "DM", "OM");
		//			p.printf("%s (%s)%n", spieler.getName(), spieler.getPosition());
		//		}
		//		p.println(" ");
		//		for(int i = 0; i<10; i++){
		//			Spieler spieler = Heimteam.getPlayerFrom("TW", "ST", "DM", "OM");
		//			p.printf("%s (%s)%n", spieler.getName(), spieler.getPosition());
		//		}


		//		int TW = 0; int LI= 0; int MD= 0; int IV= 0; int LV= 0; int DM= 0; int LM= 0; int ZM= 0; int OM= 0; int ST= 0;
		//		int playerCount = 0;
		//		
		//		for(int i=0; i<1000; i++){
		//			Heimteam = new Team();
		//			for (Map.Entry<String, Spieler> entry : Heimteam.getTeam().entrySet()){
		//				String position = entry.getValue().getFavPosition();
		//				playerCount +=1;
		//				
		//				switch(position){
		//				case "TW": TW +=1; break;
		//				case "LI": LI +=1; break;
		//				case "MD": MD +=1; break;
		//				case "IV": IV +=1; break;
		//				case "LV/RV": LV +=1; break;
		//				case "DM": DM +=1; break;
		//				case "LM/RM": LM +=1; break;
		//				case "ZM": ZM +=1; break;
		//				case "OM": OM +=1; break;
		//				case "ST": ST +=1; break;
		//				}
		//			}
		//		}
		//		p.printf("TW = %d%n",  TW);
		//		p.printf("LI = %d%n",  LI);
		//		p.printf("MD = %d%n",  MD);
		//		p.printf("IV = %d%n",  IV);
		//		p.printf("LV = %d%n",  LV);
		//		p.printf("DM = %d%n",  DM);
		//		p.printf("LM = %d%n",  LM);
		//		p.printf("ZM = %d%n",  ZM);
		//		p.printf("OM = %d%n",  OM);
		//		p.printf("ST = %d%n",  ST);
		//		p.printf("Anzahl = %d", playerCount);

		//		Spiel game1 = new Spiel();
		//		game1.spielsimulation(Heimteam, Auswaertsteam);
	}



}

