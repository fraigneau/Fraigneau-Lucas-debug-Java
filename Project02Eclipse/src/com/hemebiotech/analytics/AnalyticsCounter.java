package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * input and output filles
	 * 
	 * @param reader fp for input doc
	 * @param writer fp for output doc
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * 
	 * @return list of symptoms
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * Compiles all duplicates and notes the number of repetitions
	 * 
	 * @param List<String>
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countMap = new HashMap<>();
		for (String symptom : symptoms) {
			if (countMap.containsKey(symptom)) {
				countMap.put(symptom, countMap.get(symptom) + 1);
			} else {
				countMap.put(symptom, 1);
			}
		}
		return countMap;
	}

	/**
	 * sort alphabetically by symptoms
	 * 
	 * @param Map<String, Integer>
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortMap = new TreeMap<>(symptoms);
		return sortMap;
	}

	/**
	 * manages writing to the output file
	 * 
	 * @param Map<String, Integer>
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
