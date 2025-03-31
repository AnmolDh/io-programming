package com.csv.convertcsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSV {
    public static <T> List<T> convertToObjects(String filePath, Class<T> clazz) {
        try (FileReader reader = new FileReader(filePath, StandardCharsets.UTF_8)) {
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }
}
