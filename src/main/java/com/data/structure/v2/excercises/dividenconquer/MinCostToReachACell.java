package com.data.structure.v2.excercises.dividenconquer;

public class MinCostToReachACell {
    public static void main(String[] args) {
        int[][] cost = {
                {4, 7, 8, 6, 4},
                {6, 7, 3, 9, 2},
                {3, 8, 1, 2, 4},
                {7, 1, 7, 3, 7},
                {2, 9, 8, 9, 3}
        };
        int Mincost = findMinCostToReachACell(cost, cost.length - 1, cost[0].length - 1);
        System.out.println("cost to reach 0,0 cell : " + Mincost);
    }

    private static int findMinCostToReachACell(int[][] cost, int row, int col) {

        if (row == -1 || col == -1) {
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col == 0) {
            return cost[row][col];
        }
        int minCost1 = findMinCostToReachACell(cost, row - 1, col);
        int minCost2 = findMinCostToReachACell(cost, row, col - 1);

        return Math.min(minCost1, minCost2) + cost[row][col] ;
    }
}
