package com.data.structure.v2.tree.binarytree.lnkdlist;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {

    BinaryNode root;

    public BinaryTreeLL() {
        root = null;
    }

    //root -> left -> right
    public void preOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ->");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //left ->root ->right
    public void inOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + "->");
        inOrderTraversal(node.right);
    }

    //left->right->root
    public void postOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + "->");
    }

    //level1->level2->level3
    public void levelOrderTraversal() {
        if(root == null){
            System.out.println("Binary tree doesnt exist!!");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.data + "->");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    public void nodeSearch(String valueToSearch) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.data.equalsIgnoreCase(valueToSearch)) {
                System.out.println("\nvalue found in binary tree: " + valueToSearch);
                return;
            }
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.println("\nvalue not found in binary tree");
    }

    public void insertNode(String data) {
        BinaryNode newNode = new BinaryNode();
        newNode.data = data;
        if (root == null) {
            root = newNode;
            System.out.println("value inserted successfully at root: " + data);
            return;
        } else {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryNode presentNode = queue.remove();
                if (presentNode.left == null) {
                    presentNode.left = newNode;
                    System.out.println("value inserted successfully as left child: " + data);
                    break;
                } else if (presentNode.right == null) {
                    presentNode.right = newNode;
                    System.out.println("value inserted successfully as right child: " + data);
                    break;
                } else {
                    queue.add(presentNode.left);
                    queue.add(presentNode.right);
                }
            }
        }
    }

    public BinaryNode findDeepestNode() {
        BinaryNode deepestNode = null;
        if (root == null) {
            System.out.println("binary tree doesnt exist!!");
        } else {
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                deepestNode = queue.remove();

                if (deepestNode.left != null) {
                    queue.add(deepestNode.left);
                }
                if (deepestNode.right != null) {
                    queue.add(deepestNode.right);
                }
            }
        }
        return deepestNode;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode prevNode = null, presentNode = null ;
        while (!queue.isEmpty()) {
            prevNode = presentNode;
            presentNode = queue.remove();
            if(presentNode.left == null) {
                System.out.println("prev node is: "+ prevNode.data);
                System.out.println("present  node is: "+ presentNode.data);
                prevNode.right = null;
                return;
            }
            if(presentNode.right == null) {
                prevNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
        System.out.println("prev Node : "+ prevNode);
        if(prevNode.right != null) {
            prevNode.right = null;
        } else{
            prevNode.left = null;
        }

    }

    public void deleteNode(String data) {
        if (root == null) {
            System.out.println("Binary tree is empty!!");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.println("in while liipp");
            BinaryNode presentNode = queue.remove();
            //delete that node
            if (presentNode.data.equalsIgnoreCase(data)) {
                System.out.println("deleting node..");
                // find deepest node & set to current Node
                presentNode.data = findDeepestNode().data;
                deleteDeepestNode();
                System.out.println("node deleted successfully : " + data);
                break;
            } else {
                if (presentNode.left != null) {
                    queue.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println("no node found with value  : " + data);
    }

    public void deleteTree(){
        root = null;
        System.out.println("tree deleted successfully");
    }
}
