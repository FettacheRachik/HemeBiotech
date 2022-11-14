package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
* 
* A partir d'une Map triée et ordonnée, ecrire dans un fichier les items de la map
* 
* */
public interface ISymptomWrite {
	
	/**
	 * 
	 * @param Liste of symptomes
	 * 
	 */
	public void writeSymptoms (Map <String,Integer> symptomes);

}
