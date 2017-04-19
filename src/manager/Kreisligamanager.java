package manager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Map;

import simulation.*;
import tools.*;


public class Kreisligamanager {

	private static PrintStream p = System.out;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Spiel test = new Spiel();
		int Heimtore = 0;
		int Auswaertstore = 0;

		
//		for (int i = 0; i < 10; i++){
//			Spiel test = new Spiel();
//			Team Heimteam = new Team("SC Hille");
//			Team Auswaertsteam = new Team();
//			test.spielsimulation(Heimteam, Auswaertsteam);
//			Auswaertstore += test.getAuswaertsteamTore();
//			Heimtore += test.getHeimteamTore();
//		}
//		p.println("GESAMT: " + Heimtore + " : " + Auswaertstore);
		
		Team Heimteam = new Team();
		Team Auswaertsteam = new Team();
		
		File f = new File("C:\\Kreisliga\\Heim.ser");
		if(f.exists() && !f.isDirectory()) { 
			try {
		         FileInputStream fileIn = new FileInputStream("C:\\Kreisliga\\Heim.ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         Heimteam = (Team) in.readObject();
		         in.close();
		         fileIn.close();
		         p.println("Heimteam geladen");
		      }catch(IOException i) {
		         i.printStackTrace();
		         return;
		      }catch(ClassNotFoundException c) {
		         System.out.println("Team class not found");
		         c.printStackTrace();
		         return;
		      }
		}
		else {
			Heimteam = new Team("SC Hille");
			p.println("Heimteam erstellt");
		}
		
		File f2 = new File("C:\\Kreisliga\\Weg.ser");
		if(f2.exists() && !f2.isDirectory()) { 
			try {
		         FileInputStream fileIn = new FileInputStream("C:\\Kreisliga\\Weg.ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         Auswaertsteam = (Team) in.readObject();
		         in.close();
		         fileIn.close();
		         p.println("Auswaertsteam geladen");
		      }catch(IOException i) {
		         i.printStackTrace();
		         return;
		      }catch(ClassNotFoundException c) {
		         System.out.println("Team class not found");
		         c.printStackTrace();
		         return;
		      }
		}
		else {
			Auswaertsteam = new Team();
			p.println("Auswaertsteam erstellt");
		}
		

Spieler TestBoy = Heimteam.getPlayer();

p.println(TestBoy.getName());
		
		
		
		
		
		
		
		
		
		
		
//	test.spielsimulation(Heimteam, Auswaertsteam);
	//	Auswaertstore += test.getAuswaertsteamTore();
	//	 Heimtore += test.getHeimteamTore();		
		
		
	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("C:\\Kreisliga\\Heim.ser");
	          ObjectOutputStream out = new ObjectOutputStream(fileOut);
	          out.writeObject(Heimteam);
	          out.close();
	          fileOut.close();
	          p.println("Serialized data is saved in C\\Kreisliga\\Heim.ser");
	       }catch(IOException i) {
	          i.printStackTrace();
	       }


	      try {
	          FileOutputStream fileOut =
	          new FileOutputStream("C:\\Kreisliga\\Weg.ser");
	          ObjectOutputStream out = new ObjectOutputStream(fileOut);
	          out.writeObject(Auswaertsteam);
	          out.close();
	          fileOut.close();
	          p.println("Serialized data is saved in C\\Kreisliga\\Weg.ser");
	       }catch(IOException i) {
	          i.printStackTrace();
	       }

	      
	      
	      
	      
	      

	}



}

