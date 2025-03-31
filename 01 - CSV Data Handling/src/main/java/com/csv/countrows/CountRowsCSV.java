package com.csv.countrows;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CountRowsCSV {
    public static void count(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            int count = -1;
            while (reader.readNext() != null) {
                count++;
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
