package com.example.clothesservice.util;

import java.util.List;

public class ChoiceTree {
    public Node get_root() {
        return _root;
    }

    public void set_root(Node _root) {
        this._root = _root;
    }

    public interface Predicate{ boolean Check(String cond, String userCond); }
    public static class Node{
        private List<Node> children = null;
        private String _condition;
        private Predicate _predicate;
        private boolean _isLeaf = false;
        private List<String> _data = null;


        public boolean Check(String userCondition){
            return _predicate.Check(_condition, userCondition);
        }

        public void set_condition(String _condition) {
            this._condition = _condition;
        }

        public void set_predicate(Predicate _predicate) {
            this._predicate = _predicate;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public boolean isLeaf() {
            return _isLeaf;
        }

        public void set_isLeaf(boolean _isLeaf) {
            this._isLeaf = _isLeaf;
        }

        public List<String> get_data() {
            return _data;
        }

        public void set_data(List<String> _data) {
            this._data = _data;
        }
    }

    private Node _root;
}
