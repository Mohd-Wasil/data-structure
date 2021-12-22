package com.data.structure.v2.search;

public class LinearSearch {

    int arr[];
    public LinearSearch(int []arr){
        this.arr = arr;
    }
    public int linearSearch(int value) {
        for(int i =0 ; i <arr.length; i++ ){
            if(arr[i] == value) {
                System.out.println("value : "+ value +" found at index : "+ i);
                return i;
            }
        }
        System.out.println("value : "+ value+" not found");
        return -1;
    }

    public static void main(String[] args) {
        int [] arr ={2,4,3,5,1,7,6,8,9};
        LinearSearch linearSearch = new LinearSearch(arr);
        linearSearch.linearSearch(14);
    }
}
