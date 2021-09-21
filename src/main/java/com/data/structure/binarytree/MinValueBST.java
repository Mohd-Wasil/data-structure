package com.data.structure.binarytree;

public class MinValueBST {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(8);
        int[] values = {4, 7, 14, 16, 18, 2, -25, 11, -2, 31};
        for (int value : values) {
            insertNode(root, new Node<Integer>(value));
        }
        Node<Integer> minNode = minValue(root);
        System.out.println("minimum node " + minNode.getData());

        Node<Integer> maxNode = maxValue(root);
        System.out.println("max node " + maxNode.getData());
        int maxDepth = maxDepthOfBinaryTree(root);
        System.out.println("maxDepth : " + maxDepth);
    }

    private static int maxDepthOfBinaryTree(Node<Integer> head) {
        if (head == null) {
            return 0;
        }
        if (head.getRightChild() == null && head.getLeftChild() == null) {
            return 0; //leaf node has depth of zero..
        }
        int maxRightDepth = 1 + maxDepthOfBinaryTree(head.getRightChild());
        int maxLeftChildDepth = 1 + maxDepthOfBinaryTree(head.getLeftChild());
        return Math.max(maxLeftChildDepth, maxRightDepth);
    }

    private static Node<Integer> maxValue(Node<Integer> head) {
        if (head == null)
            return null;

        if (head.getRightChild() == null) {
            return head;
        }
        return maxValue(head.getRightChild());
    }

    private static Node minValue(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.getLeftChild() == null) {
            return head;
        }
        return minValue(head.getLeftChild());
    }

  /*  private static Node minValue(Node<Integer> head) {
        if(head.getLeftChild() == null) {
            return head;
        } else {
            return minValue(head.getLeftChild());
        }
    }*/

    private static Node insertNode(Node<Integer> head, Node<Integer> node) {

        if (head == null) {
            return node;
        }
        if (node.getData() <= head.getData()) {
            head.setLeftChild(insertNode(head.getLeftChild(), node));
        } else {
            head.setRightChild(insertNode(head.getRightChild(), node));
        }
        return head;
    }
}
