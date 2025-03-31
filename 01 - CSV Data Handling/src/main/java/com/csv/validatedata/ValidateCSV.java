package com.csv.validatedata;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class ValidateCSV {
    public static void validate(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (!Regex.validateEmail(line[2]) || !Regex.validatePhone(line[3])) {
                    System.out.println(Arrays.toString(line));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
