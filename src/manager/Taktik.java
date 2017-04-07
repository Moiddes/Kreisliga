package manager;

import java.util.Arrays;
import java.util.List;

import tools.RandomInt;

public class Taktik {
	private static final String[] spielertypen1 = {"TW", "LI", "MD", "MD", "DM", "DM", "LM", "ZM", "RM", "ST", "ST"};
	private static final String[] spielertypen2 = {"TW", "LV", "IV", "IV", "RV", "LM", "ZM", "ZM", "RM", "ST", "ST"};
	private static final String[] spielertypen3 = {"TW", "LV", "IV", "IV", "RV", "DM", "LM", "ZM", "RM", "ST", "ST"};
	private static final String[] spielertypen4 = {"TW", "LV", "IV", "IV", "RV", "DM", "DM", "LM", "OM", "RM", "ST"};
	private static final String[] bank1 = {"TW", "MD", "DM", "RM", "ST"};
	private static final String[] bank2 = {"TW", "IV", "DM", "RM", "ST"};
	private static final String[] reserve1 = {"ZM", "LI"};
	private static final String[] reserve2 = {"ZM", "ZM"};
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
			Spielertypen = Arrays.asList(this.concat(spielertypen1, bank1, reserve1));
			break;
		case "4-4-2":
			Spielertypen = Arrays.asList(this.concat(spielertypen2, bank2, reserve2));
			break;
		case "4-1-3-2":
			Spielertypen = Arrays.asList(this.concat(spielertypen3, bank2, reserve2));
			break;
		case "4-2-3-1":
			Spielertypen = Arrays.asList(this.concat(spielertypen4, bank2, reserve2));
			break;
		default:
			Spielertypen = Arrays.asList(this.concat(spielertypen1, bank1, reserve1)); //TODO durch exception ersetzen
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
	//TODO evtl auslagern
	public String[] concat(String[] a, String[] b) {
		   int aLen = a.length;
		   int bLen = b.length;
		   String[] c= new String[aLen+bLen];
		   System.arraycopy(a, 0, c, 0, aLen);
		   System.arraycopy(b, 0, c, aLen, bLen);
		   return c;
		}
	
	public String[] concat(String[] a, String[] b, String[] c) {
		   int aLen = a.length;
		   int bLen = b.length;
		   int cLen = c.length;
		   String[] d= new String[aLen+bLen+cLen];
		   System.arraycopy(a, 0, d, 0, aLen);
		   System.arraycopy(b, 0, d, aLen, bLen);
		   System.arraycopy(c, 0, d, aLen + bLen, cLen);
		   return d;
		}
}
