package com.data.structure.v2.graph.adjacencylist;

import java.util.ArrayList;

public class GraphNode {

    public String name;
    public int index;
    public ArrayList<GraphNode> neighbors = new ArrayList<>();
    boolean isVisited;
    GraphNode parent;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                ", index=" + index + '\'' +
                ", isVisited=" + isVisited +
                '}';
    }
}
