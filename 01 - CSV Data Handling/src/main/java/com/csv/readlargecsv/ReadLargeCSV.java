package com.csv.readlargecsv;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class ReadLargeCSV {
    public static void read(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] nextLine;
            int count = 0;
            int batchCount = 0;

            while ((nextLine = reader.readNext()) != null) {
                count++;
                System.out.println("Processing record: " + count);

                if (count % 100 == 0) {
                    batchCount++;
                    System.out.println("Processed " + (batchCount * 100) + " records so far...");
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
