package com.example.clothesservice.util.choiceTree;

public class ChoiceTree {
    public Node get_root() {
        return _root;
    }

    public void set_root(Node _root) {
        this._root = _root;
    }

    private Node _root;

    public static Node MakeChoice(Node startNode, String condition){
        for(var node : startNode.getChildren()){
            if(node.Check(condition))
                return node;
        }

        throw new RuntimeException("No node with such condition");
    }
}
