package com.data.structure.v2.graph.adjacencymatrix;

import java.util.*;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];//all value will be 0
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;//2 directional
    }

    public void addDirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[node.index][i] == 1) {
                GraphNode neighbor = nodeList.get(i);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    private void BFSTraversal(GraphNode node) {
        Queue<GraphNode> graphElementsInQueue = new LinkedList<>();
        graphElementsInQueue.add(node);
        while (!graphElementsInQueue.isEmpty()) {
            GraphNode currentNode = graphElementsInQueue.remove();
            System.out.print(currentNode.name + "->");
            currentNode.isVisited = true;

            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    graphElementsInQueue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void BFSTraversal() {
        BFSTraversal(nodeList.get(0));
    }

    private void dfsVisit(GraphNode node) {
        Stack<GraphNode> stackGraphElements = new Stack<>();
        stackGraphElements.push(node);
        while (!stackGraphElements.isEmpty()) {
            GraphNode currentNode = stackGraphElements.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            List<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    stackGraphElements.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        ArrayList<GraphNode> neighbors = getNeighbors(node);
        for (GraphNode neighbor : neighbors) {
            if (!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + "->");
        }
    }

    public void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void BFForSSSPP(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print("printing path for node " + currentNode.name +" : ");
            pathPrint(currentNode);
            System.out.println("\n");
            for (GraphNode neighbor : getNeighbors(currentNode)) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
