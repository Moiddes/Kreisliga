package tools;

import java.util.Random;

public class RandomInt {
	
	public int randomInteger(){
		Random r = new Random();
		int Low = 1;
		int High = 100;
		int Result = r.nextInt(High+1-Low) + Low;
		return Result;
	}

	public int randomIntegerbetween(int Low, int High){
		Random r = new Random();
		int Result = r.nextInt(High+1-Low) + Low;
		return Result;
	}
}
