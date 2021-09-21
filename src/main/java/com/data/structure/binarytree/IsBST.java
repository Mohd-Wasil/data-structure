package com.data.structure.binarytree;

public class IsBST {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(8);
        int[] values = {4, 7, 14, 16, 18, 2, 25, 11, -2};
        for (int value : values) {
            insertNode(root, new Node<Integer>(value));
        }
        boolean isBST = isBinarySearchTree(root, -2, 25);
        System.out.println("binary tree is BST : " + isBST);
    }

    private static boolean isBinarySearchTree(Node<Integer> root, int min, int max) {
        if (root == null) return true;

        if (root.getData() <= min || root.getData() > max) {
            return false;
        }
        return isBinarySearchTree(root.getRightChild(), root.getData(), max) && isBinarySearchTree(root.getLeftChild(), min, root.getData());

    }

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
