package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {

		String filePath = "symptoms.txt";
		BufferedReader reader = new BufferedReader (new FileReader(filePath));
		String line = reader.readLine();

		//int i = 0;
		while (line != null) {
			//i++;
			//System.out.println("Line : " + i + "  symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		// log 
		System.out.println("number of headache: " + headacheCount);
		System.out.println("number of rash: " + rashCount);
		System.out.println("number of pupils: " + pupilCount);

		// generate and write result.txt 
		FileWriter writer = new FileWriter ("result.txt");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
        reader.close(); 
	}
}
