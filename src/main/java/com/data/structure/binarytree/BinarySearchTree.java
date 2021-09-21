package com.data.structure.binarytree;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(8);
        int[] values = {4, 7, 14, 16, 18, 2, 25, 11, -2};
        for (int value : values) {
            insertNode(root, value);
        }

        System.out.println("printing nodes...");
        inOrderTraversal(root);

        Node<Integer> root2 = new Node<>(8);
        for (int value : values) {
            Node<Integer> node = new Node<>(value);
            //O(LOG(N)), reasonably balanced tree
            //no of nodes are halevd at every step..
            // if tree is skewed then all with only left /right children
            //- O(N)
            insertNode2(root2, node);
        }
        System.out.println("\n printing nodes 22 new way...");
        inOrderTraversal(root);
        //O(LOG(N)), reasonably balanced tree
        //no of nodes are halevd at every step..
        // if tree is skewed then all with only left /right children
        //- O(N)
        Node response = lookup(root, 18);
        System.out.println("\n element : exists " +
                (response));

    }

    private static Node lookup(Node<Integer> head, int data) {
        if (head == null) return null;

        if (data == head.getData()) {
            return head;
        }
        if (data >= head.getData()) {
            return lookup(head.getRightChild(), data);
        } else {
            return lookup(head.getLeftChild(), data);
        }
    }

    private static Node insertNode2(Node<Integer> head, Node<Integer> node) {
        if (head == null) {
            return node;
        }
        if (node.getData() <= head.getData()) {
            head.setLeftChild(insertNode2(head.getLeftChild(), node));
        } else {
            head.setRightChild(insertNode2(head.getRightChild(), node));
        }
        return head;
    }

    private static void inOrderTraversal(Node<Integer> root) {
        if (root == null) return;

        inOrderTraversal(root.getLeftChild());
        print(root);
        inOrderTraversal(root.getRightChild());
    }

    private static void print(Node<Integer> root) {
        System.out.print(root.getData() + " , ");
    }

    private static void insertNode(Node<Integer> root, int value) {

        if (value < root.getData() && root.getLeftChild() != null) {
            insertNode(root.getLeftChild(), value);
        } else if (value < root.getData() && root.getLeftChild() == null) {
            root.setLeftChild(new Node<>(value));
        }

        if (value > root.getData() && root.getRightChild() != null) {
            insertNode(root.getRightChild(), value);
        } else if (value > root.getData() && root.getRightChild() == null) {
            root.setRightChild(new Node<>(value));
        }
    }
}
