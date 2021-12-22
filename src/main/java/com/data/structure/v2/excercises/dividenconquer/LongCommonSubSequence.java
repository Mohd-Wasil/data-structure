package com.data.structure.v2.excercises.dividenconquer;

public class LongCommonSubSequence {

    public static void main(String[] args) {
        int lcs = findLongestCommonSubSequenceLength("elephant", "erepat", 0, 0);
        System.out.println("lenght of LCS  : " + lcs);
    }

    public static int findLongestCommonSubSequenceLength(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2 == s2.length()) {
            return 0;
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + findLongestCommonSubSequenceLength(s1, s2, i1 + 1, i2 + 1);
        }
        int op1 = findLongestCommonSubSequenceLength(s1, s2, i1 + 1, i2);
        int op2 = findLongestCommonSubSequenceLength(s1, s2, i1, i2 + 1);
        return Math.max(op1, op2);
    }

}
