package com.data.structure.v2.search;

public class BinarySearch {

    private int search(int[] array, int left, int middle, int right, int value) {
        if (array[middle] == value) {
            System.out.println("value : " + value + " found at index : " + middle);
            return middle;
        }
        if (right == left) {//or left==middle //middle==right
            System.out.println("value : " + value + " not available ");
            return -1;
        }
        if (value > array[middle]) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
        middle = (left + right) / 2;
        return search(array, left, middle, right, value);
    }

    public int binarySearch(int[] arr, int left, int right, int value) {
        int middle = (left + right) / 2;
        return search(arr, left, middle, right, value);
    }

    public int binarySearchUsingLoop(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;
        while (arr[middle] != value && left <= right) {
            //(left==right means only one element and if not available)
            if (value < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        if (arr[middle] == value) {
            System.out.println("value loop : " + value + " found at index : " + middle);
            return middle;
        } else {
            System.out.println("value looop : " + value + " not available ");
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        BinarySearch search = new BinarySearch();
        search.binarySearch(arr, 0, arr.length - 1, 21);
        search.binarySearchUsingLoop(arr, 30);
    }
}
