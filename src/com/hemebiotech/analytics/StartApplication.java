package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class to start application
 * @author Rachik
 *
 */

public class StartApplication {

	public static void main(String[] args) {


		//Créer un objet ISymptomReader
		ISymptomReader reader = new ReadSymptomDataFromFile("ressources/symptoms.txt");
		
		//Creer un objet AnalyticsCounter
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.setReader(reader);
		
		//List des Symptomes
		List<String> listeSymptoms= analyticsCounter.getListSymptoms();
		
		//Compter avec une Map les occurences de chaque symptome
		Map <String,Integer> countSymptoms = analyticsCounter.countSymptoms(listeSymptoms);
		
		
		
		//Ordonner les Symptomes
		Map<String,Integer> orderSymptoms = analyticsCounter.orderSymptoms(countSymptoms);
				
				
		//Ecrire dans un fichier les symptomes
		ISymptomWrite writer = new WriteSymptomsToFile("ressources/output.txt");
		analyticsCounter.setWriter(writer);
		writer.writeSymptoms(orderSymptoms);
		
		

	}

}
