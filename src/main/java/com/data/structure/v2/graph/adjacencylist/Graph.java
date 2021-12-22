package com.data.structure.v2.graph.adjacencylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }


    public void BFSTraversal() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    private void bfsVisit(GraphNode node) {
        Queue<GraphNode> queueGraphElement = new LinkedList<>();
        queueGraphElement.add(node);
        while (!queueGraphElement.isEmpty()) {
            GraphNode currentNode = queueGraphElement.remove();
            System.out.print(currentNode.name + " ");
            currentNode.isVisited = true;
            for (GraphNode neighbor : currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queueGraphElement.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                dfsVisit(node);
                node.isVisited = true;
            }
        }
    }

    private void dfsVisit(GraphNode node) {
        Stack<GraphNode> stackGraphElements = new Stack<>();
        stackGraphElements.push(node);
        while (!stackGraphElements.isEmpty()) {
            GraphNode currentNode = stackGraphElements.pop();
            System.out.print(currentNode.name + " ");
            currentNode.isVisited = true;
            for (GraphNode neighbor : currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    stackGraphElements.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode node = nodeList.get(i);
        node.neighbors.add(nodeList.get(j)); // directed edge from i to j only..
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : node.neighbors) {
            if (!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
        }
        stack.push(node);
        node.isVisited = true;
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

    private static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + "->");
    }

    public void BFSForSSSPP(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print("printing path for current node: " + currentNode.name + " : " );
            pathPrint(currentNode);
            System.out.println("\n");
            for (GraphNode neighbor : currentNode.neighbors) {
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

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            //for (GraphNode neighbor : nodeList.get(i).neigbors) {
            //s.append(neighbor.name + "->");
            //}
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j != nodeList.get(i).neighbors.size() - 1) {
                    s.append(nodeList.get(i).neighbors.get(j).name + "->");
                } else {
                    s.append(nodeList.get(i).neighbors.get(j).name);
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
