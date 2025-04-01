package com.jsondata.validateschema;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class ValidateSchemaJSON {
    public static void main(String[] args) {
        String json = "{ \"id\": 1, \"name\": \"Alice\", \"email\": \"test@test.com\" }";

        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode schemaNode = mapper.readTree(new File("src/main/java/com/jsondata/validateschema/schema.json"));

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            JsonNode jsonData = mapper.readTree(json);

            if (schema.validate(jsonData).isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("Invalid JSON!");
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
