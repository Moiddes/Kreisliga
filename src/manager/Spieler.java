package manager;

public class Spieler {

	private int speed;
	private int strength;
	private int morale;



	public Spieler() {
		this.setSpeed(50);
		this.setStrength(50);
		this.setMorale(50);
	}

	public Spieler( int speed, int strength, int morale) {
		this.setSpeed(speed);
		this.setStrength(strength);
		this.setMorale(morale);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getMorale() {
		return morale;
	}

	public void setMorale(int morale) {
		this.morale = morale;
	}	

}
