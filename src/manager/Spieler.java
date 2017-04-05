package manager;

import java.util.HashMap;
import java.util.Map;

import tools.*;

public class Spieler {

	//neutrale Werte
	private int geschwindigkeit;
	private int zweikampf;
	private int stellungsspiel;
	private int ausdauer;
	private int kopfball;
	//mentale Werte
	private int moral;
	private int selbstbewusstsein;
	private int disziplin;
	private int aggresivitat;
	//defensive Werte
	private int antizipation;
	private int torwart;
	//offensive Werte
	private int schuss;
	private int freistoss;
	private int pass;
	private int dribbling;
	private int flanken;
	//feste Werte
	private String fuss; //mögliche Werte (links, rechts, beidfüßig)
	//Team Werte
	private String team;
	private String position; //mögliche Werte (TW, LI, MD, IV, LV, RV, DM, LM, ZM, RM, OM, ST)
	private String favPosition;
	private String firstname;
	private String lastname;
	//sim Werte	
	private boolean busy;
	
	static RandomInt r = new RandomInt();

	public Spieler(String firstname, String lastname) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		//neutrale Werte
		this.setGeschwindigkeit(r.randomInteger());
		this.setZweikampf(r.randomInteger());
		this.setStellungsspiel(r.randomInteger());
		this.setAusdauer(r.randomInteger());
		this.setKopfball(r.randomInteger());
		//mentale Werte
		this.setMoral(r.randomInteger());
		this.setSelbstbewusstsein(r.randomInteger());
		this.setDisziplin(r.randomInteger());
		this.setAggresivitat(r.randomInteger());
		//defensive Werte
		this.setAntizipation(r.randomInteger());
		this.setTorwart(r.randomInteger());
		//offensive Werte
		this.setSchuss(r.randomInteger());
		this.setFreistoss(r.randomInteger());
		this.setPass(r.randomInteger());
		this.setDribbling(r.randomInteger());
		this.setFlanken(r.randomInteger());
		
