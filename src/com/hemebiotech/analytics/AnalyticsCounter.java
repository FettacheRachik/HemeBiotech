package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Read ,List , Count , order Symptoms from an object ISymptomReader
 */

public class AnalyticsCounter {
	
	
	private ISymptomReader reader;
	private ISymptomWrite writer;
	
	/*
	 * setter and Getter
	 */
	public ISymptomReader getReader() {
		return reader;
	}

	public void setReader(ISymptomReader reader) {
		this.reader = reader;
		
	}
	
	

	public ISymptomWrite getWriter() {
		return writer;
	}

	public void setWriter(ISymptomWrite writer) {
		this.writer = writer;
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

	
	/**
	 * Method to count Symptoms
	 * @param listeSymptomes
	 * @return une Map with clé:symptoms and valeur:nombre d 'occurence du symptome
	 */
	public Map<String, Integer> countSymptoms(List<String> listSymptomes) {

		Map<String, Integer> mapSymptomes = new HashMap<>();

		for (String symptome : listSymptomes) {
			mapSymptomes.putIfAbsent(symptome, 0);
			mapSymptomes.put(symptome, mapSymptomes.get(symptome) + 1);
		}

		return mapSymptomes;

	}
	
	
	/**
	 * Method to class symptoms
	 * @param mapSymptomes type Map<String,Integer>
	 * @return TreeMap
	 */
	public Map<String, Integer> orderSymptoms(Map<String, Integer> mapSymptomes) {

		Map<String, Integer> orderSymptoms = new TreeMap<String, Integer>(mapSymptomes);
		return orderSymptoms;
	}
	
	/**
	 * Method to writer symptoms with numbers of occurence in a file
	 * @param mapOrderSymptoms
	 */
	public void writeSymptoms (Map <String,Integer> mapOrderSymptoms) {
		
		
		this.writer.writeSymptoms(mapOrderSymptoms);
	}

}





	
