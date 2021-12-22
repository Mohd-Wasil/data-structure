package com.data.structure.v2.graph.excercises;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int size = 0;

    public TreeNode(int data) {
        this.data = data;
        size = 1;
    }

    public static TreeNode createMinimalBST(int[] array) {
        TreeNode root = new TreeNode(array[0]);
        for(int i = 1; i < array.length; i++) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode newNode = new TreeNode(array[i]);

        }
        return root;
    }

}
