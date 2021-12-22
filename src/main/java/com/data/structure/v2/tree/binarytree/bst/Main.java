package com.data.structure.v2.tree.binarytree.bst;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNodeUsingRecursion(20);
        bst.insertNodeUsingRecursion(11);
        bst.insertNodeUsingRecursion(15);
        bst.insertNodeUsingRecursion(18);
        bst.insertNodeUsingRecursion(8);
        bst.insertNodeUsingRecursion(25);
        bst.insertNodeUsingRecursion(22);
        bst.insertNodeUsingRecursion(30);
        bst.insertNodeUsingRecursion(28);
        bst.insertNodeUsingRecursion(35);
        System.out.println(bst.root.left.value);
        System.out.println("level order traversal .." );
        bst.levelOrderTraversal();
        System.out.println("\npre order traversal - > root ->left->right");
        bst.preOrderTraversal(bst.root);
        System.out.println("\nIn order traversal - > left->root->right");
        bst.inOrderTraversal(bst.root);
        System.out.println("\npost order traversal - > left->right->root");
        bst.postOrderTraversal(bst.root);
        bst.searchNode(174);
        System.out.println("\nlevel order traversla before delete");
        bst.levelOrderTraversal();
        System.out.println("mon : "+ bst.minimumNode(bst.root).value);
        bst.deleteNode(bst.root, 25);
        bst.levelOrderTraversal();
        bst.deleteTree();
    }
}

