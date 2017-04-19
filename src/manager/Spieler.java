package manager;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import tools.*;

public class Spieler implements java.io.Serializable {

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
	//Eigenschaften
	private GregorianCalendar geburtstag;
	private int alter;
	private String fuss; //m�gliche Werte (links, rechts, beidf��ig)
	//Team Werte
	private String team;
	private String position; //m�gliche Werte ("TW", "LI", "IV", "MD", "LV", "RV", "DM", "LM", "ZM", "OM", "RM", "ST")
	private String favPosition;
	private String firstname;
	private String lastname;
	//sim Werte	
	private boolean busy;
	
	//interne Werte f�r Positionen
	private float TW;
	private float LI;
	private float MD;
	private float IV;
	private float LV;
	private float RV;
	private float DM;
	private float LM;
	private float ZM;
	private float RM;
	private float OM;
	private float ST;

	static RandomInt r = new RandomInt();

	public Spieler(String firstname, String lastname) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPosition("RES");
		this.setBusy(false);
		this.setRandomFuss();
		this.setRandomGeburtstag();
		this.updateAlter();

		this.setValues(50, 20);

		this.updateFavPosition();

	}

	public Spieler(String firstname, String lastname, String bestPosition) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPosition("RES");
		this.setBusy(false);
		this.setRandomFuss();
		this.setRandomGeburtstag();
		this.updateAlter();

		switch(bestPosition){
		case("TW"):
			this.setValues(30, 20);
			this.setAntizipation(r.randomIntegerGauss(50, 20));
			this.setTorwart(r.randomIntegerGauss(60, 10));
			break;
		case "LI":
			this.setValues(40, 20);
			this.setStellungsspiel(r.randomIntegerGauss(60, 10));
			this.setAntizipation(r.randomIntegerGauss(60, 10));
			this.setZweikampf(r.randomIntegerGauss(60, 10));
			break;
		case "MD":
			this.setValues(40, 20);
			this.setStellungsspiel(r.randomIntegerGauss(60, 10));
			this.setGeschwindigkeit(r.randomIntegerGauss(60, 10));
			this.setZweikampf(r.randomIntegerGauss(60, 10));
			break;
		case "IV":
			this.setValues(40, 20);
			this.setStellungsspiel(r.randomIntegerGauss(60, 10));
			this.setAntizipation(r.randomIntegerGauss(60, 10));
			this.setGeschwindigkeit(r.randomIntegerGauss(60, 10));
			this.setZweikampf(r.randomIntegerGauss(60, 10));
			break;
		case "LV": case "RV":
			this.setValues(40, 20);
			this.setGeschwindigkeit(r.randomIntegerGauss(60, 10));
			this.setZweikampf(r.randomIntegerGauss(60, 10));
			this.setFlanken(r.randomIntegerGauss(60, 10));
			break;
		case "DM":
			this.setValues(40, 20);
			this.setPass(r.randomIntegerGauss(60, 10));
			this.setZweikampf(r.randomIntegerGauss(60, 10));
			this.setAusdauer(r.randomIntegerGauss(60, 10));
			break;
		case "LM": case "RM":
			this.setValues(40, 20);
			this.setGeschwindigkeit(r.randomIntegerGauss(60, 10));
			this.setPass(r.randomIntegerGauss(60, 10));
			this.setFlanken(r.randomIntegerGauss(60, 10));
			break;
		case "ZM":
			this.setValues(40, 20);
			this.setAusdauer(r.randomIntegerGauss(60, 10));
			this.setPass(r.randomIntegerGauss(60, 10));
			this.setSchuss(r.randomIntegerGauss(60, 10));
			break;
		case "OM":
			this.setValues(40, 20);
			this.setDribbling(r.randomIntegerGauss(60, 10));
			this.setPass(r.randomIntegerGauss(60, 10));
			this.setSchuss(r.randomIntegerGauss(60, 10));
			break;
		case "ST":
			this.setValues(40, 20);
			this.setDribbling(r.randomIntegerGauss(60, 10));
			this.setKopfball(r.randomIntegerGauss(60, 10));
			this.setSchuss(r.randomIntegerGauss(60, 10));
			break;
		default:
			this.setValues(50, 20);
		}
		this.updateFavPosition();
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

	private void setRandomFuss(){
		int decider = r.randomInteger();
		if (decider > 25){
			this.setFuss("rechts");
		}
		else if(decider <= 25 && decider > 10){
			this.setFuss("rechts");
		}
		else{
			this.setFuss("beidf��ig");
		}
	}
	
	public int getAlter() {
		return alter;
	}
	
	public void updateAlter(){
       
        GregorianCalendar today = new GregorianCalendar(); //TODO aktuelles Spiel Datum einf�gen
       
        int year = today.get(GregorianCalendar.YEAR) - geburtstag.get(GregorianCalendar.YEAR);
       
        if(today.get(GregorianCalendar.MONTH) <= geburtstag.get(GregorianCalendar.MONTH))
        {
            if(today.get(GregorianCalendar.DATE) < geburtstag.get(GregorianCalendar.DATE))
            {
                year -= 1;
            }
        }
       
        if(year < 0)
            throw new IllegalArgumentException("invalid age: "+year);
       
        this.alter = year;
	}
	
	public GregorianCalendar getGeburtstag() {
		return geburtstag;
	}
		
	public void setGeburtstag(GregorianCalendar geburtstag) {
		this.geburtstag = geburtstag;
	}

	private void setRandomGeburtstag(){ //TODO GregorianCalender nimmt f�r dezember 0 als R�ckgabewert... evtl andere Klasse verwenden (JODA TIME)
		int jahr = r.randomIntegerGaussbetween(1990, 6, 1970, 1999); //TODO muss vom aktuellen Datum im Spiel abh�ngen
		int monat = r.randomIntegerbetween(12, 12);
		int tag = 1;
		switch(monat){
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			tag = r.randomIntegerbetween(1, 31);
			break;
		case 4: case 6: case 9: case 11:
			tag = r.randomIntegerbetween(1, 30);
			break;
		case 2:
			tag = r.randomIntegerbetween(1, 28);
			break;
		}
		this.geburtstag = new GregorianCalendar(jahr,monat,tag);
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
	
	public String getName(){
		return this.firstname + " " + this.lastname;
	}
	public String getNamePosition(){
		return this.firstname + " " + this.lastname + " (" + this.position + ")";
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
	private void setFavPosition(String favPosition) {
		this.favPosition = favPosition;
	}

	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}	

	public float getPositionValue(String string) {
		float value = 0;
		switch(string){
		case("TW"):
			value = this.TW;
		break;
		case "LI":
			value = this.LI;
			break;
		case "MD":
			value = this.MD;
			break;
		case "IV":
			value = this.IV;
			break;
		case "LV": 
			value = this.LV;
			break;
		case "RV":
			value = this.RV;
			break;
		case "DM":
			value = this.DM;
			break;
		case "LM": 
			value = this.LM;
			break;
		case "RM":
			value = this.RM;
			break;
		case "ZM":
			value = this.ZM;
			break;
		case "OM":
			value = this.OM;
			break;
		case "ST":
			value = this.ST;
			break;
		default:
			value = 0;
			break;
		}
		return value;
	}


	private void setValues(int average, int deviation){
		//metale Werte
		this.setMoral(50);
		this.setSelbstbewusstsein(r.randomIntegerGauss(50, 20));
		this.setDisziplin(r.randomIntegerGauss(50, 20));
		this.setAggresivitat(r.randomIntegerGauss(50, 20));
		//neutrale Werte
		this.setGeschwindigkeit(r.randomIntegerGauss(average, deviation));
		this.setZweikampf(r.randomIntegerGauss(average, deviation));
		this.setStellungsspiel(r.randomIntegerGauss(average, deviation));
		this.setAusdauer(r.randomIntegerGauss(average, deviation));
		this.setKopfball(r.randomIntegerGauss(average, deviation));
		//offensive Werte
		this.setSchuss(r.randomIntegerGauss(average, deviation));
		this.setFreistoss(r.randomIntegerGauss(average, deviation));
		this.setPass(r.randomIntegerGauss(average, deviation));
		this.setDribbling(r.randomIntegerGauss(average, deviation));
		this.setFlanken(r.randomIntegerGauss(average, deviation));
		//defensive Werte
		this.setAntizipation(r.randomIntegerGauss(average, deviation));
		this.setTorwart(r.randomIntegerGauss(average - 15, deviation));
	}

	private void setNeutralValues(int average, int deviation){
		//neutrale Werte
		this.setGeschwindigkeit(r.randomIntegerGauss(average, deviation));
		this.setZweikampf(r.randomIntegerGauss(average, deviation));
		this.setStellungsspiel(r.randomIntegerGauss(average, deviation));
		this.setAusdauer(r.randomIntegerGauss(average, deviation));
		this.setKopfball(r.randomIntegerGauss(average, deviation));
	}

	private void setOffensiveValues(int average, int deviation){
		//offensive Werte
		this.setSchuss(r.randomIntegerGauss(average, deviation));
		this.setFreistoss(r.randomIntegerGauss(average, deviation));
		this.setPass(r.randomIntegerGauss(average, deviation));
		this.setDribbling(r.randomIntegerGauss(average, deviation));
		this.setFlanken(r.randomIntegerGauss(average, deviation));
	}

	public void updateFavPosition(){
		this.TW = (float)(this.torwart);
		this.LI = (float)(this.stellungsspiel + this.antizipation + this.zweikampf)/3;
		this.MD = (float)(this.stellungsspiel + this.geschwindigkeit + this.zweikampf)/3;
		this.IV = (float)(this.stellungsspiel + this.antizipation + this.zweikampf + this.geschwindigkeit)/4;
		this.LV = (float)(this.geschwindigkeit + this.zweikampf + this.pass)/3;
		this.RV = (float)(this.geschwindigkeit + this.zweikampf + this.pass)/3;
		this.DM = (float)(this.pass + this.zweikampf + this.ausdauer)/3;
		this.LM = (float)(this.geschwindigkeit + this.flanken + this.pass)/3;
		this.RM = (float)(this.geschwindigkeit + this.flanken + this.pass)/3;
		this.ZM = (float)(this.pass + this.ausdauer + this.schuss)/3;
		this.OM = (float)(this.pass + this.schuss + this.dribbling)/3;
		this.ST = (float)(this.schuss + this.kopfball + this.dribbling)/3;
		
		Map<String, Float> positionValues = new HashMap<String, Float>();
		positionValues.put("TW", this.getPositionValue("TW"));
		positionValues.put("LI", this.getPositionValue("LI"));
		positionValues.put("MD", this.getPositionValue("MD"));
		positionValues.put("IV", this.getPositionValue("IV"));
		positionValues.put("LV/RV", this.getPositionValue("LV"));
		positionValues.put("DM", this.getPositionValue("DM"));
		positionValues.put("LM/RM", this.getPositionValue("LM"));
		positionValues.put("ZM", this.getPositionValue("ZM"));
		positionValues.put("OM", this.getPositionValue("OM"));
		positionValues.put("ST", this.getPositionValue("ST"));
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
