package com.jsondata.toxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXML {
    public static void main(String[] args) {
        try {
            String json = "{\"name\":\"Alice\",\"age\":25,\"city\":\"New York\"}";

            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            Object obj = objectMapper.readValue(json, Object.class);

            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            System.out.println(xml);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
