package com.data.structure.v2.tree.binarytree.array;

public class BinaryTreeArray {

    String[] arr;
    int lastUsedIndex;

    public BinaryTreeArray(int size) {
        arr = new String[size + 1]; //oth index not ised
        lastUsedIndex = 0;
        System.out.println("blank tree of size : " + size + " has been created");
    }

    public boolean isFull() {
        return lastUsedIndex == arr.length - 1;
    }

    public void insertNode(String value) {
        if (isFull()) {
            System.out.println("tree is full.. ");
        } else {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("value inserted to Binary tree : " + value);
        }
    }

    //root -> left ->right
    public void preOrderTraversal(int index) {

        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrderTraversal(2 * index);
        preOrderTraversal((2 * index) + 1);
    }

    //left ->root ->right
    public void inOrderTraversal(int index) {

        if (index > lastUsedIndex) {
            return;
        }
        inOrderTraversal(2 * index);
        System.out.print(arr[index] + " ");
        inOrderTraversal((2 * index) + 1);
    }

    //left ->right->root
    public void postOrderTraversal(int index) {
        if (index > lastUsedIndex)
            return;

        postOrderTraversal(2 * index);
        postOrderTraversal(2 * index + 1);
        System.out.print(arr[index] + " ");
    }

    public void levelOrderTraversal() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int searchNode(String valueToSearch) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i].equalsIgnoreCase(valueToSearch)) {
                System.out.println("value found at index : " + i);
                return i;
            }
        }
        System.out.println("value not found in binary tree!!");
        return Integer.MIN_VALUE;
    }

    public void deleteNode(String valueToDelete) {

        if (lastUsedIndex == 0) {
            System.out.println("Binary tree doesnt exist!!");
        }

        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i].equalsIgnoreCase(valueToDelete)) {
                arr[i] = arr[lastUsedIndex];
                lastUsedIndex = lastUsedIndex - 1;
                System.out.println("node deleted successfully : " + valueToDelete);
                return;
            }
        }
        System.out.println("Node doesnt exist!");
    }

    public void deleteTree(){
        arr = null;
        System.out.println("\nbinary tree deleted successfully..");
    }
}
