package manager;
import simulation.*;
import tools.*;


public class Kreisligamanager {
	public static Team Heimteam;
	public static Team Auswaertsteam;
	
	public static void main(String[] args) {
		Heimteam = new Team("Sc Hille");
		Auswaertsteam = new Team(); 

		 Spiel game1 = new Spiel();
		 game1.spielsimulation(Heimteam, Auswaertsteam);

	}

}
