package com.example.clothesservice.util.choiceTree;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChoiceTreeBuilder {
    public ChoiceTree MakeTree(String dataPath){
        var choiceTree = new ChoiceTree();

        JsonArray jsonArray;
        try {
            var jsonString = new String(Files.readAllBytes(Path.of("C:\\main\\projects\\javaProjects\\clothes-service\\src\\main\\java\\com\\example\\clothesservice\\data.json")));
            jsonArray = JsonParser.parseString(jsonString).getAsJsonObject().getAsJsonArray("root");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var rootNode = new Node();

        for(var el : jsonArray){
            JsonObjectToNode(el, null);
        }

        return new ChoiceTree();
    }

    private Node JsonObjectToNode(JsonElement obj, Node rootNode){
        var node = new Node();
        node.set_condition(obj.getAsString());
    }
}
