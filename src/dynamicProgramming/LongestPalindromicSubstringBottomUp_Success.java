package dynamicProgramming;

class LongestPalindromicSubstringBottomUp_Success {
//https://leetcode.com/problems/longest-palindromic-substring
    public static void main(String[] args) {
        System.out.printf(new LongestPalindromicSubstringBottomUp_Success().longestPalindrome("cbbd"));
    }

    int len = Integer.MIN_VALUE;
    int x = 0;
    int y = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            findPal(s, i, i);
            if (i + 1 < s.length()) {
                findPal(s, i, i + 1);
            }
        }
        return s.substring(x, y + 1);
    }

    void findPal(String s, int i, int j) {
        if (s.charAt(i) == s.charAt(j)) {
            if ((j - i + 1) > len) {
                len = j - i + 1;
                x = i;
                y = j;
            }
            if (i - 1 >= 0 && j + 1 < s.length()) {
                findPal(s, i - 1, j + 1);
            }
        }
    }
}