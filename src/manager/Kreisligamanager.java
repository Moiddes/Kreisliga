package manager;
import java.io.PrintStream;
import java.util.Map;

import simulation.*;
import tools.*;


public class Kreisligamanager {

	private static PrintStream p = System.out;

	public static Team Heimteam;
	public static Team Auswaertsteam;

	public static void main(String[] args) {
		Heimteam = new Team("Sc Hille");
		Auswaertsteam = new Team(); 

		int TW = 0; int LI= 0; int MD= 0; int IV= 0; int LV= 0; int DM= 0; int LM= 0; int ZM= 0; int OM= 0; int ST= 0;

		for(int i=0; i<10000; i++){
			Heimteam = new Team();
			for (Map.Entry<String, Spieler> entry : Heimteam.getTeam().entrySet()){
				entry.getValue().updateFavPosition();
				String position = entry.getValue().getFavPosition();

				switch(position){
				case "TW": TW +=1; break;
				case "LI": LI +=1; break;
				case "MD": MD +=1; break;
				case "IV": IV +=1; break;
				case "LV/RV": LV +=1; break;
				case "DM": DM +=1; break;
				case "LM/RM": LM +=1; break;
				case "ZM": ZM +=1; break;
				case "OM": OM +=1; break;
				case "ST": ST +=1; break;
				}
			}
		}
		p.printf("TW = %d%n",  TW);
		p.printf("LI = %d%n",  LI);
		p.printf("MD = %d%n",  MD);
		p.printf("IV = %d%n",  IV);
		p.printf("LV = %d%n",  LV);
		p.printf("DM = %d%n",  DM);
		p.printf("LM = %d%n",  LM);
		p.printf("ZM = %d%n",  ZM);
		p.printf("OM = %d%n",  OM);
		p.printf("ST = %d%n",  ST);

	}
	//		String player = Heimteam.getPlayerNames().get(0);
	//		System.out.println(player);
	//		System.out.println(Heimteam.getTeam().get(player).getAggresivitat());
	//
	//		Heimteam.addSpieler(new Spieler("Hans", "Sarpei"));
	//		System.out.println(Heimteam.getPlayerNames());
	//		System.out.println(Heimteam.getTeam().get("HansSarpei").getAggresivitat());
	//		Heimteam.removeSpieler("HansSarpei");
	//		System.out.println(Heimteam.getPlayerNames());
	//		Heimteam.removeSpieler("HansSarpei");
	//		
	//		 Spiel game1 = new Spiel();
	//		 game1.spielsimulation(Heimteam, Auswaertsteam);

}

