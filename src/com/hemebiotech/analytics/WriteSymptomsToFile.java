package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomsToFile implements ISymptomWrite {
	
	private String filePath;
	
	
	//Constructor
	public WriteSymptomsToFile(String filePath) {
	this.filePath =filePath;
	}



	@Override
	public void writeSymptoms(Map<String, Integer> symptomes)  {
		
		
		try (FileWriter fileWriter = new FileWriter(filePath, false);
				BufferedWriter writer = new BufferedWriter(fileWriter);)

		{

			for (Map.Entry mapentry : symptomes.entrySet()) {
				writer.write(mapentry.getKey() + " : " + mapentry.getValue());
	
				writer.newLine();

			}

		} catch (IOException e) {
			System.err.println (e.getMessage());
		}
			      
		
		
	}

}
