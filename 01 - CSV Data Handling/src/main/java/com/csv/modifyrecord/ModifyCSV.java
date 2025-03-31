package com.csv.modifyrecord;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSV {
    public static void modify(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                if (line[2].equals("IT")){
                    double salary = Double.parseDouble(line[3]);
                    salary *= 1.10;
                    line[3] = String.format("%.2f", salary);
                }
                records.add(line);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            csvWriter.writeAll(records);
            System.out.println("Updated file saved as " + filePath);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
