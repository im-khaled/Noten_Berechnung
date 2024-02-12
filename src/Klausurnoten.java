/*
 * Author: Khaled M.
 * Years: 2022
 */
public class Klausurnoten {

	public static void verarbeiteKlausurPunktzahl (int [] punkte, int [] punktGrenzen ) {
		
		int [] sPunkte = new int [punkte.length];
			
		int anzahl = punkte.length;
		double gesamtepunk = 0;
		double durschnitpunkte = 0.0;
		
		int note1 = 0;
		int note2 = 0;
		int note3 = 0;
		int note4 = 0;
		int note5 = 0;
		
		int besteN = 0;
		int slechsteN = 0;
		
		int bestanden = 0;
		int Nbestanden = 0;
		
		
		for (int i=0; i<punkte.length; i++) {
			gesamtepunk += punkte[i];
			
		}
		durschnitpunkte = gesamtepunk/punkte.length;
		
		//Note ermitteln aus der Punkte
		for (int i=0; i<punkte.length; i++) {

			if (punkte[i] > punktGrenzen[3]) {
				punkte[i] = 1;
			}
			else if (punkte[i] > punktGrenzen[2] && punkte[i] <= punktGrenzen[3]  ) {
				punkte[i] = 2;
			}
			else if (punkte[i] >punktGrenzen[1]  && punkte[i] <= punktGrenzen[2] ) {
				punkte[i] = 3;
			}
			else if (punkte[i] >punktGrenzen[0] && punkte[i] <= punktGrenzen[1] ) {
				punkte[i] = 4;
			}
			else  {
				punkte[i] = 5;
			}
		}
		
		for (int i=0; i<punkte.length; i++) {
			if (punkte[i] == 1)
				note1 ++;
			else if (punkte[i] == 2)
				note2 ++;
			else if (punkte[i] == 3)
				note3 ++;
			else if (punkte[i] == 4)
				note4 ++;
			else 
				note5 ++;
		}
		
		// Bestanden und Nicht Bestanden bestimmen
		for (int i=0; i<punkte.length; i++) {
			if (punkte[i] < 5)
				bestanden++;
			if (punkte[i] == 5)
				Nbestanden++;
		}
		
		for (int i=0; i<punkte.length; i++) {
			sPunkte[i] = punkte[i];
			
		}
		
		//beste Note ermitteln
		for (int i=0; i<punkte.length; i++) {
			if (i<punkte.length-1) { 
				if (punkte[i]<punkte[i+1]) {
					besteN = punkte[i];
					punkte[i+1] = besteN;
				}
			}
			if (i<punkte.length-1) { 
					if (punkte[i]<punkte[i+1]) {
						besteN = punkte[i];
					}
			}
		}
		
		//Slechste Note ermitteln
		for (int i=0; i<sPunkte.length; i++) {
			if (i<sPunkte.length-1) { 
				if (sPunkte[i]>sPunkte[i+1]) {
					slechsteN = sPunkte[i];
					sPunkte[i+1] = slechsteN;
				}
			}
			if (i<sPunkte.length-1) { 
					if (sPunkte[i]>sPunkte[i+1]) {
						slechsteN = sPunkte[i];
					}
			}
		}
	
		//Bildschirm Ausgeben
		System.out.println(anzahl);
		System.out.println(besteN+" "+slechsteN);
		System.out.println(bestanden+" "+Nbestanden);
		System.out.println(durschnitpunkte);
		System.out.println(1+" "+note1);
		System.out.println(2+" "+note2);
		System.out.println(3+" "+note3);
		System.out.println(4+" "+note4);
		System.out.println(5+" "+note5);
	
	}
	public static void main(String[] args) {
		
		int [] punkte = {30, 74, 81, 67, 95, 65};
		int [] punktGrenzen = {59, 69, 79, 89};

		 verarbeiteKlausurPunktzahl(punkte, punktGrenzen);
		
	}
}
