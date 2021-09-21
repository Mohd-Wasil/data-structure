package com.data.structure.binarytree;

import com.data.structure.queue.Queue;
import com.data.structure.queue.exception.QueueOverFlowException;
import com.data.structure.queue.exception.QueueUnderFlowException;

public class BinaryTreeTraversal {

    public static void main(String[] args) throws QueueOverFlowException, QueueUnderFlowException {
        Node<String> root = new Node<>("A", new Node<>("B"), new Node<>("C"));
        root.getRightChild().setLeftChild(new Node<>("D", new Node<>("G"), new Node<>("H")));
        root.getRightChild().setRightChild(new Node<>("F", new Node<>("I"), false));
        root.getLeftChild().setLeftChild(new Node<>("E"));
        breadthFirstTraversal(root);
        System.out.println(" \nprinting PreOrderTraversal..");
        preOrderTraversal(root);
        System.out.println(" \nprinting inOrderTraversal..");
        inOrderTraversal(root);
        System.out.println(" \nprinting postOrderTraversal..");
        postOrderTraversal(root);
    }

    private static void postOrderTraversal(Node<String> root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.getLeftChild());
        postOrderTraversal(root.getRightChild());
        print(root);
    }

    private static void inOrderTraversal(Node<String> root) {
        if(root == null)
            return;

        preOrderTraversal(root.getLeftChild());
        print(root);
        preOrderTraversal(root.getRightChild());
    }

    private static void preOrderTraversal(Node<String> root) {
        if(root == null)
            return;
        print(root);
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    private static void breadthFirstTraversal(Node<String> root) throws QueueOverFlowException, QueueUnderFlowException {
        if (root == null) {
            return;
        }
        System.out.println("printing BFT ..");
        Queue<Node> queue = new Queue<>(Node.class);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node data = queue.dequeue();
            print(data); //process the data
            if (data.getLeftChild() != null) {
                queue.enqueue(data.getLeftChild()); //add all left child first
            }
            if (data.getRightChild() != null) {
                queue.enqueue(data.getRightChild()); //thena add all right child to it
            }
        }
    }

    private static void print(Node data) {
        System.out.print(data.getData() + " , ");
    }
}
