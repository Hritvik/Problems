package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class LongestPalindromicSubstringTopDown_TLE {
//https://leetcode.com/problems/longest-palindromic-substring
    public static void main(String[] args) {
        new LongestPalindromicSubstringTopDown_TLE().longestPalindrome("cbbd");
    }

    int len = Integer.MIN_VALUE;
    String answer = "";
    Map<String, Boolean> checked = new HashMap<>();

    public String longestPalindrome(String s) {
        findPal(s, 0, s.length());
        return answer;
    }

    void findPal(String s, int i, int j) {
        if (!checked.containsKey(i + "" + j)) {
            checked.put(i + "" + j, true);
            if (j - i > len) {
                String test = s.substring(i, j);
                if (checkPal(test)) {
                    answer = test;
                    len = j - i;
                } else {
                    if (j > i + 1) {
                        findPal(s, i + 1, j);
                    }
                    if (i < j - 1) {
                        findPal(s, i, j - 1);
                    }
                }
            }
        }
    }

    public boolean checkPal(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}