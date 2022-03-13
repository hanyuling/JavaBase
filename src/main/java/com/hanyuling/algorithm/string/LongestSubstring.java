package com.hanyuling.algorithm.string;

public class LongestSubstring {

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "abe";
        System.out.println(longestSubstring(text1,text2));
    }

    public static int longestSubstring(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        int max = -1;
        for (int i = 1; i <= x.length(); i++) {
            char c1 = x.charAt(i-1);
            for (int j = 1; j <= y.length(); j++) {
                char c2 = y.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

}
