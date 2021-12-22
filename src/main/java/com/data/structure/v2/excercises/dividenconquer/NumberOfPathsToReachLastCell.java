package com.data.structure.v2.excercises.dividenconquer;

public class NumberOfPathsToReachLastCell {

    public static void main(String[] args) {
        int array[][] = {
                {4, 7, 1, 6},
                {5, 7, 3, 9},
                {3, 2, 1, 2},
                {7, 1, 6, 3}
        };
        int totalCost = 25;
        int paths = noOfPathsToReachLastCell(array, array.length - 1, array[0].length - 1, 25);
        System.out.println("paths : "+ paths);
    }

    public static int noOfPathsToReachLastCell(int array[][], int row, int col, int cost) {
        if (cost < 0) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return array[0][0] - cost == 0 ? 1 : 0; //no of wyas..
        }
        if (row == 0) {
            return noOfPathsToReachLastCell(array, 0, col - 1, cost - array[row][col]);
        }
        if (col == 0) {
            return noOfPathsToReachLastCell(array, row - 1, 0, cost - array[row][col]);
        }
        int sub1 = noOfPathsToReachLastCell(array, row - 1, col, cost - array[row][col]);
        int sub2 = noOfPathsToReachLastCell(array, row, col - 1, cost - array[row][col]);

        return sub1 + sub2;
    }
}
