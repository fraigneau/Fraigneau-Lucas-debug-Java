package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileNotFoundException;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * Setter 
	 * @param fp a full or partial path to file with symptom strings in it, one per
	 *           line
	 */
	public ReadSymptomDataFromFile(String fp) {
		this.filepath = fp;
	}

	@Override
	/**
	 * @return List<String> list of symptoms
	 */
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e){
				System.err.println("The specified file was not found.");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
