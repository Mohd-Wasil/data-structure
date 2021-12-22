package com.data.structure.v2.excercises.greedy.knapsack;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<KnapSackItem> knapSackItems= new ArrayList<>();
        knapSackItems.add(new KnapSackItem(10, 60, 1));
        knapSackItems.add(new KnapSackItem(20, 100, 2));
        knapSackItems.add(new KnapSackItem(30, 120, 3));
        FractionalKnapSackProblem.knapSackProblem(knapSackItems, 50);
    }
}
