package com.data.structure.v2.excercises.greedy.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapSackProblem {

    public static void knapSackProblem(ArrayList<KnapSackItem> knapSackItems, int capacity) {
        System.out.println("total weight : " + capacity);
        Collections.sort(knapSackItems, (o1, o2) -> { //sort in desecnding order..
            return (int) (o2.valueToWeightRatio - o1.valueToWeightRatio);
        });
        double totalvalue = 0;
        int usedCapacity = 0;
        for (KnapSackItem item : knapSackItems) {
            //dem02
            if (usedCapacity + item.weight <= capacity) {
                usedCapacity += item.weight;
                totalvalue = totalvalue + item.value;
                System.out.println("item taken : " + item + " value added : " + item.value);
            } else {
                //double fraction = ((capcity - usedCapacity) * 1.0) / item.weight;
                double value = (capacity - usedCapacity) * item.valueToWeightRatio;
                usedCapacity = capacity;
                totalvalue = totalvalue + value;
                System.out.println("item : " + item + " value added : " + value);
            }
            if (usedCapacity == capacity) {
                break;
            }
        }
        //demo 1
           /* if(totalWeight !=0 ) {
                if (item.weight <= totalWeight) {
                    totalWeight = totalWeight - item.weight;
                    value = value + item.value;
                    System.out.println("item : " + item + " value added : "+ item.value);
                } else {
                    double fraction = totalWeight * 1.0 / item.weight;
                    totalWeight =0;
                    value = value + item.value * fraction;
                    System.out.println("item : " + item + " value added : "+ item.value * fraction);
                }
            }*/
        System.out.println("total value : " + totalvalue);
    }

}

