package com.hemebiotech.analytics;

/**
 * Main class to start application
 * @author Rachik
 *
 */

public class StartApplication {

	public static void main(String[] args) {


		
		ISymptomReader reader = new ReadSymptomDataFromFile("ressources/symptoms.txt");
		
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.setReader(reader);
		
		System.out.println(" Liste des symptomes" + analyticsCounter.getListSymptoms());

	}

}
