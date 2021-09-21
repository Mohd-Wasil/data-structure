package com.data.structure.binarytree;

public class MirrorBST {

    public static void main(String[] args) {
        Node<Integer> binaryTree = new Node<>(8);
        int[] values = {4, 7, 14, 16, 18, 2, -25, 11, -2, 31};
        for (int value : values) {
            insertNode(binaryTree, new Node<Integer>(value));
        }
        System.out.println("\n printing binarytree");
        inOrderTraversal(binaryTree);
        Node<Integer> mirrorBinaryTree =  new Node<Integer>(binaryTree.getData());
        mirrorBinaryTreeExpensive(binaryTree, mirrorBinaryTree);
        System.out.println("\n printing mirror binarytree");
        inOrderTraversal(mirrorBinaryTree);

        mirrorBinaryTree(binaryTree);
        System.out.println("\n printing mirror binarytree INLINE");

        inOrderTraversal(binaryTree);
    }

    private static void mirrorBinaryTree(Node<Integer> head) {
        if(head == null)
            return;
        mirrorBinaryTree(head.getLeftChild());
        mirrorBinaryTree(head.getRightChild());
        Node<Integer> temp = head.getLeftChild();
        head.setLeftChild(head.getRightChild());
        head.setRightChild(temp);
    }

    //too expensive...
    private static void mirrorBinaryTreeExpensive(Node<Integer> head, Node<Integer> mirrorNode) {
        if(head == null)
            return;
        if(head.getRightChild() !=null) {
            Node<Integer> node = new Node<>(head.getRightChild().getData());
            mirrorNode.setLeftChild(node);
            mirrorBinaryTreeExpensive(head.getRightChild(), node);
        }

        if(head.getLeftChild()!=null){
            Node<Integer> node = new Node<>(head.getLeftChild().getData());
            mirrorNode.setRightChild(node);
            mirrorBinaryTreeExpensive(head.getLeftChild(), node);
        }
    }

    private static void inOrderTraversal(Node<Integer> binaryTree) {
        if (binaryTree == null) {
            return;
        }
        inOrderTraversal(binaryTree.getLeftChild());
        print(binaryTree);
        inOrderTraversal(binaryTree.getRightChild());
    }

    private static void print(Node<Integer> binaryTree) {
        System.out.print(binaryTree.getData() + " , ");
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
