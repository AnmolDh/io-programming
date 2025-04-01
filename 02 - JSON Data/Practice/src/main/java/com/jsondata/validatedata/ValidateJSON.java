package com.jsondata.validatedata;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Alice\", \"age\": 25 }";
        ObjectMapper mapper = new ObjectMapper();

        try{
            Person person = mapper.readValue(json, Person.class);
            System.out.println(person);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
