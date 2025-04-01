package com.jsondata.listjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ListToJSON {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Anmol", 21),
                new Person("John", 21)
        );

        try{
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);

            System.out.println(json);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
