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
		
		
		//Afficher la Map des occurences
		for(Map.Entry mapSymptoms:countSymptoms.entrySet()){  
			   System.out.println(mapSymptoms.getKey()+": "+mapSymptoms.getValue()); 
		}

	}

}
