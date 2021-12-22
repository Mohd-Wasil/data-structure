package com.data.structure.v2.tree.binarytree.array;

public class Main {
    public static void main(String[] args) {
        BinaryTreeArray bta = new BinaryTreeArray(5);
        bta.insertNode("N1");
        bta.insertNode("N2");
        bta.insertNode("N3");
        bta.insertNode("N4");
        bta.insertNode("N5");
        bta.insertNode("N6");
        System.out.println("\npre order traversal , root ->left->right");
        bta.preOrderTraversal(1);
        System.out.println("\nin order traversal left->root->right");
        bta.inOrderTraversal(1);
        System.out.println("\nPOST order traversal left->right->root");
        bta.postOrderTraversal(1);
        System.out.println("\nlevel order traversal");
        bta.levelOrderTraversal();
        System.out.println("\n");
        bta.searchNode("N31");
        bta.deleteNode("N3");
        System.out.println("\nin order traversal left->root->right");
        bta.inOrderTraversal(1);
        bta.deleteTree();
    }
}
