package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/**
 * Write symptoms to a file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;
    /**
     * Set the filepath to write to
     * @param fp Filepath to write to
     */
    public WriteSymptomDataToFile(String fp) {
        this.filepath = fp;
    }

    @Override
    /**
     * Write the symptoms to a file
     * @param symptoms Map of symptoms sorted in alphabetical order
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filepath != null) {
            try {
                FileWriter writer = new FileWriter(filepath);
                for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                    writer.write(symptom.getKey() + ": " + symptom.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
