package com.data.structure.v2.excercises;

import java.util.HashMap;

public class FibanoicciSeriesTopDown {
    public static void main(String[] args) {
        int array[] = new int[8];
        fibanoicciSeries(8, array);
        for (int a : array) {
            System.out.println(a);
        }

        HashMap<Integer, Integer> fibMap = new HashMap<>();

        fibanoicciWithHashMap(8, fibMap);
        System.out.println(fibMap);
    }

    public static int fibanoicciWithHashMap(int n, HashMap<Integer, Integer> fibMapMemo) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            fibMapMemo.put(n, 0);
            return 0;
        }
        if (n == 2) {
            fibMapMemo.put(n, 1);
            return 1;
        }

        if (fibMapMemo.get(n) == null) {
            int fibanoici = fibanoicciWithHashMap(n - 1, fibMapMemo) + fibanoicciWithHashMap(n - 2, fibMapMemo);
            fibMapMemo.put(n, fibanoici);
        }
        return fibMapMemo.get(n);
    }

    private static int fibanoicciSeries(int n, int array[]) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            array[0] = 0;
            return 0;
        }
        if (n == 2) {
            array[1] = 1;
            return 1;
        }
        array[n - 1] = fibanoicciSeries(n - 1, array) + fibanoicciSeries(n - 2, array);
        return array[n - 1];
    }
}
