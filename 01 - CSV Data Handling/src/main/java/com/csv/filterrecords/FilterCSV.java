package com.csv.filterrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class FilterCSV {
    public static void filter (String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext();
            int marksColumn = 3;
            while ((line = reader.readNext()) != null) {
                if (Integer.parseInt(line[marksColumn]) >= 80) {
                    System.out.println(Arrays.toString(line));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
