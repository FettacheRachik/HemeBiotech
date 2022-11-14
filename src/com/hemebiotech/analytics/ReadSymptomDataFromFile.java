package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hemebiotech.analytics.exceptions.FileEmptyException;
import com.hemebiotech.analytics.exceptions.NotAllowedCharacterException;

/**
 * Implements ISymptomReader
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Constructor
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *  one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	
	/**
	 * Getter
	 * @return
	 */
	public String getFilepath() {
		return filepath;
	}
	
	/**
	 * Setter
	 * @param filepath
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}





	@Override
	public List<String> getSymptoms() {
		
		//Liste contenant les symptomes
		ArrayList<String> listSymptoms = new ArrayList<String>();
		
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath))){
				
				String line = reader.readLine();
				
				
				//Test si fichier est vide
				if (line == null) {
					throw new FileEmptyException("Le fichier est vide");
				}
				
				//Lecture ligne par ligne 
				while (line != null) {
					
					//Verifier les lignes
					if (line.matches(".*\\d.*") || line.trim().length() ==0) {
						throw new NotAllowedCharacterException("Contenu du fichier est invalide");
					
					}else {
							//Ajouter les lignes a la liste de symptomes
							listSymptoms.add(line);
							line = reader.readLine();	
					}
				
					
				}
				
			} catch (IOException | FileEmptyException | NotAllowedCharacterException e) {
				e.printStackTrace();
			}
		}
		
		return listSymptoms;
	}
	
	
	
		

}
