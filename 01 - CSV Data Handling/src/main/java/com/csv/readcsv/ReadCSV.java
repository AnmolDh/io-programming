package com.csv.readcsv;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {
    public static void read(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println(columns[0] + " " + columns[1] + " " + columns[2] + " " + columns[3]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
