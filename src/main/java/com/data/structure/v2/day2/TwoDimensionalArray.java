package com.data.structure.v2.day2;

import java.util.Arrays;

public class TwoDimensionalArray {
    int[][] int2DArray; //declaration

    public TwoDimensionalArray(int row, int columns) {
        this.int2DArray = new int[row][columns];
        //Time complexity - O(m*n)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < int2DArray[i].length; j++) {
                int2DArray[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        String[][] str2DArray = {{"alpha", "beta"},
                {"ceta", "delta"} //space complexity - O(m*n)
        }; //O(1)
        System.out.println(Arrays.deepToString(str2DArray));
        TwoDimensionalArray twoDimensionalArray = new TwoDimensionalArray(2, 3);
        twoDimensionalArray.printArray();
        twoDimensionalArray.insertValueInTheArray(0, 0, 71);
        twoDimensionalArray.insertValueInTheArray(0, 1, 287);
        twoDimensionalArray.insertValueInTheArray(1, 1, 57);
        //duplicate
        twoDimensionalArray.insertValueInTheArray(1, 1, 57);
        twoDimensionalArray.insertValueInTheArray(0, 2, 30);
        twoDimensionalArray.insertValueInTheArray(1, 2, 43);
        twoDimensionalArray.insertValueInTheArray(1, 0, 97);
        twoDimensionalArray.printArray();
        twoDimensionalArray.traverse2DArray();
        twoDimensionalArray.searchArray(97);
        twoDimensionalArray.deleteArray(0,2);
        twoDimensionalArray.deleteArray(0,3);
    }

    //time complexity - O(m*n)
    //space complexity -  O(1)
    private void searchArray(int value) {
        for (int row = 0; row < int2DArray.length; row++) {
            for (int col = 0; col < int2DArray[0].length; col++) {
                if (int2DArray[row][col] == value) {
                    System.out.println("value found at : " + row + "*" + col);
                    return;
                }
            }
        }
        System.out.println("value not found ");
    }

    private void deleteArray(int row, int col) {
        try{
            System.out.println("successfully deleted : "+ int2DArray[row][col]);
            int2DArray[row][col] = Integer.MIN_VALUE;
            printArray();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("row col not  found in array : " + row +"*"+ col);
        }

    }

    private void printArray() {
        System.out.println(Arrays.deepToString(int2DArray));
    }

    private void insertValueInTheArray(int row, int column, int valueToInsert) {
        try {
            if (int2DArray[row][column] == Integer.MIN_VALUE) {
                int2DArray[row][column] = valueToInsert;
                System.out.println("value is inserted");
            } else {
                System.out.println("this cell " + row + "*" + column + " is already occupied..");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" index not available in 2D array : " + row + "*" + column);
        }
    }

    //time complexity  - O(m*n)
    private void traverse2DArray() {
        System.out.println("traversing 2D Array : ");
        for (int row = 0; row < int2DArray.length; row++) {
            for (int col = 0; col < int2DArray[0].length; col++) {
                System.out.print(int2DArray[row][col] + " ");
            }
            System.out.println();
        }
    }

}
