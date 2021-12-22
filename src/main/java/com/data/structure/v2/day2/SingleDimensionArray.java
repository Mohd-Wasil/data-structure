package com.data.structure.v2.day2;

import java.util.Arrays;

public class SingleDimensionArray {
    int[] arr;

    public SingleDimensionArray(int size) {
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        //int arr[] = {32, 54, 71, 19, 9};
        SingleDimensionArray singleDimensionArray = new SingleDimensionArray(4);
        singleDimensionArray.insertAtEnd(0, 12);
        singleDimensionArray.insertAtEnd(1, 15);
        singleDimensionArray.insertAtEnd(2, 34);
        singleDimensionArray.insertAtEnd(3, 521);
        singleDimensionArray.insertAtEnd(4, 28);
        singleDimensionArray.printArray();
        singleDimensionArray.searchInArray(34);
        singleDimensionArray.deleteValueFromArray(34);
        singleDimensionArray.deleteValueFromArrayIndex(4);
        singleDimensionArray.printArray();
        //var first                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          Element = 1;

    }

    public void insertAtEnd(int location, int value) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = value;
                System.out.println("successfully inserted..");
            } else {
                System.out.println("this cell is already occupied by : " + arr[location]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("invalid index error..");
        }
    }

    private void printArray() {
        Arrays.stream(arr).forEach(e -> System.out.println(e));
    }

    private void searchInArray(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) {
                System.out.println("value : " + valueToSearch + " is found: at indexOf : " + i);
                return;
            }
        }
        System.out.println("value : " + valueToSearch + " is not found");
    }

    private void deleteValueFromArray(int valueToDelete) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToDelete) {
                arr[i] = Integer.MIN_VALUE;
                System.out.println("value : " + valueToDelete + " deleted");
                return;
            }
        }
        System.out.println("value : " + valueToDelete + " not found");
    }

    private void deleteValueFromArrayIndex(int valueToDeleteIndex) {
        try {
            arr[valueToDeleteIndex] = Integer.MIN_VALUE;
            System.out.println("value : " + valueToDeleteIndex + " deleted");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("index: " + valueToDeleteIndex + " not found");
        }

    }
}
