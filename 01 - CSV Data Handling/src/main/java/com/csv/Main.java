package com.csv;

import com.csv.countrows.CountRowsCSV;
import com.csv.filterrecords.FilterCSV;
import com.csv.readcsv.ReadCSV;
import com.csv.searchrecord.SearchCSV;
import com.csv.writecsv.WriteCSV;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ReadCSV.read("src/main/java/com/csv/readcsv/content/Student.csv");

//        ArrayList<String[]> data = new ArrayList<String[]>();
//        data.add(new String[] { "ID", "Name", "Dept", "Salary" });
//        data.add(new String[] { "1", "Anmol", "IT", "0" });
//        data.add(new String[] { "2", "IDK", "CSE", "10" });
//        WriteCSV.write(data, "src/main/java/com/csv/writecsv/content/Employee.csv");

//        CountRowsCSV.count("src/main/java/com/csv/countrows/content/Employee.csv");

//        FilterCSV.filter("src/main/java/com/csv/filterrecords/content/Student.csv");

        SearchCSV.search("src/main/java/com/csv/searchrecord/content/Employee.csv", "IDK");
    }
}