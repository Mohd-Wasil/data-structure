package com.data.structure.v2.avltree;


import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    BinaryNode root;

    AVL() {
        root = null;
    }

    //root->left->right
    public void preOrderTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //left ->root ->right
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

    //levle1 -.level2->level3
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("AVL tree is empty!!!");
            return;
        }
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

    //to test...
    BinaryNode searchNode(BinaryNode node, int valueToSearch) {
        BinaryNode presentNode = node;
        if (node == null) {
            System.out.println("value not found in AVL tree : " + valueToSearch);
            return null;
        }
        if (valueToSearch < node.value) {
            presentNode = searchNode(node.left, valueToSearch);
        } else if (valueToSearch > node.value) {
            presentNode = searchNode(node.right, valueToSearch);
        } else {
            System.out.println("value found at : " + node.value);
        }
        return presentNode;
    }

    public int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // time and space o(1)
    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // time and space o(1)
    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public int getBalance(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) { //base condition
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue <= node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        // left left condition
        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }
        // left-right condition
        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left); //case 1 rotate left node's left node one level down
            return rotateRight(node);//case 2 rotate right main node
        }

        //right -right condition
        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }

        //right-left condition
        if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insertNode(int value) {
        root = insertNode(root, value);
    }

    public BinaryNode getMinimumNode(BinaryNode node) {
        if (node.left == null) {
            return node;
        }
        return getMinimumNode(node.left);
    }

    public BinaryNode deleteNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            System.out.println("value not found in the tree");
            return node;
        }
        if (nodeValue < node.value) {
            node.left = deleteNode(node.left, nodeValue);
        } else if (nodeValue > node.value) {
            node.right = deleteNode(node.right, nodeValue);
        } else {
            //case1 both left/right exists
            if (node.right != null && node.left != null) {
                //find successor
                BinaryNode tempNode = node;
                BinaryNode minimumNodeForRight = getMinimumNode(tempNode.right);
                node.value = minimumNodeForRight.value;
                node.right = deleteNode(node.right, minimumNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
            int balance = getBalance(node);
            //left left condition
            if(balance > 1 && getBalance(node.left) >= 0) {
                return rotateRight(node);
            }
            //left-right condition
            if(balance >1 && getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

            //right - right condition
            if(balance < -1 && getBalance(node.right) <= 0) {
                return rotateLeft(node);
            }

            //right -left condition
            if(balance < -1 && getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
                return rotateLeft(node.left);

        }
        return node;
    }
    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    public void deleteTree() {
        root = null;
        System.out.println("avl tree deleted !!");
    }

}
