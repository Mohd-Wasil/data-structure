package com.data.structure.v2.excercises.dividenconquer;

public class LongestPalindromeSubSequence {

    public static void main(String[] args) {
        String s1 = "ELRMENMET"; //E ME ME
       // String s1 = "AMEENMEA";
        int lengthPSS = findLongestPalindromeSubSequenceLength(s1, 0, s1.length() -1 );
        System.out.println("length panidrome sub sequence... " + lengthPSS);
    }

    private static int findLongestPalindromeSubSequenceLength(String s1, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }

        if(startIndex == endIndex) {
            return 1; //point to same character
        }
        int count =0;
        if (s1.charAt(startIndex) == s1.charAt(endIndex)) {
            count = 2 + findLongestPalindromeSubSequenceLength(s1, startIndex + 1, endIndex - 1);
        }
        int op2 = findLongestPalindromeSubSequenceLength(s1, startIndex + 1, endIndex);
        int op1 = findLongestPalindromeSubSequenceLength(s1, startIndex, endIndex - 1);
        return Math.max(count, Math.max(op1, op2));
    }
}
