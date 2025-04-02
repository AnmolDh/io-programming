package com.ipl.inputhandler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipl.censor.Censor;
import com.ipl.classes.Match;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class InputHandler {
    public static void json(String filePath){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/ipl/content/censored/ipl.json"))) {
            ObjectMapper mapper = new ObjectMapper();

            Match[] matches = mapper.readValue(new File(filePath), Match[].class);

            for (Match match : matches) {
                match.setTeam1(Censor.apply(match.getTeam1()));
                match.setTeam2(Censor.apply(match.getTeam2()));
                match.setPlayer_of_match(Censor.redacted(match.getPlayer_of_match()));
            }

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matches);
            bw.write(json);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void csv(String filePath){
        try (
                CSVReader reader = new CSVReader(new FileReader(filePath));
                CSVWriter writer = new CSVWriter(new FileWriter("src/main/java/com/ipl/content/censored/ipl.csv"));
            ) {
            String[] header = reader.readNext();
            writer.writeNext(header);
            String[] line;
            while ((line = reader.readNext()) != null) {
                line[1] = Censor.apply(line[1]);
                line[2] = Censor.apply(line[2]);
                line[6] = Censor.redacted(line[6]);
                writer.writeNext(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
