package com.jsondata.csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVtoJSON {
    public static void main(String[] args) {
        String csvFilePath = ""; // Path to your CSV file
        List<Map<String, String>> jsonList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] headers = reader.readNext(); // Read header row

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Map<String, String> jsonObject = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], nextLine[i]);
                }
                jsonList.add(jsonObject);
            }

            // Convert List of Maps to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
