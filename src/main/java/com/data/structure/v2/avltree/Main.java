package com.data.structure.v2.avltree;

import java.util.AbstractList;

public class Main {

    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insertNode(5);
        avl.insertNode(10);
        avl.insertNode(15);
        avl.insertNode(20);
        System.out.println("level 1");
        avl.levelOrderTraversal();
        avl.deleteNode(5);
        System.out.println("level again");
        avl.levelOrderTraversal();


    }
}
