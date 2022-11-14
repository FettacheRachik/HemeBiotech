package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

/*
 * Read ,List , Count , order Symptoms from an object ISymptomReader
 */

public class AnalyticsCounter {
	
	
	private ISymptomReader reader;
	
	/*
	 * setter and Getter
	 */
	public ISymptomReader getReader() {
		return reader;
	}

	public void setReader(ISymptomReader reader) {
		this.reader = reader;
		
	}

	/**
	 * Methode qui a partir du fichier contenant les symptomes , va les insérer dans une liste
	 * @return liste des Symptomes
	 */
	public List<String> getListSymptoms () {
		
		
		List <String> listeSymptoms = null;
		listeSymptoms= this.reader.getSymptoms();
		return listeSymptoms;
		
	}

	
}
