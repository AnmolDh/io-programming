package com.csv;

import com.csv.readcsv.ReadCSV;
import com.csv.writecsv.WriteCSV;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ReadCSV.read("src/main/java/com/csv/readcsv/content/Student.csv");

        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(new String[] { "ID", "Name", "Dept", "Salary" });
        data.add(new String[] { "1", "Anmol", "IT", "0" });
        data.add(new String[] { "2", "IDK", "CSE", "10" });
        WriteCSV.write(data, "src/main/java/com/csv/writecsv/content/Employee.csv");
    }
}