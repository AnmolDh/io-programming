package com.csv.converter;

import com.csv.converter.Student;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {
    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            List<Student> students = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.replace("{", "").replace("}", "").replace("\"", "").split(",");
                Student student = new Student();
                for (String part : parts) {
                    String[] keyValue = part.split(":");
                    switch (keyValue[0].trim()) {
                        case "id": student.id = Integer.parseInt(keyValue[1].trim()); break;
                        case "name": student.name = keyValue[1].trim(); break;
                        case "department": student.department = keyValue[1].trim(); break;
                        case "salary": student.salary = Double.parseDouble(keyValue[1].trim()); break;
                    }
                }
                students.add(student);
            }

            String[] header = {"ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            for (Student student : students) {
                String[] data = {
                        String.valueOf(student.id),
                        student.name,
                        student.department,
                        String.valueOf(student.salary)
                };
                writer.writeNext(data);
            }
            System.out.println("JSON converted to CSV: " + csvFilePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void csvToJson(String csvFilePath, String jsonFilePath) {
        List<String> jsonLines = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath))) {

            String[] nextLine;
            reader.readNext(); // Skip header

            while ((nextLine = reader.readNext()) != null) {
                String json = String.format("{\"id\":%s, \"name\":\"%s\", \"department\":\"%s\", \"salary\":%s}",
                        nextLine[0], nextLine[1], nextLine[2], nextLine[3]);
                jsonLines.add(json);
            }

            writer.write("[" + String.join(",", jsonLines) + "]");
            System.out.println("CSV converted to JSON: " + jsonFilePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
