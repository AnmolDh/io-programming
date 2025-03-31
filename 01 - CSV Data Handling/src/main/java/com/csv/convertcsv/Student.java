package com.csv.convertcsv;

import com.opencsv.bean.CsvBindByName;

public class Student {
    @CsvBindByName(column = "ID")
    private int id;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Age")
    private int age;

    @CsvBindByName(column = "Grade")
    private String grade;

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }
}