package com.example.clothesservice.util.choiceTree;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ChoiceTreeBuilder {
    private final ObjectMapper _objectMapper = new ObjectMapper();
    public ChoiceTree MakeTree(String dataPath) throws IOException {
        var choiceTree = new ChoiceTree();
        var data = ParseJsonInputFile(dataPath);
        return new ChoiceTree();
    }

    private Map<String, Object> ParseJsonInputFile(String filePath) throws IOException {
        var file = new File(filePath);
        return _objectMapper.readValue(file, new TypeReference<>() {});
    }
}
