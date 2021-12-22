package com.data.structure.v2.graph.adjacencymatrix;

public class GraphNode {
    public String name;
    public int index;
    boolean isVisited;
    GraphNode parent;

    public GraphNode (String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", isVisited=" + isVisited +
                '}';
    }
}
