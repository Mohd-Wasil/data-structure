package com.data.structure.v2.tree;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleTreeNode {
    String data;
    ArrayList<SimpleTreeNode> children;

    public SimpleTreeNode(String data) {
        this.data = data;
        children = new ArrayList<SimpleTreeNode>();
    }

    public void addChild(SimpleTreeNode node) {
        children.add(node);
    }

    public String print(int level) {
        String ret =String.join("", Collections.nCopies(level, " ")) + " " + data + "\n";
        for (SimpleTreeNode node : children) {
            ret += node.print(level + 1);
        }
        return ret;
    }

}
