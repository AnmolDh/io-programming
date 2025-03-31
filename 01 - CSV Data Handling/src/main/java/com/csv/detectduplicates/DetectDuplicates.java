package com.csv.detectduplicates;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void detect(String fileName) {
        Set<String> set = new HashSet<String>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (set.contains(line[0])) {
                    System.out.println(line[0] + "\t" + line[1]);
                }
                set.add(line[0]);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
