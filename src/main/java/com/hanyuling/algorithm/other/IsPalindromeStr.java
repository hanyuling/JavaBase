package com.hanyuling.algorithm.other;

/**
 * @author: wrg
 * @date: 2024/3/19 11:46
 */
public class IsPalindromeStr {


    public static boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }
            while (left < right && Character.isLetterOrDigit(s.charAt(right))) {
                left --;
            }
            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
