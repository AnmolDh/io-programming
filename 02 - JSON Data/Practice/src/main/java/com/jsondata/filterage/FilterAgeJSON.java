package com.jsondata.filterage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class FilterAgeJSON {
    public static void main(String[] args) {
        String jsonArray = "[{\"name\": \"Alice\", \"age\": 25}, {\"name\": \"Bob\", \"age\": 30}, {\"name\": \"Charlie\", \"age\": 28}]";

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(jsonArray);

            List<JsonNode> list = new ArrayList<>();

            for (JsonNode jsonNode : node) {
                if (jsonNode.get("age").asInt() > 25) {
                    list.add(jsonNode);
                }
            }

            String filteredJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(filteredJson);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
