package tools;


public class Vergleich {
	
	public int RationX(int x, int y){
		return ((int) ((double) x/(double) x + (double) y));
	}
	
	public boolean StringEquals(String first, String...strings){
		boolean isEqual = false;
		for(int i = 0; i < strings.length; i++){
			if (strings[i] == first){
				isEqual = true;
			}
		}
		return isEqual;
	}
}
