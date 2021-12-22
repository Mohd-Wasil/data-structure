package com.data.structure.v2.excercises.dividenconquer;

public class ConvertOneStringToAnother {

    private int findMinOperation(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) {
            return s2.length() - i2;
        }
        if (i2 == s2.length()) {
            return s1.length() - i1;
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return findMinOperation(s1, s2, i1 + 1, i2 + 1);
        }
        int deleteOp = 1 + findMinOperation(s1, s2, i1, i2 + 1);
        int insertOp = 1 + findMinOperation(s1, s2, i1 + 1, i2);
        int replaceOp = 1 + findMinOperation(s1, s2, i1 + 1, i2 + 1);
        return Math.min(deleteOp, Math.min(insertOp, replaceOp));
    }


    public int findMinOperation(String s1, String s2) {
        int minOp = findMinOperation(s1, s2, 0, 0);
        System.out.println("min op :" + minOp);
        return minOp;
    }

    public static void main(String[] args) {
        ConvertOneStringToAnother cosa = new ConvertOneStringToAnother();
        cosa.findMinOperation("table", "tbres");
    }
}
