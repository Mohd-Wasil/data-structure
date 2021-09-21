package com.data.structure.binarytree;

public class PrintRangeBinaryTree {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(8);
        int[] values = {4, 7, 14, 16, 18, 2, 25, 11, -2, 13, 32};
        for (int value : values) {
            insertNode(root, new Node<>(value));
        }
        inOrderTraversal(root);
        int low = 7, high = 18;
        System.out.println("\n printing range - low " + low + " high " + high);
        printRange(root, low, high);
    }

    private static void printRange(Node<Integer> node, int low, int high) {
        if (node == null) return;
        if (low <= node.getData()) {
            printRange(node.getLeftChild(), low, high);
        }
        if (node.getData() >= low && node.getData() <= high) {
            System.out.print(node.getData() + " , ");
        }

        if (high > node.getData()) {
            printRange(node.getRightChild(), low, high);
        }

    }

    private static void inOrderTraversal(Node<Integer> head) {
        if (head == null) return;
        inOrderTraversal(head.getLeftChild());
        print(head);
        inOrderTraversal(head.getRightChild());
    }

    private static void print(Node<Integer> head) {
        System.out.print(head.getData() + " , ");
    }

    private static Node insertNode(Node<Integer> head, Node<Integer> node) {
        if (head == null) {
            return node; //reached leaf node of binary tree add the actiual data to the left/right to parent node
        }
        if (node.getData() <= head.getData()) {
            head.setLeftChild(insertNode(head.getLeftChild(), node));
        } else {
            head.setRightChild(insertNode(head.getRightChild(), node));
        }
        return head;
    }
}
