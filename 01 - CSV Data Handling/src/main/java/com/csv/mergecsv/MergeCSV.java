package com.csv.mergecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MergeCSV {
    public static void merge (String file1, String file2) {
        List<String[]> data = new ArrayList<>();
        try (
            CSVReader csv1 = new CSVReader(new FileReader(file1));
            CSVReader csv2 = new CSVReader(new FileReader(file2));
        ) {
            data.add(new String[]{"id", "name", "age", "marks", "grade"});
            String[] line1;

            csv1.readNext();
            while ((line1 = csv1.readNext()) != null) {
                data.add(new String[]{line1[0], line1[1], line1[2], "", ""});
            }

            String[] line2;
            csv2.readNext();
            while ((line2 = csv2.readNext()) != null) {
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i)[0].equals(line2[0])) {
                        data.get(i)[3] = line2[1];
                        data.get(i)[4] = line2[2];
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("src/main/java/com/csv/mergecsv/content/output.csv"))) {
            csvWriter.writeAll(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
