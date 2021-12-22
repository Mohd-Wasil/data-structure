package com.data.structure.v2.day3;

public class SearchInArray {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int valueToSearch = 71;
        System.out.println("element found : "+ linearSearch(intArray, valueToSearch));
    }

    //linear search
    private static int linearSearch(int[] intArray, int valueToSearch) {
        for (int i = 0; i < intArray.length; i++) {
            if(valueToSearch == intArray[i]){
                return i;
            }
        }
        throw new IllegalArgumentException("value not found");
    }


}
