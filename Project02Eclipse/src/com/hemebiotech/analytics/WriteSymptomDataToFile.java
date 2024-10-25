package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;
    /**
     * 
     * @param fp path du fichier quón doit ouvrir pour écriture
     */
    public WriteSymptomDataToFile (String fp) {
        this.filepath = fp;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) { 
         
        if (filepath != null) {
            try {
                FileWriter writer = new FileWriter (filepath);
                for(Map.Entry<String, Integer> symptom : symptoms.entrySet())
                {
                writer.write("Key = " + symptom.getKey() + " et la valeur : " + symptom.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }  
        } 
    }
}
