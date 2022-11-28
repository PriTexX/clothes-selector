package com.example.clothesservice;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
@EnableAsync
public class ClothesServiceApplication {

    public static void main(String[] args) {
        JsonArray jsonArray;
        try {
            var jsonString = new String(Files.readAllBytes(Path.of("C:\\main\\projects\\javaProjects\\clothes-service\\src\\main\\java\\com\\example\\clothesservice\\data.json")));
            jsonArray = JsonParser.parseString(jsonString).getAsJsonObject().getAsJsonObject("root").getAsJsonArray("children");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



//        SpringApplication.run(ClothesServiceApplication.class, args);
    }

}
