package com.data.structure.v2.excercises.greedy.knapsack;

public class KnapSackItem {

    public int weight;
    public int value;
    public int index;
    public double valueToWeightRatio;

    public KnapSackItem(int weight, int value, int index) {
        this.index = index;
        this.weight = weight;
        this.value = value;
        this.valueToWeightRatio = (value * 1.0) / weight;
    }

    @Override
    public String toString() {
        return "Item : index " + index + " ,weight " + weight +
                " , value : " + value + " ,ratio : " + valueToWeightRatio;
    }
}
