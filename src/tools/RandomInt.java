package tools;

import java.util.Random;

public class RandomInt {
	
	public int randomInteger(){
		Random r = new Random();
		int low = 0;
		int high = 100;
		int result = r.nextInt(high+1-low) + low;
		return result;
	}

	public int randomIntegerbetween(int low, int high){
		Random r = new Random();
		int result = r.nextInt(high+1-low) + low;
		return result;
	}
	
	// nur positive Werte für die Spieler Eigenschaften
	public int randomIntegerGauss(int average){
		Random r = new Random();
		int result = (int) (r.nextGaussian()*average/10 + average);
		while(true){
			if(result > 0 && result <= 100){
				break;
			}
			else{
				result = (int) (r.nextGaussian()*average/10 + average);
			}
		}
		return result;
	}
	
	// nur positive Werte für die Spieler Eigenschaften
	public int randomIntegerGauss(int average, int deviation){
		Random r = new Random();
		int result = (int) (r.nextGaussian()*deviation + average);
		while(true){
			if(result > 0 && result <= 100){
				break;
			}
			else{
				result = (int) (r.nextGaussian()*deviation + average);
			}
		}
		return result;
	}
	
	public int randomIntegerGaussbetween(int average, int deviation, int low, int high){
		Random r = new Random();
		int result = (int) (r.nextGaussian()*deviation + average);
		while(true){
			if(result >= low && result <= high){
				break;
			}
			else{
				result = (int) (r.nextGaussian()*deviation + average);
			}
		}
		return result;
	}
}
