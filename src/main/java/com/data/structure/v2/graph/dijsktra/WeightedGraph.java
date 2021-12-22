package com.data.structure.v2.graph.dijsktra;

import com.data.structure.v2.graph.adjacencymatrix.GraphNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedEdge(int i, int j, int distance) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, distance); //directed edge
        //second.weightMap.put(first, distance);
    }

    public void dijsktraAlgo(WeightedNode node) {
        PriorityQueue<WeightedNode> pQueue = new PriorityQueue<>();
        node.distance = 0;
        pQueue.add(node);
        pQueue.addAll(nodeList);
        while (!pQueue.isEmpty()) {
            WeightedNode currentNode = pQueue.remove();
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (pQueue.contains(neighbor)) {
                    if (neighbor.distance > (currentNode.distance + currentNode.weightMap.get(neighbor))) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        //refresh pQueue
                        pQueue.remove(neighbor);
                        pQueue.add(neighbor);
                    }
                }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node: " + nodeToCheck + ", distance: " + nodeToCheck.distance + " , path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    //takes source node
    public void bellManFordAlgorithm(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 0; i < nodeList.size(); i++) { //v-1
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbor : currentNode.neighbors) {
                    if (neighbor.distance > (currentNode.distance + currentNode.weightMap.get(neighbor))) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                    }
                }
            }
        }

        System.out.println("checking for negative cycle...");
        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neigbor : currentNode.neighbors) {
                if (neigbor.distance > currentNode.distance + currentNode.weightMap.get(neigbor)) {
                    System.out.println("it is a neagtive cycle.. found.. can not construct shortes path from source...");
                    System.out.println("Vertes name : " + neigbor.name);
                    System.out.println("Old cost  : " + neigbor.distance);
                    System.out.println("New cost  : " + currentNode.distance + currentNode.weightMap.get(neigbor));
                    return;
                }
            }
        }
        System.out.println("no negative cycle identified");

        for (WeightedNode node : nodeList) {
            System.out.print("Node : " + node.name + " , distance : " + node.distance + " , path: ");
            pathPrint(node);
            System.out.println();
        }

    }

    public void flyodWarshall() {
        int size = nodeList.size();
        int[][] V = new int[size][size];

        //update matrix to current distance between edges/...
        for (int i = 0; i < size; i++) {
            WeightedNode first = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                if (i == j) {
                    V[i][j] = 0;
                } else if (first.weightMap.containsKey(second)) {
                    V[i][j] = first.weightMap.get(second);
                } else {
                    V[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }

        for (int k = 0; k < nodeList.size(); k++) {
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if (V[i][j] > V[i][k] + V[k][j]) { //flyod warshall formula
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }

        //printing updated matrix..
        for (int i = 0; i < size; i++) {
            System.out.println("printing distance LIST from given node.." + nodeList.get(i) +" : ");
            for (int j = 0; j < size; j++) {
                System.out.println(V[i][j] +" ");
            }
            System.out.println();

        }
    }

    private void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

}
