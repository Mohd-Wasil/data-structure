package com.data.structure.v2.day3;

public class MaxProduct {

    public static void main(String[] args) {
        int[] intArr = {10, 30, 20, 50, 40, 60};
        int maxProduct = 0;
        String pairs ="";
        for (int i = 0; i < intArr.length; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                int product = intArr[i] * intArr[j];
                if (product > maxProduct) {
                    maxProduct = product;
                    pairs = Integer.toString(intArr[i]) +"," + Integer.toString(intArr[j]);
                }
            }
        }
        System.out.println("macx product : "+ maxProduct + " pairs : "+ pairs);
    }
}
