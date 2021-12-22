package com.data.structure.v2.graph.dijsktra;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        WeightedGraph wGraph = new WeightedGraph(nodeList);
        wGraph.addWeightedEdge(0,1, 2);
        wGraph.addWeightedEdge(0,2, 5);
        wGraph.addWeightedEdge(1,2, 6);
        wGraph.addWeightedEdge(1,3, 1);
        wGraph.addWeightedEdge(1,4, 3);
        wGraph.addWeightedEdge(2,5, 8);
        wGraph.addWeightedEdge(3,4, 4);
        wGraph.addWeightedEdge(4,6, 9);
        wGraph.addWeightedEdge(5,6, 7);

        System.out.println("Diijsktra alog from source A: ");
        wGraph.dijsktraAlgo(nodeList.get(0));
        System.out.println("Bell man ford alog from source A: ");
        wGraph.bellManFordAlgorithm(nodeList.get(0));

    }
}

