package com.jsondata.readextract;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadExtractJSON {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/jsondata/readextract/content/file.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            JSONObject obj = new JSONObject(content);

            String name = obj.optString("name", "NA");
            String email = obj.optString("email", "NA");

            System.out.println(name + " " + email);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
