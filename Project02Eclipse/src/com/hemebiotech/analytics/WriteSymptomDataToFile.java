package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * 
     * @param fp of the file that must be opened for writing
     */
    public WriteSymptomDataToFile(String fp) {
        this.filepath = fp;
    }

    @Override
    /**
     * @param List sorts symptoms and their number of occurrences
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {

        if (filepath != null) {
            try {
                FileWriter writer = new FileWriter(filepath);
                for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
                    writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
