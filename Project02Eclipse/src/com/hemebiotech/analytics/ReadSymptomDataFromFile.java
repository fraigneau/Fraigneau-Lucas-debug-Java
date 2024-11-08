package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileNotFoundException;
/**
 * Read symptoms from a file
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	/**
	 * Set the filepath to read from
	 * @param fp Filepath to read from
	 */
	public ReadSymptomDataFromFile(String fp) {
		this.filepath = fp;
		System.out.println("Filepath set to: " + fp); // Debugging statement
	}

	@Override
	/**
	 * Read symptoms from a file
	 * @return List of symptoms
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		System.out.println("GetSymptoms called"); // Debugging statement

		if (filepath != null) {
			try {
				System.out.println("Attempting to read file: " + filepath); // Debugging statement
				BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				System.out.println("File read successfully"); // Debugging statement
			} catch (FileNotFoundException e){
				System.err.println("The specified file was not found."); // Debugging statement
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
