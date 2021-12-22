package com.data.structure.v2.graph.excercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public ArrayList<GraphNode> nodeList = new ArrayList<>();

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }


    public boolean identifyRouteBetweenTwoNodes(GraphNode source, GraphNode destination) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            if(currentNode.name.equalsIgnoreCase(destination.name)) {
                System.out.println("destination node identified...from " + source.name +" to : " + destination.name);
                System.out.println("printing path from source to destination node..");
                printPath(currentNode);
                return true;
            }
            for(GraphNode neighbor : currentNode.neighbors) {
                queue.add(neighbor);
                neighbor.parent = currentNode;
                neighbor.isVisited = true;
            }
        }
        System.out.println("destination node NOT identified...from " + source.name +" to : " + destination.name);
        return false;
    }

    public void printPath(GraphNode node ){
        if(node.parent != null){
            printPath(node.parent);
        }
        System.out.print(node.name +" ->");
    }
}
