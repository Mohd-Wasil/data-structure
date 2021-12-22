package com.data.structure.v2.excercises.greedy.coin;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 1000};
        int totalAmount = 2038;
        System.out.println("total amount: " + totalAmount);
        int x = coinChangeSolution(totalAmount, denominations);
        System.out.println("min coins : " + x );

    }

   public void coinChangeProblem2(int totalAmount, int[] denominations) {
        Arrays.sort(denominations);

        int index = denominations.length - 1;
        while(true) {

        }
    }

    public static int coinChangeSolution(int totalAmount, int[] denominations) {
        if(totalAmount == 0) {
            return 0;
        }

        int maxDenomination = denominations[0];
        for (int i = 1; i < denominations.length; i++) {
            if(denominations[i] <= totalAmount && denominations[i] > maxDenomination) {
                maxDenomination = denominations[i];
            }
        }
        totalAmount = totalAmount - maxDenomination;
        System.out.println("coin value taken: " + maxDenomination);
        return 1 + coinChangeSolution(totalAmount, denominations);
    }

}
