package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
/**
 *
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Get symptoms from the reader
	 * 
	 * @return List of symptoms
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Count the number of occurrences of each symptom
	 * 
	 * @param symptoms List of symptoms
	 * @return Map of symptoms with their occurrences
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countMap = new HashMap<>();
		symptoms.forEach(symptom -> countMap.put(symptom, countMap.getOrDefault(symptom, 0) + 1));
		return countMap;
	}

	/**
	 * Sort the symptoms in alphabetical order
	 * 
	 * @param symptoms Map of symptoms with their occurrences
	 * @return Map of symptoms sorted in alphabetical order
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortMap = new TreeMap<>(symptoms);
		return sortMap;
	}

	/**
	 * Write the symptoms to the writer
	 * 
	 * @param symptoms Map of symptoms sorted in alphabetical order
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
