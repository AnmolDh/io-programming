package com.csv.searchrecord;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class SearchCSV {
    public static void search(String filePath, String employeeToSearch) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            csvReader.readNext();
            String[] line;
            int nameColumn = 1;
            while ((line = csvReader.readNext()) != null) {
                if (line[nameColumn].equals(employeeToSearch)) {
                    System.out.println(Arrays.toString(line));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
