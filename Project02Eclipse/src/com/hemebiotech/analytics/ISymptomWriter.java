package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Anything that will write symptoms data to a source
 */
public interface ISymptomWriter {
    /**
     * Write the symptoms to a file
     * @param symptoms Map of symptoms sorted in alphabetical order
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}