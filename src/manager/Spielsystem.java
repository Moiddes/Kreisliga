package manager;

public class Spielsystem {
	private String[] system1 = {"TW", "LI", "MD", "MD", "DM", "DM", "LM", "RM", "ZM", "ST", "ST"};
	private String[] system2 = {"TW", "LI", "MD", "MD", "DM", "DM", "LM", "RM", "ZM", "ST", "ST"};
	private String[] system3 = {"TW", "LI", "MD", "MD", "DM", "DM", "LM", "RM", "ZM", "ST", "ST"};
	private String[] system4 = {"TW", "LI", "MD", "MD", "DM", "DM", "LM", "RM", "ZM", "ST", "ST"};
	private String[] Spielertypen;
	
	public String[] getSpielertypen(String spielSystem){
		switch(spielSystem){
		case "1-2-5-2":
			Spielertypen = system1;
			break;
		case "4-4-2":
			Spielertypen = system2;
			break;
		

		}
		return Spielertypen;
	}
}