		this.setBusy(false);
	}

	public Spieler(String firstname, String lastname, String position) { //TODO constructoren für versch. Spieler schreiben
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPosition(position);
		//neutrale Werte
		this.setGeschwindigkeit(r.randomInteger());
		this.setZweikampf(r.randomInteger());
		this.setStellungsspiel(r.randomInteger());
		this.setAusdauer(r.randomInteger());
		this.setKopfball(r.randomInteger());
		//mentale Werte
		this.setMoral(r.randomInteger());
		this.setSelbstbewusstsein(r.randomInteger());
		this.setDisziplin(r.randomInteger());
		this.setAggresivitat(r.randomInteger());
		//defensive Werte
		this.setAntizipation(r.randomInteger());
		this.setTorwart(r.randomInteger());
		//offensive Werte
		this.setSchuss(r.randomInteger());
		this.setFreistoss(r.randomInteger());
		this.setPass(r.randomInteger());
		this.setDribbling(r.randomInteger());
		this.setFlanken(r.randomInteger());
		
		this.setBusy(false);
	}
	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}
	public void setGeschwindigkeit(int geschwindigkeit) {
		if (geschwindigkeit <= 100 && geschwindigkeit >= 0) {
			this.geschwindigkeit = geschwindigkeit;
		}
	}

	public int getZweikampf() {
		return zweikampf;
	}
	public void setZweikampf(int zweikampf) {
		if (zweikampf <= 100 && zweikampf >= 0) {
			this.zweikampf = zweikampf;
		}
	}
	
	public int getStellungsspiel() {
		return stellungsspiel;
	}
	public void setStellungsspiel(int stellungsspiel) {
		if (stellungsspiel <= 100 && stellungsspiel >= 0) {
			this.stellungsspiel = stellungsspiel;
		}
	}

	public int getAusdauer() {
		return ausdauer;
	}
	public void setAusdauer(int ausdauer) {
		if (ausdauer <= 100 && ausdauer >= 0) {
			this.ausdauer = ausdauer;
		}
	}

	public int getKopfball() {
		return kopfball;
	}
	public void setKopfball(int kopfball) {
		if (kopfball <= 100 && kopfball >= 0) {
			this.kopfball = kopfball;
		}
	}

	public int getMoral() {
		return moral;
	}
	public void setMoral(int moral) {
		if (moral <= 100 && moral >= 0) {
			this.moral = moral;
		}
	}
	
	public int getSelbstbewusstsein() {
		return selbstbewusstsein;
	}
	public void setSelbstbewusstsein(int selbstbewusstsein) {
		if (selbstbewusstsein <= 100 && selbstbewusstsein >= 0) {
			this.selbstbewusstsein = selbstbewusstsein;
		}
	}

	public int getDisziplin() {
		return disziplin;
	}
	public void setDisziplin(int disziplin) {
		if (disziplin <= 100 && disziplin >= 0) {
			this.disziplin = disziplin;
		}
	}

	public int getAggresivitat() {
		return aggresivitat;
	}
	public void setAggresivitat(int aggresivitat) {
		if (aggresivitat <= 100 && aggresivitat >= 0) {
			this.aggresivitat = aggresivitat;
		}
	}

	public int getAntizipation() {
		return antizipation;
	}
	public void setAntizipation(int antizipation) {
		if (antizipation <= 100 && antizipation >= 0) {
			this.antizipation = antizipation;
		}
	}

	public int getTorwart() {
		return torwart;
	}
	public void setTorwart(int torwart) {
		if (torwart <= 100 && torwart >= 0) {
			this.torwart = torwart;
		}
	}

	public int getSchuss() {
		return schuss;
	}
	public void setSchuss(int schuss) {
		if (schuss <= 100 && schuss >= 0) {
			this.schuss = schuss;
		}
	}

	public int getFreistoss() {
		return freistoss;
	}
	public void setFreistoss(int freistoss) {
		if (freistoss <= 100 && freistoss >= 0) {
			this.freistoss = freistoss;
		}
	}

	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		if (pass <= 100 && pass >= 0) {
			this.pass = pass;
		}
	}

	public int getDribbling() {
		return dribbling;
	}
	public void setDribbling(int dribbling) {
		if (dribbling <= 100 && dribbling >= 0) {
			this.dribbling = dribbling;
		}
	}

	public int getFlanken() {
		return flanken;
	}
	public void setFlanken(int flanken) {
		if (flanken <= 100 && flanken >= 0) {
			this.flanken = flanken;
		}
	}
	
	public String getFuss() {
		return fuss;
	}
	public void setFuss(String fuss) {
		this.fuss = fuss;
	}

	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}	

	public String getFavPosition() {
		return favPosition;
	}
	public void setFavPosition(String favPosition) {
		this.favPosition = favPosition;
	}

	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public void updateFavPosition(){
		Map<String, Float> positionValues = new HashMap<String, Float>();
		positionValues.put("TW", (float)(this.torwart + this.antizipation)/2);
		positionValues.put("LI", (float)(this.stellungsspiel + this.antizipation + this.zweikampf)/3);
		positionValues.put("MD", (float)(this.stellungsspiel + this.geschwindigkeit + this.zweikampf)/3);
		positionValues.put("IV", (float)(this.stellungsspiel + this.antizipation + this.zweikampf + this.geschwindigkeit)/4);
		positionValues.put("LV/RV", (float)(this.stellungsspiel + this.geschwindigkeit + this.zweikampf + this.pass)/4);
		positionValues.put("DM", (float)(this.pass + this.zweikampf + this.ausdauer)/3);
		positionValues.put("LM/RM", (float)(this.geschwindigkeit + this.flanken + this.pass)/3);
		positionValues.put("ZM", (float)(this.pass + this.ausdauer + this.schuss)/3);
		positionValues.put("OM", (float)(this.pass + this.schuss + this.dribbling)/3);
		positionValues.put("ST", (float)(this.schuss + this.kopfball)/2);
		float best = 0;
		for (Map.Entry<String, Float> entry : positionValues.entrySet()) {
			if(entry.getValue() > best){
				best = entry.getValue();
				this.setFavPosition(entry.getKey());				
			}
			else if(entry.getValue() == best){
				this.setFavPosition(getFavPosition() + "/" + entry.getKey());
			}
		}
		
	}
}
