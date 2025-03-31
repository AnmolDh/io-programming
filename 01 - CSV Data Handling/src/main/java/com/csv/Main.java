package com.csv;

import com.csv.convertcsv.ConvertCSV;
import com.csv.convertcsv.Student;
import com.csv.countrows.CountRowsCSV;
import com.csv.filterrecords.FilterCSV;
import com.csv.mergecsv.MergeCSV;
import com.csv.modifyrecord.ModifyCSV;
import com.csv.readcsv.ReadCSV;
import com.csv.searchrecord.SearchCSV;
import com.csv.sortrecords.SortCSV;
import com.csv.validatedata.Regex;
import com.csv.validatedata.ValidateCSV;
import com.csv.writecsv.WriteCSV;

import java.util.ArrayList;
import java.util.List;

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

//        SearchCSV.search("src/main/java/com/csv/searchrecord/content/Employee.csv", "IDK");

//        ModifyCSV.modify("src/main/java/com/csv/modifyrecord/content/Employee.csv");

//        SortCSV.sort("src/main/java/com/csv/sortrecords/content/Employee.csv");

//        ValidateCSV.validate("src/main/java/com/csv/validatedata/content/Contact.csv");

//        List<Student> list = ConvertCSV.convertToObjects("src/main/java/com/csv/convertcsv/content/Student.csv", Student.class);
//        System.out.println(list);

        MergeCSV.merge("src/main/java/com/csv/mergecsv/content/students1.csv", "src/main/java/com/csv/mergecsv/content/students2.csv");
    }
}