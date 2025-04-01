package com.jsondata.studentdata;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentDataJSON {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "John");
        student.put("age", 23);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Maths");
        jsonArray.put("English");

        student.put("subjects", jsonArray);

        System.out.println(student.toString());
    }
}
