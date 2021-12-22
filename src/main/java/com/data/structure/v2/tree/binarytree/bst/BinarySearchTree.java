package com.data.structure.v2.tree.binarytree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertNode(int value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            System.out.println("value inserted successfully at root " + value);
        } else {
            BinaryNode presentNode = root;
            BinaryNode prevNode = null;
            while (presentNode != null) {
                prevNode = presentNode;
                if (value <= presentNode.value) {
                    presentNode = presentNode.left;
                } else if (value > presentNode.value) {
                    presentNode = presentNode.right;
                }
            }
            if (value <= prevNode.value) {
                prevNode.left = newNode;
            } else {
                prevNode.right = newNode;
            }
        }
    }

    private BinaryNode insertNodeUsingRecursion(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("value successfully inserted : " + value);
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insertNodeUsingRecursion(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insertNodeUsingRecursion(currentNode.right, value);
            return currentNode;
        }
    }

    public void insertNodeUsingRecursion(int value) {
        root = insertNodeUsingRecursion(root, value);
    }

    //L1->l2->l3
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Binary tree doesnt exist@!");
            return;
        } else {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryNode presentNode = queue.remove();
                System.out.print(presentNode.value + " ");
                if (presentNode.left != null) {
                    queue.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    queue.add(presentNode.right);
                }
            }
        }
    }

    //root ->left->right
    public void preOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //left->root->right
    public void inOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    //left->right->root
    public void postOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");
    }

    private BinaryNode searchNode(BinaryNode node, int valueToSearch) {
        if (node == null) {
            System.out.println("\nvalue not found.." + valueToSearch);
            return null;
        } else if (node.value == valueToSearch) {
            System.out.println("\nvalue found : " + valueToSearch);
            return node;
        } else if (valueToSearch < node.value) {
            return searchNode(node.left, valueToSearch);
        } else {
            return searchNode(node.right, valueToSearch);
        }
    }

    public void searchNode(int value) {
        searchNode(root, value);
    }

    public BinaryNode minimumNode(BinaryNode node) {
        if (node.left == null) {
            return node;
        } else {
            return minimumNode(node.left);
        }
    }

    public BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("value not found in binary seacrh tree");
            return null;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            //case 1 current node has two children
            //node to be deleted
            if (node.left != null && node.right != null) {
                //BinaryNode temp = node;
                BinaryNode minimumNodeForRight = minimumNode(node.right);
                //temp.value = minimumNodeForRight.value;
                node.value = minimumNodeForRight.value;
                node.right = deleteNode(node.right, minimumNodeForRight.value);
            } else if (node.left != null) { //case 2 only 1 child
                node = node.left;
            } else if (node.right != null) { //case 2 only 1 child
                return node.right;
            } else { //leaf node
                node = null;
            }
        }
        return node;
    }

    public void deleteTree() {
        root = null;
        System.out.println("\nDeleted binary tree successfully!!");
    }
}
