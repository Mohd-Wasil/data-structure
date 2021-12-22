package com.data.structure.v2.excercises;

import java.util.ArrayList;

public class FibanoicciSeriesBottomUp {

    public static void main(String[] args) {
        int n = 6;
        int array[] = new int[n];
        array[0] = 0;
        array[1] = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i < n; i++) {
            //array[i] = array[i - 1] + array[i - 2];
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        //System.out.println(array[n - 1]);
        System.out.println(list.get(n-1));
        for (int a : array) {
            System.out.print(a + " ,");
        }
    }
}
