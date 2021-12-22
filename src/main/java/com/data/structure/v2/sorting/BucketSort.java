package com.data.structure.v2.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    int arr[];

    public BucketSort(int arr[]) {
        this.arr = arr;
    }

    public void printBuckets(List<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("\n Buckets : " + i);
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " , ");
            }
        }
    }

    public void bucketSort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = findMaxValue();
        System.out.println("max value : " + maxValue);
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int element : arr) {
            int bucketNo = (int) Math.ceil(((float) element * numberOfBuckets) / (float) maxValue);
            int bucketIndex = bucketNo - 1;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new ArrayList<>();
            }
            buckets[bucketIndex].add(element);
        }
        System.out.println("\n printing buckets before sorting...........");
        printBuckets(buckets);
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }
        System.out.println("\n printing buckets AFTER sorting...........");
        printBuckets(buckets);
        int counter = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[counter] = buckets[i].get(j);
                counter++;
            }
        }
    }

    private int findMaxValue() {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public void printArray() {
        for (int n : arr) {
            System.out.print(n + " , ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 7, 2, 8, 6, 9, 1};
        BucketSort sort = new BucketSort(array);
        System.out.println("before sorting....");
        sort.printArray();
        sort.bucketSort();
        System.out.println("\nafter sorting....");
        sort.printArray();
    }

}
