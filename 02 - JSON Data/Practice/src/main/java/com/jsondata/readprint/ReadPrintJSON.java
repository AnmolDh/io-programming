package com.jsondata.readprint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class ReadPrintJSON {
    public static void main(String[] args) {
        String json = "{\"name\": \"Alice\", \"age\": 25}";
        try {
            JSONObject obj = new JSONObject(json);

            for (String key : obj.keySet()) {
                System.out.println(key + ": " + obj.get(key));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
