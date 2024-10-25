package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;	

	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public static void main(String args[]) throws Exception {


		ReadSymptomDataFromFile mon_instance = new ReadSymptomDataFromFile("symptoms.txt");
		mon_instance.GetSymptoms();
		
		WriteSymptomDataToFile mon_output = new WriteSymptomDataToFile("result.out");

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

		// generate and write result.out 
		Map<String, Integer> check_symptom = new HashMap<>();
		check_symptom.put("headache", headacheCount);
		check_symptom.put("rash", rashCount);
		check_symptom.put("pupils", pupilCount);
		mon_output.writeSymptoms(check_symptom);

        reader.close(); 
	}
}
