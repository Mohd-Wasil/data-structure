package com.data.structure.sort;

public class BinarySearch {

    public static void main(String[] args) {
        //assumes list is sorted..
        //
        int[] arr = {11, 21, 33, 46, 57, 65, 73, 81, 95, 101};
        int element = 33;
        int midIndex = arr.length / 2 + arr.length % 2;
        //binarySearch(arr, element, midIndex);
        //O(LOG(N))
        System.out.println(binarySearch(arr, element));
    }

    public static int binarySearch(int[] sortedList, int number) {

        int min = 0;
        int max = sortedList.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2; //midpoint of search area..
            if (sortedList[mid] == number) {
                return mid; //element is found
            }
            if (number > sortedList[mid]) {
                min = mid + 1; //element will be found at second half of list
            } else {
                max = mid - 1; //element will be found in first half...
            }
        }
        return -1; //element is not found...
    }

    private static int binarySearch(int[] arr, int minIndex, int maxIndex, int element) {
        int index = minIndex + (maxIndex - minIndex) / 2;
        if (element == arr[index]) {
            return index;
        }
        if (element > arr[index]) {
            int midIndex = (arr.length + index) / 2 + (arr.length - index) % 2;
            //binarySearch();
        }
        return 0;
    }
}
