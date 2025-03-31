package com.csv.sortrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortCSV {
    public static void sort(String filePath) {
        ArrayList<String[]> csvData = new ArrayList<String[]>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                csvData.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Collections.sort(csvData, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Double.compare(Double.parseDouble(o2[3]), Double.parseDouble(o1[3]));
            }
        });

        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(csvData.get(i)));
        }
    }
}
