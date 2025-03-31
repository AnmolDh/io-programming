package com.csv.writecsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class WriteCSV {
    public static void write(ArrayList<String[]> data, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                String line = String.join(",", row);
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
