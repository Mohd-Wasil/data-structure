package com.data.structure.v2.excercises.dividenconquer;

public class Palindrome {

    public static void main(String[] args) {
        String s1 = "MADAM";
        //String s1 = "AMEEMA";
        boolean isPalindrome = checkPalindrome(s1, 0, s1.length() - 1);
        System.out.println("string: " + s1 +" is plaindrome: "+ isPalindrome);
    }

    private static boolean checkPalindrome(String s1, int startIndex, int endIndex) {
        if (startIndex > endIndex || startIndex == endIndex) {
            return true;
        }

        if (s1.charAt(startIndex) == s1.charAt(endIndex)) {
            return checkPalindrome(s1, startIndex + 1, endIndex - 1);
        } else {
            return false;
        }
    }
}
