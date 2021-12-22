package com.data.structure.v2.day3;

public class UniqueArray {

    public static void main(String[] args) {
        int []intArray = {1,2,3,4,5,6,4};

        for(int i =0; i< intArray.length; i++) {
            for( int j=i+1; j< intArray.length; j++){
                if(intArray[i] == intArray[j]) {
                    throw new IllegalArgumentException("array not unique");
                }
            }
        }
        System.out.println("array is unque");
    }
}
