package com.example.clothesservice.util.choiceTree;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileChoiceTreeBuilder extends ChoiceTreeBuilder {
    private final ObjectMapper _objectMapper = new ObjectMapper();
    private final Map<Integer, Predicate> _predicates = new HashMap<>();
    private final String _dataPath;

    public FileChoiceTreeBuilder(String dataPath){
        _dataPath = dataPath;
        _predicates.put(0, (var one, var another) -> {
            var range = ParseString(one);
            return Integer.parseInt(another) > range[0] && Integer.parseInt(another) < range[1];
        });
        _predicates.put(1, String::equals);
    }

    @Override
    public ChoiceTree Build() throws IOException {
        var tree = new ChoiceTree();
        var data = ParseJsonInputFile(_dataPath);
        var rootNode = new Node();
        var rootNodeChildren = new ArrayList<Node>();

        var list = (ArrayList<LinkedHashMap<String, Object>>)((Map<String, Object>)data.get("root")).get("children");

        for(var el : list){
            var node = BuildNode(el);

            NodeSetup((List<Map<String, Object>>) el.get("children"), node);
            rootNodeChildren.add(node);
        }

        rootNode.setChildren(rootNodeChildren);
        tree.set_root(rootNode);

        return tree;
    }

    private Map<String, Object> ParseJsonInputFile(String filePath) throws IOException {
        var file = new File(filePath);
        return _objectMapper.readValue(file, new TypeReference<>() {});
    }

    private int[] ParseString(String str){
        var idx = str.indexOf("_");
        if(idx == -1) throw new RuntimeException("Cannot parse string %s".formatted(str));

        var firstInt = Integer.parseInt(str.substring(0, idx));
        var secondInt = Integer.parseInt(str.substring(idx+1));

        return new int[]{firstInt, secondInt};
    }

    private void NodeSetup(List<Map<String, Object>> children, Node parent){
        List<Node> childrenNodes = new ArrayList<>();
        for(var child : children){
            var childNode = BuildNode(child);
            if(!childNode.isLeaf()){
                NodeSetup((List<Map<String, Object>>) child.get("children"), childNode);
            }
            childrenNodes.add(childNode);
        }
        parent.setChildren(childrenNodes);
    }

    private Node BuildNode(Map<String, Object> element){
        var node = new Node();
        node.set_condition((String)element.get("condition"));
        node.set_isLeaf((boolean) element.get("isLeaf"));
        node.set_predicate(_predicates.get((Integer) element.get("predicate")));

        if(node.isLeaf())
            node.set_data((List<String>) element.get("data"));

        return node;
    }
}
