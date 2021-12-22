package com.data.structure.v2.tree.binarytree.lnkdlist;

public class Main {
    public static void main(String[] args) {
        BinaryTreeLL btll = new BinaryTreeLL();
        BinaryNode N1 = createNodeManually();
        btll.root = N1;
        System.out.println("\npre order traversal = root->left->right");
        btll.preOrderTraversal(btll.root);
        System.out.println("\nin order traversal =  left->root->right");
        btll.inOrderTraversal(btll.root);
        System.out.println("\npost order traversal = left->right->root");
        btll.postOrderTraversal(btll.root);
        System.out.println("\nLevel order traversal = level1->level2->level3");
        btll.levelOrderTraversal();
        btll.nodeSearch("N34");
        btll.insertNode("N10");
        btll.postOrderTraversal(btll.root);

        btll.root =null;

        btll.insertNode("N1");
        btll.insertNode("N2");
        btll.insertNode("N3");
        btll.insertNode("N4");
        btll.insertNode("N5");
        btll.insertNode("N6");
        btll.insertNode("N7");
        btll.insertNode("N8");
        btll.insertNode("N9");
        System.out.println("\nLevel order traversal = level1->level2->level3");
        btll.levelOrderTraversal();
        System.out.println("deepest node is :  "+btll.findDeepestNode().data);
        btll.deleteNode("N7");
        System.out.println("\nLevel order traversal = level1->level2->level3");
        btll.levelOrderTraversal();
        btll.deleteTree();
        btll.levelOrderTraversal();
    }

    private static BinaryNode createNodeManually() {
        BinaryNode N1 = new BinaryNode();
        N1.data = "N1";
        BinaryNode N2 = new BinaryNode();
        N2.data = "N2";
        BinaryNode N3 = new BinaryNode();
        N3.data = "N3";
        BinaryNode N4 = new BinaryNode();
        N4.data = "N4";
        BinaryNode N5 = new BinaryNode();
        N5.data = "N5";
        BinaryNode N6 = new BinaryNode();
        N6.data = "N6";
        BinaryNode N7 = new BinaryNode();
        N7.data = "N7";
        BinaryNode N8 = new BinaryNode();
        N8.data = "N8";
        BinaryNode N9 = new BinaryNode();
        N9.data = "N9";
        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N3.left = N6;
        N3.right = N7;
        N4.left = N8;
        N4.right = N9;
        return N1;
    }
}
