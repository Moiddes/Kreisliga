package manager;

import java.util.Random;

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
	//Team Werte
	private String team;
	private String position;
	
	public Spieler() {
		//neutrale Werte
		this.setGeschwindigkeit(this.randomInteger());
		this.setZweikampf(this.randomInteger());
		this.setStellungsspiel(this.randomInteger());
		this.setAusdauer(this.randomInteger());
		this.setKopfball(this.randomInteger());
		//mentale Werte
		this.setMoral(this.randomInteger());
		this.setSelbstbewusstsein(this.randomInteger());
		this.setDisziplin(this.randomInteger());
		this.setAggresivitat(this.randomInteger());
		//defensive Werte
		this.setAntizipation(this.randomInteger());
		this.setTorwart(this.randomInteger());
		//offensive Werte
		this.setSchuss(this.randomInteger());
		this.setFreistoss(this.randomInteger());
		this.setPass(this.randomInteger());
		this.setDribbling(this.randomInteger());
		this.setFlanken(this.randomInteger());
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
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	private int randomInteger(){
		Random r = new Random();
		int Low = 1;
		int High = 100;
		int Result = r.nextInt(High+1-Low) + Low;
		return Result;
	}
	
	private int randomIntegerbetween(int Low, int High){
		Random r = new Random();
		int Result = r.nextInt(High+1-Low) + Low;
		return Result;
	}
}
