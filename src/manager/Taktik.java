package manager;

import java.util.Arrays;
import java.util.List;

import tools.RandomInt;

public class Taktik {
	private static final String[] formation1 = {"TW", "LI", "MD", "MD", "DM", "DM", "LM", "ZM", "RM", "ST", "ST"};
	private static final String[] formation2 = {"TW", "LV", "IV", "IV", "RV", "LM", "ZM", "ZM", "RM", "ST", "ST"};
	private static final String[] formation3 = {"TW", "LV", "IV", "IV", "RV", "DM", "LM", "ZM", "RM", "ST", "ST"};
	private static final String[] formation4 = {"TW", "LV", "IV", "IV", "RV", "DM", "DM", "LM", "OM", "RM", "ST"};
	private List<String> Spielertypen;
	private String formation;
	static RandomInt r = new RandomInt();
	
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	
	public List<String> getSpielertypen(){
		switch(this.formation){
		case "1-2-2-3-2":
			Spielertypen = Arrays.asList(formation1);
			break;
		case "4-4-2":
			Spielertypen = Arrays.asList(formation2);
			break;
		case "4-1-3-2":
			Spielertypen = Arrays.asList(formation3);
			break;
		case "4-2-3-1":
			Spielertypen = Arrays.asList(formation4);
			break;
		default:
			Spielertypen = Arrays.asList(formation1); //TODO durch exception ersetzen
			break;
		}
		return Spielertypen;
	}
	
	public void setrandomFormation(){
		int decider = r.randomIntegerbetween(1, 4);
		switch(decider){
		case 1:
			this.formation = "1-2-2-3-2";
			break;
		case 2:
			this.formation = "4-4-2";
			break;
		case 3:
			this.formation = "4-1-3-2";
			break;
		case 4:
			this.formation = "4-2-3-1";
			break;
		default:
			this.formation = "1-2-2-3-2"; //TODO durch exception ersetzen
			break;
		}
	}
}
